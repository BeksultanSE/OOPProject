package entities;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Transaction {
    private int id;
    private int clientId;
    private String transactionType;
    private int amount;
    private Timestamp transactionDate = Timestamp.valueOf(LocalDateTime.now());
    public Transaction(int clientId, String transactionType, int amount){
        this.clientId = clientId;
        this.transactionType = transactionType;
        this.amount = amount;
    }
    public Transaction(int id, int clientId, String transactionType, int amount){
        this.id = id;
        this.clientId = clientId;
        this.transactionType = transactionType;
        this.amount = amount;
    }
    public int getId(){
        return id;
    }
    public int getClientId() {
        return clientId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public int getAmount() {
        return amount;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }
}
