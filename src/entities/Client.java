package entities;

public class Client {
    private int id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private int balance;

    public Client(String name, String surname, String login, String password, int balance){
        setLogin(login);
        setPassword(password);
        setName(name);
        setSurname(surname);
        setBalance(balance);
    }
    public Client(int id, String name, String surname, String login, String password, int balance){
        this(name, surname, login, password, balance);
        setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }
}
