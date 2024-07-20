import java.util.Locale;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String employeeID;
    private String assembledEmail;
    private String password;
    private String companySuffix = "bestcompany.com";
    private String department;
    private int mailboxCapacity = 500;
    private String alternateEmail;

    // Constructor to retrieve data and assemble email
    // firstname.lastname@deparment.company.com
    public Email(String firstName, String lastName, String employeeID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeID = employeeID;
        System.out.println("CREATING EMAIL FOR EMPLOYEE: " + this.firstName + " " + this.lastName
        + " | Employee ID: " + this.employeeID);

        // Call a Method that asks for department, then return the department
        // private class variable department is being set to user input via method below.

        this.department = setDepartment();
        System.out.println("Deparment: " + this.department);

        //Assemble Email
        this.assembledEmail =
                (this.firstName.toLowerCase() + "." + this.lastName.toLowerCase()
                + "@" + this.department + "." + this.companySuffix);
        System.out.println("EMAIL = " + this.assembledEmail);
        /* Call a method that generates a random password for associated email.
            I selected 8, but it can be any number. */

        this.password = generatePassword(8);
        System.out.println("Random Password Generated: " + this.password);
        System.out.println("**** Employee must login with generated password and set up a new password" +
                " with 8 characters.");
        System.out.println("It must include at least one uppercase letter, one lower case letter, " +
        "one number, " + "and a symbol. ****");;
    }



    // Retrieve Department as input

    private String setDepartment() {
        System.out.println("Please select the employee's department code:" +
                "\n DEPARTMENT CODES" +
                "\n1. Sales " +
                "\n2. Technology" +
                "\n3. Accounting" +
                "\n4. Administration " +
                "\n5. Other/Specialist");
        Scanner scannerInt = new Scanner(System.in);
        int Dept_Selection = scannerInt.nextInt();
        if (Dept_Selection == 1) {
            return "sales";
        }
        else if (Dept_Selection == 2) {
            return "tech";
        }
        else if (Dept_Selection == 3) {
            return "acct";
        }
        else if (Dept_Selection == 4) {
            return "admin";
        }
        else if (Dept_Selection == 5) {
            return "spec";
        }
        else {
            return null;
        }
    }

        /* Note:
                This method is for initial password generation only and the employee
                should be encouraged to establish a new password that
                meets your organization's requirements. */

    private String generatePassword(int length) {
        // create a String to pull letters and numbers from
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*abcedefghijklmnopqrstuvwxyz";
        // create an array of characters to assemble new password string
        char[] password = new char[length];
        // pull from String passwordSet using random character puller we assembled via For Loop
        for (int i = 0; i < length; i++) {
            // generate a random number
            int randomNumber = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(randomNumber);
        }
        return new String(password);

    }

    // Establish Setters for Optional Housekeeping items

    // Set mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    // Set alternate Email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    // Change Password
    public void changePassword(String newpass) {
        this.password = newpass;
    }


    // Establish Getters for Optional Housekeeping items

    // returns our current Mailbox Capacity
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    // returns our established Alternate Email
    public String getAlternateEmail() {
        return alternateEmail;
    }

    // returns our current Password
    public String getPassword() {
        return password;
    }

    public String allInfo() {
        return "NAME: " + firstName + " " + lastName + "\n"
                + "EMAIL: " + assembledEmail + "\n"
                + "MAILBOX CAPACITY: " + mailboxCapacity;
    }
}
