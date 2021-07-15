
import java.util.LinkedList;
import java.util.ListIterator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AtakanAYYILDIZ
 */
public class StockStatus {

    public StockStatus(LinkedList<Item> items) {
        System.out.println("***********************************\n"
                + "PROGRESSING COMMAND: stock_status");
        ListIterator<Item> itemIter = items.listIterator();
        while (itemIter.hasNext()) {
            Item item = itemIter.next();
            System.out.println(item.getName() + ":\t" + item.getAmount());
        }
    }
}
