package sdm.application.entity;

public class AnswerEntity extends Entity{
	private int label;
	private int imagePathId;
	private int questionId;

	
	public int getImagePathId() {
		return imagePathId;
	}
	
	public int getLabel() {
		return label;
	}
	
	public int getQuestionId() 
	{
		return questionId;
	}
	
	public void setQuesionId(int id) {
		questionId = id;
	}
	
	public AnswerEntity(int label, int imagePathId) {
		super();
		this.label = label;
		this.imagePathId = imagePathId;
		this.questionId = -1;
	}
	
	
	
}
