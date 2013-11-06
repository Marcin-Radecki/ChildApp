package com.example.db;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;

import com.example.entity.QuestionEntity;
import com.example.entity.UserEntity;

public class DAO {

    private DMO connection;
    private Activity context;
    
    public DAO(Activity context) {
    	this.context = context;
    }

    public List<UserEntity> getUsers() { 	
        connection = new Database(context, new UsersTable(context));
        final Cursor result = connection.selectAll(DbConfig.TABLE_USERS.name(), null);
        
        List<UserEntity> list = new ArrayList<UserEntity>();
        result.moveToFirst();
		while (!result.isAfterLast()) {
			UserEntity entity = new UserEntity();
			
			entity.setName(result.getString(result.getColumnIndex(DbConfig.TableUsersConfig.NAME.name())));
			entity.setTimeStamp(result.getString(result.getColumnIndex(DbConfig.TableUsersConfig.TIMESTAMP.name())));
		
			list.add(entity);
			result.moveToNext();
		}
		
		result.close();
        connection.close();
        return list;
    }
    
    public List<QuestionEntity> getQuestions() { 	
        connection = new Database(context, new UsersTable(context));
        final Cursor result = connection.selectAll(DbConfig.TABLE_USERS.name(), null);
        
        List<QuestionEntity> list = new ArrayList<QuestionEntity>();
        result.moveToFirst();
		while (!result.isAfterLast()) {
			QuestionEntity entity = new QuestionEntity();
			
			entity.setQuestion(result.getString(result.getColumnIndex(DbConfig.TableQuestionsConfig.QUESTION.name())));
			entity.setTimeStamp(result.getString(result.getColumnIndex(DbConfig.TableQuestionsConfig.TIMESTAMP.name())));
		
			list.add(entity);
			result.moveToNext();
		}
		
		result.close();
        connection.close();
        return list;
    }
    
    public int addUser(UserEntity user) {
    	ContentValues fotoRowToCreate = new ContentValues();
        fotoRowToCreate.put(DbConfig.TableUsersConfig.NAME.name(), user.getName());
        fotoRowToCreate.put(DbConfig.TableUsersConfig.TIMESTAMP.name(), user.getTimeStamp());
        connection = new Database(context, new UsersTable(context));
        final int newRowIndex = connection.insert(DbConfig.TABLE_USERS.name(), fotoRowToCreate);
        return newRowIndex;
    }
    
    public int addQuestion(QuestionEntity question) {
    	ContentValues fotoRowToCreate = new ContentValues();
        fotoRowToCreate.put(DbConfig.TableQuestionsConfig.QUESTION.name(), question.getQuestion());
        fotoRowToCreate.put(DbConfig.TableQuestionsConfig.TIMESTAMP.name(), question.getTimeStamp());
        connection = new Database(context, new QuestionsTable(context));
        final int newRowIndex = connection.insert(DbConfig.TABLE_QUESTIONS.name(), fotoRowToCreate);
        return newRowIndex;
    }


} 
