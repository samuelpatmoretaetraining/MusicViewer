package com.muelpatmore.musicviewer;

import com.muelpatmore.musicviewer.model.TrackListModel;
import com.muelpatmore.musicviewer.utils.ConnectionService;
import com.muelpatmore.musicviewer.utils.RequestInterface;

import io.reactivex.Observable;

/**
 * Created by Samuel on 27/11/2017.
 */

public class AppApiHelper implements APIHelper {

    private RequestInterface connection;

    public AppApiHelper() {
        connection = ConnectionService.getConnection();
    }

    @Override
    public Observable<TrackListModel> getClassicList() {
        return connection.getClassicList();
    }

    @Override
    public Observable<TrackListModel> getRockList() {
        return connection.getRockList();
    }

    @Override
    public Observable<TrackListModel> getPopList() {
        return connection.getPopList();
    }


}
