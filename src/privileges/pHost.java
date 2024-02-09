package privileges;

import controllers.ClientController;

import java.util.Scanner;

public class pHost implements pInterface{
    protected final ClientController controller;
    protected final Scanner sc;

    public pHost(ClientController controller, Scanner sc){
        this.controller = controller;
        this.sc = sc;
    }
    public boolean mainMenu(){
        System.out.println("Select the option:");
        System.out.println("1. Make a deposit");
        System.out.println("2. Register");
        System.out.println("0. Back");
        int option = sc.nextInt();
        if(option == 1){
            makeDeposit();
            return true;
        }
        else if(option == 2){
            addClientMenu();
            return true;
        }
        return false;
    }
    public void makeDeposit(){
        System.out.println("Please enter the account login:");
        String login = sc.next();
        System.out.println("Please enter the funds:");
        int cash = sc.nextInt();
        String res = controller.updateClientAccount(login, cash);
        System.out.println(res);
    }
    public void addClientMenu(){
        System.out.println("Please enter name:");
        String name = sc.next();
        System.out.println("Please enter surname:");
        String surname = sc.next();
        System.out.println("Please enter login:");
        String login = sc.next();
        while (controller.loginExists(login)){
            System.out.println("Login already exists!\nPlease enter another login:");
            login = sc.next();
        }
        String password = passwordCreation();
        System.out.println("Please enter your starting balance:");
        int balance = sc.nextInt();
        String res = controller.addClient(name, surname, login, password, balance);
        System.out.println(res);
    }
    public String passwordCreation() {
        System.out.println("Please enter the new password:");
        String password = sc.next();
        System.out.println("Repeat the password:");
        String repeatedPassword = sc.next();
        while (!password.equals(repeatedPassword)) {
            System.out.println("Passwords does not match! Please enter the password again:");
            password = sc.next();
            System.out.println("Repeat the password:");
            repeatedPassword = sc.next();
        }
        return password;
    }
}
