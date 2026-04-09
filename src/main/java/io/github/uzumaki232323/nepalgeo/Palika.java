package io.github.uzumaki232323.nepalgeo;

import java.util.Objects;

public final class Palika {
    private final String nameEn;
    private final String nameNe;
    private final District district;
    private final PalikaType palikaType;

    public Palika(String nameEn, String nameNe, District district, PalikaType palikaType) {
        this.nameEn = Objects.requireNonNull(nameEn, "nameEn must not be null");
        this.nameNe = Objects.requireNonNull(nameNe, "nameNe must not be null");
        this.district = Objects.requireNonNull(district, "district must not be null");
        this.palikaType = Objects.requireNonNull(palikaType, "palikaType must not be null");
    }

    public String getNameEn() {
        return nameEn;
    }

    public String getNameNe() {
        return nameNe;
    }

    public District getDistrict() {
        return district;
    }

    public PalikaType getPalikaType() {
        return palikaType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Palika palika)) {
            return false;
        }
        return nameEn.equals(palika.nameEn)
                && nameNe.equals(palika.nameNe)
                && district == palika.district
                && palikaType == palika.palikaType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameEn, nameNe, district, palikaType);
    }

    @Override
    public String toString() {
        return "Palika{"
                + "nameEn='" + nameEn + '\''
                + ", nameNe='" + nameNe + '\''
                + ", district=" + district
                + ", palikaType=" + palikaType
                + '}';
    }
}
