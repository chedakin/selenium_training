package sc.stqa.pft.litecart.models;

import java.util.Objects;

public class CountryData {
    public String name;
    public  String code;
    public int zones;

    public String getCode() {
        return code;
    }

    public CountryData withCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public CountryData withName(String name) {
        this.name = name;
        return this;
    }

    public int getZones() {
        return zones;
    }

    public CountryData withZones(int zones) {
        this.zones = zones;
        return this;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", zones=" + zones +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryData country = (CountryData) o;
        return zones == country.zones && Objects.equals(name, country.name) && Objects.equals(code, country.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, code, zones);
    }
}
