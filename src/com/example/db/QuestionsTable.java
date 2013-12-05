package com.example.db;


public class QuestionsTable extends Table {

	public QuestionsTable() {
		super();
	}

	@Override
	public String defineTableColumnsToCreate() {
		return DbConfig.TableQuestionsConfig.generateCreateTableStatement();

	}

	@Override
	public String defineTableNameToCreate() {
		return DbConfig.TABLE_QUESTIONS.name();
	}
}
