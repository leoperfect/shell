package com.github.zheyi.shell.commands.project;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author zheyi
 * @date 2018/10/10
 */
public class ProjectGenerator {

    private static final String JAVA_SOURCE_PATH = "src/main/java";

    private static final String RESOURCE_PATH = "src/main/resources";

    private static final String JAVA_TEST_PATH = "src/test/java";

    private static final String GIT_IGNORE = "gitignore";

    private static final String README = "README.md";

    private static final String PROPERTIES = "application.properties";

    public void generator(ProjectContext projectContext) throws IOException {

        // 先生成根目录
        Path rootPath = Files.createDirectory(projectContext.getRootPath().resolve(projectContext.getArtifactId()));

        // 再生成子目录结构
        Path javaPath = Files.createDirectories(rootPath.resolve(JAVA_SOURCE_PATH));
        Path resourcePath = Files.createDirectories(rootPath.resolve(RESOURCE_PATH));
        Path testPath = Files.createDirectories(rootPath.resolve(JAVA_TEST_PATH));

        // 生成固定内容的文件
        copyFromTemplate(GIT_IGNORE, rootPath.resolve("." + GIT_IGNORE));
        copyFromTemplate(README, rootPath.resolve(README));
        copyFromTemplate(PROPERTIES, resourcePath.resolve(PROPERTIES));

        // 生成源码
        Path packagePath = Files.createDirectories(
            javaPath.resolve(projectContext.getGroupId().replaceAll("\\.", "/")));
        generateFromTemplate("Application.java",
            packagePath.resolve(projectContext.getFirstCharUpperArtifactId() + "Application.java"),
            projectContext);
        // 根据type生成对应的对应的
        if (projectContext.getProjectType() == ProjectType.MAVEN) {
            generateFromTemplate("pom.xml", rootPath.resolve("pom.xml"), projectContext);
        } else if (projectContext.getProjectType() == ProjectType.GRADLE) {
            generateFromTemplate("settings.gradle", rootPath.resolve("settings.gradle"), projectContext);
            generateFromTemplate("build.gradle", rootPath.resolve("build.gradle"), projectContext);
        }
    }

    private void generateFromTemplate(String filename, Path resolve,
                                      ProjectContext projectContext) throws IOException {
        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile("/template/" + filename);
        Files.createFile(resolve);
        mustache.execute(new FileWriter(resolve.toFile()), projectContext).flush();
    }

    private void copyFromTemplate(String sourceFilename, Path target) throws IOException {
        Files.copy(this.getClass().getResourceAsStream("/template/" + sourceFilename), target);
    }

}
