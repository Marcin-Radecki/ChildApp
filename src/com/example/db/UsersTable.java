package com.example.db;

import android.content.Context;

public class UsersTable extends Table {

    public UsersTable(Context appContext) {
        super(appContext);
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
