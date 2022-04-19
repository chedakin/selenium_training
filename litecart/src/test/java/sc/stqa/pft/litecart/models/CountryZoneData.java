package sc.stqa.pft.litecart.models;

import java.util.Objects;

public class CountryZoneData {
    public String name;
    public String code;

    public String getName() {
        return name;
    }

    public CountryZoneData withName(String name) {
        this.name = name;
        return this;
    }

    public String getCode() {
        return code;
    }

    public CountryZoneData withCode(String code) {
        this.code = code;
        return this;
    }

    @Override
    public String toString() {
        return "CountryZones{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryZoneData that = (CountryZoneData) o;
        return Objects.equals(name, that.name) && Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, code);
    }
}
