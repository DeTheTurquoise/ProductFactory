package dmm.productfactory.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import dmm.productfactory.R;
import dmm.productfactory.jsonObjects.JsonData;
import dmm.productfactory.jsonObjects.JsonParser;

public class StoryActivity extends AppCompatActivity{



    private int storyNumber = 0;
    private int poemsCount = JsonParser.countPoems(JsonData.POEM_DATA) - 1;
    private TextView titleText;
    private TextView generalTextView;
    private Button leftButton;
    private Button rightButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story_layout);
        prepareScreen();
        refreshScreen();
    }

    private void prepareScreen(){
        titleText = (TextView) findViewById(R.id.poem_title);
        generalTextView = (TextView) findViewById(R.id.poem_general_text);
        leftButton = (Button) findViewById(R.id.left_button);
        rightButton = (Button) findViewById(R.id.right_button);
    }

    private void refreshScreen(){
        titleText.setText(JsonParser.getPoemTitle(JsonData.POEM_DATA,storyNumber));
        generalTextView.setText(JsonParser.getPoemText(JsonData.POEM_DATA,storyNumber));
        setButtonsVisibility();
    }

    public void nextPage(View view){
        storyNumber++;
        refreshScreen();
    }

    public void previousPage(View view){
        storyNumber--;
        refreshScreen();
    }

    private void setButtonsVisibility(){
        if(storyNumber == poemsCount){
            rightButton.setVisibility(View.INVISIBLE);
            leftButton.setVisibility(View.VISIBLE);
        }
        else if(storyNumber == 0){
            leftButton.setVisibility(View.INVISIBLE);
            rightButton.setVisibility(View.VISIBLE);
        } else {
            leftButton.setVisibility(View.VISIBLE);
            rightButton.setVisibility(View.VISIBLE);
        }
    }

    public void setGeneralText(String text){
        generalTextView.setText(text);
    }

    public String getGeneralText(){
        return generalTextView.getText().toString();
    }





}