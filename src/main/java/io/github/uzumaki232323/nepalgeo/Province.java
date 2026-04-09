package io.github.uzumaki232323.nepalgeo;

public enum Province {
    KOSHI(1, "Koshi Province", "कोशी प्रदेश"),
    MADHESH(2, "Madhesh Province", "मधेश प्रदेश"),
    BAGMATI(3, "Bagmati Province", "बागमती प्रदेश"),
    GANDAKI(4, "Gandaki Province", "गण्डकी प्रदेश"),
    LUMBINI(5, "Lumbini Province", "लुम्बिनी प्रदेश"),
    KARNALI(6, "Karnali Province", "कर्णाली प्रदेश"),
    SUDURPASHCHIM(7, "Sudurpashchim Province", "सुदूरपश्चिम प्रदेश");

    private final int id;
    private final String englishName;
    private final String nepaliName;

    Province(int id, String englishName, String nepaliName) {
        this.id = id;
        this.englishName = englishName;
        this.nepaliName = nepaliName;
    }

    public int getId() {
        return id;
    }

    public String getEnglishName() {
        return englishName;
    }

    public String getNepaliName() {
        return nepaliName;
    }
}
