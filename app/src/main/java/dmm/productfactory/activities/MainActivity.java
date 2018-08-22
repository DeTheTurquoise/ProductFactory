package dmm.productfactory.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

import dmm.productfactory.R;
import dmm.productfactory.applicationData.ThingsToDo;

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

    public void selectRandom(View view) {
        int thing = random.nextInt(thingsToDo.length);
        text.setText(thingsToDo[thing]);
    }
}