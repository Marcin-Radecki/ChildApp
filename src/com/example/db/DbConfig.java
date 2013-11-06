package com.example.db;

import android.database.sqlite.SQLiteDatabase.CursorFactory;

public enum DbConfig {

    DATABASE_TEST, TABLE_USERS, TABLE_QUESTIONS;

    public static final int dbDefaultVersion = 1;
    public static final CursorFactory dbDefaultCursorFactory = null;

    /** defines in a central way the table column names from the table {@link TableFotoConfig} */
    public enum TableUsersConfig {

        ID, NAME, TIMESTAMP;

        public static String generateCreateTableStatement() {
            final String c0 = NAME.name() + TEXT + COMMA;
            final String c1 = TIMESTAMP.name() + TEXT;
            final String creteStatement = c0 + c1;
            return creteStatement;
        }
    }

    /** defines in a central way the table column names from the table {@link TableVideoConfig} */
    public enum TableQuestionsConfig {

        ID, QUESTION, TIMESTAMP;
        public static String generateCreateTableStatement() {
            final String c0 = QUESTION.name() + TEXT + COMMA;
            final String c1 = TIMESTAMP.name() + TEXT;
            final String creteStatement = c0 + c1;
            return creteStatement;
        }
    }

   

    /** use it to separate values while creating SQL statements */
    public static final String COMMA = ",";
    /** use it to save it as a null value */
    public static final String NULL = " NULL ";
    /** use it to save integers, primary keys */
    public static final String INTEGER = " INTEGER ";
    /** use it to save doubles, floats */
    public static final String REAL = " REAL ";
    /** use it to save text, varchar, char */
    public static final String TEXT = " TEXT ";
    /** use it to save fotos, videos, audio, data etc. */
    public static final String BLOB = " BLOB ";

} 