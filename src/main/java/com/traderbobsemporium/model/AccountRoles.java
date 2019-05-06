package main.java.com.traderbobsemporium.model;

/**
 * @Author Aidan Stewart
 * @Year 2019
 * Copyright (c)
 * All rights reserved.
 */
public enum AccountRoles {
    EMPLOYEE, RETAILER, UNCONFIRMED;

    public static AccountRoles intToAccountRole(int accountTypeInt){
        switch (accountTypeInt){
            case 0:
                return EMPLOYEE;
            case 1:
                return RETAILER;
            case 2:
                return UNCONFIRMED;
        }
        return UNCONFIRMED;
    }

    public static int accountRoleToInt(AccountRoles accountType){
        switch (accountType) {
            case EMPLOYEE:
                return 0;
            case RETAILER:
                return 1;
            case UNCONFIRMED:
                return 2;
        }
        return 3;
    }
}
