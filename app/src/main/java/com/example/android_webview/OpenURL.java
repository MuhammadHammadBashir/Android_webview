package com.example.android_webview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.HttpCookie;

public class OpenURL extends AppCompatActivity {
    private EditText input;
    private Button load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_u_r_l);
        input=findViewById(R.id.input);
        load=findViewById(R.id.button);
        load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String URL=input.getText().toString();


                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse(URL));
                Intent chooser=Intent.createChooser(intent,"Choose an Application");
                if(intent.resolveActivity(getPackageManager())!=null)
                {
                    startActivity(chooser);
                }
            }
        });
    }
}