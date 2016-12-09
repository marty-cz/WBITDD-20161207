package ca.jbrains.pos.test.model;

import com.google.common.collect.ImmutableMap;

import ca.jbrains.pos.model.ICatalog;
import ca.jbrains.pos.model.InMemoryCatalog;
import ca.jbrains.pos.model.data.Price;

public class FindPriceInMemoryCatalogTest extends FindPriceInCatalogContract {

    @Override
    protected ICatalog catalogWith(String barcode, Price matchingPrice) {
        return new InMemoryCatalog(ImmutableMap.of(
                "not " + barcode, Price.cents(0),
                barcode, matchingPrice,
                "still not " + barcode, Price.cents(18372)
        ));
    }

    @Override
    protected ICatalog catalogWithout(String barcodeToAvoid) {
        return new InMemoryCatalog(ImmutableMap.of(
                "not " + barcodeToAvoid, Price.cents(1),
                "still not " + barcodeToAvoid, Price.cents(2),
                "definitely not " + barcodeToAvoid, Price.cents(3)
        ));
    }

}
