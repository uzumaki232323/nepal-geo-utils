package io.github.uzumaki232323.nepalgeo;

public enum PalikaType {
    METROPOLITAN(1, "Metropolitan"),
    SUB_METROPOLITAN(2, "Sub-Metropolitan"),
    MUNICIPALITY(3, "Municipality"),
    RURAL_MUNICIPALITY(4, "Rural Municipality");

    private final int id;
    private final String displayName;

    PalikaType(int id, String displayName) {
        this.id = id;
        this.displayName = displayName;
    }

    public int getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static PalikaType fromLocalLevelTypeId(int id) {
        return switch (id) {
            case 1 -> METROPOLITAN;
            case 2 -> SUB_METROPOLITAN;
            case 3 -> MUNICIPALITY;
            case 4 -> RURAL_MUNICIPALITY;
            default -> throw new IllegalArgumentException("Unsupported local level type id: " + id);
        };
    }
}
