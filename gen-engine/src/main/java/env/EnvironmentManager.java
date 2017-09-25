package env;

import language.Languages;

/**
 * Created by kzang on 2017/9/24.
 */
public class EnvironmentManager {
    private static final String SERVER_OUT_PATH = "client-server/src/main/java/com/server/";
    private static final String CLIENT_OUT_PATH = "client-server/src/main/java/";
    private static final String DEFAULT_LANGUAGE = "java";
    private static final String SERVER_TEM_PATH = "JavaTemplate/ServerTemplate";
    private static final String CLIENT_TEM_PATH = "JavaTemplate/ClientTemplate";
    private static final String SPEC_PATH = "JSON/spec.json";

    public Environment getEnvironment(String[] args) {
        if (args == null || args.length == 0) {
            return defaultEnv();
        }
        // Other environment setup not implemented yet

        return defaultEnv();
    }
    private Environment defaultEnv() {
        String serverOut = SERVER_OUT_PATH + "server" + getSourceFileSuffix(getLanguage(null));
        String clientOut = CLIENT_OUT_PATH + "client" + getSourceFileSuffix(getLanguage(null));
        return new Environment(serverOut, clientOut, SERVER_TEM_PATH, CLIENT_TEM_PATH, DEFAULT_LANGUAGE, SPEC_PATH);
    }
    private Languages getLanguage(String[] args) {
        if (args == null || args.length == 0) {
            return Languages.JAVA;
        }
        return Languages.JAVA;
    }
    private String getSourceFileSuffix(Languages language) {
        switch (language) {
            case JAVA:
                return ".java";
            case PYTHON:
                return ".py";
            case JAVASCRIPT:
                return ".js";
            case GO:
                return ".go";
            default:
                return ".java";
        }
    }

}
