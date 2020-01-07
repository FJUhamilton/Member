package com.fju.member;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NicknameActivity extends AppCompatActivity {
    EditText edname;
    String nickname;
    SharedPreferences pres;
    public static final int RC_LOGIN = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nickname);


    }
    public void nickbtn(View v) {
        edname = findViewById(R.id.nickname);
        nickname = edname.getText().toString();
        pres = getSharedPreferences("example",MODE_PRIVATE);
        pres.edit()
                .putString("nickname",nickname)
                .commit();
        Intent intent = new Intent(this,AgeActivity.class);
        intent.putExtra("nickname",nickname);
        startActivityForResult(intent,RC_LOGIN);
    }
}
