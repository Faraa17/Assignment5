import controllers.Manager;
import data.DBManager;
import data.interfaces.IDBManager;
import storages.Companystorage;
import storages.interfaces.CompanyStorage;


public class Main {

    public static void main(String[] args) {
        IDBManager dbManager = new DBManager();
        Companystorage companyStorage = new Companystorage(dbManager);
        Manager manager = new Manager(companyStorage);
        MyApplication myApplication = new MyApplication(manager);
        myApplication.start();
    }
}