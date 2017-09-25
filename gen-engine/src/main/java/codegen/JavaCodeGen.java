package codegen;

import language.Languages;

/**
 * Created by kzang on 2017/9/25.
 */
public class JavaCodeGen extends CodeGen {

    @Override
    public Languages getLanguage() {
        return Languages.JAVA;
    }
}
