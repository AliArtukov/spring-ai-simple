# spring-ai-simple

## Simple service in java and spring framework for using new spring-ai module

Our
project's [spring initializr](https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.3.0&packaging=jar&jvmVersion=21&groupId=ali.artukov&artifactId=spring-ai-simple&name=spring-ai-simple&description=Simple%20service%20in%20java%20and%20spring%20framework%20for%20using%20new%20spring-ai%20module&packageName=ali.artukov.spring-ai-simple&dependencies=spring-ai-openai,web,lombok).

Plus added next dependency for enabling swagger:

```xml
<!-- https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-ui -->
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.5.0</version>
</dependency>
```

Project pom.xml file full content:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.3.0</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>ali.artukov</groupId>
    <artifactId>spring-ai-simple</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>spring-ai-simple</name>
    <description>Simple service in java and spring framework for using new spring-ai module</description>
    <properties>
        <java.version>21</java.version>
        <spring-ai.version>1.0.0-M1</spring-ai.version>
    </properties>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.ai</groupId>
            <artifactId>spring-ai-openai-spring-boot-starter</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <scope>annotationProcessor</scope>
        </dependency>
        <dependency>
            <groupId>org.springdoc</groupId>
            <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
            <version>2.5.0</version>
        </dependency>
    </dependencies>
    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.ai</groupId>
                <artifactId>spring-ai-bom</artifactId>
                <version>${spring-ai.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
    <repositories>
        <repository>
            <id>spring-milestones</id>
            <name>Spring Milestones</name>
            <url>https://repo.spring.io/milestone</url>
            <snapshots>
                <enabled>false</enabled>
            </snapshots>
        </repository>
    </repositories>

</project>

```

# How to run

- Clone project from my [github repo](https://github.com/AliArtukov/spring-ai-simple)
- Create OPENAI_API_KEY variable with your openai api kiy value
- Run next commands:

 ```shell
mvn spring-boot:run
 ```

- Open swagger page http://localhost:8080/swagger in your browser
- Use all the methods and have fun

# Result

I called GET method `/simple-chat` without param http://localhost:8080/simple-chat and received the following response:

```text
Sure, here's a dad joke for you: 

Why did the black cat sit next to the computer? 

Because it wanted to keep an eye on the mouse! 🐱💻
```

I called GET method `/simple-chat` with param 'Tell me a dad joke about lion's
woman' http://localhost:8080/simple-chat?message=Tell%20me%20a%20dad%20joke%20about%20lion%27s%20woman and received the
following response:

```text
Sure, here's a dad joke for you:

Why did the lion's wife always bring a map?

Because she didn't want to be caught "roaring" in the wrong direction! 🦁😂
```

I called GET method `/simple-chat/with-chat-response` without param http://localhost:8080/simple-chat/with-chat-response
and received the following response:

```json
{
  "result": {
    "output": {
      "messageType": "ASSISTANT",
      "media": [],
      "metadata": {
        "finishReason": "STOP",
        "role": "ASSISTANT",
        "id": "chatcmpl-9YwTCHthPUFn4yhQQrlGMcXklDaGK",
        "messageType": "ASSISTANT"
      },
      "content": "Sure, here's a dad joke for you:\n\nWhy did the white cat sit in the snow?\n\nBecause it wanted to be purr-fectly camouflaged!"
    },
    "metadata": {
      "finishReason": "STOP",
      "contentFilterMetadata": null
    }
  },
  "metadata": {},
  "results": [
    {
      "output": {
        "messageType": "ASSISTANT",
        "media": [],
        "metadata": {
          "finishReason": "STOP",
          "role": "ASSISTANT",
          "id": "chatcmpl-9YwTCHthPUFn4yhQQrlGMcXklDaGK",
          "messageType": "ASSISTANT"
        },
        "content": "Sure, here's a dad joke for you:\n\nWhy did the white cat sit in the snow?\n\nBecause it wanted to be purr-fectly camouflaged!"
      },
      "metadata": {
        "finishReason": "STOP",
        "contentFilterMetadata": null
      }
    }
  ]
}
```
