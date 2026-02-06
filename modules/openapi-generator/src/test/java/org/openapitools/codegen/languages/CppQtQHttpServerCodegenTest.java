package org.openapitools.codegen.languages;

import org.openapitools.codegen.CodegenType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CppQtQHttpServerCodegenTest {

    @Test
    public void testGeneratorName() {
        CppQtQHttpServerCodegen codegen = new CppQtQHttpServerCodegen();
        Assert.assertEquals(codegen.getName(), "cpp-qt-qhttpserver");
    }

    @Test
    public void testGeneratorType() {
        CppQtQHttpServerCodegen codegen = new CppQtQHttpServerCodegen();
        Assert.assertEquals(codegen.getTag(), CodegenType.SERVER);
    }

    @Test
    public void testHelpText() {
        CppQtQHttpServerCodegen codegen = new CppQtQHttpServerCodegen();
        Assert.assertTrue(codegen.getHelp().contains("Qt 6"));
        Assert.assertTrue(codegen.getHelp().contains("QHttpServer"));
    }

    @Test
    public void testApiTemplates() {
        CppQtQHttpServerCodegen codegen = new CppQtQHttpServerCodegen();
        Assert.assertTrue(codegen.apiTemplateFiles().containsKey("apihandler.h.mustache"));
        Assert.assertTrue(codegen.apiTemplateFiles().containsKey("apihandler.cpp.mustache"));
        Assert.assertFalse(codegen.apiTemplateFiles().containsKey("apirequest.h.mustache"));
        Assert.assertFalse(codegen.apiTemplateFiles().containsKey("apirequest.cpp.mustache"));
    }

    @Test
    public void testModelTemplates() {
        CppQtQHttpServerCodegen codegen = new CppQtQHttpServerCodegen();
        Assert.assertTrue(codegen.modelTemplateFiles().containsKey("model-header.mustache"));
        Assert.assertTrue(codegen.modelTemplateFiles().containsKey("model-body.mustache"));
    }
}
