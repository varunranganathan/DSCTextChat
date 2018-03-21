package com.varun.dsctextchat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        final EditText messageEditText = findViewById(R.id.userMessageEditText);
        Button sendMessageButton = findViewById(R.id.sendMessageButton);

        final String userID = getIntent().getStringExtra("uid");

        sendMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userMessage = messageEditText.getEditableText().toString();
                if(!userMessage.equals("")) {
                    userMessage = FirebaseAuth.getInstance().getCurrentUser().getDisplayName()+" : "+userMessage;
                    DatabaseReference otherUserRef =
                            FirebaseDatabase.getInstance().getReference("posts/"+userID);
                    otherUserRef.push().setValue(userMessage);

                }else {
                    Toast.makeText(MessageActivity.this, "Please enter a message!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
