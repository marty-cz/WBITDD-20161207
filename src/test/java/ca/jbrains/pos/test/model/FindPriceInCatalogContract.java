package ca.jbrains.pos.test.model;

import org.junit.Assert;
import org.junit.Test;

import ca.jbrains.pos.model.ICatalog;
import ca.jbrains.pos.model.data.Price;

public abstract class FindPriceInCatalogContract {
    @Test
    public void productFound() throws Exception {
        final ICatalog catalog = catalogWith("12345", Price.cents(795));
        Assert.assertEquals(Price.cents(795), catalog.findPrice("12345"));
    }

    protected abstract ICatalog catalogWith(String barcode, Price matchingPrice);

    @Test
    public void productNotFound() throws Exception {
        final ICatalog catalog = catalogWithout("::barcode not found::");
        Assert.assertEquals(null, catalog.findPrice("::barcode not found::"));
    }

    protected abstract ICatalog catalogWithout(String barcodeToAvoid);
}
