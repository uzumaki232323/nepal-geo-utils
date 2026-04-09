# nepal-geo-utils

`nepal-geo-utils` is a Java 17 library for working with Nepal's federal administrative geography in both English and Nepali Unicode.

It provides:

- all 7 provinces with bilingual names
- all 77 districts mapped to their province
- all 753 palikas loaded from a JSON resource
- stream-based lookup utilities for province, district, and palika queries

## Features

- Bilingual support for English and Nepali names
- `Province` enum with id, English name, and Nepali name
- `District` enum with province linkage and search aliases
- `Palika` model with district and `PalikaType`
- `NepalGeo` utility methods for district and palika lookup
- Resource-backed palika dataset in [`src/main/resources/palikas.json`](src/main/resources/palikas.json)

## Maven Coordinates

```xml
<dependency>
    <groupId>io.github.uzumaki232323</groupId>
    <artifactId>nepal-geo-utils</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Requirements

- Java 17+
- Maven 3.8+

## Build

Compile the project:

```bash
mvn clean compile
```

Run the test suite:

```bash
mvn test
```

Build the JAR:

```bash
mvn clean package
```

Install locally to your Maven repository:

```bash
mvn clean install
```

## Usage

```java
import io.github.uzumaki232323.nepalgeo.District;
import io.github.uzumaki232323.nepalgeo.NepalGeo;
import io.github.uzumaki232323.nepalgeo.Province;

import java.util.List;

public class Example {
    public static void main(String[] args) {
        List<District> gandakiDistricts = NepalGeo.getDistrictsByProvince(Province.GANDAKI);
        System.out.println(gandakiDistricts);

        NepalGeo.findDistrict("कास्की")
                .ifPresent(System.out::println);

        System.out.println(NepalGeo.getPalikasByDistrict(District.KASKI).size());
    }
}
```

## Project Structure

- [`src/main/java/io/github/uzumaki232323/nepalgeo`](src/main/java/io/github/uzumaki232323/nepalgeo) contains the core library classes
- [`src/main/resources/palikas.json`](src/main/resources/palikas.json) contains the 753-palika dataset
- [`src/test/java/io/github/uzumaki232323/nepalgeo/NepalGeoTest.java`](src/test/java/io/github/uzumaki232323/nepalgeo/NepalGeoTest.java) contains the test suite

## Validation

The project is validated with:

```bash
mvn test
```

## Publishing to Maven Central

This project is configured for Sonatype Central Portal publishing with a dedicated `release` profile.

Before publishing, make sure you have:

- created the GitHub repository `uzumaki232323/nepal-geo-utils`
- verified the `io.github.uzumaki232323` namespace in Sonatype Central
- generated a Central Portal token
- configured a GPG key for artifact signing
- added your Central credentials in `~/.m2/settings.xml`

Example `settings.xml` server entry:

```xml
<settings>
    <servers>
        <server>
            <id>central</id>
            <username>YOUR_CENTRAL_PORTAL_USERNAME</username>
            <password>YOUR_CENTRAL_PORTAL_TOKEN</password>
        </server>
    </servers>
</settings>
```

Release command:

```bash
mvn -Prelease clean deploy
```

The `release` profile will:

- attach source JARs
- attach Javadoc JARs
- sign artifacts with GPG
- publish through the Sonatype Central Publishing plugin

## Author

Developed by Gaurav Suwal ([`@uzumaki232323`](https://github.com/uzumaki232323)).

## License

This project is released under the MIT License. See [LICENSE](LICENSE).
