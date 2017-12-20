package com.my.provider.service.impl;

import com.my.provider.config.Log;
import com.my.provider.config.SleepUtils;
import com.my.provider.service.IAccountService;

import org.bytesoft.compensable.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.atomic.AtomicLong;

/**
 * <p></p>
 *
 * @author ooooow
 * @Since 2017/12/20
 */

@Service("accountServiceImpl")
@Transactional
public class AccountServiceImpl implements IAccountService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    static final AtomicLong count = new AtomicLong(1);

    @Override
    public void increaseAmount(String accountId, double amount) {
        Log.me().debug(this.getClass().getName() + "increaseAmount:{},{}", accountId, amount);
        //SleepUtils.sleep(10);
        int value = this.jdbcTemplate.update("update tb_account_two set frozen = frozen + ? where acct_id = ?", amount, accountId);
        long t = count.getAndIncrement();
        if(t%2==0){
            int i = 1/0;
        }
        if (value != 1) {
            throw new IllegalStateException("ERROR!");
        }
        System.out.printf("exec increase: acct= %s, amount= %7.2f%n", accountId, amount);
    }

    @Override
    public void decreaseAmount(String accountId, double amount) {
        Log.me().debug(this.getClass().getName() + "decreaseAmount:{},{}", accountId,amount);
        //SleepUtils.sleep(10);
        int value = this.jdbcTemplate.update(
                "update tb_account_two set amount = amount - ?, frozen = frozen + ? where acct_id = ?", amount, amount, accountId);
        if (value != 1) {
            throw new IllegalStateException("ERROR!");
        }
        System.out.printf("exec decrease: acct= %s, amount= %7.2f%n", accountId, amount);
    }
}
