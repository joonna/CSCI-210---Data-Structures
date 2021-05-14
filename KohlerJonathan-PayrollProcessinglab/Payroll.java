import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Payroll class gathers the data from the hireFile and the fireFile
 * 
 * @author Jonathan Kohler
 * @version 7/27/2019
 * 
 */

public class Payroll {

    private Scanner inputFile;
    private PrintWriter pw;
    private ObjectList data;
    private Scanner hireFile;
    private Scanner fireFile;
    /**
     * Class constructor
     * @param Input file name
     * @param output file
     */
    public Payroll(Scanner input, PrintWriter pw, Scanner hire, Scanner fire) {
        this.inputFile = input;
        this.pw = pw;
        this.data = new ObjectList();
        this.hireFile = hire;
        this.fireFile = fire;
    }

    /**
     * Method that reads the input file and creates an employee object from each line 
     */
    public void ReadInputFile() 
    {
        while (inputFile.hasNext()) {
            String buf = inputFile.nextLine();

            String[] tokens = buf.split("\\s+");  
            Employee emp = new Employee(tokens);
            ObjectListNode node = new ObjectListNode(emp);
            Updatedata(node);

        }
    }

    /**
     * Method that inserts employee objectListNode into ObjectList data
     */
    public void Updatedata(ObjectListNode emp) 
    {
        data.addLast(emp);
    }

    /**
     * Outputs header
     */
    public void header() 
    {
        System.out.println("First Name\tLast Name\tGender\t\tTenure\t\tRate\t\tSalary");
        pw.println("First Name\tLast Name\tGender\t\tTenure\t\tRate\t\tSalary\n");
    }

    /**
     * Prints data of emplyee to file
     */
    public void printEmployeeData() 
    {
        int count = 0;
        ObjectListNode p = data.getFirstNode();
        while (p != null) {
            ++count;
            // count++;
            Employee emp = (Employee) p.getInfo();
            System.out.println(emp.getFirstName() + "\t\t" + emp.getLastName() + "\t\t" + emp.getGender() + "\t\t" + String.valueOf(emp.getTenure()) + "\t\t" + emp.getRate() + "\t\t" + String.valueOf(emp.getSalary()));
            pw.println(emp.getFirstName() + "\t\t" + emp.getLastName() + "\t\t" + emp.getGender() + "\t\t" + String.valueOf(emp.getTenure()) + "\t\t" + emp.getRate() + "\t\t" + String.valueOf(emp.getSalary()) + "\n");
            p = p.getNext();
        }
        System.out.println("\nNumber of employees in the data is: " + String.valueOf(count));
        pw.println("\r\nNumber of employees in the data is: " + String.valueOf(count) + "\n");
    }

    /**
     * Prints out a sorted data of the employees to file
     */
    public void printSortedData() 
    {
        ObjectListNode p = data.getFirstNode();
        while (p != null) {
            Employee emp = (Employee) p.getInfo();
            System.out.println(emp.getFirstName() + "\t\t" + emp.getLastName() + "\t\t" + emp.getGender() + "\t\t" + String.valueOf(emp.getTenure()) + "\t\t" + emp.getRate() + "\t\t" + String.valueOf(emp.getSalary()));
            pw.println(emp.getFirstName() + "\t\t" + emp.getLastName() + "\t\t" + emp.getGender() + "\t\t" + String.valueOf(emp.getTenure()) + "\t\t" + emp.getRate() + "\t\t" + String.valueOf(emp.getSalary()) + "\n");
            p = p.getNext();
        }

    }

    /**
     * Prints the first and last name of each employee and how many employees there are in data
     * 
     */
    public void printFirstLast() 
    {
        int count = 0;
        System.out.println("First Name\tLast Name");
        pw.println("First Name\tLast Name\n");
        ObjectListNode p = data.getFirstNode();
        while (p != null) {
            ++count;
            //count++;
            Employee emp = (Employee) p.getInfo();
            System.out.println(emp.getFirstName() + "\t\t" + emp.getLastName());
            pw.println(emp.getFirstName() + "\t\t" + emp.getLastName() + "\n");
            p = p.getNext();
        }
        System.out.println("\nNumber of employees in the data is: " + String.valueOf(count));
        pw.println("\r\nNumber of employees in the data is: " + String.valueOf(count) + "\n");

    }

    /**
     * outputs first and last name of all women in payroll
     */
    public void printWomen() 
    {
        ObjectListNode p = data.getFirstNode();
        System.out.println("\nFirst and last name of all the women in the data are: " );
        pw.println("\r\nFirst and last name of all the women in the data are: \n");
        while (p != null) 
        {
            Employee emp = (Employee) p.getInfo();

            if (emp.getGender().equals("F")) {
                System.out.println(emp.getFirstName() + "\t" + emp.getLastName());
                pw.println(emp.getFirstName()  + "\t" + emp.getLastName() + "\n");
            }
            p = p.getNext();
        }
    }

