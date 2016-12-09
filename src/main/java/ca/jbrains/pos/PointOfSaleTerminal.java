package ca.jbrains.pos;

import com.google.common.collect.ImmutableMap;

import ca.jbrains.pos.controller.command.ConsumeTextCommands;
import ca.jbrains.pos.controller.SellOneItemController;
import ca.jbrains.pos.model.InMemoryCatalog;
import ca.jbrains.pos.model.data.Price;
import ca.jbrains.pos.view.WriterDisplay;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PointOfSaleTerminal {
    public static void main(String[] args) {
        new ConsumeTextCommands(
                new SellOneItemController(
                        new InMemoryCatalog(
                                ImmutableMap.of(
                                        "12345", Price.cents(795),
                                        "7070529026686", Price.cents(125)
                                )
                        ),
                        new WriterDisplay(new OutputStreamWriter(System.out))
                )::onBarcode
        ).consume(new InputStreamReader(System.in));
    }
}
