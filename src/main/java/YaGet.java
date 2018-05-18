import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class YaGet
{
    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet("http://speller.yandex.net/services/spellservice/checkText?text=пневмоудар+центробега+по+поджипкику");
        CloseableHttpResponse resp1 = httpClient.execute(httpGet);

        System.out.println(EntityUtils.toString(resp1.getEntity()));
    }
}







