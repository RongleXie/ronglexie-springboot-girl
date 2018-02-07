package com.ronglexie.ronglexiegirl.handle;

import org.apache.http.client.methods.RequestBuilder;

/**
 * HttpClient 操作具类
 * 请求方式: POST
 * @author ronglexie
 * @version 2018-2-7
 */
public class HttpClientPostHandler extends HttpClientHandler {

    public HttpClientPostHandler(String url) {
        super(url);
    }

    @Override
    protected RequestBuilder createRequestBuilder() {
        return RequestBuilder.post();
    }
}
