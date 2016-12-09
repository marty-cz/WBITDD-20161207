package ca.jbrains.pos.view;

import ca.jbrains.pos.model.data.Price;

public interface IDisplay {
	
    void displayPrice(Price price);
    
    String formatPrice(Price price);

    void displayProductNotFoundMessage(String barcodeNotFound);

    void displayScannedEmptyBarcodeMessage();
}
