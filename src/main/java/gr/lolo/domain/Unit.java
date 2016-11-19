package gr.lolo.domain;

import lombok.Getter;

@Getter
public enum Unit {

    KILO("kilo"),
    GRAM("gr"),
    KOUTALI_GLUKOU("koutali glukou"),
    KOUTALI_SOUPAS("koutali soupas"),
    KOMMATI("kommati"),
    KOUPA("koupa");

    private String name;

    Unit(java.lang.String name) {
        this.name = name;
    }

    /**
     * helper method to facilitate more humane unit names in the db
     * @param name as found in the DB
     * @return the corresponding {@link Unit} that matches that name
     */
    public static Unit valueOfDbName(String name) {
        for (Unit unit : Unit.values()) {
            if (unit.name.equals(name)) {
                return unit;
            }
        }
        throw new IllegalArgumentException("No enum found for name:" + name);
    }
}
