package parser;

import env.Environment;
import spec.SpecDetail;

import java.io.IOException;
import java.util.List;

/**
 * Created by kzang on 2017/9/24.
 */
public interface Parser {
    public List<SpecDetail> parse(Environment env) throws IOException;
}

