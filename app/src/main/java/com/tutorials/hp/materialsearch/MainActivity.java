package com.tutorials.hp.materialsearch;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MaterialSearchBar.OnSearchActionListener {

    private MaterialSearchBar searchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        searchBar = (MaterialSearchBar) findViewById(R.id.searchBar);
        searchBar.setHint("Custom hint");
        searchBar.setSpeechMode(true);
        searchBar.setOnSearchActionListener(this);

    }



    @Override
    public void onSearchStateChanged(boolean b) {
        String state = b ? "enabled" : "disabled";
        Toast.makeText(MainActivity.this, "Search " + state, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSearchConfirmed(CharSequence charSequence) {
        Toast.makeText(this,"Searching "+ charSequence.toString()+" ......",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onButtonClicked(int i) {
        switch (i){
            case MaterialSearchBar.BUTTON_NAVIGATION:
                Toast.makeText(MainActivity.this, "Button Nav " , Toast.LENGTH_SHORT).show();
                break;
            case MaterialSearchBar.BUTTON_SPEECH:
                Toast.makeText(MainActivity.this, "Speech " , Toast.LENGTH_SHORT).show();
        }
    }
}
