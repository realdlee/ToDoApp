package com.lee.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {
    EditText editText;
    Integer position;

    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        editText = (EditText) findViewById(R.id.editText);

        position = getIntent().getIntExtra("position", 0);
        String text = getIntent().getStringExtra("text");
        editText.setText("");
        editText.append(text);
    }

    public void onEditItem(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        Intent data = new Intent();
        data.putExtra("text", editText.getText().toString());
        data.putExtra("position", position);
        setResult(RESULT_OK, data);
        this.finish();
    }
}
