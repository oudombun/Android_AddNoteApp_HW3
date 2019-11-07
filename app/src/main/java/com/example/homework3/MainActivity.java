package com.example.homework3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.homework3.animation.FadeInActivity;
import com.example.homework3.animation.FadeOutActivity;
import com.example.homework3.animation.RotateActivity;
import com.example.homework3.animation.ZoomActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    boolean opened;
    LinearLayout myModal;
    private MenuItem btnAddNote,btnMore;
    ArrayList<DataModel> itemsArrayList;
    CustomAdapter adapter;

    EditText mTitle,mDesc;
    Button mAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Note");

        mTitle = findViewById(R.id.txtTitle);
        mDesc = findViewById(R.id.txtDesc);
        mAdd = findViewById(R.id.btnAdd);

        /*set position to modal*/
        myModal = findViewById(R.id.myModal);
        myModal.setVisibility(View.INVISIBLE);

        /*set up list adapter*/
        // Setup the data source
        itemsArrayList =new ArrayList<>();

        // instantiate the custom list adapter
        adapter = new CustomAdapter(this, itemsArrayList);

        // get the ListView and attach the adapter
        ListView itemsListView  = findViewById(R.id.myList);
        itemsListView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_note,menu);
        btnAddNote= menu.getItem(0);
        btnMore= menu.getItem(1);

        /*remove title sub menu*/
        MenuItem menuMore = menu.findItem(R.id.more);
        if (menuMore != null) {
            menuMore.getSubMenu().clearHeader();
        }

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.fadein:
                Intent i1 =new Intent(getApplicationContext(), FadeInActivity.class);
                startActivity(i1);
                finish();
                return true;
            case R.id.fadeout:
                Intent i2 =new Intent(getApplicationContext(), FadeOutActivity.class);
                startActivity(i2);
                finish();
                return true;
            case R.id.zoom:
                Intent i3 =new Intent(getApplicationContext(), ZoomActivity.class);
                startActivity(i3);
                finish();
                return true;
            case R.id.rotate:
                Intent i4 =new Intent(getApplicationContext(), RotateActivity.class);
                startActivity(i4);
                finish();
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        btnAddNote.setEnabled(true);
        btnMore.setEnabled(true);
        return super.onPrepareOptionsMenu(menu);
    }

    public void ShowPopup(MenuItem item) {
        if(!opened){
            btnAddNote.setEnabled(false);
            btnMore.setEnabled(false);
            myModal.setVisibility(View.VISIBLE);
            TranslateAnimation animate = new TranslateAnimation(
                    0,
                    0,
                    myModal.getHeight()+1000,
                    0);
            animate.setDuration(500);
            animate.setFillAfter(true);
            myModal.startAnimation(animate);
            opened = !opened;
        }
    }

    public void closePopup(View view) {
        if(opened){
            btnAddNote.setEnabled(true);
            btnMore.setEnabled(true);

            myModal.setVisibility(View.INVISIBLE);
            TranslateAnimation animate = new TranslateAnimation(
                    0,
                    0,
                    0,
                    myModal.getHeight()+1000);
            animate.setDuration(500);
            animate.setFillAfter(true);
            myModal.startAnimation(animate);
            opened = !opened;
        }
    }

    public void addToNote(View view) {
        if(opened){
            /*add to list*/
            String title = mTitle.getText().toString();
            String des= mDesc.getText().toString();
            if(!title.isEmpty()&&!des.isEmpty()){
                itemsArrayList.add(new DataModel(title,des));
                adapter.notifyDataSetChanged();

                /*close popup*/
                closePopup(view);
                clearTextField();
            }else{
                Toast.makeText(this, "Please input", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void clearTextField(){
        mTitle.setText("");
        mDesc.setText("");
    }

    public void removeAll(MenuItem item) {
        /*add to list*/
        itemsArrayList.removeAll(itemsArrayList);
        adapter.notifyDataSetChanged();
    }
}
