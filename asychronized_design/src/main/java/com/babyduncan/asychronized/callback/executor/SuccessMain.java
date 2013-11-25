package com.babyduncan.asychronized.callback.executor;

import com.babyduncan.asychronized.callback.FetcherCallBack;
import com.babyduncan.asychronized.callback.internal.SimpleFetcher;
import org.apache.log4j.Logger;

/**
 * User: guohaozhao (guohaozhao116008@sohu-inc.com)
 * Date: 11/25/13 11:18
 */
public class SuccessMain {

    private static final Logger logger = Logger.getLogger(SuccessMain.class);

    public static void main(String... args) {
        final SimpleFetcher simpleFetcher = new SimpleFetcher();
        new Thread(new Runnable() {
            @Override
            public void run() {
                simpleFetcher.fetch(new TestCallBack());
            }
        }).start();
        logger.info("do something in main thread ...");
        logger.info("do something in main thread ,,,");
        logger.info("do something in main thread ///");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        }

    }

    private static class TestCallBack implements FetcherCallBack {

        @Override
        public void fetchSuccess(String s) {
            logger.info(s);
        }

        @Override
        public void fetchError(String error) {
            logger.error(error);
        }
    }

}
