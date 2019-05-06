package main.java.com.traderbobsemporium.dao;

import main.java.com.traderbobsemporium.model.Account;
import main.java.com.traderbobsemporium.model.Item;
import main.java.com.traderbobsemporium.util.DatabaseUtil;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO implements AbstractDAO<Account> {

    @Override
    public Account get(long id) throws SQLException {
        ResultSet resultSet = DatabaseUtil.REQUEST_RESULT_SET("account WHERE id =" + id);
        Account account = new Account(resultSet);
        resultSet.close();
        return account;
    }

    @Override
    public List<Account> getAll() throws SQLException {
        List<Account> accounts = new ArrayList<>();
        ResultSet resultSet = DatabaseUtil.REQUEST_RESULT_SET("item");
        while (resultSet.next())
            accounts.add(new Account(resultSet));
        resultSet.close();
        return accounts;
    }

    @Override
    public void update(Account account, String[] params) throws SQLException {
        account.setName(params[0]);
        account.setPassword(params[1]);
        DatabaseUtil.UPDATE("UPDATE item SET username = '" + account.getName() + "'," +
                "password = '" + account.getPassword() + "' + WHERE id =" + account.getId() + ";");
    }

    @Override
    public void add(Account account) throws SQLException {
        DatabaseUtil.UPDATE("INSERT INTO item VALUES('" + account.getId() + "','" + account.getName() + "','" +
                account.getPassword() + "')");
    }

    @Override
    public void delete(long id) throws SQLException {
        DatabaseUtil.UPDATE("DELETE FROM account WHERE id = '" + id + "'");
    }
}