
import java.util.LinkedList;

public class Table {
    private String ID;
    private int capacity;
    private boolean inService;
    private int totalOrder;
    private Employer e;
    private Waiter w;
    private int counter=0;
    private String[][] itemCount=new String[5][]; //Linked list created to parse neworder and addorder
                                         //in each order we pass next linkedlist

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String[] getItemCount() {
        return itemCount[counter-1];       
    }
    
    public void DeleteItemCount(){
        itemCount=new String[5][];
        //itemCount=null;  
        counter=0;
    }
    
    public String [][]getAllItemCount(){
        return itemCount;
    }

    public void setItemCount(String[] itemCount) {
        this.itemCount[counter]=new String[itemCount.length];
        this.itemCount[counter]=itemCount;
        counter++;
    }

    
    
    public Table(String ID, int capacity, boolean inService, Employer e) {
        this.ID = ID;
        this.capacity = capacity;
        this.inService = inService;
        this.e = e;
    }
    
    

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isInService() {
        return inService;
    }

    public void setInService(boolean inService) {
        this.inService = inService;
    }

    public int getTotalOrder() {
        return totalOrder;
    }

    public void setTotalOrder(int totalOrder) {
        this.totalOrder = totalOrder;
    }

    public Employer getE() {
        return e;
    }

    public void setE(Employer e) {
        this.e = e;
    }

    public Waiter getW() {
        return w;
    }

    public void setW(Waiter w) {
        this.w = w;
    }
    
    
}
