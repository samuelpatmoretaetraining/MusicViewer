package com.muelpatmore.musicviewer.utils;

import com.muelpatmore.musicviewer.model.TrackListModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Samuel on 27/11/2017.
 */

public interface RequestInterface {
    public static final String CLASSIC_QUERY= "/search?term=classic&amp;media=music&amp;entity=song&amp;limit=50";
    public static final String ROCK_QUERY= "/search?term=rock&amp;media=music&amp;entity=song&amp;limit=50";
    public static final String POP_QUERY= "/search?term=pop&amp;media=music&amp;entity=song&amp;limit=50";

    @GET(CLASSIC_QUERY)
    Observable<TrackListModel> getClassicList();

    @GET(ROCK_QUERY)
    Observable<TrackListModel> getRockList();

    @GET(POP_QUERY)
    Observable<TrackListModel> getPopList();
}
