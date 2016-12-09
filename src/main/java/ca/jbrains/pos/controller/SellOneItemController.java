package ca.jbrains.pos.controller;

import ca.jbrains.pos.model.ICatalog;
import ca.jbrains.pos.model.data.Price;
import ca.jbrains.pos.view.IDisplay;

public class SellOneItemController implements IBarcodeScannedListener {
    private final ICatalog catalog;
    private final IDisplay display;

    public SellOneItemController(ICatalog catalog, IDisplay display) {
        this.catalog = catalog;
        this.display = display;
    }

    public void onBarcode(String barcode) {
        final Price price = catalog.findPrice(barcode);
        if (price == null)
            display.displayProductNotFoundMessage(barcode);
        else
            display.displayPrice(price);
    }
}
