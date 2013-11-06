package com.example.db;

import android.content.Context;

public class QuestionsTable extends Table {

    public QuestionsTable(Context appContext) {
        super(appContext);
    }

    @Override
    public String defineTableColumnsToCreate() {
        return DbConfig.TableQuestionsConfig.generateCreateTableStatement();

    }

    @Override
    public String defineTableNameToCreate() {
        return DbConfig.TABLE_QUESTIONS.name();
    }
} 

