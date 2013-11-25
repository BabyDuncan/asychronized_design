package com.babyduncan.asynchronous.future;

import org.apache.log4j.Logger;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * User: guohaozhao (guohaozhao116008@sohu-inc.com)
 * Date: 11/25/13 11:31
 * a synchronized design
 */
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String... args) {
        ExecutorService executors = Executors.newCachedThreadPool();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    logger.error(e.getMessage(), e);
                }
                logger.info("heavy task has done !!!");
            }
        };

        Callable<String> callableTask = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(600);
                logger.info("heavy callable task has done !!!");
                return "foobar";
            }
        };

        Future<?> future1 = executors.submit(task);
        Future<String> future2 = executors.submit(callableTask);

        while (!future1.isDone() && !future2.isDone()) {
            logger.info("some other process in main thread ...");
            logger.info("some other process in main thread |||");
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
        }
        System.exit(0);


    }

}
