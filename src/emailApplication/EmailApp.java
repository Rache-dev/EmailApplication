package emailApplication;


import java.util.Scanner;

//where we create the objects
class Email {
    private String firstName;
    private String lastName;
    private String department;
    private  String email;
    private  String companySuffix = "aeycompany.com";
    private String password;
    private int mailboxCapacity =500;
    private String alternateEmail;
    //constructor to receive firstname and lastname
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

        //call a method asking for the department - and will return the department
        this.department = setDepartment();

        //generate email
        email = firstName.toLowerCase()+"."+lastName.toLowerCase() +"@"+department.toLowerCase()+"." + companySuffix;

        //call a method that returns a random password
        this.password = randomPassword(6);
    }
    //Ask for the department
    private  String setDepartment(){
        System.out.println("DEPARTMENTCODES\n1 for Sales\n2 for Development\n3 for accounting\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();

        if (depChoice == 1) {
            return "Sales";
        } else if(depChoice == 2){
            return "development";
        }else if(depChoice == 3){
            return "accounting";
        } else {
            return " ";
        }
    }
    //generate a random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%abcdefghijklmnopqrstuvwxyz";
        char[] password = new char[length];

        for(int i = 0; i<length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] =passwordSet.charAt(rand);
        }
        return new String(password);
    }
    //set mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }
    //set an alternative email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }
    //change password
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public void showInfo(){
        System.out.println("Name: "+firstName+" "+lastName);
        System.out.println("Department: "+department);
        System.out.println("Company email: "+email);
        System.out.println("Password: "+password);
        System.out.println("Mailbox Capacity: "+mailboxCapacity+"mb");
    }
}

public class EmailApp {

    public static void main(String[] args){
        Email em1 = new Email("John", "Doe");
        em1.showInfo();
    }
}