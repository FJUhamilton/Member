package com.fju.member;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AgeActivity extends AppCompatActivity {
    EditText edage ;
    String age;
    String nickname;
    SharedPreferences pres1;
    public static final int RC_LOGIN = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age);

    }
    public void agebtn(View v) {
        edage = findViewById(R.id.edage);
        Intent intent = getIntent();
        nickname = intent.getStringExtra("nickname");
        age = edage.getText().toString();
        pres1 = getSharedPreferences("example",MODE_PRIVATE);
        pres1.edit()
                .putString("age",age)
                .putString("nickname",nickname)
                .commit();
        Intent intent1 = new Intent(this,GenderActivity.class);
        intent1.putExtra("nickname",nickname);
        intent1.putExtra("age",age);
        startActivityForResult(intent1,RC_LOGIN);
    }
}
