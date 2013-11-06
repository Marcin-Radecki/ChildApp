package com.example.db;

import android.content.Context;

public class Database extends DMO {

    public Database(Context appContext, Table tableToOpen) {
        super(appContext, tableToOpen);
    }

    @Override
    public String defineDatabaseNameToCreate() {
        return DbConfig.DATABASE_TEST.name();
    }
} 
