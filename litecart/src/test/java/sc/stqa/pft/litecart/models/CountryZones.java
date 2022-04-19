package sc.stqa.pft.litecart.models;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CountryZones extends ForwardingSet<CountryZone> {
    private Set<CountryZone> delegate;

    @Override
    protected Set<CountryZone> delegate() {
        return delegate;
    }

    public CountryZones() {
        this.delegate = new HashSet<CountryZone>();
    }

    public CountryZones(CountryZones countryZones) {
        this.delegate = new HashSet<CountryZone>(countryZones.delegate);
    }

    public CountryZones(Collection<CountryZone> countryZones) {
        this.delegate = new HashSet<CountryZone>(countryZones);
    }

    public CountryZones withAdded(CountryZone countryZone){
        CountryZones countryZones = new CountryZones(this);
        countryZones.add(countryZone);
        return countryZones;
    }

    public CountryZones without(CountryZone countryZone){
        CountryZones countryZones = new CountryZones(this);
        countryZones.remove(countryZone);
        return countryZones;
    }
}
