import sun.net.www.protocol.http.HttpURLConnection;
import java.io.DataOutputStream;
import java.net.URL;

public class client {
    
    
    public void sendOrderFoodPOST(Integer amount, String food, 
            String baseUrl, String httpMethod)
            throws Exception {
        String url = baseUrl + "/" + "OrderFood";
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
        con.setRequestMethod(httpMethod);
        con.setRequestProperty("Content-Type","application/json");
        String str =  "{"
         + "amount" + ":" + amount + "," + "food" + ":" + food
        + "}";
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
    
    
    
    public void sendRateFoodPOST(Integer rating, String food, 
            String baseUrl, String httpMethod)
            throws Exception {
        String url = baseUrl + "/" + "RateFood";
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
        con.setRequestMethod(httpMethod);
        con.setRequestProperty("Content-Type","application/json");
        String str =  "{"
         + "rating" + ":" + rating + "," + "food" + ":" + food
        + "}";
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
    
    
    
    public void getnewEndPointGET(String somethingelse, Integer rating, String food, String baseUrl)
            throws Exception {
        String url = baseUrl + "/" + "newEndPoint" + "?"+ "somethingelse" + "=" + somethingelse + "&"+ "rating" + "=" + rating + "&"+ "food" + "=" + food + "&";
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
    }
    
    
    
    public void sendsomeputEndPointPUT(String somethingelse, Integer rating, String food, 
            String baseUrl, String httpMethod)
            throws Exception {
        String url = baseUrl + "/" + "someputEndPoint";
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
        con.setRequestMethod(httpMethod);
        con.setRequestProperty("Content-Type","application/json");
        String str =  "{"
         + "somethingelse" + ":" + somethingelse + "," + "rating" + ":" + rating + "," + "food" + ":" + food
        + "}";
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
    
    
}