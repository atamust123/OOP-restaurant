
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
public class NewOrder {

    private final int MAX_TABLE_SERVICES = 3;
    private static int MAX_ITEMS = 10;

    public NewOrder(LinkedList<Employer> employers, String[] command, LinkedList<Table> tables,
            LinkedList<Waiter> waiters, LinkedList<Item> items) {
        ListIterator<Table> tableIter = tables.listIterator();
        ListIterator<Waiter> waiterIter = waiters.listIterator();
        boolean isWaiterExist = false;
        Waiter w = null;
        while (waiterIter.hasNext()) {
            w = waiterIter.next();
            if (w.getName().equals(command[1])) {
                isWaiterExist = true;
                break;
            }
        }
        if (isWaiterExist == false) {
            System.out.println("***********************************\n"
                    + "PROGRESSING COMMAND: new_order\n"
                    + "There is no waiter named " + command[1]);
            return;
        }
        if (w.getMAX_TABLE_SERVICES() >= MAX_TABLE_SERVICES ) {
            System.out.println("***********************************\n"
                    + "PROGRESSING COMMAND: new_order\n"
                    + "Not allowed to service max. number of tables, MAX_TABLE_SERVICES");

            return;
        }
        while (tableIter.hasNext()) {
            Table t = tableIter.next();
            if (t.isInService() == false) {
                MAX_ITEMS = 10;
                if (Integer.parseInt(command[2]) <= t.getCapacity()) {
                    t.setInService(true);//table is in service
                    w.setMAX_TABLE_SERVICES(w.getMAX_TABLE_SERVICES() + 1);
                    t.setW(w);//set waiter the table

                    String array[] = command[3].split("[:-]");
                    System.out.println("***********************************\n"
                            + "PROGRESSING COMMAND: new_order\n"
                            + "Table (= ID " + t.getID() + ") has been taken into service");
                    int orderItems = 0;
                    while (orderItems < array.length) {
                        ListIterator<Item> itemIter = items.listIterator();
                        while (itemIter.hasNext()) {
                            Item item = itemIter.next();//search the item
                            if (item.getName().equals(array[orderItems])) {//item found and operate
                                int AmountOfOrder = Integer.parseInt(array[orderItems + 1]);
                                if (AmountOfOrder <= MAX_ITEMS) {//control max 10
                                    if (AmountOfOrder <= item.getAmount()) {//control stock
                                        int i = 0;
                                        while (i < AmountOfOrder) {
                                            System.out.println("Item " + item.getName()
                                                    + " added into order");
                                            i++;
                                        }
                                        MAX_ITEMS -= AmountOfOrder;
                                        item.setAmount(item.getAmount() - AmountOfOrder);
                                        if (array.length - 2 == orderItems) {
                                            t.setItemCount(array); //orders are stored in table
                                            t.getW().setTotalOrder(t.getW().getTotalOrder() + 1);
                                        }

                                        break;
                                    } else {//stock will be 0
                                        int i = 0;
                                        while (i < item.getAmount()) {
                                            System.out.println("Item " + item.getName()
                                                    + " added into order");
                                            i++;
                                        }
                                        MAX_ITEMS -= item.getAmount();
                                        i = 0;
                                        while (i < Integer.parseInt(array[orderItems + 1]) - item.getAmount()) {
                                            System.out.println("Sorry! No " + item.getName()
                                                    + " in the stock!");
                                            i++;
                                        }
                                        array[orderItems + 1] = Integer.toString(item.getAmount());
                                        item.setAmount(0);//stock is empty
                                        if (array.length - 2 == orderItems) {
                                            t.setItemCount(array);
                                            t.getW().setTotalOrder(t.getW().getTotalOrder() + 1);
                                        }

                                        break;
                                    }

                                } else {//if more than max items entered
                                    if (MAX_ITEMS == 0) {
                                        int i = 0;
                                        while (i < Integer.parseInt(array[orderItems + 1])) {
                                            System.out.println("Not allowed to exceed max no. "
                                                    + "of max item in a single order!");
                                            i++;
                                        }
                                        array[orderItems + 1] = Integer.toString(MAX_ITEMS);
                                        if (array.length - 2 == orderItems) {
                                            t.setItemCount(array);
                                        }
                                        break;
                                    } else if (MAX_ITEMS <= item.getAmount()) {//3 order can add but 
                                        int i = 0;
                                        while (i < MAX_ITEMS) {
                                            System.out.println("Item " + item.getName()
                                                    + " added into order");
                                            i++;
                                        }
                                        i = 0;
                                        while (i < Integer.parseInt(array[orderItems + 1]) - MAX_ITEMS) {
                                            System.out.println("Not allowed to exceed max no. "
                                                    + "of max item in a single order!");
                                            i++;
                                        }
                                        item.setAmount(item.getAmount() - MAX_ITEMS);
                                        array[orderItems + 1] = Integer.toString(MAX_ITEMS);
                                        if (array.length - 2 == orderItems) {
                                            t.setItemCount(array);
                                            t.getW().setTotalOrder(t.getW().getTotalOrder() + 1);
                                        }
                                        MAX_ITEMS = 0;

                                        break;
                                    } else {//orders can still add to the table but stock is empty
                                        int i = 0;
                                        while (i < item.getAmount()) {
                                            System.out.println("Item " + item.getName()
                                                    + " added into order");
                                            i++;
                                        }
                                        i = 0;
                                        while (i < AmountOfOrder - item.getAmount()) {
                                            System.out.println("Sorry! No " + item.getName()
                                                    + " in the stock!");
                                            i++;
                                        }
                                        array[orderItems + 1] = Integer.toString(item.getAmount());
                                        MAX_ITEMS -= item.getAmount();
                                        item.setAmount(0);
                                        if (array.length - 2 == orderItems) {
                                            t.setItemCount(array);
                                            t.getW().setTotalOrder(t.getW().getTotalOrder() + 1);
                                        }

                                        break;
                                    }
                                }
                            } else if (itemIter.hasNext() == false) {
                                int amountOfItem = Integer.parseInt(array[orderItems + 1]);
                                int i = 0;
                                while (i < amountOfItem) {
                                    System.out.println("Unknown item " + array[orderItems]);
                                    i++;
                                }
                                array[orderItems + 1] = Integer.toString(0);
                                
                                if (array.length - 2 == orderItems) {
                                            t.setItemCount(array);
                                            t.getW().setTotalOrder(t.getW().getTotalOrder() + 1);
                                }
                                
                                break;
                            }
                        }
                        orderItems += 2;
                    }
                    break;
                } else if (tableIter.hasNext() == false
                        && Integer.parseInt(command[2]) > t.getCapacity()) {
                    System.out.println("***********************************\n"
                            + "PROGRESSING COMMAND: new_order\n"
                            + "There is no appropriate table for this order!");
                    break;
                }
            } else if (tableIter.hasNext() == false) {
                System.out.println("***********************************\n"
                        + "PROGRESSING COMMAND: new_order\n"
                        + "There is no appropriate table for this order!");
                break;
            }
        }
    }
}
