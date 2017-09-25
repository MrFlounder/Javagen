package env;

/**
 * Created by kzang on 2017/9/24.
 */
public class Environment {
    private String serverOutputPath;
    private String clientOutputPath;
    private String serverTemplatePath;
    private String clientTempaltePath;
    private String outputLanguage;

    public Environment(String serverOutputPath, String clientOutputPath, String serverTemplatePath,
                       String clientTempaltePath, String outputLanguage, String specFilePath) {
        this.serverOutputPath = serverOutputPath;
        this.clientOutputPath = clientOutputPath;
        this.serverTemplatePath = serverTemplatePath;
        this.clientTempaltePath = clientTempaltePath;
        this.outputLanguage = outputLanguage;
        this.specFilePath = specFilePath;
    }

    public String getSpecFilePath() {
        return specFilePath;
    }

    public void setSpecFilePath(String specFilePath) {
        this.specFilePath = specFilePath;
    }

    private String specFilePath;


    public String getServerOutputPath() {
        return serverOutputPath;
    }

    public void setServerOutputPath(String serverOutputPath) {
        this.serverOutputPath = serverOutputPath;
    }

    public String getClientOutputPath() {
        return clientOutputPath;
    }

    public void setClientOutputPath(String clientOutputPath) {
        this.clientOutputPath = clientOutputPath;
    }

    public String getServerTemplatePath() {
        return serverTemplatePath;
    }

    public void setServerTemplatePath(String serverTemplatePath) {
        this.serverTemplatePath = serverTemplatePath;
    }

    public String getClientTempaltePath() {
        return clientTempaltePath;
    }

    public void setClientTempaltePath(String clientTempaltePath) {
        this.clientTempaltePath = clientTempaltePath;
    }

    public String getOutputLanguage() {
        return outputLanguage;
    }

    public void setOutputLanguage(String outputLanguage) {
        this.outputLanguage = outputLanguage;
    }
}
