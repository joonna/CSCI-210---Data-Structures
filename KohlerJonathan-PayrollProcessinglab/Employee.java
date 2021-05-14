/**
 * This class is an implentation of an Employee which implements Comparable.
 * 
 * @author Jonathan Kohler
 * @version 7/27/2019
 */
public class Employee implements Comparable {
    private String firstName;
    private String lastName;
    private String gender;
    private int tenure;
    private String rate;
    private double salary;

    /**
     * Class constructor
     * @param tokens
     */
    public Employee(String[] tokens) {
        this.firstName = tokens[0];
        this.lastName = tokens[1];
        this.gender = tokens[2];
        this.tenure = Integer.parseInt(tokens[3]);
        this.rate = tokens[4];
        this.salary = Double.parseDouble(tokens[5]);
    }

    /**
     * Returns first name of the worker
     * @return first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Returns the last name of the worker
     * @return last name
     */
    public String getLastName(){
        return this.lastName;
    }

    /**
     * Returns the gender of the worker
     * @return gender
     */
    public String getGender() {
        return this.gender;
    }

    /**
     * Returns the tenure
     * @return
     */
    public int getTenure() {
        return this.tenure;
    }

    /**
     * Returns the rate
     * @return
     */
    public String getRate() {
        return this.rate;
    }

    /**
     * Returns the salary
     * @return
     */
    public double getSalary(){
        return this.salary;
    }

    /**
     * Sets a new salary for the worker
     * @return new salary
     */
    public void setSalary(double new_salary){
        this.salary = new_salary;
    }

    /**
     * Compares the last name of two Employee objects
     */
    public int compareTo (Object o) {
        Employee e = (Employee) o;
        return lastName.compareTo(e.getLastName());
    }
}