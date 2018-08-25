# Spring Boot and Log4j 2 Example

Learn how to use Log4j-2 with Spring Boot, Gradle.
## Requirements

1. Java - 1.8.x

2. Gradle - 4.x

## Steps to setup

**1. Clone the application**

```bash
git clone https://github.com/nghiapt1112/spring-boot-log4j2.git
```

**2. Build and run the app using maven**
```bash
./gradlew build -x test && java -jar build/libs/spring-boot-log4j-0.0.1-SNAPSHOT.jar
```

_You can also run the app without packaging it by using:_

```bash
./gradlew bootRun
```