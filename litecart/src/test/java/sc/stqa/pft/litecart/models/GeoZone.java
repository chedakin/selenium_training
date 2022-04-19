package sc.stqa.pft.litecart.models;

import java.util.Objects;

public class GeoZone {
    private String name;
    private int zones;

    public String getName() {
        return name;
    }

    public GeoZone withName(String name) {
        this.name = name;
        return this;
    }

    public int getZones() {
        return zones;
    }

    public GeoZone withZones(int zones) {
        this.zones = zones;
        return this;
    }

    @Override
    public String toString() {
        return "GeoZone{" +
                "name='" + name + '\'' +
                ", zones=" + zones +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeoZone geoZone = (GeoZone) o;
        return zones == geoZone.zones && Objects.equals(name, geoZone.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, zones);
    }
}
