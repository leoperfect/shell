package com.github.zheyi.shell.commands.project;

import com.github.zheyi.shell.utils.StringUtils;

import java.nio.file.Path;

/**
 * @author zheyi
 * @date 2018/10/10
 */

public class ProjectContext {

    private Path rootPath;

    private ProjectType projectType;

    private String groupId;

    private String artifactId;

    private String firstCharUpperArtifactId;

    public ProjectContext(Path rootPath, ProjectType projectType, String groupId, String artifactId) {
        this.rootPath = rootPath;
        this.projectType = projectType;
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.firstCharUpperArtifactId = StringUtils.upperCaseFirstChar(artifactId);
    }

    public Path getRootPath() {
        return rootPath;
    }

    public ProjectType getProjectType() {
        return projectType;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public String getFirstCharUpperArtifactId() {
        return firstCharUpperArtifactId;
    }
}
