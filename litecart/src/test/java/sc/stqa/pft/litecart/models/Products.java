package sc.stqa.pft.litecart.models;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Products extends ForwardingSet<ProductData> {
    private Set<ProductData> delegate;

    @Override
    protected Set<ProductData> delegate() {
        return delegate;
    }

    public Products() {
        this.delegate = new HashSet<ProductData>();
    }

    public Products(Products products) {
        this.delegate = new HashSet<ProductData>(products.delegate);
    }

    public Products(Collection<ProductData> products) {
        this.delegate = new HashSet<ProductData>(products);
    }

    public Products withAdded(ProductData product){
        Products products = new Products(this);
        products.add(product);
        return products;
    }

    public Products without(ProductData product){
        Products products = new Products(this);
        products.remove(product);
        return products;
    }
}