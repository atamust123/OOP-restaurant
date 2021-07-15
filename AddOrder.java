
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
public class AddOrder {

    private static int MAX_ITEMS = 10;

    public AddOrder(LinkedList<Employer> employers, String[] command, LinkedList<Table> tables,
            LinkedList<Waiter> waiters, LinkedList<Item> items) {
        Waiter w = null;//temporary waiter
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
                    + "PROGRESSING COMMAND: add_order\n"
                    + "There is no waiter named " + command[1]);
            return;
        }
        Table t = null;
        ListIterator<Table> tableIter = tables.listIterator();
        while (tableIter.hasNext()) {//control table
            t = tableIter.next();
            if (t.getID().equals(command[2]) && t.isInService()
                    && t.getW().getName().equals(command[1]) 
                    && t.getCounter()<5) {
                break;
            } else if (t.getID().equals(command[2]) &&
                    t.getW().getName().equals(command[1]) == false) {
                System.out.println("\n"+t.getID()+"\nasdasdasdasd\n\n\n");
                System.out.println("***********************************\n"
                        + "PROGRESSING COMMAND: add_order\n"
                        + "This table is either not in service now or "
                        + command[1] + " cannot be assigned this table!");
                break;
            } else if (tableIter.hasNext() == false) {
                t = null;
                break;
            }else if (t.getCounter()==5){
                System.out.println("***********************************\n"
                    + "PROGRESSING COMMAND: add_order\n"
                    + "Not allowed to exceed max number of orders!");
                return;
            }
        }
        if (t == null) {
            System.out.println("***********************************\n"
                    + "PROGRESSING COMMAND: add_order\n"
                    + "This table is either not in service now or "
                    + command[1] + " cannot be assigned this table!");
            return;
        }
        String arraytemp[][] = t.getAllItemCount();//look at the previous orders
        int result = 0,
                i,
                j;
        
        for (i = 0; arraytemp[i] != null; i++) {
            for (j = 1; j < arraytemp[i].length; j += 2) {
                result += Integer.parseInt(arraytemp[i][j]);
            }
        }
        MAX_ITEMS = 10 - result;
        String newOrders[] = command[3].split("[:-]");
        if (MAX_ITEMS == 0) {
            System.out.println("***********************************\n"
                    + "PROGRESSING COMMAND: add_order\n"
                    + "Not allowed to exceed max number of orders!");
            return;
        } else {
            System.out.println("***********************************\n"
                    + "PROGRESSING COMMAND: add_order");
            int orderItems = 0;
            while (orderItems < newOrders.length) {
                ListIterator<Item> itemIter = items.listIterator();
                while (itemIter.hasNext()) {
                    Item item = itemIter.next();
                    int amountOfItem = Integer.parseInt(newOrders[orderItems + 1]);
                    if (newOrders[orderItems].equals(item.getName())) {
                        if (amountOfItem <= MAX_ITEMS) {
                            if (amountOfItem <= item.getAmount()) {
                                i = 0;
                                while (i < amountOfItem) {
                                    System.out.println("Item " + item.getName()
                                            + " added into order");
                                    i++;
                                }
                                MAX_ITEMS -= amountOfItem;
                                item.setAmount(item.getAmount() - amountOfItem);
                                if (newOrders.length - 2 == orderItems) {
                                    t.setItemCount(newOrders); //orders are stored in table
                                    t.getW().setTotalOrder(t.getW().getTotalOrder() + 1);
                                }

                                break;
                            } else {//stock will be 0
                                i = 0;
                                while (i < item.getAmount()) {
                                    System.out.println("Item " + item.getName()
                                            + " added into order");
                                    i++;
                                }
                                MAX_ITEMS -= item.getAmount();
                                i = 0;
                                while (i < Integer.parseInt(newOrders[orderItems + 1]) - item.getAmount()) {
                                    System.out.println("Sorry! No " + item.getName()
                                            + " in the stock!");
                                    i++;
                                }
                                newOrders[orderItems + 1] = Integer.toString(item.getAmount());
                                item.setAmount(0);//stock is empty
                                if (newOrders.length - 2 == orderItems) {
                                    t.setItemCount(newOrders);
                                    t.getW().setTotalOrder(t.getW().getTotalOrder() + 1);
                                }
                                break;
                            }
                        } else {//if more than max items entered
                            if (MAX_ITEMS == 0) {
                                i = 0;
                                while (i < Integer.parseInt(newOrders[orderItems + 1])) {
                                    System.out.println("Not allowed to exceed max no. "
                                            + "of max item in a single order!");
                                    i++;
                                }
                                newOrders[orderItems + 1] = Integer.toString(MAX_ITEMS);
                                if (newOrders.length - 2 == orderItems) {
                                    t.setItemCount(newOrders);
                                }
                                break;
                            } else if (MAX_ITEMS <= item.getAmount()) {//3 order can add but 
                                i = 0;
                                while (i < MAX_ITEMS) {
                                    System.out.println("Item " + item.getName()
                                            + " added into order");
                                    i++;
                                }
                                i = 0;
                                while (i < Integer.parseInt(newOrders[orderItems + 1]) - MAX_ITEMS) {
                                    System.out.println("Not allowed to exceed max no. "
                                            + "of max item in a single order!");
                                    i++;
                                }
                                item.setAmount(item.getAmount() - MAX_ITEMS);
                                newOrders[orderItems + 1] = Integer.toString(MAX_ITEMS);
                                if (newOrders.length - 2 == orderItems) {
                                    t.setItemCount(newOrders);
                                    t.getW().setTotalOrder(t.getW().getTotalOrder() + 1);
                                }
                                MAX_ITEMS = 0;

                                break;
                            } else {//orders can still add to the table but stock is empty
                                i = 0;
                                while (i < item.getAmount()) {
                                    System.out.println("Item " + item.getName()
                                            + " added into order");
                                    i++;
                                }
                                i = 0;
                                while (i < amountOfItem - item.getAmount()) {
                                    System.out.println("Sorry! No " + item.getName()
                                            + " in the stock!");
                                    i++;
                                }
                                newOrders[orderItems + 1] = Integer.toString(item.getAmount());
                                MAX_ITEMS -= item.getAmount();
                                item.setAmount(0);
                                if (newOrders.length - 2 == orderItems) {
                                    t.setItemCount(newOrders);
                                    t.getW().setTotalOrder(t.getW().getTotalOrder() + 1);
                                }

                                break;
                            }
                        }
                    } else if (itemIter.hasNext() == false) {

                        i = 0;
                        while (i < amountOfItem) {
                            System.out.println("Unknown item " + newOrders[orderItems]);
                            i++;
                        }
                        newOrders[orderItems + 1] = Integer.toString(0);
                        break;
                    }
                }
                orderItems += 2;
            }
        }
    }
}
