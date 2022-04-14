package emailapp;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private String alternateEmail;
    private String companySuffix = "aeycompany.com";
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 12;

    // Constructor to recieve first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        // System.out.println("Email created: " + this.firstName + " " + this.lastName);
        this.department = setDepartment();
        // System.out.println("Department: " + this.department);
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
        // System.out.println("Your email is: " + email);
    }

    private String setDepartment() {
        System.out.println(
                "New Worker: " + firstName
                        + "\nDepartment Codes:\n1 for Sales\n2 for Developement\n3 for Accounting\n0 for none\n Enter department code: ");
        Scanner input = new Scanner(System.in);
        int depChoice = input.nextInt();
        if (depChoice == 1) {
            return "Sales";
        } else if (depChoice == 2) {
            return "Dev";
        } else if (depChoice == 3) {
            return "Acct";
        } else {
            return "";
        }
    }

    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVUXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    public void setMailBoxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public int getMailBoxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo() {
        return "Display Name: " + firstName + " " + lastName + "\nCompany Email: " + email + "\nMailbox Capacity: "
                + mailboxCapacity + "mb";
    }

}
