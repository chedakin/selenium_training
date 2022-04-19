package sc.stqa.pft.litecart.models;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CountryZones extends ForwardingSet<CountryZoneData> {
    private Set<CountryZoneData> delegate;

    @Override
    protected Set<CountryZoneData> delegate() {
        return delegate;
    }

    public CountryZones() {
        this.delegate = new HashSet<CountryZoneData>();
    }

    public CountryZones(CountryZones countryZones) {
        this.delegate = new HashSet<CountryZoneData>(countryZones.delegate);
    }

    public CountryZones(Collection<CountryZoneData> countryZones) {
        this.delegate = new HashSet<CountryZoneData>(countryZones);
    }

    public CountryZones withAdded(CountryZoneData countryZone){
        CountryZones countryZones = new CountryZones(this);
        countryZones.add(countryZone);
        return countryZones;
    }

    public CountryZones without(CountryZoneData countryZone){
        CountryZones countryZones = new CountryZones(this);
        countryZones.remove(countryZone);
        return countryZones;
    }
}
