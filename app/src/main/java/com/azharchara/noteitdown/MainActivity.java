package com.azharchara.noteitdown;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Azhar Chara on 22/08/17.
 */

public class MainActivity extends AppCompatActivity {

    //Declarations
    ListView listView;
    ArrayList<String> title;
    ArrayList<String> content;
    ArrayList<String> date;
    private Row_item rowItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // This instantiates DBFlow
        FlowManager.init(new FlowConfig.Builder(this).build());

        setContentView(R.layout.activity_main);

        //Settings Toolbar text color
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.BLACK);
        setSupportActionBar(toolbar);

        //Floating button action
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,AddNoteActivity.class);
                i.putExtra("position",-1);
                startActivityForResult(i,200);
            }
        });

        //List view display
        listView = (ListView)findViewById(R.id.list);
        title=new ArrayList<>();
        content=new ArrayList<>();
        date=new ArrayList<>();

        //DB access & adapter settings
        List<Note> noteList = SQLite.select().
                from(Note.class).queryList();

        for(int i = 0 ; i<noteList.size() ; i++)
        {
            title.add(i,noteList.get(i).getTitle());
            content.add(i,noteList.get(i).getContent());
            date.add(i,noteList.get(i).getDate());
        }
        rowItem=new Row_item(this, noteList.size(), title, content, date);
        listView.setAdapter(rowItem);

        //List view on click action
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              Intent i = new Intent(MainActivity.this,AddNoteActivity.class);
              i.putExtra("position",position);
              startActivityForResult(i,200);
            }
        });

        //List view long press action
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {


                final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);

                // Setting Dialog Title
                alertDialog.setTitle("Confirm Delete...");

                // Setting Dialog Message
                alertDialog.setMessage("Are you sure you want delete this?");

                // Setting Icon to Dialog
                alertDialog.setIcon(R.drawable.ic_delete);

                // Setting Positive "Yes" Button
                alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {

                        List<Note> noteList = SQLite.select().
                        from(Note.class).queryList();

                noteList.get(position).delete();
                noteList.remove(position);
                for(int i = 0 ; i<noteList.size() ; i++)
                {
                    title.add(i,noteList.get(i).getTitle());
                    content.add(i,noteList.get(i).getContent());
                    date.add(i,noteList.get(i).getDate());
                }
                rowItem.size=noteList.size();
                rowItem.notifyDataSetChanged();

                    }
                });

                // Setting Negative "NO" Button
                alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                // Showing Alert Message
                alertDialog.show();

                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==200)
        {
            {
                //refresh listview
                List<Note> noteList = SQLite.select().
                        from(Note.class).queryList();

                for(int i = 0 ; i<noteList.size() ; i++)
                {
                    title.add(i,noteList.get(i).getTitle());
                    content.add(i,noteList.get(i).getContent());
                    date.add(i,noteList.get(i).getDate());
                }
                rowItem.size=noteList.size();
                rowItem.notifyDataSetChanged();
            }

        }
    }
}
