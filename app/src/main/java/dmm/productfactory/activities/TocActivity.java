package dmm.productfactory.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import dmm.productfactory.R;
import dmm.productfactory.jsonObjects.JsonData;
import dmm.productfactory.jsonObjects.JsonParser;
import dmm.productfactory.recyclerView.TocAdapter;

public class TocActivity extends AppCompatActivity implements TocAdapter.ListItemClickListener {



    private TextView storyTitle;
    private int numberOfResultsToDisplay = JsonParser.countObjects(JsonData.POEM_DATA);
    private TocAdapter tocAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toc);
        storyTitle = (TextView) findViewById(R.id.story_title_list_element);
        recyclerView = (RecyclerView) findViewById(R.id.story_toc_list_element);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        tocAdapter = new TocAdapter(numberOfResultsToDisplay, this);
        recyclerView.clearOnScrollListeners();
        tocAdapter.setToc(JsonParser.getObjectsList(JsonData.POEM_DATA));
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(tocAdapter);
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        Intent intent = new Intent(this,QuestionActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT,clickedItemIndex);
        startActivity(intent);
    }
}
