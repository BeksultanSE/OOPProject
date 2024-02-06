package repositories.interfaces;

import entities.Client;
import java.util.List;
public interface IClientRepository {
    boolean createClient(Client client);
    Client getClientByID(int id);
    Client getClientByLogin(String login);
    List<Client> getAllClients();
}
