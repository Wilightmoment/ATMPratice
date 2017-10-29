package com.example.user.atmpratice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {
    boolean logon=false;
    public static final int FUNC_LOGIN=1;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==FUNC_LOGIN){
            if(resultCode==RESULT_OK){
                String uid= data.getStringExtra("Login_user");
                String pw=data.getStringExtra("Login_pwd");
            }else finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if(!logon){
            Intent intent =new Intent(this,MainActivity.class);
            startActivityForResult(intent,FUNC_LOGIN);
        }
    }
}
