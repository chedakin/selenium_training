package sc.stqa.pft.litecart.models;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Countries extends ForwardingSet<Country> {
    private Set<Country> delegate;

    @Override
    protected Set<Country> delegate() {
        return delegate;
    }

    public Countries() {
        this.delegate = new HashSet<Country>();
    }

    public Countries(Countries countries) {
        this.delegate = new HashSet<Country>(countries.delegate);
    }

    public Countries(Collection<Country> countries) {
        this.delegate = new HashSet<Country>(countries);
    }

    public Countries withAdded(Country country){
        Countries countries = new Countries(this);
        countries.add(country);
        return countries;
    }

    public Countries without(Country country){
        Countries countries = new Countries(this);
        countries.remove(country);
        return countries;
    }
}

