
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AtakanAYYILDIZ
 */
public class Setup {
    public Setup(LinkedList<Waiter> waiters, LinkedList<Table> tables,
            LinkedList<Item> items,LinkedList<Employer>employers) throws FileNotFoundException{
        Scanner sc = new Scanner(new BufferedReader(new FileReader("setup.dat")));     

        while (sc.hasNextLine()) {
            String temp = sc.nextLine();
            String[] command = temp.split("[; ]");
            switch (command[0]) {
                case "add_item":
                    //1.itemName,  2.Cost, 3.Amount
                    Item item = new Item(command[1], Double.parseDouble(command[2]), Integer.parseInt(command[3]));
                    items.add(item);
                    break;
                case "add_employer":
                    //1. Name,  2.Salary
                    if (employers.size() < 5) {                        
                        Employer emp = new Employer(command[1], Double.parseDouble(command[2]), 0);
                        employers.add(emp);
                        break;
                    } else {
                        System.out.println("***********************************\n"
                                + "Not allowed to exceed max. number of employers, 5");
                    }
                    break;
                case "add_waiter":
                    if (waiters.size() < 5) {
                        Waiter w = new Waiter(command[1], Double.parseDouble(command[2]), 0);
                        waiters.add(w);
                        break;
                    } else {
                        System.out.println("***********************************\n"
                                + "waiter can not added.");
                    }
                    break;
                default:
                    break;
            }
        }
    }
    
}
