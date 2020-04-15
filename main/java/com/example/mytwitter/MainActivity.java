package com.example.mytwitter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.app.AlertDialog;


import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemLongClickListener {

    ListView list;
    private String m_Text = "";
    ArrayList<Tweet> tweets;
    TweetAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        list =(ListView) findViewById(R.id.listView);
        tweets= new ArrayList<Tweet>();
        tweets.add(new Tweet(R.drawable.bird,"Serine Bourokba",""));


        TweetAdapter adapter = new TweetAdapter(MainActivity.this, tweets);
        list.setAdapter(adapter);
        list.setOnItemLongClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i=item.getItemId();

        if (i == R.id.add) {
            final Dialog dialog=new Dialog(this);
            dialog.setContentView(R.layout.dialog);
            dialog.setTitle("Twitter");
            Button ajouter = (Button) dialog.findViewById(R.id.ajouter) ;
            dialog.show();
            ajouter.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {

                    EditText contenu = (EditText) dialog.findViewById(R.id.cont);
                    ListView list =(ListView) findViewById(R.id.listView);
                    tweets.add(new Tweet(R.drawable.bird,"Serine Bourokba",contenu.getText().toString()));


                    adapter = new TweetAdapter(MainActivity.this,tweets);
                    list.setAdapter(adapter);
                    dialog.dismiss();
                }
            });





        }
        return false;
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long id) {

        list=(ListView) findViewById(R.id.listView);
        AlertDialog.Builder confirm = new AlertDialog.Builder(this);
        confirm.setTitle("Suppression");
        confirm.setIcon(android.R.drawable.ic_dialog_alert);
        confirm.setMessage("Voulez vous supprimer le twit ?");
        confirm.setPositiveButton(android.R.string.yes,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int idBtn) {
                        tweets.remove(position);

                        adapter.notifyDataSetChanged();

                    }
                });
        confirm.setNegativeButton(android.R.string.no, null);
        confirm.show();

        return false;
    }
}
