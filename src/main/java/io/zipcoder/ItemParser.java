package io.zipcoder;

import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;

import java.util.Arrays;
import java.util.List;

public class ItemParser {
    public List<Item> parseItemList(String valueToParse) {
        Item[] parsedList = GroceryReporter.groceryListArray(valueToParse);
        return Arrays.asList(parsedList);
    }

    public Item parseSingleItem(String singleItem) throws ItemParseException {
        Item[] parsedList = GroceryReporter.groceryListArray(singleItem);
        return parsedList[0];
    }
}
