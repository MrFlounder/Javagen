import sun.net.www.protocol.http.HttpURLConnection;

import java.io.DataOutputStream;
import java.net.URL;

/**
 * Created by kzang on 2017/9/23.
 */
public class ClientRunner {
    private static final String baseUrl = "http://localhost:8080";
    public static void main(String[] args) throws Exception {
        client http = new client();
        http.getnewEndPointGET("something", 100, "apple", baseUrl);
        http.sendOrderFoodPOST(1000, "orange", baseUrl, "POST");
        http.sendRateFoodPOST(12, "banana", baseUrl, "POST");
    }

}
