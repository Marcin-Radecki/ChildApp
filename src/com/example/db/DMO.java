package com.example.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public abstract class DMO {

	private SQLiteDatabase db;
	private SQLiteHelper helper;

	public DMO(Context appContext)
			throws NullPointerException {
		helper = new SQLiteHelper(appContext);
		garantConnection(appContext);
		openTable();
	}

	public void openTable() {
		if (this.db == null || !this.db.isOpen()) {
			this.db = helper.getWritableDatabase();
		}
	}

	public void close() {
		if (this.db != null) {
			this.db.close();
		}
	}

	/**
	 * Defines the name of this database in the concrete implementation of this
	 * class
	 */
	public abstract String defineDatabaseNameToCreate();

	public int insert(String tableName, ContentValues rowToCreate) {
		db.insert(tableName, null, rowToCreate);
		String[] columnsToShow = null;
		String selection = null;
		String[] selectionArgs = null;
		String groupBy = null;
		String having = null;
		String orderBy = "ID DESC LIMIT 1";
		Cursor query = db.query(tableName, columnsToShow, selection,
				selectionArgs, groupBy, having, orderBy);
		query.moveToFirst();
		int indexId = query.getColumnIndex("ID");
		int id = query.getInt(indexId);
		
		return id;
	}

	public void update(String tableName, int rowIdToUpdate,
			ContentValues rowToUpdate) {

		final String whereClause = "ID=" + rowIdToUpdate;
		db.update(tableName, rowToUpdate, whereClause, null);
		
	}

	public void dropTable(String tableName) {

		String sql = "DROP TABLE IF EXISTS " + tableName;
		db.execSQL(sql);
	
	}

	public boolean dropDatabase(Context appContext, String databaseName) {
		return appContext.deleteDatabase(databaseName);
	}

	public void deleteById(String tableName, int id) {

		String whereClause = "ID=" + id;
		String[] whereArgs = null;
		db.delete(tableName, whereClause, whereArgs);
		
	}

	public Cursor selectAll(String tableName, String[] columnNamesToShow) {

		String[] columnsToShow = columnNamesToShow;
		String selection = null;
		String[] selectionArgs = null;
		String groupBy = null;
		String having = null;
		String orderBy = null;
		return db.query(tableName, columnsToShow, selection, selectionArgs,
				groupBy, having, orderBy);
	}

	public Cursor selectAllOrderBy(String tableName,
			String[] columnNamesToShow, String columnNameToOrderBy) {

		String[] columnsToShow = columnNamesToShow;
		String selection = null;
		String[] selectionArgs = null;
		String groupBy = null;
		String having = null;
		String orderBy = columnNameToOrderBy;
		return db.query(tableName, columnsToShow, selection, selectionArgs,
				groupBy, having, orderBy);
	}

	public Cursor selectAllDistinct(String tableName,
			String[] columnNamesToShow, String columnNameToDistinct) {

		String[] columnsToShow = columnNamesToShow;
		String selection = null;
		String[] selectionArgs = null;
		String groupBy = columnNameToDistinct;
		String having = null;
		String orderBy = columnNameToDistinct;
		return db.query(tableName, columnsToShow, selection, selectionArgs,
				groupBy, having, orderBy);
	}

	public Cursor selectRowById(String tableName, int id) {

		String[] columnsToShow = null;
		String selection = "ID=" + id;
		String[] selectionArgs = null;
		String groupBy = null;
		String having = null;
		String orderBy = null;
		return db.query(tableName, columnsToShow, selection, selectionArgs,
				groupBy, having, orderBy);
	}

	public Cursor getDifferences(String tableName, String timestamp) {

		String[] columnsToShow = null;
		String selection = "TIMESTAMP = '" + timestamp + "'";
		String[] selectionArgs = null;
		String groupBy = null;
		String having = null;
		String orderBy = null;
		return db.query(tableName, columnsToShow, selection, selectionArgs,
				groupBy, having, orderBy);
	}

	private void garantConnection(Context appContext) {
		if (appContext == null  ) {
			throw new NullPointerException(
					"appContext and  can't be set to null");
		}
	}

}
