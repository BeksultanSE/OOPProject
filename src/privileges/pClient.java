package privileges;

import controllers.ClientController;

import java.util.Scanner;

public class pClient extends pHost{
    private String login;
    public pClient(ClientController controller, Scanner sc){
        super(controller, sc);
    }
    public pClient(ClientController controller, Scanner sc, String login){
        this(controller, sc);
        this.login = login;
    }
    @Override
    public boolean mainMenu() {
        if(confirmation()) {
            System.out.println("Select the option:");
            System.out.println("1. Make a deposit");
            System.out.println("2. Withdraw funds");
            System.out.println("3. Change the password");
            System.out.println("4. Close my account");
            System.out.println("0. Back");
            int option = sc.nextInt();
            if (option == 1) {
                makeDeposit();
                return true;
            } else if (option == 2) {
                withdraw();
                return true;
            } else if (option == 3) {
                changePassword();
                return true;
            } else if (option == 4) {
                closeAccount();
                return true;
            }
        }
        return false;
    }
    protected boolean confirmation(){
        System.out.println("Please enter the password:");
        String password = sc.next();
        int counter = 3;
        while(!controller.isPasswordCorrect(login, password) && counter > 0) {
            System.out.println("Incorrect Password!\nPlease enter the correct password:");
            password = sc.next();
            counter--;
        }
        if(!controller.isPasswordCorrect(login, password)){
            System.out.println("Invalid confirmation!");
            return false;
        }
        return true;
    }
    public void withdraw(){
        if(confirmation()) {
            String res = null;
            int cash = 0;
            do {
                System.out.println("Please enter the sum:");
                cash = sc.nextInt();
                res = controller.updateClientAccount(login, -cash);
                System.out.println(res);
            } while (res.charAt(0) == 'F');
            System.out.println("Take your cash [" + cash + "]");
        }
    }
    public void changePassword(){
        System.out.println("Please enter the password:");
        String password = sc.next();
        String newPassword = passwordCreation();
        String res = controller.changePassword(login, password, newPassword);
        System.out.println(res);
        while(res.charAt(0) == 'I') {
            System.out.println("Please enter the old password:");
            password = sc.next();
            newPassword = passwordCreation();
            res = controller.changePassword(login, password, newPassword);
            System.out.println(res);
        }
    }
    public void closeAccount(){
        String password = null;
        String res = null;
        do {
            System.out.println("Please enter the password:");
            password = sc.next();
            res = controller.closeAccount(login, password);
            System.out.println(res);
        }while(res.charAt(0) == 'I');
    }
}
