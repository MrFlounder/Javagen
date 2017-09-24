
import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;
import com.github.jknack.handlebars.Template;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import util.SpecDetail;


import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by kzang on 2017/9/22.
 */
public class GeneratorHandlebars {
    static List<SpecDetail> methodList = new ArrayList<SpecDetail>();
    public static void main(String[] args) {
        JSONArray  jsonArray = null;
        // read json standard file to JSONArray
        try {
            FileReader reader = new FileReader("C:\\Users\\kzang\\CodingProjects\\Javagen\\JSON\\interface.json");

            JSONParser jsonParser = new JSONParser();
            jsonArray = (JSONArray) jsonParser.parse(reader);
            System.out.println(jsonArray);
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
            if (httpmethod.equalsIgnoreCase("POST")) {
                newSpec.setPostOrPut(true);
            } else {
                newSpec.setGet(true);
            }
            methodList.add(newSpec);
        }

        // Load templates and generate source code. Output source code to server app directory
        Handlebars handlebars = new Handlebars();
        handlebars.registerHelper("equal", new Helper<Boolean>() {
            public Object apply(Boolean aBoolean, Options options) throws IOException {
                return null;
            }
            public boolean equal(boolean arg1, boolean arg2) {
                return arg1 == arg2;
            }
        });
        Writer writer = null;
        try {
            Template template = handlebars.compile("JavaTemplate/ServerTemplate");
            writer = new BufferedWriter(new FileWriter("client-server/src/main/java/com/server/server.java"));
            template.apply(methodList, writer);
            writer.close();
            template = handlebars.compile("JavaTemplate/ClientTemplate");
            writer = new BufferedWriter(new FileWriter("client-server/src/main/java/client.java"));
            template.apply(methodList, writer);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (writer != null) try { writer.close(); } catch (IOException ignore) {}
        }
    }

}
