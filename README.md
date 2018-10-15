基于[spring-boot](https://github.com/spring-projects/spring-boot)和[spring-shell](https://github.com/spring-projects/spring-shell)的[`spring initializr`](https://start.spring.io/)的简化java命令行版本
1. `gradle clean build` 生成 `shell-0.0.1-SNAPSHOT.jar`
2. `java -jar shell-0.0.1-SNAPSHOT.jar`启动并进入shell
3. 执行`init project --groupId=xxx --artifactId=xxx --type=maven`生成项目
4. `quit`退出
5. 将demo项目导入idea中

效果图如下：
![](https://github.com/leoperfect/shell/blob/master/img.jpg)
