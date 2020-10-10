package seedu.stock.testutil;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.stock.model.SerialNumberSetsBook;
import seedu.stock.model.StockBook;
import seedu.stock.model.stock.AccumulatedQuantity;
import seedu.stock.model.stock.SerialNumberSet;
import seedu.stock.model.stock.Stock;

/**
 * A utility class containing a list of {@code Stock} objects to be used in tests.
 */
public class TypicalStocks {
    public static final Stock APPLE = new StockBuilder().withName("Apple Juice")
            .withSerialNumber("Ntuc1").withSource("Ntuc")
            .withQuantity("2000").withLocation("Fruit Section, Subsection C")
            .build();
    public static final Stock BANANA = new StockBuilder().withName("Banana Cake")
            .withSerialNumber("Fairprice1").withSource("Fairprice")
            .withQuantity("2103").withLocation("Fruits section, Subsection B")
            .build();

    private TypicalStocks() {} // prevents instantiation

    /**
     * Returns an {@code StockBook} with all the typical stocks.
     */
    public static StockBook getTypicalStockBook() {
        StockBook inventory = new StockBook();
        for (Stock stock : getTypicalStocks()) {
            inventory.addStock(stock);
        }
        return inventory;
    }

    public static List<Stock> getTypicalStocks() {
        return new ArrayList<>(Arrays.asList(APPLE, BANANA));
    }

    public static SerialNumberSetsBook getTypicalStocksSerialNumbers() {
        SerialNumberSetsBook serialNumbers = new SerialNumberSetsBook();
        List<SerialNumberSet> serialNumberSets = new ArrayList<>();
        for (Stock stock: getTypicalStocks()) {
            serialNumberSets.add(new SerialNumberSet(stock.getSource(), new AccumulatedQuantity("1")));
        }
        serialNumbers.setSerialNumberSets(serialNumberSets);
        return serialNumbers;
    }
}
