package com.example.user.locistest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CreateRoomActivity extends AppCompatActivity {

ArrayList<FriendInList> friendsList;
    ListView listViewFriends;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_room);
        friendsListView();
    }

    private void friendsListView(){
        friendsList = new ArrayList<>();
        friendsList.add(new FriendInList("Борян"));
        friendsList.add(new FriendInList("Антоха"));
        friendsList.add(new FriendInList("ВиВиВи"));
        friendsList.add(new FriendInList("Кадаш"));

        listViewFriends = (ListView) findViewById(R.id.create_room_friends_lv);
    }
}
