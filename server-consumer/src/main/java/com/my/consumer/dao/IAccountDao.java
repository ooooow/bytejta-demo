package com.my.consumer.dao;

/**
 * <p></p>
 *
 * @author ooooow
 * @Since 2017/12/19
 */
public interface IAccountDao {

    int decreaseAmount(String accountId, double amount);

    int confirmDecrease(String accountId,double amount);

    int cancelDecrease( String accountId,double amount);

}
