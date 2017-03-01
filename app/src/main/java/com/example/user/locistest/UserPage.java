package com.example.user.locistest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserPage extends AppCompatActivity {

    Button createRoomButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_page);
    }
    protected void onResume() {
        super.onResume();
        bindViews();
    }
    private void bindViews(){
        createRoomButton = (Button) findViewById(R.id.up_create_room_btn);
        createRoomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent createRoomIntent = new Intent(getWindow().getContext(), CreateRoomActivity.class);
                startActivity(createRoomIntent);
            }
        });
    }
}
