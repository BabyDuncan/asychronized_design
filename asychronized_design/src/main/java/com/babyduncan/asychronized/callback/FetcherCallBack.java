package com.babyduncan.asychronized.callback;

/**
 * User: guohaozhao (guohaozhao116008@sohu-inc.com)
 * Date: 11/25/13 11:07
 * fetcher call back
 */
public interface FetcherCallBack {

    /**
     * if fetcher success
     */
    public void fetchSuccess(String s);

    /**
     * if fetch failed or catch an exception
     */
    public void fetchError(String error);

}
