package com.remijonathan.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DisplayMessage extends AppCompatActivity {
    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        output = findViewById(R.id.outputMessage);

        output.setText(getIntent().getStringExtra("Message"));

    output.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = getIntent();
            intent.putExtra("message back","From the second Activity");
            //Send something back if it's OK to do so.
            setResult(RESULT_OK, intent);
            finish();
        }
    });
    }


}
