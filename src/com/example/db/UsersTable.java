package com.example.db;


public class UsersTable extends Table {

	public UsersTable() {
		super();
	}

	@Override
	public String defineTableColumnsToCreate() {
		return DbConfig.TableUsersConfig.generateCreateTableStatement();

	}

	@Override
	public String defineTableNameToCreate() {
		return DbConfig.TABLE_USERS.name();
	}
}
