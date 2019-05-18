# tianyiiot-north-spring-boot-starter
[![](https://jitpack.io/v/com.jadendong/tianyiiot-north-spring-boot-starter.svg)](https://jitpack.io/#com.jadendong/tianyiiot-north-spring-boot-starter)

电信物联网北向SDK的简单封装。使之可以充分利用 spring boot的自动配置特性，简化开发流程。

## How to use ?

**Step 1.** Add the JitPack repository to your build file

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

**Step 2.** Add the dependency

```xml
<dependency>
    <groupId>com.jadendong</groupId>
    <artifactId>tianyiiot-north-spring-boot-starter</artifactId>
    <version>Tag</version>
</dependency>
```
**Step 3.** 下载lib包下的api-client-1.0.0.jar,然后mvn安装到本地
```
mvn install:install-file -DgroupId=com.huawei.iotplatform -DartifactId=api-client -Dversion=1.5.3 -Dpackaging=jar -Dfile=api-client-1.0.0.jar
```
```
<dependency>
    <groupId>com.huawei.iotplatform</groupId>
    <artifactId>api-client</artifactId>
    <version>1.5.3</version>
</dependency>
```
