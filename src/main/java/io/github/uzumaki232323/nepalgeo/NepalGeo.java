package io.github.uzumaki232323.nepalgeo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public final class NepalGeo {
    private static final String PALIKA_RESOURCE = "/palikas.json";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final List<Palika> PALIKAS = loadPalikas();

    private NepalGeo() {
    }

    public static List<District> getDistrictsByProvince(Province province) {
        return Arrays.stream(District.values())
                .filter(district -> province != null && district.getProvince() == province)
                .toList();
    }

    public static List<Palika> getPalikasByDistrict(District district) {
        return PALIKAS.stream()
                .filter(palika -> district != null && palika.getDistrict() == district)
                .toList();
    }

    public static Optional<District> findDistrict(String name) {
        if (name == null || name.isBlank()) {
            return Optional.empty();
        }

        String normalizedInput = normalize(name);
        return Arrays.stream(District.values())
                .filter(district -> matchesDistrictName(district, normalizedInput))
                .findFirst();
    }

    private static boolean matchesDistrictName(District district, String normalizedInput) {
        return district.searchableNames()
                .map(NepalGeo::normalize)
                .anyMatch(normalizedInput::equals);
    }

    private static String normalize(String value) {
        return value.trim()
                .replaceAll("\\s+", " ")
                .toLowerCase(Locale.ROOT);
    }

    private static List<Palika> loadPalikas() {
        try (InputStream inputStream = NepalGeo.class.getResourceAsStream(PALIKA_RESOURCE)) {
            if (inputStream == null) {
                throw new IllegalStateException("Palika resource not found: " + PALIKA_RESOURCE);
            }

            PalikaJson[] rawPalikas = OBJECT_MAPPER.readValue(inputStream, PalikaJson[].class);
            return Arrays.stream(rawPalikas)
                    .map(NepalGeo::toPalika)
                    .toList();
        } catch (IOException exception) {
            throw new IllegalStateException("Unable to load palika resource: " + PALIKA_RESOURCE, exception);
        }
    }

    private static Palika toPalika(PalikaJson rawPalika) {
        District district = District.fromId(rawPalika.districtId())
                .orElseThrow(() -> new IllegalStateException("Unknown district id in palika dataset: " + rawPalika.districtId()));
        PalikaType palikaType = PalikaType.fromLocalLevelTypeId(rawPalika.localLevelTypeId());
        return new Palika(rawPalika.name(), rawPalika.nepaliName(), district, palikaType);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private record PalikaJson(
            String name,
            @JsonProperty("nepali_name") String nepaliName,
            @JsonProperty("district_id") int districtId,
            @JsonProperty("local_level_type_id") int localLevelTypeId
    ) {
    }
}
