package io.zipcoder;

import io.zipcoder.utils.FileReader;
import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroceryReporter {
    private final String originalFileText;

    public GroceryReporter(String jerksonFileName) {
       this.originalFileText = FileReader.readFile(jerksonFileName);
    }

//    public static Item[] groceryListArray(String valueToParse) throws ItemParseException{
//        List<String>groceryListIn;
//        groceryListIn = Arrays.asList(valueToParse.toLowerCase().replaceAll("##", "\n").split("\\n"));
//        Item[] formattedList = new Item[groceryListIn.size()];
//            for (int i=0; i<groceryListIn.size(); i++){
//                    String newItem = groceryListIn.get(i).replaceAll("[^\\p{Alpha}\\p{Digit}]", " ");
//                    String[] itemArr = newItem.split(" ");
//                    String name = itemArr[1];
//                    Double price = Double.parseDouble(itemArr[3] + "." + itemArr[4]);
//                    String type = itemArr[6];
//                    String expiration = itemArr[8] + "/" + itemArr[9] + "/" + itemArr[10];
//                    Item itemObj = new Item(name, price, type, expiration);
//                    formattedList[i] = itemObj;
//                    System.out.println(Arrays.toString(formattedList));
//
//
//                }return formattedList;
//            }


    @Override
    public String toString() {
        return null;
    }
}
