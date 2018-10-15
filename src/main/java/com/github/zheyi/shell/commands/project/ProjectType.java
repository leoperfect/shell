package com.github.zheyi.shell.commands.project;

import java.util.Arrays;

/**
 * @author zheyi
 * @date 2018/10/10
 */
public enum ProjectType {
    MAVEN("maven"),
    GRADLE("gradle");

    private String value;

    ProjectType(String value) {
        this.value = value;
    }

    public static ProjectType from(String type) {
        return Arrays.stream(ProjectType.values()).filter(e -> e.value.equals(type)).findFirst().orElse(MAVEN);
    }
}
