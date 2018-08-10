package dmm.productfactory.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

import dmm.productfactory.R;
import dmm.productfactory.jsonObjects.JsonData;
import dmm.productfactory.jsonObjects.JsonParser;

public class MainActivity extends AppCompatActivity {

    private TextView title;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = (TextView) findViewById(R.id.title_text);
        text = (TextView) findViewById(R.id.main_text);

        text.setText(JsonParser.getAuthor(JsonData.POEM_DATA));
        title.setText(JsonParser.getTitle(JsonData.POEM_DATA));
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
        intent.putExtra(Intent.EXTRA_TEXT,randomPage.nextInt(JsonParser.countPoems(JsonData.POEM_DATA)));
        startActivity(intent);
    }
}
