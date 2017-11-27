package com.muelpatmore.musicviewer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.muelpatmore.musicviewer.model.TrackListModel;
import com.muelpatmore.musicviewer.model.TrackModel;
import com.muelpatmore.musicviewer.utils.AppSchedulerProvider;
import com.muelpatmore.musicviewer.utils.ConnectionService;
import com.muelpatmore.musicviewer.utils.RequestInterface;
import com.muelpatmore.musicviewer.utils.SchedulerProvider;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

public class TrackListView extends AppCompatActivity {

    private final String TAG = TrackListView.class.getSimpleName();

    private MusicListViewModel viewModel;
    private final CompositeDisposable mSubscription = new CompositeDisposable();
    private SchedulerProvider scheduler = new AppSchedulerProvider();
    private ArrayList<TrackModel> trackList;
    private String genre = "classic";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classic_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewModel = MusicListViewModel.getInstance();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public void onResume() {
        super.onResume();
        listenForTrackList(genre);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_classic_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        mSubscription.dispose();
        mSubscription.clear();
        super.onPause();
    }

    private void listenForTrackList(String genre) {
        Observable<TrackListModel> observable = viewModel.getGenreObservable(genre);
        mSubscription.add(observable
                .observeOn(scheduler.ui())
                .subscribeOn(scheduler.io())
                .subscribe(trackListModel -> {
                    //setTrackList(new ArrayList<>(trackListModel.getResults()));
                    for (TrackModel t : trackListModel.getResults()) {
                        Log.i(TAG, t.getTrackName());
                    }
                }, Throwable::printStackTrace));
    }

    public void setTrackList(ArrayList<TrackModel> trackList) {
        this.trackList = trackList;
        initRecyclerView();
    }

    public void initRecyclerView() {
        if(trackList == null) {
            listenForTrackList(genre);
        }
    }


}
