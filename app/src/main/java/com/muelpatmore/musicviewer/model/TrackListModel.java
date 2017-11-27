package com.muelpatmore.musicviewer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Samuel on 27/11/2017.
 */

public class TrackListModel {

    @SerializedName("resultCount")
    @Expose
    private Integer resultCount;
    @SerializedName("results")
    @Expose
    private List<TrackModel> results = null;

    public Integer getResultCount() {
        return resultCount;
    }

    public void setResultCount(Integer resultCount) {
        this.resultCount = resultCount;
    }

    public List<TrackModel> getResults() {
        return results;
    }

    public void setResults(List<TrackModel> results) {
        this.results = results;
    }

}

