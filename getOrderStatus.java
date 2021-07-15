
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
public class getOrderStatus {

    public getOrderStatus(LinkedList<Table> tables) {
        System.out.println("***********************************\n"
                + "PROGRESSING COMMAND: get_order_status");
        ListIterator<Table> tableIter = tables.listIterator();
        while (tableIter.hasNext()) {
            Table table = tableIter.next();
            System.out.println("Table: " + table.getID());
            if (table.getAllItemCount()==null){
                System.out.println("\t" + "0" + " order(s)");
                continue;
            }
            String array[][] = table.getAllItemCount();
            int orderCount = 0;
            int i = 0, j;
            while (i < 5 && array[i++] != null) {
                orderCount++;
            }
            i = 0;
            int totalItems;
            System.out.println("\t" + orderCount + " order(s)");
            while (i < orderCount) {
                j = 0;
                totalItems = 0;
                while (j < array[i].length) {
                    totalItems += Integer.parseInt(array[i][j + 1]);
                    j += 2;
                }
                System.out.println("\t\t" + totalItems + " item(s)");
                i++;
            }
            
        }
    }

}
