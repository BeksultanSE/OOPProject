package controllers;

import entities.Client;
import repositories.interfaces.IClientRepository;

import java.util.List;

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
        Client client = repo.getClientByLogin(login);
        return (client != null);
    }
    public String getAllClients(){
        List<Client> clients = repo.getAllClients();

        StringBuilder response = new StringBuilder();
        for (Client client : clients){
            response.append(client.toString());
            response.append('\n');
        }
        return response.toString();
    }
}
