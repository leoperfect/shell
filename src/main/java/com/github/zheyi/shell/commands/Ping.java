package com.github.zheyi.shell.commands;

import org.springframework.shell.standard.ShellCommandGroup;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

/**
 * @author zheyi
 * @date 2018/10/10
 */
@ShellComponent
@ShellCommandGroup("test")
public class Ping {

    @ShellMethod("ping")
    public String ping() {
        return "pong";
    }

}
