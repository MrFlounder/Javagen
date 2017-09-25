package parser;

import env.Environment;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import spec.SpecDetail;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kzang on 2017/9/25.
 */
public class JsonParser implements Parser {
    public List<SpecDetail> parse(Environment env) throws IOException {
        List<SpecDetail> methodList = new ArrayList<SpecDetail>();
        JSONArray jsonArray = null;
        // read json standard file to JSONArray
        try {
            FileReader reader = new FileReader(env.getSpecFilePath());

            JSONParser jsonParser = new JSONParser();
            jsonArray = (JSONArray) jsonParser.parse(reader);

        } catch (Exception e) {
            System.out.println(e);
        }
        SpecDetail newSpec = null;
        // Convert jsonArray to java objects
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject spec = (JSONObject) jsonArray.get(i);
            JSONObject arguments = (JSONObject) spec.get("arguments");
            List<Map<String, String>> alist = new ArrayList<Map<String, String>>();
            for (Object cur : arguments.keySet()) {
                String key = (String)cur;
                Map<String, String> amap = new HashMap<String, String>();
                String type = null;
                if (arguments.get(key).toString().equalsIgnoreCase("number")) {
                    type = "Integer";
                } else {
                    type = "String";
                }
                amap.put("name", key);
                amap.put("type", type);
                alist.add(amap);
            }
            String endPoint = (String) spec.get("endpoint");
            String httpmethod = (String) spec.get("method");
            newSpec = new SpecDetail(endPoint + httpmethod, httpmethod, endPoint, alist);
            if (httpmethod.equalsIgnoreCase("POST") || httpmethod.equalsIgnoreCase("PUT")) {
                newSpec.setPostOrPut(true);
            } else {
                newSpec.setGet(true);
            }
            methodList.add(newSpec);
        }
        return methodList;
    }
}
