package io.github.kimmking.gateway.outbound.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class HttpClient {

    private String url;

    public HttpClient (String url) {
        this.url = url;
    }

    public HttpEntity get() {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet(url);
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        try {
            response = client.execute(get);
            entity = response.getEntity();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                client.close();
                if (response != null)
                    response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return entity;
    }
}
