package io.github.uzumaki232323.nepalgeo;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NepalGeoTest {

    @Test
    void returnsAllDistrictsForAProvince() {
        assertEquals(11, NepalGeo.getDistrictsByProvince(Province.GANDAKI).size());
        assertTrue(NepalGeo.getDistrictsByProvince(Province.GANDAKI).contains(District.KASKI));
    }

    @Test
    void loadsAll753PalikasFromResource() {
        long totalPalikas = Arrays.stream(District.values())
                .map(NepalGeo::getPalikasByDistrict)
                .mapToLong(java.util.List::size)
                .sum();

        assertEquals(753, totalPalikas);
    }

    @Test
    void returnsExpectedPalikasForDistrict() {
        Set<String> kaskiPalikas = NepalGeo.getPalikasByDistrict(District.KASKI).stream()
                .map(Palika::getNameEn)
                .collect(Collectors.toSet());

        assertEquals(5, kaskiPalikas.size());
        assertTrue(kaskiPalikas.contains("Pokhara"));
        assertTrue(kaskiPalikas.contains("Machhapuchchhre"));
    }

    @Test
    void findsDistrictByEnglishNepaliAndAliasNames() {
        assertEquals(District.KASKI, NepalGeo.findDistrict("Kaski").orElseThrow());
        assertEquals(District.KASKI, NepalGeo.findDistrict("कास्की").orElseThrow());
        assertEquals(District.NAWALPUR, NepalGeo.findDistrict("Nawalparasi East").orElseThrow());
        assertEquals(District.KAPILVASTU, NepalGeo.findDistrict("Kapilbastu").orElseThrow());
    }

    @Test
    void returnsEmptyForUnknownDistrict() {
        assertTrue(NepalGeo.findDistrict("Unknown District").isEmpty());
        assertFalse(NepalGeo.findDistrict("झापा").isEmpty());
    }
}
