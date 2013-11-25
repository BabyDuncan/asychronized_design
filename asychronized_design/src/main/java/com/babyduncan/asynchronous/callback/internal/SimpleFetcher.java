package com.babyduncan.asynchronous.callback.internal;

import com.babyduncan.asynchronous.callback.Fetcher;
import com.babyduncan.asynchronous.callback.FetcherCallBack;
import org.apache.log4j.Logger;

/**
 * User: guohaozhao (guohaozhao116008@sohu-inc.com)
 * Date: 11/25/13 11:08
 */
public class SimpleFetcher implements Fetcher {

    private static final Logger logger = Logger.getLogger(SimpleFetcher.class);

    @Override
    public String fetch(FetcherCallBack fetcherCallBack) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        }
        String s = "foobar";
        fetcherCallBack.fetchSuccess(s);
        return s;
    }
}
