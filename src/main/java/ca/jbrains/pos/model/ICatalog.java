package ca.jbrains.pos.model;

import ca.jbrains.pos.model.data.Price;

public interface ICatalog {
    Price findPrice(String barcode);
}
