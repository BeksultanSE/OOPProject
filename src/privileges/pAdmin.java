package privileges;

import controllers.ClientController;

import java.util.Scanner;

public class pAdmin extends pClient{

    public pAdmin(ClientController controller, Scanner sc){
        super(controller, sc);
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
