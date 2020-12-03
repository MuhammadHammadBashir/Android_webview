package com.example.android_webview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OpenCamera extends AppCompatActivity {
    public static final int REQUEST_CODE = 0;
    public static final int REQUEST_CODE1 = 1;
    private Button takeImg;
    private Button getImg;
    private ImageView img;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_camera);
        takeImg=findViewById(R.id.btn);
        getImg=findViewById(R.id.btn1);
        img=findViewById(R.id.img);

        takeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent,REQUEST_CODE);





            }

        });
        getImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(pickPhoto ,REQUEST_CODE1);//one can be replaced with any action code




            }

        });





    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case 0:
                if(resultCode == RESULT_OK){
                    Bitmap cameraImage = (Bitmap) data.getExtras().get("data");
                    img.setImageBitmap(cameraImage);

                }

                break;
            case 1:
                if(resultCode == RESULT_OK){
                    Bitmap cameraImage = (Bitmap) data.getExtras().get("data");
                    img.setImageBitmap(cameraImage);

                }
                break;
        }





    }
}