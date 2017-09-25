import codegen.JavaCodeGen;
import env.Environment;
import env.EnvironmentManager;
import parser.JsonParser;
import parser.Parser;
import spec.SpecDetail;

import java.io.IOException;
import java.util.List;

/**
 * Created by kzang on 2017/9/24.
 */
public class Main {
    static EnvironmentManager envManager = new EnvironmentManager();

    public static void main(String[] args) throws IOException {
        Environment env = envManager.getEnvironment(args);
        Parser jsonParser = new JsonParser();
        List<SpecDetail> methodList = jsonParser.parse(env);
        JavaCodeGen gen = new JavaCodeGen();
        gen.generateClientCode(env, methodList);
        gen.generateServerCode(env, methodList);
    }
}
