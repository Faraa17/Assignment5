package controllers;
import entities.Company;
import storages.interfaces.CompanyStorage;



public class Manager {
    private final CompanyStorage companyStorage;

    public Manager(CompanyStorage companyStorage) {
        this.companyStorage = companyStorage;
    }

    public String searchCompanyByName(String name) {
        String result = companyStorage.searchCompanyByName(name).toString();

        return result;
    }

    public String getCompanyById(int id) {
        String result = companyStorage.getCompanyById(id).toString();

        return result;
    }

    public String addEmployee(String name, double price, String specialization, String surname, String email ) {

        boolean added = companyStorage.addCompany(new Company(name, price,specialization,surname,email));

        if (added) {
            return "Employee was added!";
        }

        return "Employee was not added!";
    }

    public String removeCompanyById(int id) {
        boolean removed = companyStorage.removeCompanyById(id);

        if (removed) {
            return "Employee was removed!";
        }

        return "Employee was not removed!";
    }
}
