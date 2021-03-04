package storages.interfaces;

import entities.Company;

import java.util.ArrayList;

public interface CompanyStorage {
    public ArrayList<Company> searchCompanyByName(String name);
    public Company getCompanyById(int id);
    public boolean addCompany(Company company);
    public boolean removeCompanyById(int id);
}
