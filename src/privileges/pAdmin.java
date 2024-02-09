package privileges;

import controllers.ClientController;

import java.util.Scanner;

public class pAdmin extends pClient{

    public pAdmin(ClientController controller, Scanner sc){
        super(controller, sc);
    }

    @Override
    public boolean mainMenu() {
        System.out.println("Select the option:");
        System.out.println("1. Get all clients");
        System.out.println("2. Get a client by ID");
        System.out.println("3. Get a client by Login");
        System.out.println("0. Back");
        int option = sc.nextInt();
        if (option == 1) {
            getAllClientsMenu();
            return true;
        } else if (option == 2) {
            getClientByIdMenu();
            return true;
        } else if (option == 3) {
            getClientByLogin();
            return true;
        }
        return false;
    }

    public void getAllClientsMenu(){
        String res = controller.getAllClients();
        System.out.println(res);
    }
    public void getClientByLogin(){
        System.out.print("Enter login: ");
        String login = sc.next();
        String res = controller.getClientByLogin(login);
        System.out.println(res);
    }
    public void getClientByIdMenu(){
        System.out.print("Enter id: ");
        int id = sc.nextInt();
        String res = controller.getClientByID(id);
        System.out.println(res);
    }


}
