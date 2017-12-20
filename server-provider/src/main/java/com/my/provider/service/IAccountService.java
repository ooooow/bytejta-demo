package com.my.provider.service;

/**
 * <p></p>
 *
 * @author ooooow
 * @Since 2017/12/19
 */
public interface IAccountService {

    void increaseAmount(String accountId, double amount);

    void decreaseAmount(String accountId, double amount);
}
