package com.example.accesscontentprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView loadDataTV;

    public Uri CONTENT_URI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }
    private void init(){
        loadDataTV=findViewById(R.id.loadDataTV);
        CONTENT_URI=Uri.parse("content://com.example.companyprovider.provider/EMPLOYEE".trim());
        Log.d("CONTENT_URI",CONTENT_URI.toString());

    }

    public void loadData(View view) {
        Cursor cursor= getContentResolver().query(CONTENT_URI,null,null,null,"ID");
        StringBuilder stringBuilder = new StringBuilder();
        while (cursor.moveToNext()){
            int id=cursor.getInt(0);
            String name=cursor.getString(1);
            String pos=cursor.getString(2);
            stringBuilder.append(id+"\t\t"+name+"\t\t"+pos+"\n");
        }
        loadDataTV.setText(stringBuilder);
        cursor.close();
    }
}