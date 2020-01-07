package com.fju.member;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean login = false;
    public static final int RC_LOGIN = 1;
    String age;
    String nickname;
    String gender;
    TextView edname;
    TextView edage;
    TextView edgender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        nickname = intent.getStringExtra("nickname");
        age = intent.getStringExtra("age");
        gender = intent.getStringExtra("gender");
        edname = findViewById(R.id.name);
        edage = findViewById(R.id.age);
        edgender = findViewById(R.id.gender);
        edname.setText(nickname);
        edage.setText(age);
        edgender.setText(gender);
        if(nickname!=null && age!= null && gender!= null ){
            login = true ;
        };
        if (!login){
            Intent intent1 = new Intent(this,NicknameActivity.class);
            startActivityForResult(intent1,RC_LOGIN);
        };

    }
}
