package sdm.application.db;

import java.util.ArrayList;
import java.util.List;

import sdm.application.entity.AnswerEntity;
import sdm.application.entity.QuestionEntity;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;


public class DAO {

	private DMO connection;
	private Activity context;

	public DAO(Activity context) {
		this.context = context;
	}
	
	public ArrayList<AnswerEntity> getAnswers() {
		connection = new Database(context);
		final Cursor result = connection.selectAll(DbConfig.TABLE_ANSWERS.name(),
				null);
		
		ArrayList<AnswerEntity> list = new ArrayList<AnswerEntity>();
		result.moveToFirst();
		while (!result.isAfterLast()) {
			int label = result.getInt(result
					.getColumnIndex(DbConfig.TableAnswersConfig.LABEL
							.name()));
			int imagepathId = result.getInt(result
					.getColumnIndex(DbConfig.TableAnswersConfig.IMAGEPATH
							.name()));
			Integer questionid = result.getInt(result
					.getColumnIndex(DbConfig.TableAnswersConfig.QUESTIONID
							.name()));
			Integer id = result.getInt(result
					.getColumnIndex(DbConfig.TableAnswersConfig.ID
							.name()));
		
			AnswerEntity entity = new AnswerEntity(label, imagepathId);
			entity.setId(id);
			entity.setQuesionId(questionid);
			list.add(entity);
			result.moveToNext();
		
		}
		
		result.close();
		connection.close();
		return list;
	}

	public List<QuestionEntity> getQuestions() {
		ArrayList<AnswerEntity> answers = getAnswers();
		
		connection = new Database(context);
		final Cursor result = connection.selectAll(DbConfig.TABLE_QUESTIONS.name(),
				null);
		
		List<QuestionEntity> list = new ArrayList<QuestionEntity>();
		result.moveToFirst();
		while (!result.isAfterLast()) {
			int question = result.getInt(result
					.getColumnIndex(DbConfig.TableQuestionsConfig.QUESTION
							.name()));
			String type = result.getString(result
					.getColumnIndex(DbConfig.TableQuestionsConfig.KIND
							.name()));
			Integer answer = result.getInt(result
					.getColumnIndex(DbConfig.TableQuestionsConfig.ANSWER
							
							.name()));
			Integer id = result.getInt(result
					.getColumnIndex(DbConfig.TableQuestionsConfig.ID
							.name()));
		
			ArrayList<AnswerEntity> listA = new ArrayList<AnswerEntity>();
			for(AnswerEntity ar:answers)
				if (ar.getQuestionId() == id)
					listA.add(ar);
			
			QuestionEntity entity = new QuestionEntity(question, type, listA, answer);
			entity.setId(id);
			
			list.add(entity);
			result.moveToNext();
		}

		result.close();
		connection.close();
		return list;
	}

	private int addAnswer(AnswerEntity answer) {
		ContentValues fotoRowToCreate = new ContentValues();
		fotoRowToCreate.put(DbConfig.TableAnswersConfig.LABEL.name(),
				answer.getLabel());
		fotoRowToCreate.put(DbConfig.TableAnswersConfig.IMAGEPATH.name(),
				answer.getImagePathId());
		fotoRowToCreate.put(DbConfig.TableAnswersConfig.QUESTIONID.name(),
				answer.getQuestionId());
		fotoRowToCreate.put(DbConfig.TableAnswersConfig.TIMESTAMP.name(),
				answer.getTimeStamp());
		
		connection = new Database(context);
		final int newRowIndex = connection.insert(
				DbConfig.TABLE_ANSWERS.name(), fotoRowToCreate);
		connection.close();
		return newRowIndex;
	}
	
	public int addQuestion(QuestionEntity question) {
		ContentValues fotoRowToCreate = new ContentValues();
		fotoRowToCreate.put(DbConfig.TableQuestionsConfig.QUESTION.name(),
				question.getQuestion());
		fotoRowToCreate.put(DbConfig.TableQuestionsConfig.TIMESTAMP.name(),
				question.getTimeStamp());
		fotoRowToCreate.put(DbConfig.TableQuestionsConfig.KIND.name(),
				question.getQuestionType());
		fotoRowToCreate.put(DbConfig.TableQuestionsConfig.ANSWER.name(),
				question.getAnswer());
	
		connection = new Database(context);
		final int newRowIndex = connection.insert(
				DbConfig.TABLE_QUESTIONS.name(), fotoRowToCreate);
		connection.close();
		
		for(AnswerEntity ae: question.getAnswers()) {
			ae.setQuesionId(newRowIndex);
			addAnswer(ae);
		}
		
		return newRowIndex;
	}
	
}
