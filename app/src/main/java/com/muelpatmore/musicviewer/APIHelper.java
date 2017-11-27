package com.muelpatmore.musicviewer;

import com.muelpatmore.musicviewer.model.TrackListModel;
import com.muelpatmore.musicviewer.utils.API_Constants;

import io.reactivex.Observable;

/**
 * Created by Samuel on 27/11/2017.
 */

public interface APIHelper {

    Observable<TrackListModel> getClassicList();
    Observable<TrackListModel> getRockList();
    Observable<TrackListModel> getPopList();
}

