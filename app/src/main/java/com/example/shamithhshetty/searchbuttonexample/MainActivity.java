package com.example.shamithhshetty.searchbuttonexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SearchEvent;
import android.view.View;

import com.example.searchbutton.SearchButton;

public class MainActivity extends AppCompatActivity {

    SearchButton l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l=findViewById(R.id.btn);

    }
    public void start(View view){
        l.open();
    }
    public void close(View view){
        l.close();
    }

}
