package com.my.consumer.service.impl;

import com.my.consumer.client.AccountServiceClient;
import com.my.consumer.dao.IAccountDao;
import com.my.consumer.service.ITransferService;

import org.bytesoft.compensable.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p></p>
 *
 * @author ooooow
 * @Since 2017/12/20
 */
@Service("transferServiceTry")
@Transactional
@Compensable(interfaceClass = ITransferService.class,
        confirmableKey = "transferServiceConfirm",
        cancellableKey = "transferServiceCancel")
public class TransferServiceTry implements ITransferService {

    @Autowired
    IAccountDao accountDao;

    @Autowired
    AccountServiceClient accountServiceClient;

    @Override
    public void transfer(String sId, String tId, double amount) {
        accountDao.decreaseAmount(sId, amount);
        accountServiceClient.increaseAmount(tId,amount/2);
        accountServiceClient.increaseAmount(tId,amount/2);
    }
}
