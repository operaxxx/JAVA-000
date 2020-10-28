import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class NettyHomework {

    private static final String URL = "localhost:8801";

    public static void main(String[] args) {
        HttpEntity getWithoutParamsEntity = get(URL);
        HttpEntity getWithParamsEntity = post(URL);
    }

    public static HttpEntity get(String Url) {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet(Url);
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

    public static HttpEntity post(String url) {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(url);
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        try {
            response = client.execute(post);
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
