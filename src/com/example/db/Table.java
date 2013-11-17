package com.example.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public abstract class Table  {

	public Table() {
		
	}

    public void CreateTable(SQLiteDatabase db) {
		final String sqlCmdStart = "CREATE TABLE ";
		final String primaryKeyCmd = " (ID integer primary key autoincrement, ";
		final String sqlCmdEnd = ");";
		final String createQuery = sqlCmdStart + defineTableNameToCreate()
				+ primaryKeyCmd + defineTableColumnsToCreate() + sqlCmdEnd;
		db.execSQL(createQuery);
    }
    
    public Table DropTable(SQLiteDatabase db) {
		String sql = "DROP TABLE IF EXISTS " + defineTableNameToCreate();
		db.execSQL(sql);
		return this;
}

	public abstract String defineTableColumnsToCreate();

	public abstract String defineTableNameToCreate();

	
}
