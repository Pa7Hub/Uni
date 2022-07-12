package Q4.TM.w3;

import Q4.TM.w1.DBConnectionManager;

import java.sql.Connection;

/**
 * Will transfer 100€ from Account A to account Z
 * TODO should be dynamic and receive a connection and data to act upon
 */
public class GenericBankTransfer implements ITransaction {
    private String _account;

    public GenericBankTransfer(String account, Integer amount, Operator operator) {
        this._account = "'" + account + "'";
    }

    @Override
    public void run(DBConnectionManager manager) {

    }

}
