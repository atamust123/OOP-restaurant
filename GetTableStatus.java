
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
public class GetTableStatus {

    public GetTableStatus(LinkedList<Table> tables) {
        System.out.println("***********************************\n"
                + "PROGRESSING COMMAND: get_table_status");
        ListIterator<Table> tableIter = tables.listIterator();
        while (tableIter.hasNext()) {
            Table table = tableIter.next();
            System.out.print("Table " + table.getID() + ": ");
            if (table.isInService()) {
                System.out.println("Reserved (" + table.getW().getName() + ")");
            } else {
                System.out.println("Free");
            }
        }
    }

}
