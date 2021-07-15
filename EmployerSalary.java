
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
public class EmployerSalary {

    public EmployerSalary(LinkedList<Employer> employers) {
        System.out.println("***********************************\n"
                + "PROGRESSING COMMAND: get_employer_salary");
        ListIterator<Employer> empIter = employers.listIterator();
        while (empIter.hasNext()) {
            Employer e = empIter.next();
            System.out.print("Salary for " + e.getName() + ": ");
            System.out.println(e.getSalary() + e.getSalary() * (0.1) * e.getAllowedMaxTables());
        }
    }

}
