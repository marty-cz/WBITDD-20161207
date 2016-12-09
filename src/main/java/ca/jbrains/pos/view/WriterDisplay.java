package ca.jbrains.pos.view;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import ca.jbrains.pos.model.data.Price;
import ca.jbrains.pos.view.IDisplay;

public class WriterDisplay implements IDisplay {
	
	private final PrintWriter writer;
	
    public WriterDisplay(Writer writer) {
		this.writer = new PrintWriter(writer, true);
	}

	@Override
    public void displayPrice(Price price) {
        writer.println(String.format("EUR %.2f", price.euro()));
    }

    @Override
    public void displayProductNotFoundMessage(String barcodeNotFound) {
    	writer.println(String.format("Product not found for %s", barcodeNotFound));
    }

    @Override
    public void displayScannedEmptyBarcodeMessage() {
    	writer.println("Scanning error: empty barcode");
    }
}
