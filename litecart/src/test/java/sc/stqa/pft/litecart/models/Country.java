package sc.stqa.pft.litecart.models;

import java.util.Objects;

public class Country {
    public String name;
    public  String code;
    public int zones;

    public String getCode() {
        return code;
    }

    public Country withCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public Country withName(String name) {
        this.name = name;
        return this;
    }

    public int getZones() {
        return zones;
    }

    public Country withZones(int zones) {
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
        Country country = (Country) o;
        return zones == country.zones && Objects.equals(name, country.name) && Objects.equals(code, country.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, code, zones);
    }
}
