package com.github.zheyi.shell.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

/**
 * @author zheyi
 * @date 2018/10/10
 */
public class Start implements CommandLineRunner {

    @Autowired
    private Custom custom;

    @Override
    public void run(String... args) throws Exception {
        custom.init("maven", "com.github", "demo");
    }

}
