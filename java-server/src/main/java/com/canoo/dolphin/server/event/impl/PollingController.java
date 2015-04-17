package com.canoo.dolphin.server.event.impl;

import com.canoo.dolphin.server.event.DolphinEventBus;

import java.util.concurrent.TimeUnit;

/**
 * Created by hendrikebbers on 17.04.15.
 */
public class PollingController {

    public void pollEvents() {
        try {
            DolphinEventBusImpl.getInstance().sendEventsForCurrentDolphinSession(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            //this exception is called when the clients has an update and needs to stop the polling.
            // Therefore we do nothing here
        }
    }

}
