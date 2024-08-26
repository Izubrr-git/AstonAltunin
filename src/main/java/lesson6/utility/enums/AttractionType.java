package utility.enums;

public enum AttractionType {
    ROLLER_COASTER("Американские горки"),
    FERRIS_WHEEL("Колесо обозрения"),
    CAROUSEL("Карусель"),
    WATER_RIDE("Водный аттракцион"),
    DARK_RIDE("Тёмный аттракцион"),
    DROP_TOWER("Башня свободного падения"),
    BUMPER_CARS("Автодром"),
    SWING_RIDE("Качели"),
    HAUNTED_HOUSE("Дом с привидениями"),
    VIRTUAL_REALITY("Виртуальная реальность"),
    SIMULATOR("Симулятор"),
    KIDDIE_RIDE("Детский аттракцион"),
    FLAT_RIDE("Плоский аттракцион"),
    THRILL_RIDE("Экстремальный аттракцион"),
    FAMILY_RIDE("Семейный аттракцион");

    private final String description;

    AttractionType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
