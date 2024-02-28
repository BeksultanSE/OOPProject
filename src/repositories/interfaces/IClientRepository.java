package repositories.interfaces;

import entities.Client;
import entities.Transaction;

import java.util.List;
public interface IClientRepository {
    boolean createClient(Client client);
    Client getClientByID(int id);
    Client getClientByLogin(String login);
    List<Client> getAllClients();
    List<Transaction> getAllTransactions(int clientId);
    boolean updateClientAccount(String login, int newBalance, Transaction transactionHistory);
    boolean changePassword(String login, String newPassword);
    boolean deleteClient(String login);

}
