package sc.stqa.pft.litecart.models;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class GeoZones extends ForwardingSet<GeoZone> {
    private Set<GeoZone> delegate;

    @Override
    protected Set<GeoZone> delegate() {
        return delegate;
    }

    public GeoZones() {
        this.delegate = new HashSet<GeoZone>();
    }

    public GeoZones(GeoZones geoZones) {
        this.delegate = new HashSet<GeoZone>(geoZones.delegate);
    }

    public GeoZones(Collection<GeoZone> geoZones) {
        this.delegate = new HashSet<GeoZone>(geoZones);
    }

    public GeoZones withAdded(GeoZone GeoZone){
        GeoZones geoZones = new GeoZones(this);
        geoZones.add(GeoZone);
        return geoZones;
    }

    public GeoZones without(GeoZone GeoZone){
        GeoZones geoZones = new GeoZones(this);
        geoZones.remove(GeoZone);
        return geoZones;
    }
}
