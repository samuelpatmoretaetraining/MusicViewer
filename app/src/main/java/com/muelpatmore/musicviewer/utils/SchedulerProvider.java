package com.muelpatmore.musicviewer.utils;

import io.reactivex.Scheduler;

/**
 * Created by Samuel on 27/11/2017.
 */

public interface SchedulerProvider {

    Scheduler ui();

    Scheduler computation();

    Scheduler io();

}
