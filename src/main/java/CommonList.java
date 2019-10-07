import java.util.*;
import org.apache.log4j.Logger;

public class CommonList<T extends Human> {

    private List<T> inMemoryList = new ArrayList<T>();
    Scanner input;
    private final Logger log = Logger.getRootLogger();

    public CommonList() {
        this.input = new Scanner(System.in);
    }

    public int length(){
        return inMemoryList.size();
    }

    public boolean checkRepeat(T a){
        boolean repeat = false;
        for (T value: inMemoryList) {
            if (value.getComparingValue() == a.getComparingValue()){
                repeat = true;
            }
        }
        return repeat;
    }

    public void add(T a){
        if (! this.checkRepeat(a)){
            log.info("new object added");
            inMemoryList.add(a);
        }
        else {
            System.err.println("Repeated Entry");
        }
    }
    // delete the object at index provided.
    public void delete(){
        System.out.println("Enter index to delete element(Index start with 1):");
        int x = input.nextInt();
        if ( x < 1 || x > this.length()){
            System.err.println("Index out of bound");
        }
        else {
            inMemoryList.remove(x-1);
            log.info("object deleted" + x);
            System.out.println("Object deleted");
        }
    }
    // insert the object at the desired position, if pos out of bound it add in last.
    public void insert(T a){
        if (! this.checkRepeat(a)) {
            System.out.println("Enter index to insert element(Index start with 1):");
            int x = input.nextInt();

            if (x < 1 || x > this.length()) {
                inMemoryList.add(a);
                log.info("new object added through insert at last");
            } else {
                inMemoryList.add(x - 1, a);
                log.info("new object added through insert at " + x);
            }
        }
        else {
            System.err.println("Repeated Entry");
        }
    }

    public void sortList(){
        Collections.sort(inMemoryList,new MakeInOrder());
        /* another option is to use -
        Comparator<Human> cm1=Comparator.comparing(Human::getComparingValue);
        Collections.sort(inMemoryList,cm1);
         */
    }

    public void show(){
        System.out.println("Entries in List are");
        for (T value: inMemoryList) {
            System.out.println(value.toString());

        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        this.input.close();
    }
}
