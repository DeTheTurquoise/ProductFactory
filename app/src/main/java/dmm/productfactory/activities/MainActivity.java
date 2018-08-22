package dmm.productfactory.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

import dmm.productfactory.R;
import dmm.productfactory.applicationData.ThingsToDo;
import dmm.productfactory.jsonObjects.JsonData;
import dmm.productfactory.jsonObjects.JsonParser;

public class MainActivity extends AppCompatActivity {

    private TextView title;
    private TextView text;
    String[] thingsToDo;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.random_play);
        title = (TextView) findViewById(R.id.title_text);
        text = (TextView) findViewById(R.id.main_text);


        thingsToDo = ThingsToDo.getPlayForChildren();
        int thing = random.nextInt(thingsToDo.length);

        text.setText(thingsToDo[thing]);
        title.setText(R.string.play_text);


    }

    public void selectRandom(View view){
        int thing = random.nextInt(thingsToDo.length);
        text.setText(thingsToDo[thing]);
    }

    public void startReading(View view){
        startActivity(new Intent(this,StoryActivity.class));
    }

    public void startToc(View view){
        startActivity(new Intent(this,TocActivity.class));
    }

    public void startFromRandomPage(View view){
        Random randomPage = new Random();
        Intent intent = new Intent(this,StoryActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT,randomPage.nextInt(JsonParser.countObjects(JsonData.POEM_DATA)));
        startActivity(intent);
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu, menu);    return true;}
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        return selectItem(item);}
//
//    public boolean selectItem(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.menu_toc:
//                for (String thingToDo : thingsToDo) {
//                    allItems.append(thingToDo + "\n");
//                }
//                return true;
//            case R.id.menu_no:
//                allItems.setText("");
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);    }
//    }

}
