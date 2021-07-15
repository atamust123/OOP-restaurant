
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
public class WaiterSalary {

    public WaiterSalary(LinkedList<Waiter> waiters) {
        System.out.println("***********************************\n"
                + "PROGRESSING COMMAND: get_waiter_salary");
        ListIterator<Waiter> waiterIter = waiters.listIterator();
        while (waiterIter.hasNext()) {
            Waiter w = waiterIter.next();
            System.out.print("Salary for " + w.getName() + ": ");
            System.out.println(w.getSalary() + w.getSalary() * (0.05) * w.getTotalOrder());
        }
    }

}
