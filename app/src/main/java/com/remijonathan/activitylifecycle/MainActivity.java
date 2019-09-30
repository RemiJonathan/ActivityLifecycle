package com.remijonathan.activitylifecycle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText enteredText;
    private Button submitButton;
    private final int REQUEST_CODE = 2;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            assert data != null;
            String message = data.getStringExtra("message back");
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
        }
//        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enteredText = findViewById(R.id.enteredText);
        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DisplayMessage.class);
                intent.putExtra("Message", enteredText.getText().toString());
                startActivityForResult(intent, REQUEST_CODE);
            }
        });


        Toast.makeText(MainActivity.this, "Create()", Toast.LENGTH_SHORT).show();
        Log.d("Life", "onCreate: called");
    }

    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(MainActivity.this, "onStart()", Toast.LENGTH_SHORT).show();
        Log.d("Life", "onStart: called");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        Toast.makeText(MainActivity.this, "onPostResume()", Toast.LENGTH_SHORT).show();
        Log.d("Life", "onPostResume: called");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Toast.makeText(MainActivity.this, "onPause()", Toast.LENGTH_SHORT).show();
        Log.d("Life", "onPause: called");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Toast.makeText(MainActivity.this, "onStop()", Toast.LENGTH_SHORT).show();
        Log.d("Life", "onStop: called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Toast.makeText(MainActivity.this, "onRestart()", Toast.LENGTH_SHORT).show();
        Log.d("Life", "onRestart: called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Toast.makeText(MainActivity.this, "onDestroy()", Toast.LENGTH_SHORT).show();
        Log.d("Life", "onDestroy: called");
    }
}
