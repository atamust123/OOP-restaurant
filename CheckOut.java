
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AtakanAYYILDIZ
 */
public class CheckOut {

    public CheckOut(LinkedList<Waiter> waiters, String[] command, LinkedList<Table> tables,
            LinkedList<Item> items) {
        Waiter w = null; //waiter w
        ListIterator<Waiter> waiterIter = waiters.listIterator();
        while (waiterIter.hasNext()) {//control waiter 
            w = waiterIter.next();
            if (command[1].equals(w.getName())) {
                break;
            } else if (waiterIter.hasNext() == false) {
                w = null;
                break;
            }
        }
        if (w == null) {
            System.out.println("***********************************\n"
                    + "PROGRESSING COMMAND: check_out\n"
                    + "There is no waiter named " + command[1]);
            return;
        }
        Table t = null;
        int i, j;
        ListIterator<Table> tableIter = tables.listIterator();
        while (tableIter.hasNext()) {//control table
            t = tableIter.next();
            if (t.getID().equals(command[2]) && t.isInService()
                    && t.getW().getName().equals(command[1])) {
                System.out.println("***********************************\n"
                        + "PROGRESSING COMMAND: check_out");
                String array[][] = t.getAllItemCount();
                
                ArrayList<String> list = new ArrayList<String>();
                for (i = 0; i<5; i++) {
                    if (array[i] != null){
                        for (j = 0; j < array[i].length; j += 2) {
                            int b = 0;
                            while (b < Integer.parseInt(array[i][j + 1])) {
                                list.add(array[i][j]);
                                b++;
                            }
                        }
                    }
                        
                }
                Set<String> set = new LinkedHashSet<>();
                set.addAll(list);
                double total = 0;
                Item item = null;
                for (String s : set) {
                    ListIterator<Item> itemIter = items.listIterator();
                    while (itemIter.hasNext()) {
                        item = itemIter.next();
                        if (item.getName().equals(s)) {
                            break;
                        }
                    }
                    System.out.print(s + ":\t");
                    System.out.printf("%.3f", item.getCost());
                    total += item.getCost() * Collections.frequency(list, s);
                    System.out.print(" (x " + Collections.frequency(list, s) + ") ");
                    System.out.printf("%.3f $\n", (item.getCost() * Collections.frequency(list, s)));
                }
                System.out.printf("Total:\t%.3f $\n", total);
                t.setE(null);
                t.setInService(false);
                t.DeleteItemCount();
                t.getW().setMAX_TABLE_SERVICES(t.getW().getMAX_TABLE_SERVICES()-1);
                t.setW(null);//table is freee
                t.DeleteItemCount();
                break;
            } else if (t.getID().equals(command[2]) && t.isInService()
                    && t.getW().getName().equals(command[1]) == false) {
                System.out.println("***********************************\n"
                        + "PROGRESSING COMMAND: check_out\n"
                        + "This table is either not in service now or "
                        + command[1] + " cannot be assigned this table!");
                break;
            } else if (tableIter.hasNext() == false) {
                t = null;
                break;
            }
        }
        if (t == null) {
            System.out.println("***********************************\n"
                    + "PROGRESSING COMMAND: check_out\n"
                    + "This table is either not in service now or "
                    + command[1] + " cannot be assigned this table!");
            return;
        }
    }
}
