package com.muelpatmore.musicviewer;

import com.muelpatmore.musicviewer.model.TrackListModel;
import com.muelpatmore.musicviewer.utils.AppSchedulerProvider;
import com.muelpatmore.musicviewer.utils.SchedulerProvider;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * Created by Samuel on 27/11/2017.
 */

public class MusicListViewModel {

    private static MusicListViewModel instance = null;
    private AppApiHelper appApiHelper;
    private CompositeDisposable disposable;
    private SchedulerProvider scheduler = new AppSchedulerProvider();

    private TrackListView classicView;

    private MusicListViewModel() {
        appApiHelper = new AppApiHelper();
        disposable = new CompositeDisposable();
    }

    public static MusicListViewModel getInstance() {
        if (instance == null) {
            instance = new MusicListViewModel();
        }
        return instance;
    }

    public Observable<TrackListModel> getGenreObservable(String genre) {
        switch (genre) {
            case "classic" :
                return appApiHelper.getClassicList();
            case "rock" :
                return appApiHelper.getRockList();
            case "pop" :
                return appApiHelper.getPopList();
        }
        return null;
    }
}
