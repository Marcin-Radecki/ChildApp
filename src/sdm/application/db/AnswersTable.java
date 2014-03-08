package sdm.application.db;

public class AnswersTable  extends Table{

	public AnswersTable() {
		super();
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
