package com.example.user.atmpratice;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText uid,psd;
    private Button login,cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uid=(EditText) findViewById(R.id.et_1);
        SharedPreferences pref=getSharedPreferences("atm",MODE_PRIVATE);
        uid.setText(pref.getString("PREF_USER",""));
        findview();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.action_settings){
            Toast.makeText(this,"設定",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void findview(){
        uid=(EditText) findViewById(R.id.et_1);
        psd=(EditText) findViewById(R.id.et_2);
        login=(Button) findViewById(R.id.btn_1);
        cancel=(Button) findViewById(R.id.btn_2);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String user=uid.getText().toString().trim();
                 String pwd=psd.getText().toString().trim();
                if(user.equals("jack") && pwd.equals("1234")){
                    SharedPreferences pref = getSharedPreferences("atm",MODE_PRIVATE);
                    pref.edit().putString("PREF_USER",user).commit();
                    Toast.makeText(MainActivity.this,"登入成功",Toast.LENGTH_SHORT).show();
                    getIntent().putExtra("Login_user",user);
                    getIntent().putExtra("Login_pwd",pwd);
                    setResult(RESULT_OK,getIntent());
                    finish();
                }else{
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("ATM")
                            .setMessage("登入失敗")
                            .setPositiveButton("OK",null)
                            .show();
                }
            }
        });
        
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uid.setText("");
                psd.setText("");
            }
        });
    }
}
