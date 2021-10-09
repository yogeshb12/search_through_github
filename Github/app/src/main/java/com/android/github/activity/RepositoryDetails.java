package com.android.github.activity;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.github.R;

public class RepositoryDetails extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repository_details);

        String repo = getIntent().getStringExtra("repo");
        TextView details = (TextView) findViewById(R.id.Details);
        details.setText(repo);
    }
}