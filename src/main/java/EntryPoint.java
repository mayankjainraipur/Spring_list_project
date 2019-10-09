import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Scanner;

public class EntryPoint {

    static Logger log = Logger.getLogger(EntryPoint.class.getName());

    public static void main(String[] args) throws IOException {
        int choice1,choice2;
        log.debug("");
        Scanner myObj = new Scanner(System.in);
        log.info("Program Started");
        System.out.println("Choose the type of DataEntry \n1. Employee \n2. Student \nEnter the option: ");
        choice1 = myObj.nextInt();
        CommonList ll = null;
        if (choice1 == 1) {
                ll = new CommonList<Employee>();
                log.info("User has chosen Employee");
        } else {
                ll = new CommonList<Student>();
                log.info("User has chosen Student");
        }
        do {
            Human h = choice1 == 1? new Employee() : new Student() ;
            System.out.flush();
            System.out.println("1. ADD \n2. DELETE \n3. INSERT \n4. SORT LIST BY NAME \n5. SHOW ALL \n6. EXIT\n Enter your choice : ");
            choice2 = myObj.nextInt();
            switch (choice2) {
                case 1:
                    h.getInput();
                    ll.add(h);
                    break;
                case 2:
                    ll.delete();
                    break;
                case 3:
                    h.getInput();
                    ll.insert(h);
                    break;
                case 4:
                    ll.sortList();
                    break;
                case 5:
                    ll.show();
                    break;
                case 6:
                    System.out.println("You choose to exit....");
                    break;
                default:
                    System.out.println("Wrong Option !");
                    break;
            }
            System.out.println("Press Any Key To Continue");
            System.in.read();
        } while (choice2 != 6);
        myObj.close();
    }
}

