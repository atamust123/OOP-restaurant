
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
public class CreateTable {

    private static int maxTableCounter = 0;//up to five
    private boolean isEmployerExist = false;
    private static int tableID = 0;
    private final int allowedMaxTableCounter = 2;//employer can deal with up to 2

    public CreateTable(LinkedList<Employer> employers, String[] command, LinkedList<Table> tables) {
        ListIterator<Employer> iter = employers.listIterator();
        if (maxTableCounter >= 5) {
            System.out.println("***********************************\n"
                    + "PROGRESSING COMMAND: create_table\n"
                    + "Not allowed to exceed max. number of tables, 5");
            return;
        }
        while (iter.hasNext()) {
            Employer e = iter.next();
            if (e.getName().equals(command[1]) && maxTableCounter < 5) {
                if (e.getAllowedMaxTables() < allowedMaxTableCounter) {
                    isEmployerExist = true;
                    System.out.println("***********************************\n"
                            + "PROGRESSING COMMAND: create_table\n"
                            + "A new table has successfully been added");
                    Table t = new Table(Integer.toString(tableID++), Integer.parseInt(command[2]), false, e);
                    tables.add(t);
                    maxTableCounter++;
                    e.setAllowedMaxTables(e.getAllowedMaxTables() + 1);
                } else {
                    isEmployerExist = true;
                    System.out.println("***********************************\n"
                            + "PROGRESSING COMMAND: create_table\n"
                            + command[1] + " has already created 2 tables!");
                }
                break;
            }
        }
        if (isEmployerExist == false) {
            System.out.println("***********************************\n"
                    + "PROGRESSING COMMAND: create_table\n"
                    + "There is no employer named " + command[1]);
            return;
        }
        return;
    }

}
