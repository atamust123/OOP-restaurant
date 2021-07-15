
import java.io.FileNotFoundException;
import java.util.LinkedList;

public class Assignment2 {

    public static void main(String[] args) throws FileNotFoundException {

        LinkedList<Item> items = new LinkedList<>();
        LinkedList<Employer> employers = new LinkedList<>();
        LinkedList<Waiter> waiters = new LinkedList<>();
        LinkedList<Table> tables = new LinkedList<>();

        Setup setup = new Setup(waiters, tables, items, employers);
        Commands commands = new Commands(waiters, tables, items, employers);
    }
}
