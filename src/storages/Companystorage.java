package storages;
import data.interfaces.IDBManager;
import entities.Company;
import storages.interfaces.CompanyStorage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Companystorage implements CompanyStorage {
    private final IDBManager dbManager;

    public Companystorage(IDBManager dbManager) {
        this.dbManager = dbManager;
    }

    @Override
    public ArrayList<Company> searchCompanyByName(String name) {
        Connection connection = null;

        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employees WHERE name LIKE '%" + name + "%'");

            ResultSet resultSet = preparedStatement.executeQuery();

            ArrayList<Company> companies = new ArrayList<>();

            while (resultSet.next()) {
                Company company = new Company(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("salary"),
                        resultSet.getString("specialization"),
                        resultSet.getString("surname"),
                        resultSet.getString("email"));

                companies.add(company);
            }

            return companies;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Company getCompanyById(int id) {
        Connection connection = null;

        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM employees WHERE id=?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            Company company = new Company();

            if (resultSet.next()) {
                company.setId(resultSet.getInt("id"));
                company.setName(resultSet.getString("name"));
                company.setSalary(resultSet.getDouble("salary"));
                company.setSpecialization(resultSet.getString("specialization"));
                company.setEmail(resultSet.getString("email"));
                company.setSurname(resultSet.getString("surname"));
            }

            return company;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean addCompany(Company company) {
        Connection connection = null;

        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employees (surname, name, salary, specialization, email) VALUES(?,?,?,?,?)");
            preparedStatement.setString(1, company.getSurname());
            preparedStatement.setString(2, company.getName());
            preparedStatement.setDouble(3, company.getSalary());
            preparedStatement.setString(4, company.getSpecialization());
            preparedStatement.setString(5, company.getEmail());

            preparedStatement.execute();

            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean removeCompanyById(int id) {
        Connection connection = null;

        try {
            connection = dbManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM employees WHERE id=?");

            preparedStatement.setInt(1, id);

            preparedStatement.execute();

            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
