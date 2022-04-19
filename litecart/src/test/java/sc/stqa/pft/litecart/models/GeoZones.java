package sc.stqa.pft.litecart.models;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class GeoZones extends ForwardingSet<GeoZoneData> {
    private Set<GeoZoneData> delegate;

    @Override
    protected Set<GeoZoneData> delegate() {
        return delegate;
    }

    public GeoZones() {
        this.delegate = new HashSet<GeoZoneData>();
    }

    public GeoZones(GeoZones geoZones) {
        this.delegate = new HashSet<GeoZoneData>(geoZones.delegate);
    }

    public GeoZones(Collection<GeoZoneData> geoZones) {
        this.delegate = new HashSet<GeoZoneData>(geoZones);
    }

    public GeoZones withAdded(GeoZoneData GeoZone){
        GeoZones geoZones = new GeoZones(this);
        geoZones.add(GeoZone);
        return geoZones;
    }

    public GeoZones without(GeoZoneData GeoZoneData){
        GeoZones geoZones = new GeoZones(this);
        geoZones.remove(GeoZoneData);
        return geoZones;
    }
}
