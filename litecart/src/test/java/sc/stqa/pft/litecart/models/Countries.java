package sc.stqa.pft.litecart.models;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Countries extends ForwardingSet<CountryData> {
    private Set<CountryData> delegate;

    @Override
    protected Set<CountryData> delegate() {
        return delegate;
    }

    public Countries() {
        this.delegate = new HashSet<CountryData>();
    }

    public Countries(Countries countries) {
        this.delegate = new HashSet<CountryData>(countries.delegate);
    }

    public Countries(Collection<CountryData> countries) {
        this.delegate = new HashSet<CountryData>(countries);
    }

    public Countries withAdded(CountryData country){
        Countries countries = new Countries(this);
        countries.add(country);
        return countries;
    }

    public Countries without(CountryData country){
        Countries countries = new Countries(this);
        countries.remove(country);
        return countries;
    }
}

