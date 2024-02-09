package controllers;

import entities.Client;
import repositories.interfaces.IClientRepository;

import java.util.List;
import java.util.Objects;

public class ClientController {
    private final IClientRepository repo;
    public ClientController(IClientRepository repo){
        this.repo = repo;
    }
    public String addClient(String name, String surname, String login, String password, int balance){
        Client client = new Client(name, surname, login, password, balance);
        boolean created = repo.createClient(client);
        return (created ? "Client added successfully!" : "Client addition was failed!");
    }
    public String getClientByID(int id){
        Client client = repo.getClientByID(id);
        return (client == null ? "Client was not found!" : client.toString());
    }
    public boolean loginExists(String login){
        return (!getClientByLogin(login).equals("Client was not found!"));
    }
    public String getClientByLogin(String login){
        Client client = repo.getClientByLogin(login);
        return (client == null ? "Client was not found!" : client.toString());
    }
    public String getAllClients(){
        List<Client> clients = repo.getAllClients();
        StringBuilder response = new StringBuilder();
        for (Client client : clients){
            response.append(client.toString());
            response.append("\n");
        }
        return response.toString();
    }
    public String updateClientAccount(String login, int change){
        Client client = repo.getClientByLogin(login);
        int changedBalance = client.getBalance() + change;
        if(changedBalance >= 0){
            boolean updated = repo.updateClientAccount(login, changedBalance);
            return (updated ? "Transaction completed successfully!" : "Transaction failed!");
        }
        else
            return "Failed!\nInsufficient funds!";
    }
    public boolean isPasswordCorrect(String login, String password){
        Client client = repo.getClientByLogin(login);
        return client.getPassword().equals(password);
    }
    public String changePassword(String login, String password, String newPassword){
        if(isPasswordCorrect(login, password)) {
            boolean changed = repo.changePassword(login, newPassword);
            return (changed ? "Password changed successfully!" : "Password change failed!");
        }
        return "Invalid confirmation!";
    }
    public String closeAccount(String login, String password){
        if(isPasswordCorrect(login, password)){
            boolean deleted = repo.deleteClient(login);
            return (deleted ? "The account was deleted successfully!" : "The account deletion was failed!");
        }
        return "Invalid confirmation!";
    }
}
