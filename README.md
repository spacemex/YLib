# YLib

A simple and feature-rich YAML utility library for Java using SnakeYAML. This library provides easy-to-use functionality for loading, validating, and manipulating YAML files.

## Features

- Load YAML content from strings, files, or input streams.
- Retrieve values with automatic type conversion.
- Validate YAML content.
- Pretty-print YAML data.
- Check for the existence of keys and nested keys.
- Support for primitive types: `int`, `boolean`, `double`, `long`, `float`, `short`.

## Installation

You can include this library in your project using JitPack.

Add the JitPack repository to your `build.gradle` or `pom.xml` file:

### Gradle
```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.spacemex:YLib:Tag'
}
```

### Maven
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>com.github.spacemex</groupId>
        <artifactId>YLib</artifactId>
        <version>Tag</version>
    </dependency>
</dependencies>
```

Replace `Tag` with the version you want to use.

## Usage

### Loading YAML Content

#### From File
```java
File yamlFile = new File("config.yaml");
YamlLoader loader = new YamlLoader(yamlFile);
```

#### From String
```java
String yamlContent = "key: value";
YamlLoader loader = new YamlLoader(yamlContent);
```

#### From InputStream
```java
InputStream inputStream = new FileInputStream("config.yaml");
YamlLoader loader = new YamlLoader(inputStream);
```

### Retrieve Values

```java
String stringValue = loader.getString("someKey");
Integer intValue = loader.getInt("someInt");
Boolean boolValue = loader.getBoolean("someBoolean");
Double doubleValue = loader.getDouble("someDouble");
Long longValue = loader.getLong("someLong");
Float floatValue = loader.getFloat("someFloat");
Short shortValue = loader.getShort("someShort");
```

### Validate YAML Content

```java
YamlValidator validator = new YamlValidator();
boolean isValid = validator.isValidYaml(yamlContent);
```

### Pretty-Print YAML Data

```java
String prettyYaml = loader.prettyPrint();
System.out.println(prettyYaml);
```

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request or open an Issue.

## License

This project is licensed under the MIT License.