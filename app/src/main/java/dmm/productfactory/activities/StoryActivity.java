package dmm.productfactory.activities;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import dmm.productfactory.R;
import dmm.productfactory.databaseObjects.StoryDatabase;

public class StoryActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StoryDatabase db = Room.databaseBuilder(getApplicationContext(),
                StoryDatabase.class, "story_database").build();
    }


    private TextView titleText;
    private TextView generalTextView;
    private Button leftButton;
    private Button rightButton;


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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);    return true;}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return selectItem(item);}

    public boolean selectItem(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_toc:
                startActivity(new Intent(this,TocActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);    }
    }


}
