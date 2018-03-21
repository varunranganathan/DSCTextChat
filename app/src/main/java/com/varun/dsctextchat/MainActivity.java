package com.varun.dsctextchat;

import android.content.Intent;
import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    final int GOOGLE_NUMBER = 111;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == GOOGLE_NUMBER){
            if(resultCode== RESULT_OK){
                Toast.makeText(this, "You have signed in!", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "Error signing in!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(FirebaseAuth.getInstance().getCurrentUser()==null){
            //User is not signed in

            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setAvailableProviders(Arrays.asList(
                                    new AuthUI.IdpConfig.GoogleBuilder().build()))
                            .build(),
                    GOOGLE_NUMBER);
        }else{
            //User is signed in
            DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("users/"+FirebaseAuth.getInstance().getCurrentUser().getUid());
            TextChatUser currUser = new TextChatUser(FirebaseAuth.getInstance().getCurrentUser().getDisplayName(),
                    FirebaseAuth.getInstance().getCurrentUser().getUid());
            userRef.setValue(currUser);
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivity(intent);
            Toast.makeText(this, FirebaseAuth.getInstance().getUid(), Toast.LENGTH_SHORT).show();
        }
    }

}
