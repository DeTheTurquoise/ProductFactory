package dmm.productfactory.activities;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import dmm.productfactory.R;
import dmm.productfactory.databaseObjects.StoryDatabase;

public class MainActivity extends AppCompatActivity {

    private TextView generalTextView;
    private Button leftButton;
    private Button rightButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StoryDatabase db = Room.databaseBuilder(getApplicationContext(),
                StoryDatabase.class, "story_database").build();
    }

    public void nextPage(View view){

    }

    public void previousPage(View view){

    }

    public void setGeneralText(String text){
        generalTextView.setText(text);
    }

    public String getGeneralText(){
        return generalTextView.getText().toString();
    }
}
