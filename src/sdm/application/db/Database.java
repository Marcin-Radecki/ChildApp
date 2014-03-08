package sdm.application.db;

import android.content.Context;

public class Database extends DMO {

	public Database(Context appContext) {
		super(appContext);
	}

	@Override
	public String defineDatabaseNameToCreate() {
		return DbConfig.DATABASE_TEST.name();
	}
	
	
}
