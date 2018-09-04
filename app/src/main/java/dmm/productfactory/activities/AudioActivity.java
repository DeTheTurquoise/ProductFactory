package dmm.productfactory.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.media.session.MediaButtonReceiver;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;

import org.json.JSONException;

import java.io.IOException;
import java.net.URL;

import dmm.productfactory.R;
import dmm.productfactory.jsonObjects.JsonParser;
import dmm.productfactory.network.NetworkData;
import dmm.productfactory.network.NetworkUtils;
import dmm.productfactory.recyclerView.TocAdapter;

public class AudioActivity extends AppCompatActivity implements View.OnClickListener, ExoPlayer.EventListener, TocAdapter.ListItemClickListener{

    private SimpleExoPlayer mExoPlayer;
    private SimpleExoPlayerView mPlayerView;
    private static MediaSessionCompat mMediaSession;
    private static PlaybackStateCompat.Builder mStateBuilder;
    private EditText podcastSearched;
    private TextView errorMessage;
    private ProgressBar connectionProgress;
    private static int numberOfResultsToDisplay = 20;
    private static TocAdapter tocAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_podcast_list);


        recyclerView = (RecyclerView) findViewById(R.id.story_toc_list_element);
     //   mPlayerView = (SimpleExoPlayerView) findViewById(R.id.playerView);
        podcastSearched = (EditText) findViewById(R.id.search_episode);
        errorMessage = (TextView) findViewById(R.id.error_message_text);
        connectionProgress = (ProgressBar) findViewById(R.id.internet_connection_progress_bar);


        tocAdapter = new TocAdapter(numberOfResultsToDisplay, this);
        String digitalGirl = NetworkData.SPREAKER_API_BASE + NetworkData.SPREAKER_API_SHOWS + NetworkData.URL_SEPARATOR + NetworkData.DIGITAL_GIRLS_SHOW_NUMEBR + NetworkData.URL_SEPARATOR + NetworkData.SPREAKER_API_EPISODES;
        Log.d("SpreakerUrl", digitalGirl);
        URL url = NetworkUtils.changeToUrl(digitalGirl);
        new SpreakerConnection().execute(url);




//
//        Intent lessonIntent = getIntent();
//        String audioPath = "";
//        if(lessonIntent.hasExtra(Intent.EXTRA_TEXT)){
//            audioPath = lessonIntent.getStringExtra(Intent.EXTRA_TEXT);
//        }
//        lessonIntent.getStringExtra(audioPath);
//
//
//        mPlayerView.setPlayer(mExoPlayer);
//        initializeMediaSession();
//        initializePlayer(Uri.parse(audioPath));

    }

    private void showPodcastList(){
        errorMessage.setVisibility(View.INVISIBLE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    private void showErrorMessage(){
        recyclerView.setVisibility(View.INVISIBLE);
        errorMessage.setVisibility(View.VISIBLE);
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        Intent intent = new Intent(this,QuestionActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT,clickedItemIndex);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        releasePlayer();
        mMediaSession.setActive(false);
    }

    public void searchPodcastTitle(View view){

        String textToShow = "Search clicked";
        Toast.makeText(this.getBaseContext(), textToShow, Toast.LENGTH_SHORT).show();
    }

    private void initializeMediaSession() {

        mMediaSession = new MediaSessionCompat(this, this.getClass().getSimpleName());
        mMediaSession.setFlags(
                MediaSessionCompat.FLAG_HANDLES_MEDIA_BUTTONS |
                        MediaSessionCompat.FLAG_HANDLES_TRANSPORT_CONTROLS);
        mMediaSession.setMediaButtonReceiver(null);
        mStateBuilder = new PlaybackStateCompat.Builder()
                .setActions(
                        PlaybackStateCompat.ACTION_PLAY |
                                PlaybackStateCompat.ACTION_PAUSE |
                                PlaybackStateCompat.ACTION_SKIP_TO_PREVIOUS |
                                PlaybackStateCompat.ACTION_PLAY_PAUSE);
        mMediaSession.setPlaybackState(mStateBuilder.build());
        mMediaSession.setCallback(new MySessionCallback());
        mMediaSession.setActive(true);

    }

    private void initializePlayer(Uri mediaUri) {
        if (mExoPlayer == null) {
            TrackSelector trackSelector = new DefaultTrackSelector();
            LoadControl loadControl = new DefaultLoadControl();
            mExoPlayer = ExoPlayerFactory.newSimpleInstance(this, trackSelector, loadControl);
            mPlayerView.setPlayer(mExoPlayer);

            mExoPlayer.addListener(this);

            String userAgent = Util.getUserAgent(this, String.valueOf(R.string.app_name));
            MediaSource mediaSource = new ExtractorMediaSource(mediaUri, new DefaultDataSourceFactory(
                    this, userAgent), new DefaultExtractorsFactory(), null, null);
            mExoPlayer.prepare(mediaSource);
            mExoPlayer.setPlayWhenReady(true);
        }
    }

    @Override
    public void onTimelineChanged(Timeline timeline, Object manifest) {
    }

    @Override
    public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {
    }

    @Override
    public void onLoadingChanged(boolean isLoading) {
    }

    @Override
    public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {

    }

    @Override
    public void onPlayerError(ExoPlaybackException error) {

    }

    @Override
    public void onPositionDiscontinuity() {

    }

    @Override
    public void onClick(View view) {

    }

    private class MySessionCallback extends MediaSessionCompat.Callback {
        @Override
        public void onPlay() {
            mExoPlayer.setPlayWhenReady(true);
        }

        @Override
        public void onPause() {
            mExoPlayer.setPlayWhenReady(false);
        }

        @Override
        public void onSkipToPrevious() {
            mExoPlayer.seekTo(0);
        }
    }

    private void releasePlayer() {
        //   mNotificationManager.cancelAll();
        mExoPlayer.stop();
        mExoPlayer.release();
        mExoPlayer = null;
    }

    public static class MediaReceiver extends BroadcastReceiver {
        public MediaReceiver() {
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            MediaButtonReceiver.handleIntent(mMediaSession, intent);
        }
    }

    public class SpreakerConnection extends AsyncTask<URL, Void, String>{
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            connectionProgress.setVisibility(View.VISIBLE);
        }
        @Override
        protected String doInBackground(URL... params){
            Log.d("Spreaker", "doInBackground");
            URL episodesUrl = params[0];
            String spreakerResponse = null;
            try {
                spreakerResponse = NetworkUtils.getResponseFromHttpUrl(episodesUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.d("Spreaker", "Response "+spreakerResponse);
            return spreakerResponse;
        }

        @Override
        protected void onPostExecute(String spreakerResponse) {
            connectionProgress.setVisibility(View.INVISIBLE);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setHasFixedSize(true);

            recyclerView.clearOnScrollListeners();
            if (spreakerResponse != null && !spreakerResponse.equals("")) {
                showPodcastList();
                try {
                    tocAdapter.setToc(JsonParser.getDGlist(spreakerResponse,"title"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(tocAdapter);
            }
            else {
                showErrorMessage();
            }
        }
    }
}