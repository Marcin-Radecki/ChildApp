package sdm.application.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBUser extends SQLiteOpenHelper{
	
public static final String TABLE_USERS = "users";
	
	public static final String COLUMN_ID = "_id";
	
	public static final String COLUMN_USER = "user";
	
	public static final String COLUMN_SCORE = "score";
	
	public static final String DATABASE_NAME = "users.db";
	private static final int DATABASE_VERSION = 1;

	public MyDBUser(Context context) {
		super(context, DATABASE_NAME, null , DATABASE_VERSION);
	}
	
	private static final String DATABASE_CREATE = "create table "+ TABLE_USERS + "("+
			COLUMN_ID+ " " +"integer primary key autoincrement, " + COLUMN_USER +
			" text not null, "+ COLUMN_SCORE +" integer not null"
			+");";

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}

}
