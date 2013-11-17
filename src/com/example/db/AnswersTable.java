package com.example.db;

import android.content.Context;

public class AnswersTable  extends Table{

	public AnswersTable() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String defineTableColumnsToCreate() {
		return DbConfig.TableAnswersConfig.generateCreateTableStatement();
	}

	@Override
	public String defineTableNameToCreate() {
		return DbConfig.TABLE_ANSWERS.name();
	}

}
