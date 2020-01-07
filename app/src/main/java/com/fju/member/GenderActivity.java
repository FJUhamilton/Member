package com.fju.member;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class GenderActivity extends AppCompatActivity {
    EditText edGender;
    String age;
    String nickname;
    String gender;
    SharedPreferences pres1;
    public static final int RC_LOGIN = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
    }
    public void check(View v){
        edGender = findViewById(R.id.edgender);
        Intent intent = getIntent();
        nickname = intent.getStringExtra("nickname");
        age = intent.getStringExtra("age");
        gender = edGender.getText().toString();
        pres1 = getSharedPreferences("example",MODE_PRIVATE);
        pres1.edit()
                .putString("age",age)
                .putString("nickname",nickname)
                .putString("gender",gender)
                .commit();
        Intent intent1 = new Intent(this,MainActivity.class);
        intent1.putExtra("nickname",nickname);
        intent1.putExtra("age",age);
        intent1.putExtra("gender",gender);
        startActivityForResult(intent1,RC_LOGIN);
    }
}
