package com.example.db;

<<<<<<< HEAD
=======
import android.content.Context;
>>>>>>> d50c07cc0266843d819ac474050f06d72342984d

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
