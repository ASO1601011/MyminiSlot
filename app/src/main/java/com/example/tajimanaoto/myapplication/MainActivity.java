package com.example.tajimanaoto.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import static android.support.v7.appcompat.R.styleable.View;

public class MainActivity extends AppCompatActivity {

    String value = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup radio = (RadioGroup) findViewById(R.id.radioGroup);
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                value = radioButton.getText().toString();
                ImageView img = (ImageView) findViewById(R.id.imageView);
                switch (value) {
                    case "aaa@aaa.com":
                        img.setImageResource(R.drawable.gu);
                        break;
                    case "bbb@aaa.com":
                        img.setImageResource(R.drawable.pa);
                        break;
                    case "ccc@aaa.com":
                        img.setImageResource(R.drawable.choki);
                        break;
                }
            }
        });}

        public void onSubmitButtonTapped(View view) {
            Uri uri = Uri.parse("mailto:" + value);
            Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
            EditText etext1 = (EditText) findViewById(R.id.title);
            String title = etext1.getText().toString();
            intent.putExtra(Intent.EXTRA_SUBJECT, title);
            EditText etext2 = (EditText) findViewById(R.id.honbun);
            String memo = etext2.getText().toString();
            intent.putExtra(Intent.EXTRA_TEXT, memo);
            startActivity(intent);
        }
    }
}