    /**
     * Outputs first and last name and salary of all weekly employees who make more than $35,000 per year and 
     * have been with the company for at least five years
     */
    public void tenure() 
    {
        ObjectListNode p = data.getFirstNode();
        System.out.println("\nFirst and last names and weekly salary of all weekly employees who make more then $35,000 per year and who have been with the company for at least five years: " );
        pw.println("\r\nFirst and last names and weekly salary of all weekly employees who make more then $35,000 per year and who have been with the company for at least five years: \n" );
        while (p != null) {
            Employee emp = (Employee) p.getInfo();
            if (emp.getRate().equals("W") && emp.getTenure() >= 5) {
                double salary = emp.getSalary() * 52;
                if (salary >= 35000.0) {
                    System.out.println(emp.getFirstName() + "\t" + emp.getLastName() + "\t" + String.valueOf(emp.getSalary()));
                    pw.println(emp.getFirstName()  + "\t" + emp.getLastName() + "\t" + String.valueOf(emp.getSalary()) + "\n");
                }
            }
            p = p.getNext();
        }
    }

    /**
     * Give $0.75 raise to all hourly employees and who make less then $10.00 per hour
     * Give $50.00 raise per week to all employees who are paid on a weekly basis and make less then $350.00 per week 
     * Outputs first and lastv names and new salaries of each emplyee who got raise
     */
    public void raise() 
    {
        ObjectListNode p = data.getFirstNode();
        System.out.println("\nFirst and last names and new salary for employees who have received raises: " );
        pw.println("\r\nFirst and last names and new salary for employees who have received raises: \n" );
        while (p != null) {
            Employee emp = (Employee) p.getInfo();
            if (emp.getRate().equals("W") && emp.getSalary() < 350.00) {
                double new_salary = (double) (emp.getSalary() + 50.00);
                emp.setSalary(new_salary);
                System.out.println(emp.getFirstName() + "\t" + emp.getLastName() + "\t" + String.valueOf(emp.getSalary()));
                pw.println(emp.getFirstName()  + "\t" + emp.getLastName() + "\t" + String.valueOf(emp.getSalary()) + "\n");
            }
            else if (emp.getRate().equals("H") && emp.getSalary() < 10.00) {
                double new_salary = (double) (emp.getSalary() + 0.75);
                emp.setSalary(new_salary);
                System.out.println(emp.getFirstName() + "\t" + emp.getLastName() + "\t" + String.valueOf(emp.getSalary()));
                pw.println(emp.getFirstName()  + "\t" + emp.getLastName() + "\t" + String.valueOf(emp.getSalary()) + "\n");
            }
            p = p.getNext();
        }
    }

    /**
     * Sorts the data by last name
     */
    public void sortLastName() 
    {
        ObjectList sortedList = new ObjectList();
        ObjectListNode p = data.getFirstNode();
        while (p != null) {
            Employee emp = (Employee) data.removeFirst();
            sortedList.insert(emp);
            p = data.getFirstNode();
        }

        data = sortedList.copyList();
        System.out.println("\nSorted data by last name is: " );
        pw.println("\r\nSorted data by last name is: \n" );
        header();
        printSortedData();
    }

    /**
     * Inserts new employees in the data from the hire txt
     */
    public void hire() 
    {
        while (hireFile.hasNext()) {
            String buf = hireFile.nextLine();
            String[] tokens = buf.split("\\s+");

            Employee emp = new Employee(tokens);
            data.insert(emp);

        }
        System.out.println("\nNew hired employees inserted into data and updated file: " );
        pw.println("\r\nNew hired employees inserted into data and updated file: \n" );
        printFirstLast();
    }

    /**
     * Removes fired employees and reads from the fire list txt
     */
    public void fire() {
        while (fireFile.hasNext()) 
        {
            String buf = fireFile.nextLine();
            String[] tokens = buf.split("\\s+");
            ObjectListNode p = data.getFirstNode();
            while (p != null) {
                Employee emp = (Employee) p.getInfo(); 

                if (emp.getLastName().equalsIgnoreCase(tokens[1])) 
                {
                    data.remove(emp);
                }
                p = p.getNext();
            }
        }
        System.out.println("\nFired employees deleted and updated file: " );
        pw.println("\r\nFired employees deleted and updated file: \n" );
        printFirstLast();
    }
}