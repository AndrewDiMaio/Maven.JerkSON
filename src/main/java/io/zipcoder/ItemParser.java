package io.zipcoder;
import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemParser {

    public List<Item> parseItemList(String valueToParse){ //throws ItemParseException {
        Matcher matcher = regMethod("##", valueToParse);
        List<String> groceryListIn = Arrays.asList(matcher.replaceAll("\n").split("\n"));
        Item[] parsedList = new Item[groceryListIn.size()];
        int bound = groceryListIn.size();
        for (int i = 0; i < bound; i++) {
            try {
                if (parseSingleItem(groceryListIn.get(i)) != null) {
                    parsedList[i] = parseSingleItem(groceryListIn.get(i));
                }
            } catch (ItemParseException e) {
                e.printStackTrace();
            }
        }
        ArrayList<Item> list = new ArrayList<>();
        for (Item item : parsedList) {
            if (item != null) {
                list.add(item);
            }
        }
        return list;
    }

    public Item parseSingleItem(String singleItem) throws ItemParseException {
            Matcher matcher = regMethod("[:, @, ^, *, %,;]", singleItem.toLowerCase());
            String[] itemArr = matcher.replaceAll(" ").split(" ");
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
        return new Item(name, price, type, expiration);
    }

    public Matcher regMethod(String regex, String string){
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        return pattern.matcher(string);
    }
}
