# nepal-geo-utils

A shinobi-grade Java 17 library for working with Nepal's federal geography in both English and Nepali Unicode.

This project helps you summon:

- all 7 provinces with bilingual names
- all 77 districts mapped to their province
- all 753 palikas from a JSON resource
- fast stream-based lookup utilities for province, district, and palika queries

No shadow clones. No forbidden jutsu. Just clean geo data, dattebayo.

## Hidden Leaf Features

- Bilingual support for English and Nepali Unicode names
- `Province` enum with id, English name, and Nepali name
- `District` enum with province linkage, dataset ids, and alias-based search support
- `Palika` model with district and `PalikaType`
- `NepalGeo` utility class for district and palika lookup
- Full palika dataset stored in [`src/main/resources/palikas.json`](src/main/resources/palikas.json)

## Summoning Scroll

```xml
<dependency>
    <groupId>io.github.uzumaki232323</groupId>
    <artifactId>nepal-geo-utils</artifactId>
    <version>1.0.0</version>
</dependency>
```

## Chakra Requirements

- Java 17+
- Maven 3.8+

## Mission Commands

Compile the library:

```bash
mvn clean compile
```

Run the Chunin Exams:

```bash
mvn test
```

Build the battle-ready JAR:

```bash
mvn clean package
```

Install locally to your Maven cache:

```bash
mvn clean install
```

## Ninja Way Usage

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
                .ifPresent(district -> {
                    System.out.println(district.getEnglishName());
                    System.out.println(NepalGeo.getPalikasByDistrict(district).size());
                });
    }
}
```

## Village Map

- [`src/main/java/io/github/uzumaki232323/nepalgeo`](src/main/java/io/github/uzumaki232323/nepalgeo) contains the core library classes
- [`src/main/resources/palikas.json`](src/main/resources/palikas.json) contains the full 753-palika dataset
- [`src/test/java/io/github/uzumaki232323/nepalgeo/NepalGeoTest.java`](src/test/java/io/github/uzumaki232323/nepalgeo/NepalGeoTest.java) contains the verification suite

## Validation Jutsu

The project currently verifies with:

```bash
mvn test
```

For release packaging:

```bash
mvn -Prelease "-Dgpg.skip=true" clean package
```

## Hokage Route to Maven Central

This project is configured for Sonatype Central Portal publishing with a dedicated `release` profile.

Before publishing, make sure you have:

- verified the `io.github.uzumaki232323` namespace in Sonatype Central
- a Central Portal user and token
- a working GPG key for signing artifacts
- credentials configured in `~/.m2/settings.xml`

Example `settings.xml` entry:

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
- publish using the Sonatype Central Publishing plugin

## Shinobi Credits

Developed by Gaurav Suwal ([`@uzumaki232323`](https://github.com/uzumaki232323)).

## License

Released under the MIT License. See [LICENSE](LICENSE).
