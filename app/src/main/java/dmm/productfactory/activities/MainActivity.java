package dmm.productfactory.activities;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import dmm.productfactory.R;
import dmm.productfactory.databaseObjects.StoryDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StoryDatabase db = Room.databaseBuilder(getApplicationContext(),
                StoryDatabase.class, "story_database").build();
    }


    public void startReading(View view){
        startActivity(new Intent(this,StoryActivity.class));
    }


}
