package com.azharchara.noteitdown;


import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * Created by Azhar Chara on 22/08/17.
 */

public class AddNoteActivity extends Activity {

    //Declarations
    EditText titleText,contentText;
    TextView dateText;
    Button savebutton,calendarbutton;
    Calendar myCalendar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addnoteview);

        //Initializations
        final Bundle extras = getIntent().getExtras();
        myCalendar = Calendar.getInstance();
        titleText = (EditText)findViewById(R.id.title_addnote);
        contentText = (EditText)findViewById(R.id.content_addnote);
        dateText = (TextView)findViewById(R.id.dateTextView);
        calendarbutton = (Button)findViewById(R.id.calendarButton);
        savebutton = (Button)findViewById(R.id.saveButton);

        //DB access
        final List<Note> noteList = SQLite.select().
                from(Note.class).queryList();

        if (noteList.size() > 0 && extras.getInt("position") != -1 ) {

            titleText.setText(noteList.get(extras.getInt("position")).getTitle());
            contentText.setText(noteList.get(extras.getInt("position")).getContent());
            dateText.setText(noteList.get(extras.getInt("position")).getDate());
        }

        // save button action
        savebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (titleText.getText().toString().length() > 0 || contentText.getText().toString().length() > 0) {
                    if (extras.getInt("position") == -1) {
                        Note note = new Note();
                        note.setTitle(titleText.getText().toString());
                        note.setContent(contentText.getText().toString());
                        note.setDate(dateText.getText().toString());
                        note.save();
                    } else {
                        noteList.get(extras.getInt("position")).setTitle(titleText.getText().toString());
                        noteList.get(extras.getInt("position")).setContent(contentText.getText().toString());
                        noteList.get(extras.getInt("position")).setDate(dateText.getText().toString());
                        noteList.get(extras.getInt("position")).save();
                    }
                }
                setResult(RESULT_OK);
                finish();
            }
        });

        //date picker action
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        calendarbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(AddNoteActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    //Date label update method
    private void updateLabel() {
        String myFormat = "EEE, d MMM yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        dateText.setText(sdf.format(myCalendar.getTime()));
    }

}
