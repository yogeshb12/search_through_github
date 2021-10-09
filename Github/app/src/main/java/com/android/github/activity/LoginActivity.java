package com.android.github.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.github.R;
import com.android.github.utils.AppPreferences;
import com.android.github.utils.Constants;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = LoginActivity.class.getSimpleName();
    private AppPreferences mAppPreferences = new AppPreferences();
    private EditText mTxtUserName;
    private EditText mTxtPassword;
    private Button mSignInBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        mSignInBtn.setOnClickListener(this);
    }

    private void initViews() {
        mTxtUserName = findViewById(R.id.usernameEditTxt);
        mTxtPassword = findViewById(R.id.pswdEditTxt);
        mSignInBtn = findViewById(R.id.signIn);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.signIn:
                if (mTxtUserName.getText().toString().length() > 0 && mTxtPassword.getText().toString().length() > 0) {
                    mAppPreferences.set(getApplicationContext(), Constants.PREFERENCES)
                            .setData(Constants.KEY_USERNAME, mTxtUserName.getText().toString())
                            .setData(Constants.KEY_PASSWORD, mTxtPassword.getText().toString());
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Enter all fields", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}