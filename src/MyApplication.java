import controllers.Manager;


import java.util.Scanner;

public class MyApplication {
    private final Manager manager;
    private final Scanner scanner;

    public MyApplication(Manager manager) {
        this.manager = manager;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while(true) {
            System.out.println("Choose one option:\n 1) Search for any employee by name\n 2) Search emlpoyee by id\n 3) Add employee\n 4) Remove employee\n 0) Exit\n");
            int choice = scanner.nextInt();

            if (choice==1) {
                searchCompanyByNameMenu();
            }
            else if (choice==2) {
                getCompanyByIdMenu();
            }
            else if (choice==3) {
                addCompanyMenu();
            }
            else if (choice==4) {
                removeCompanyByIdMenu();
            }
            else {
                break;
            }

            System.out.println("*********************");
        }
    }

    public void searchCompanyByNameMenu() {
        System.out.println("Write the name of employee!");
        String name = scanner.next();
        String result = manager.searchCompanyByName(name);
        System.out.println(result);
    }

    public void getCompanyByIdMenu() {
        System.out.println("Write the id of employee!");
        int id = scanner.nextInt();
        String result = manager.getCompanyById(id);
        System.out.println(result);
    }

    public void addCompanyMenu() {
        System.out.println("Write the surname of employee!");
        String surname = scanner.next();
        System.out.println("Write the name of employee!");
        String name = scanner.next();
        System.out.println("Write employee's salary");
        double price = scanner.nextDouble();
        System.out.println("Write employee's specialization ");
        String specialization = scanner.next();
        System.out.println("Write employee's email ");
        String email = scanner.next();

        String result = manager.addEmployee(name,price, specialization,surname,email);

        System.out.println(result);
    }

    public void removeCompanyByIdMenu() {
        System.out.println("Write employee's id!");
        int id = scanner.nextInt();

        String result = manager.removeCompanyById(id);

        System.out.println(result);
    }
}
