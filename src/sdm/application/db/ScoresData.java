package sdm.application.db;

import java.util.ArrayList;
import java.util.List;

import sdm.application.entity.UserEntity;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class ScoresData {

	private final MyDBUser dbHelper;
	SQLiteDatabase database;
	private Context context;

	private final String[] allColumns = { MyDBUser.COLUMN_ID,
			MyDBUser.COLUMN_USER, MyDBUser.COLUMN_SCORE };

	public ScoresData(final Context context) {
		dbHelper = new MyDBUser(context);
		this.context = context;
	}

	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}

	public void close() {
		database.close();
	}

	public long createValoration(UserEntity userEntity) {

		ContentValues values = new ContentValues();

		values.put(MyDBUser.COLUMN_USER, userEntity.getName());
		values.put(MyDBUser.COLUMN_SCORE, userEntity.getScore());

		long insertId = database.insert(MyDBUser.TABLE_USERS, null,
				values);

		return insertId;
	}

	public long updateValoration(String userName, long newScore) {

		ContentValues values = new ContentValues();

		values.put(MyDBUser.COLUMN_SCORE, newScore);

		String[] args = new String[]{userName};
		long updateId = database.update(MyDBUser.TABLE_USERS, values,
				"user=?", args);

		return updateId;
	}
	
	public UserEntity findValoration(String name) {

		String[] args = new String[]{name};
		Cursor cursor = database.query(MyDBUser.TABLE_USERS, allColumns,
				"user=?", args, null, null, null);
		cursor.moveToFirst();
		UserEntity user = null;
		while (!cursor.isAfterLast()) {
			user = new UserEntity(context);
			user.setName(cursor.getString(1));
			user.setScore(cursor.getInt(2));

			cursor.moveToNext();
		}
		cursor.close();

		return user;
	}

	public List<UserEntity> getAllValorations() {

		List<UserEntity> userList = new ArrayList<UserEntity>();
		Cursor cursor = database.query(MyDBUser.TABLE_USERS, allColumns,
				null, null, null, null, "score DESC");
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			UserEntity user = new UserEntity(context);
			user.setName(cursor.getString(1));
			user.setScore(cursor.getInt(2));

			userList.add(user);
			cursor.moveToNext();
		}
		cursor.close();

		return userList;
	}
}
