package bpmntoconstant.generator.annotations.processors;

import org.springframework.core.io.Resource;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.lang.model.element.Element;

/**
 * @author Bhuwan Prasad Upadhyay
 */
class JavaSourceFileHelper {

    private JavaSourceFileHelper() {
        //no-arg constructor
    }

    public static String buildPackageName(Element rootElement) {
        final String elementQualifiedName = rootElement.asType().toString();
        Assert.notNull(elementQualifiedName, "elementQualifiedName must be not null");
        int lastIndexOf = elementQualifiedName.lastIndexOf('.');
        String packageName = "bpmn.metadata";
        if (lastIndexOf > 0)
            packageName = elementQualifiedName.substring(0, lastIndexOf) + '.' + packageName;
        Assert.notNull(packageName, "packageName must be not null");
        return packageName;
    }

    public static String buildClassName(Resource resource, String postfix) {
        String filename = resource.getFilename();
        int lastIndexOf = filename.lastIndexOf('.');
        if (lastIndexOf > 0)
            filename = filename.substring(0, lastIndexOf);
        return convertToJavaClassNameConvention(filename) + (StringUtils.isEmpty(postfix) ? "Constants" : postfix);
    }

    private static String convertToJavaClassNameConvention(String filename) {
        String underScoreFilename = filename.replaceAll("\\s+", "_");
        StringBuilder javaFileName = new StringBuilder();
        for (String word : underScoreFilename.split("_")) {
            javaFileName.append(word.substring(0, 1).toUpperCase()).append(word.substring(1).toLowerCase());
        }
        return javaFileName.toString();
    }

}
