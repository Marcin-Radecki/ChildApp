package com.example.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public abstract class Table extends SQLiteOpenHelper {

	public Table(Context appContext) {
		super(appContext, DbConfig.DATABASE_TEST.name(),
				DbConfig.dbDefaultCursorFactory, DbConfig.dbDefaultVersion);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		final String sqlCmdStart = "CREATE TABLE ";
		final String primaryKeyCmd = " (ID integer primary key autoincrement, ";
		final String sqlCmdEnd = ");";
		final String createQuery = sqlCmdStart + defineTableNameToCreate()
				+ primaryKeyCmd + defineTableColumnsToCreate() + sqlCmdEnd;
		db.execSQL(createQuery);
	}

	public abstract String defineTableColumnsToCreate();

	public abstract String defineTableNameToCreate();

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// NOP
	}
}
