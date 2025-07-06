#!/bin/bash

# Create the main directory
mkdir -p dsa-java

# Create src directory and subdirectories
mkdir -p dsa-java/src/{arrays,linkedlists,trees,graphs,sorting,searching,dynamic-programming}

# Create notes directory and files
mkdir -p dsa-java/notes/cheat-sheets
touch dsa-java/notes/time-complexity.md
touch dsa-java/notes/concepts.md

# Create problems directory and subdirectories
mkdir -p dsa-java/problems/{leetcode,hackerrank}

# Create build.gradle (Gradle build file)
cat > dsa-java/build.gradle << 'EOL'
plugins {
    id 'java'
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation 'org.junit.jupiter:junit-jupiter:5.8.1'
}

test {
    useJUnitPlatform()
}
EOL

# Create pom.xml (Maven alternative)
cat > dsa-java/pom.xml << 'EOL'
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.yourname</groupId>
    <artifactId>dsa-java</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>5.8.1</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
EOL

# Create README.md
cat > dsa-java/README.md << 'EOL'
# DSA Java Repository

This repository contains my Data Structures and Algorithms implementations in Java.

## Structure

- `src/`: Java source code organized by topic
- `notes/`: Study notes and cheat sheets
- `problems/`: Solutions to coding problems from various platforms

## How to Use

### With Gradle
