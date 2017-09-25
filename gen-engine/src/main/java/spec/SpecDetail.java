package spec;

import java.util.List;
import java.util.Map;

/**
 * Created by kzang on 2017/9/23.
 */
public class SpecDetail {

    private String methodName;
    private String httpMethod;
    private String endPoint;
    private boolean isPostOrPut;
    private boolean isGet;

    public boolean isGet() {
        return isGet;
    }

    public void setGet(boolean get) {
        isGet = get;
    }

    public boolean isPostOrPut() {
        return isPostOrPut;
    }

    public void setPostOrPut(boolean postOrPut) {
        isPostOrPut = postOrPut;
    }

    //Map<String, String> arguments;
    List<Map<String, String>> arguments;


    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public List<Map<String, String>> getArguments() {
        return arguments;
    }

    public void setArguments(List<Map<String, String>> arguments) {
        this.arguments = arguments;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public SpecDetail(String methodName, String httpMethod, String endPoint, List<Map<String, String>> arguments) {
        this.methodName = methodName;
        this.httpMethod = httpMethod;
        this.endPoint = endPoint;
        this.arguments = arguments;
        this.isGet = false;
        this.isPostOrPut = false;
    }

}
