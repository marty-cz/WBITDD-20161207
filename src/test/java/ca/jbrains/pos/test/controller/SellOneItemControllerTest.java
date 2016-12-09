package ca.jbrains.pos.test.controller;

import ca.jbrains.pos.controller.SellOneItemController;
import ca.jbrains.pos.model.ICatalog;
import ca.jbrains.pos.model.data.Price;
import ca.jbrains.pos.view.IDisplay;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

public class SellOneItemControllerTest {
    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Test
    public void productFound() throws Exception {
        final ICatalog catalog = context.mock(ICatalog.class);
        final IDisplay display = context.mock(IDisplay.class);
        final SellOneItemController controller = new SellOneItemController(catalog, display);

        context.checking(new Expectations() {{
            allowing(catalog).findPrice(with("12345"));
            will(returnValue(Price.cents(795)));

            oneOf(display).displayPrice(with(Price.cents(795)));
        }});

        controller.onBarcode("12345");
    }

    @Test
    public void productNotFound() throws Exception {
        final ICatalog catalog = context.mock(ICatalog.class);
        final IDisplay display = context.mock(IDisplay.class);
        final SellOneItemController controller = new SellOneItemController(catalog, display);

        context.checking(new Expectations() {{
            allowing(catalog).findPrice(with("::barcode not found::"));
            will(returnValue(null));

            oneOf(display).displayProductNotFoundMessage(with("::barcode not found::"));
        }});

        controller.onBarcode("::barcode not found::");
    }
}
