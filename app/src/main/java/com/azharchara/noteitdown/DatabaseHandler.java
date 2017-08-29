package com.azharchara.noteitdown;

import com.raizlabs.android.dbflow.annotation.Database;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by Azhar Chara on 22/08/17.
 */

@Database(name = DatabaseHandler.NAME, version = DatabaseHandler.VERSION)

public class DatabaseHandler extends BaseModel {

    public static final String NAME = "NotesDataBase";

    public static final int VERSION = 1;

}
