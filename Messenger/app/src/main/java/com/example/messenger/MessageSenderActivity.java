package com.example.messenger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MessageSenderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_sender);
    }

    public void onButtonClickHandleMe(View view) {
        EditText editText = findViewById(R.id.messageText);
        String message = editText.getText().toString();

        Intent intent = new Intent(this,MessageRecieverActivity.class);
        intent.putExtra(MessageRecieverActivity.EXTRA_MESSAGE,message);
        startActivity(intent);
    }
}
