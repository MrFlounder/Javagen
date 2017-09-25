package codegen;

import language.Languages;
import env.Environment;
import spec.SpecDetail;

import java.io.IOException;
import java.util.List;

/**
 * Created by kzang on 2017/9/25.
 */
public abstract class CodeGen {
    public abstract Languages getLanguage();

    public void generateClientCode(Environment env, List<SpecDetail> methodList) throws IOException {
        generateCode(env, methodList, GenTypes.CLIENT);
    }
    public void generateServerCode(Environment env, List<SpecDetail> methodList) throws IOException {
        generateCode(env, methodList, GenTypes.SERVER);
    }
    protected GenTemplate getTemplate(String templatePath, String outputPath) {
        GenTemplate template = new GenTemplate(templatePath, outputPath);
        return template;
    }
    private void generateCode(Environment env, List<SpecDetail> methodList, GenTypes type) throws IOException {
        GenTemplate template = getTemplate(type == GenTypes.CLIENT ? env.getClientTempaltePath() : env.getServerTemplatePath(),
                type == GenTypes.CLIENT ? env.getClientOutputPath() : env.getServerOutputPath());
        template.apply(methodList);
    }
}
