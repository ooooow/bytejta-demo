package com.my.provider.service.impl;

import com.my.provider.config.Log;
import com.my.provider.config.SleepUtils;
import com.my.provider.service.IAccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p></p>
 *
 * @author ooooow
 * @Since 2017/12/19
 */
@Service("accountServiceCancel")
@Transactional
public class AccountServiceCancel implements IAccountService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void increaseAmount(String acctId, double amount) {
        Log.me().debug(this.getClass().getName() + "increaseAmount:{},{}", acctId, amount);
        //SleepUtils.sleep(10);
        int value = this.jdbcTemplate.update("update tb_account_two set frozen = frozen - ? where acct_id = ?", amount, acctId);
        if (value != 1) {
            throw new IllegalStateException("ERROR!");
        }
        System.out.printf("undo increase: acct= %s, amount= %7.2f%n", acctId, amount);
    }

    public void decreaseAmount(String acctId, double amount) {
        Log.me().debug(this.getClass().getName() + "decreaseAmount:{},{}", acctId, amount);
        //SleepUtils.sleep(10);
        int value = this.jdbcTemplate.update(
                "update tb_account_two set amount = amount + ?, frozen = frozen - ? where acct_id = ?", amount, amount, acctId);
        if (value != 1) {
            throw new IllegalStateException("ERROR!");
        }
        System.out.printf("undo decrease: acct= %s, amount= %7.2f%n", acctId, amount);
    }
}
