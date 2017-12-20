package com.my.consumer.dao;

import com.my.consumer.config.Log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * <p></p>
 *
 * @author ooooow
 * @Since 2017/12/20
 */
@Service("accountDaoImpl")
public class AccountDaoImpl implements IAccountDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int decreaseAmount(String accountId, double amount) {
        Log.me().debug(this.getClass().getName() + ".decreaseAmount:{},{}", accountId, amount);
        //SleepUtils.sleep(10);
        int value = this.jdbcTemplate.update("update tb_account_one set frozen = frozen + ? where acct_id = ?", amount, accountId);
        if (value != 1) {
            throw new IllegalStateException("ERROR!");
        }
        System.out.printf("exec increase: acct= %s, amount= %7.2f%n", accountId, amount);
        return value;
    }


    @Override
    public int confirmDecrease(String accountId, double amount) {
        Log.me().debug(this.getClass().getName() + ".confirmDecrease:{},{}", accountId, amount);
        String sql = "update tb_account_one set amount = amount - ?, frozen = frozen - ? where acct_id = ?";
        int value = this.jdbcTemplate.update(sql,amount,amount,accountId);
        if (value != 1) {
            throw new IllegalStateException("ERROR!");
        }
        return value;
    }

    @Override
    public int cancelDecrease(String accountId, double amount) {
        Log.me().debug(this.getClass().getName() + ".cancelDecrease:{},{}", accountId, amount);
        String sql = "update tb_account_one set frozen = frozen - ? where acct_id = ?";
        int value = this.jdbcTemplate.update(sql,amount,amount,accountId);
        if (value != 1) {
            throw new IllegalStateException("ERROR!");
        }
        return value;
    }
}
