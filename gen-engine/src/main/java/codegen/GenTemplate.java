package codegen;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import spec.SpecDetail;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

/**
 * Created by kzang on 2017/9/25.
 */
public class GenTemplate {
    private String templatePath;
    private String outPutPath;

    public GenTemplate(String path1, String path2) {
        this.templatePath = path1;
        this.outPutPath = path2;
    }

    public void apply(List<SpecDetail> methodList) throws IOException {
        Handlebars handlebars = new Handlebars();
        Writer writer = null;
        try {
            Template template = handlebars.compile(templatePath);
            writer = new BufferedWriter(new FileWriter(outPutPath));
            template.apply(methodList, writer);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (writer != null) try { writer.close(); } catch (IOException ignore) {}
        }
    }
}
