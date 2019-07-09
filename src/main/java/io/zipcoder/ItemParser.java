package io.zipcoder;

import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class ItemParser {
    public List<Item> parseItemList(String valueToParse){ //throws ItemParseException {
        final String regex = "##";
        final String string = valueToParse.toLowerCase();
        final String subst = "\n";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(string);
        final String result = matcher.replaceAll(subst);
        List<String>groceryListIn;
        groceryListIn = Arrays.asList(result.split("\n"));
        Item[] parsedList = new Item[groceryListIn.size()];
        for (int i = 0; i < groceryListIn.size(); i++) {
            try {
                if (parseSingleItem(groceryListIn.get(i)) != null) {
                    parsedList[i] = parseSingleItem(groceryListIn.get(i));
                }
            } catch (ItemParseException e) {
                e.printStackTrace();
            }

        }
        List<Item>finishedList = new ArrayList<>();
        for (Item item:parsedList) {
            if (item !=null){
                finishedList.add(item);
            }
        }
        return finishedList;
    }

    public Item parseSingleItem(String singleItem) throws ItemParseException {
            final String regex = "[:, @, ^, *, %,;]";
            final String string = singleItem.toLowerCase();
            final String subst = " ";
            final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
            final Matcher matcher = pattern.matcher(string);
            final String result = matcher.replaceAll(subst);
            String[] itemArr = result.split(" ");
            String name = itemArr[1];
            Double price;
            try {
                price = Double.parseDouble(itemArr[3]);
            }catch (Exception e){
                throw new ItemParseException();
            }
            String type = itemArr[5];
            String expiration;
            try {
                 expiration = itemArr[7].replaceAll("##", "");
            }catch(Exception e){
                throw new ItemParseException();
            }

            Item itemObj = new Item(name, price, type, expiration);

        return itemObj;

    }
}
