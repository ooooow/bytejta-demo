package com.my.consumer.service.impl;

import com.my.consumer.dao.IAccountDao;
import com.my.consumer.service.ITransferService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p></p>
 *
 * @author ooooow
 * @Since 2017/12/20
 */
@Service("transferServiceConfirm")
@Transactional
public class TransferServiceConfirm implements ITransferService {
    @Autowired
    IAccountDao accountDao;
    @Override
    public void transfer(String sId, String tId, double amount) {
        accountDao.confirmDecrease(sId, amount);
    }
}
