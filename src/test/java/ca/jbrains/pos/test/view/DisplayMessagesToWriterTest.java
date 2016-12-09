package ca.jbrains.pos.test.view;

import org.junit.Assert;
import org.junit.Test;

import ca.jbrains.pos.model.data.Price;
import ca.jbrains.pos.view.WriterDisplay;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

public class DisplayMessagesToWriterTest {
    @Test
    public void emptyBarcode() throws Exception {
        final StringWriter canvas = new StringWriter();

        new WriterDisplay(canvas).displayScannedEmptyBarcodeMessage();

        Assert.assertEquals(
                Arrays.asList("Scanning error: empty barcode"),
                lines(canvas.toString())
        );
    }

    @Test
    public void productNotFoundMessage() throws Exception {
        final StringWriter canvas = new StringWriter();

        new WriterDisplay(canvas).displayProductNotFoundMessage("::barcode not found::");

        Assert.assertEquals(
                Arrays.asList("Product not found for ::barcode not found::"),
                lines(canvas.toString())
        );
    }

    @Test
    public void price() throws Exception {
        final StringWriter canvas = new StringWriter();

        new WriterDisplay(canvas).displayPrice(Price.cents(198));

        Assert.assertEquals(
                Arrays.asList("EUR 1.98"),
                lines(canvas.toString())
        );
    }

    // REFACTOR Move to a reusable library OR replace with an existing library
    public static List<String> lines(String multilineText) {
        return Arrays.asList(multilineText.split(System.lineSeparator()));
    }
    
}
