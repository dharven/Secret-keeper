package com.example.sharedprefs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private TextView result;
    private Button save;
    private SharedPreferences myprefs;
    private static final String PREFS_NAME = "myprefsfile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText)findViewById(R.id.nameID);
        result = (TextView)findViewById(R.id.resultID);
        save = (Button)findViewById(R.id.saveID);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myprefs = getSharedPreferences(PREFS_NAME,0);
                //now you need to add in it
                SharedPreferences.Editor editor = myprefs.edit();
                editor.putString("message",name.getText().toString());
                //now you need to save it
                editor.commit();
            }
        });

        //i need to get the data back
        SharedPreferences prefs =getSharedPreferences(PREFS_NAME,0);
        if(prefs.contains("message")){
            String message = prefs.getString("message","not found");
            result.setText("message:" + message);
        }


    }
}
