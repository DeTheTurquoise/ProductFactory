package dmm.productfactory.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

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
