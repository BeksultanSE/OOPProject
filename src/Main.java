import controllers.ClientController;
import data.PostgresDB;
import data.interfaces.IDB;
import repositories.ClientRepository;
import repositories.interfaces.IClientRepository;

public class Main {
    public static void main(String[] args){
        IDB db = new PostgresDB();
        IClientRepository repo = new ClientRepository(db);
        ClientController controller = new ClientController(repo);
        MyApplication app = new MyApplication(controller);
        app.start();
    }
}
