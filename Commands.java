
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
public class Commands {
    public Commands(LinkedList<Waiter> waiters, LinkedList<Table> tables,
            LinkedList<Item> items,LinkedList<Employer>employers) throws FileNotFoundException{
        Scanner sc;
        sc = new Scanner(new BufferedReader(new FileReader("commands.dat")));
        while (sc.hasNextLine()) {
            String temp = sc.nextLine();
            String command[] = temp.split("[; ]");
            switch (command[0]) {
                case "create_table":
                    CreateTable ct = new CreateTable(employers, command, tables);
                    break;
                case "new_order":
                    NewOrder newOrder = new NewOrder(employers, command, tables, waiters, items);
                    break;
                case "add_order":
                    AddOrder addOrder = new AddOrder(employers, command, tables, waiters, items);
                    break;
                case "check_out":
                    CheckOut cOut = new CheckOut(waiters, command, tables, items);
                    break;
                case "stock_status":
                    StockStatus sS = new StockStatus(items);
                    break;
                case "get_table_status":
                    GetTableStatus gts = new GetTableStatus(tables);
                    break;
                case "get_order_status":
                    getOrderStatus gos = new getOrderStatus(tables);
                    break;
                case "get_employer_salary":
                    EmployerSalary eSalary = new EmployerSalary(employers);
                    break;
                case "get_waiter_salary":
                    WaiterSalary wSalary = new WaiterSalary(waiters);
                    break;
                default:
                    break;
            }
        }
    }
}
