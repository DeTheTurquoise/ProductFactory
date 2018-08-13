package dmm.productfactory.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ScrollView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import dmm.productfactory.R;
import dmm.productfactory.jsonObjects.JsonData;
import dmm.productfactory.jsonObjects.JsonParser;

public class QuestionActivity extends AppCompatActivity {

    private TextView question;
    private TextView chosenText;
    private TextView perspective;
    private ScrollView scrollView;

    private int monthNumber;
    private int weekNumber;
    private int motivationNumber;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);
        prepareScreen();
        setMonthAndWeekNumbers();
        Intent intentThatStartedThisActivity = getIntent();
        if (intentThatStartedThisActivity != null) {
            if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)) {
                monthNumber = intentThatStartedThisActivity.getIntExtra(Intent.EXTRA_TEXT,0);
            }
        }
        setMonthData();

    }

    private void prepareScreen(){
        question = (TextView) findViewById(R.id.text_question);
        chosenText = (TextView) findViewById(R.id.text_chosen);
        perspective = (TextView) findViewById(R.id.text_perspective);
        scrollView = (ScrollView) findViewById(R.id.text_scroll);
    }

    private void setMonthAndWeekNumbers(){
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        monthNumber = calendar.get(Calendar.MONTH);
        weekNumber = calendar.get(Calendar.WEEK_OF_MONTH);
        if(calendar.get(Calendar.DAY_OF_MONTH)>14){
            motivationNumber = 1;
        } else{
            motivationNumber = 2;
        }
    }

    private void setMonthData(){
        question.setText(JsonParser.getObjectQuestion(JsonData.POEM_DATA,monthNumber));
        perspective.setText("PERSPEKTYWA: " + JsonParser.getObjectPerspective(JsonData.POEM_DATA,monthNumber));
        chosenText.setText(JsonParser.getObjectDescription(JsonData.POEM_DATA,monthNumber));
    }

    public void displayBegin(){
        chosenText.setText(JsonParser.getObjectBegin(JsonData.POEM_DATA,monthNumber));
        scrollView.scrollTo(0,0);
    }

    public void displayEnd(){
        chosenText.setText(JsonParser.getObjectEnd(JsonData.POEM_DATA,monthNumber));
        scrollView.scrollTo(0,0);
    }

    public void displayMiddle(){
        chosenText.setText(JsonParser.getObjectMiddle(JsonData.POEM_DATA,monthNumber));
        scrollView.scrollTo(0,0);
    }

    public void displayQuote(){
        chosenText.setText(JsonParser.getObjectQuote(JsonData.POEM_DATA,monthNumber) + "\n\n" + JsonParser.getObjectQuoteAuthor(JsonData.POEM_DATA,monthNumber));
        scrollView.scrollTo(0,0);
    }

    public void displayMotivation(){
        chosenText.setText(JsonParser.getObjectMotivation(JsonData.POEM_DATA,monthNumber,motivationNumber));
        scrollView.scrollTo(0,0);
    }

    public void displayWork(){
        chosenText.setText(JsonParser.getObjectWork(JsonData.POEM_DATA,monthNumber,weekNumber + 1));
        scrollView.scrollTo(0,0);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);    return true;}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return selectItem(item);}

    public boolean selectItem(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_start:
                displayBegin();
                return true;
            case R.id.menu_middle:
                displayMiddle();
                return true;
            case R.id.menu_end:
                displayEnd();
                return true;
            case R.id.menu_quote:
                displayQuote();
                return true;
            case R.id.mwnu_work:
                displayWork();
                return true;
            case R.id.menu_motivation:
                displayMotivation();
                return true;
            case R.id.menu_toc:
                startActivity(new Intent(this,TocActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);    }
    }

}
