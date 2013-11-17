package com.example.db;

import com.example.entity.AnswerEntity;
import com.example.entity.QuestionEntity;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper{
	
	public SQLiteHelper(Context appContext) {
		super(appContext, DbConfig.DATABASE_TEST.name(),
				DbConfig.dbDefaultCursorFactory, DbConfig.dbDefaultVersion);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		AnswersTable at = new AnswersTable();
		at.CreateTable(db);
		QuestionsTable qt= new QuestionsTable();
		qt.CreateTable(db);
		
		for (QuestionEntity entity: QuestionEntity.CreateQuestions())
			addQuestion(entity,db);
		
	}
	
	

	private int addQuestion(QuestionEntity question,SQLiteDatabase db) {
		ContentValues fotoRowToCreate = new ContentValues();
		fotoRowToCreate.put(DbConfig.TableQuestionsConfig.QUESTION.name(),
				question.getQuestion());
		fotoRowToCreate.put(DbConfig.TableQuestionsConfig.KIND.name(),
				question.getQuestionType());
		fotoRowToCreate.put(DbConfig.TableQuestionsConfig.TIMESTAMP.name(),
				question.getTimeStamp());
		fotoRowToCreate.put(DbConfig.TableQuestionsConfig.ANSWER.name(),
				question.getAnswer());
	
		
		final int newRowIndex = (int)db.insert(
				DbConfig.TABLE_QUESTIONS.name(),null, fotoRowToCreate);
	
		
		for(AnswerEntity ae: question.getAnswers()) {
			ae.setQuesionId(newRowIndex);
			addAnswer(ae,db);
		}
		
		return newRowIndex;
		
	}

	private int addAnswer(AnswerEntity answer,SQLiteDatabase db) {
		ContentValues fotoRowToCreate = new ContentValues();
		fotoRowToCreate.put(DbConfig.TableAnswersConfig.LABEL.name(),
				answer.getLabel());
		fotoRowToCreate.put(DbConfig.TableAnswersConfig.IMAGEPATH.name(),
				answer.getImagePathId());
		fotoRowToCreate.put(DbConfig.TableAnswersConfig.QUESTIONID.name(),
				answer.getQuestionId());
		fotoRowToCreate.put(DbConfig.TableAnswersConfig.TIMESTAMP.name(),
				answer.getTimeStamp());
		
	
		final int newRowIndex = (int)db.insert(DbConfig.TABLE_ANSWERS.name(),null, fotoRowToCreate);
		
		return newRowIndex;
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		AnswersTable at = new AnswersTable();
		at.DropTable(db);
		QuestionsTable qt= new QuestionsTable();
		qt.DropTable(db);
	}
	
	
}
