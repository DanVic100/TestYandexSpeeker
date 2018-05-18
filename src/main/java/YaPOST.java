import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

    public class YaPOST {

        public static void main(String[] args) throws IOException {
            CloseableHttpClient httpClient = HttpClients.createDefault();

            HttpPost httpPost1 = new HttpPost("https://speller.yandex.net/services/spellservice");

            String str = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:spel=\"http://speller.yandex.net/services/spellservice\">\n" +
                    "   <soapenv:Header/>\n" +
                    "   <soapenv:Body>\n" +
                    "      <spel:CheckTextRequest lang=\"en\" options=\"0\" format=\"\">\n" +
                    "         <spel:text>What I've folt \n" +
                                        "What I've knawn \n" +
                                        "Never shened through in what Ive shown </spel:text>\n" +
                    "      </spel:CheckTextRequest>\n" +
                    "   </soapenv:Body>\n" +
                    "</soapenv:Envelope>";

            StringEntity strEnt1 = new StringEntity(str);
            httpPost1.setEntity(strEnt1);

            httpPost1.addHeader("Content-Type", "text/xml;charset=UTF-8\n");
            httpPost1.addHeader("Accept-Encoding", "gzip,deflate");
            httpPost1.addHeader("SOAPAction", "http://speller.yandex.net/services/spellservice/checkText");

            CloseableHttpResponse response = httpClient.execute(httpPost1);

            System.out.println(EntityUtils.toString(response.getEntity()));
            System.out.println("\n");
            response.close();
        }

}
