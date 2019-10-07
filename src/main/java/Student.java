import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Student extends Human{

    private String name;     // first name
    private String email;     // email address
    private int section;      // section number
    private Date dob = null;

    //default constructor
    public Student(){}

    public void getInput(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Details of the Student");
        System.out.println("Student Name");
        this.name = input.nextLine();
        System.out.println("Student Email");
        this.email = input.nextLine();
        System.out.println("Student Section");
        while (!input.hasNextInt()) {
            System.out.println("Input is not a number.");
            input.nextLine();
        }
        this.section = input.nextInt();
        System.out.println("Enter Date of Birth (dd-MM-yyyy)");
        SimpleDateFormat fs = new SimpleDateFormat ("dd-MM-yyyy");
        while(this.dob == null){
            try {
                this.dob = fs.parse(input.nextLine());
            } catch (ParseException e) {
                System.out.println("Unparseable using " + fs);
            }
        }
    }

    public String getComparingValue() {
        return name;
    }

    @Override
    public String toString() {
        SimpleDateFormat fs = new SimpleDateFormat ("dd-MM-yyyy");
        return "Student{" +
                "first='" + name + '\'' +
                ", email='" + email + '\'' +
                ", section=" + section +
                ", dob=" + fs.format(dob) +
                '}';
    }
}
