package ca.jbrains.pos.view;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.Locale;

import ca.jbrains.pos.model.data.Price;
import ca.jbrains.pos.view.IDisplay;

public class WriterDisplay implements IDisplay {
	
	private final PrintWriter writer;
	
    public WriterDisplay(Writer writer) {
		this.writer = writer == null ? null : new PrintWriter(writer, true);
	}

	@Override
    public void displayPrice(Price price) {
        writer.println(formatPrice(price));
    }
	
    @Override
    public void displayProductNotFoundMessage(String barcodeNotFound) {
    	writer.println(String.format("Product not found for %s", barcodeNotFound));
    }

    @Override
    public void displayScannedEmptyBarcodeMessage() {
    	writer.println("Scanning error: empty barcode");
    }

	@Override
	public String formatPrice(Price price) {
		return String.format(Locale.ROOT, "EUR %.2f", price.euro());
	}
}
