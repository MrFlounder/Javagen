import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.JSONObject;

import java.io.FileReader;

/**
 * Created by kzang on 2017/9/22.
 */
public class Generator {
    public static void main(String[] args) {
        // read json standard file to JSONArray
        try {
            FileReader reader = new FileReader("C:\\Users\\kzang\\CodingProjects\\Javagen\\JSON\\interface.json");
            JSONParser jsonParser = new JSONParser();
            JSONArray  jsonArray = (JSONArray) jsonParser.parse(reader);
            System.out.println(jsonArray);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
