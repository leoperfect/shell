package com.github.zheyi.shell.commands;

import com.github.zheyi.shell.commands.project.ProjectContext;
import com.github.zheyi.shell.commands.project.ProjectGenerator;
import com.github.zheyi.shell.commands.project.ProjectType;
import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * @author zheyi
 * @date 2018/10/10
 */
@ShellComponent
@ShellCommandGroup("custom")
public class Custom {

    @ShellMethod("init project --groupId=xxx --artifactId=xxx --type=maven")
    public void init(@ShellOption(defaultValue = "maven") String type,
                     @ShellOption(defaultValue = "com.github") String groupId,
                     @ShellOption(defaultValue = "demo") String artifactId) throws IOException {

        String userDir = System.getProperty("user.dir");
        ProjectContext projectContext = new ProjectContext(Paths.get(userDir), ProjectType.from(type), groupId,
            artifactId);
        new ProjectGenerator().generator(projectContext);
        System.out.println(
            "init project success , path is " + projectContext.getRootPath().resolve(projectContext.getArtifactId())
                .toAbsolutePath().toString());
    }
}
