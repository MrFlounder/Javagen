import sun.net.www.protocol.http.HttpURLConnection;
import java.io.DataOutputStream;
import java.net.URL;

public class client {
    public void postOrPut(String baseUrl, String key1, String key1Name, String key2, Integer key2Val, String endPoint, String httpMethod)
            throws Exception {
        String url = baseUrl + "/" + endPoint;
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
        con.setRequestMethod(httpMethod);
        con.setRequestProperty("Content-Type","application/json");
        String str =  "{" + key1 + ":" + key1Name + "," + key2 + ":" + key2Val + ",}";
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(str);
        wr.flush();
        wr.close();
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + str);
        System.out.println("Response Code : " + responseCode);
    }
    public void get(String baseUrl, String key1, String key1Name, String key2, Integer key2Val, String endPoint)
            throws Exception {
        String url = baseUrl + "/" + endPoint + "?" + key1 + "=" + key1Name + "&" + key2 + "=" + key2Val;
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
    }
}