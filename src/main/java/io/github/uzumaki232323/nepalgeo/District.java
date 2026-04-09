package io.github.uzumaki232323.nepalgeo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum District {
    BHOJPUR(20, Province.KOSHI, "Bhojpur", "भोजपुर"),
    DHANKUTA(21, Province.KOSHI, "Dhankuta", "धनकुटा"),
    ILAM(24, Province.KOSHI, "Ilam", "इलाम"),
    JHAPA(25, Province.KOSHI, "Jhapa", "झापा"),
    KHOTANG(19, Province.KOSHI, "Khotang", "खोटाङ"),
    MORANG(4, Province.KOSHI, "Morang", "मोरङ"),
    OKHALDHUNGA(18, Province.KOSHI, "Okhaldhunga", "ओखलढुङ्गा"),
    PANCHTHAR(23, Province.KOSHI, "Panchthar", "पाँचथर", "Pachthar"),
    SANKHUWASABHA(16, Province.KOSHI, "Sankhuwasabha", "सङ्खुवासभा"),
    SOLUKHUMBU(17, Province.KOSHI, "Solukhumbu", "सोलुखुम्बु"),
    SUNSARI(11, Province.KOSHI, "Sunsari", "सुनसरी"),
    TAPLEJUNG(15, Province.KOSHI, "Taplejung", "ताप्लेजुङ"),
    TEHRATHUM(22, Province.KOSHI, "Tehrathum", "तेह्रथुम", "Terhathum"),
    UDAYAPUR(26, Province.KOSHI, "Udayapur", "उदयपुर"),

    BARA(8, Province.MADHESH, "Bara", "बारा"),
    DHANUSHA(29, Province.MADHESH, "Dhanusha", "धनुषा"),
    MAHOTTARI(30, Province.MADHESH, "Mahottari", "महोत्तरी"),
    PARSA(3, Province.MADHESH, "Parsa", "पर्सा"),
    RAUTAHAT(32, Province.MADHESH, "Rautahat", "रौतहट"),
    SAPTARI(27, Province.MADHESH, "Saptari", "सप्तरी"),
    SARLAHI(31, Province.MADHESH, "Sarlahi", "सर्लाही"),
    SIRAHA(28, Province.MADHESH, "Siraha", "सिराहा"),

    BHAKTAPUR(37, Province.BAGMATI, "Bhaktapur", "भक्तपुर"),
    CHITWAN(2, Province.BAGMATI, "Chitwan", "चितवन"),
    DHADING(35, Province.BAGMATI, "Dhading", "धादिङ"),
    DOLAKHA(33, Province.BAGMATI, "Dolakha", "दोलखा"),
    KATHMANDU(5, Province.BAGMATI, "Kathmandu", "काठमाडौं"),
    KAVREPALANCHOK(38, Province.BAGMATI, "Kavrepalanchok", "काभ्रेपलाञ्चोक"),
    LALITPUR(6, Province.BAGMATI, "Lalitpur", "ललितपुर"),
    MAKWANPUR(10, Province.BAGMATI, "Makwanpur", "मकवानपुर"),
    NUWAKOT(36, Province.BAGMATI, "Nuwakot", "नुवाकोट"),
    RAMECHHAP(39, Province.BAGMATI, "Ramechhap", "रामेछाप"),
    RASUWA(74, Province.BAGMATI, "Rasuwa", "रसुवा"),
    SINDHULI(40, Province.BAGMATI, "Sindhuli", "सिन्धुली"),
    SINDHUPALCHOK(34, Province.BAGMATI, "Sindhupalchok", "सिन्धुपाल्चोक"),

    BAGLUNG(48, Province.GANDAKI, "Baglung", "बागलुङ"),
    GORKHA(41, Province.GANDAKI, "Gorkha", "गोरखा"),
    KASKI(1, Province.GANDAKI, "Kaski", "कास्की"),
    LAMJUNG(43, Province.GANDAKI, "Lamjung", "लमजुङ"),
    MANANG(75, Province.GANDAKI, "Manang", "मनाङ"),
    MUSTANG(76, Province.GANDAKI, "Mustang", "मुस्ताङ"),
    MYAGDI(42, Province.GANDAKI, "Myagdi", "म्याग्दी"),
    NAWALPUR(45, Province.GANDAKI, "Nawalpur", "नवलपुर", "Nawalparasi East"),
    PARBAT(47, Province.GANDAKI, "Parbat", "पर्वत"),
    SYANGJA(46, Province.GANDAKI, "Syangja", "स्याङ्जा"),
    TANAHUN(44, Province.GANDAKI, "Tanahun", "तनहुँ", "Tanahu"),

    ARGHAKHANCHI(52, Province.LUMBINI, "Arghakhanchi", "अर्घाखाँची"),
    BANKE(14, Province.LUMBINI, "Banke", "बाँके"),
    BARDIYA(56, Province.LUMBINI, "Bardiya", "बर्दिया"),
    DANG(7, Province.LUMBINI, "Dang", "दाङ"),
    GULMI(51, Province.LUMBINI, "Gulmi", "गुल्मी"),
    KAPILVASTU(55, Province.LUMBINI, "Kapilvastu", "कपिलवस्तु", "Kapilbastu"),
    PALPA(53, Province.LUMBINI, "Palpa", "पाल्पा"),
    PARASI(54, Province.LUMBINI, "Parasi", "परासी", "Nawalparasi West"),
    PYUTHAN(50, Province.LUMBINI, "Pyuthan", "प्युठान"),
    ROLPA(49, Province.LUMBINI, "Rolpa", "रोल्पा"),
    RUKUM_EAST(77, Province.LUMBINI, "Rukum East", "पूर्वी रुकुम"),
    RUPANDEHI(12, Province.LUMBINI, "Rupandehi", "रुपन्देही"),

    DAILEKH(61, Province.KARNALI, "Dailekh", "दैलेख"),
    DOLPA(57, Province.KARNALI, "Dolpa", "डोल्पा"),
    HUMLA(13, Province.KARNALI, "Humla", "हुम्ला"),
    JAJARKOT(62, Province.KARNALI, "Jajarkot", "जाजरकोट"),
    JUMLA(59, Province.KARNALI, "Jumla", "जुम्ला"),
    KALIKOT(60, Province.KARNALI, "Kalikot", "कालिकोट"),
    MUGU(58, Province.KARNALI, "Mugu", "मुगु"),
    SALYAN(64, Province.KARNALI, "Salyan", "सल्यान"),
    SURKHET(65, Province.KARNALI, "Surkhet", "सुर्खेत"),
    RUKUM_WEST(63, Province.KARNALI, "Rukum West", "पश्चिमी रुकुम"),

    ACHHAM(72, Province.SUDURPASHCHIM, "Achham", "अछाम"),
    BAITADI(69, Province.SUDURPASHCHIM, "Baitadi", "बैतडी"),
    BAJHANG(67, Province.SUDURPASHCHIM, "Bajhang", "बझाङ"),
    BAJURA(66, Province.SUDURPASHCHIM, "Bajura", "बाजुरा"),
    DADELDHURA(70, Province.SUDURPASHCHIM, "Dadeldhura", "डडेल्धुरा"),
    DARCHULA(68, Province.SUDURPASHCHIM, "Darchula", "दार्चुला"),
    DOTI(71, Province.SUDURPASHCHIM, "Doti", "डोटी"),
    KAILALI(9, Province.SUDURPASHCHIM, "Kailali", "कैलाली"),
    KANCHANPUR(73, Province.SUDURPASHCHIM, "Kanchanpur", "कञ्चनपुर");

    private static final Map<Integer, District> DISTRICTS_BY_ID = Arrays.stream(values())
            .collect(Collectors.toUnmodifiableMap(District::getId, district -> district));

    private final int id;
    private final Province province;
    private final String englishName;
    private final String nepaliName;
    private final List<String> aliases;

    District(int id, Province province, String englishName, String nepaliName, String... aliases) {
        this.id = id;
        this.province = province;
        this.englishName = englishName;
        this.nepaliName = nepaliName;
        this.aliases = List.of(aliases);
    }

    public int getId() {
        return id;
    }

    public Province getProvince() {
        return province;
    }

    public String getEnglishName() {
        return englishName;
    }

    public String getNepaliName() {
        return nepaliName;
    }

    public Stream<String> searchableNames() {
        return Stream.concat(
                Stream.of(englishName, nepaliName, name().replace('_', ' ')),
                aliases.stream()
        );
    }

    public static Optional<District> fromId(int id) {
        return Optional.ofNullable(DISTRICTS_BY_ID.get(id));
    }
}
