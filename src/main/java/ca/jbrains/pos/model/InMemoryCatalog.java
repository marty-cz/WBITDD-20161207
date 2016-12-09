package ca.jbrains.pos.model;

import com.google.common.collect.ImmutableMap;

import ca.jbrains.pos.model.data.Price;

public class InMemoryCatalog implements ICatalog {
    private final ImmutableMap<String, Price> pricesByBarcode;

    public InMemoryCatalog(ImmutableMap<String, Price> pricesByBarcode) {
        this.pricesByBarcode = pricesByBarcode;
    }

    public Price findPrice(String barcode) {
        return pricesByBarcode.get(barcode);
    }
}
