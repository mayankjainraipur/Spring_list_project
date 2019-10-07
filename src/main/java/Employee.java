import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Employee extends  Human{

    private String name;
    private String company;
    private int id;
    private Date dob;

    public Employee(){}

    public void getInput(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the Details of the Employee");
        System.out.println("Employee Name");
        this.name = input.nextLine();
        System.out.println("Employee Company");
        this.company = input.nextLine();
        System.out.println("Employee ID Number");
        while (!input.hasNextInt()) {
            System.out.println("Input is not a number.");
            input.nextLine();
        }
        this.id = input.nextInt();
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

    public String getComparingValue(){
        return name;
    }

    @Override
    public String toString() {
        SimpleDateFormat fs = new SimpleDateFormat ("dd-MM-yyyy");
        return "Employee{" +
                "name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", id=" + id +
                ", dob=" + fs.format(dob) +
                '}';
    }
}
