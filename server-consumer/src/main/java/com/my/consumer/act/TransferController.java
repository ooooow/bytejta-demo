package com.my.consumer.act;

import com.my.consumer.client.AccountServiceClient;
import com.my.consumer.dao.IAccountDao;
import com.my.consumer.service.ITransferService;

import org.bytesoft.compensable.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p></p>
 *
 * @author ooooow
 * @Since 2017/12/20
 */
@RestController
@Compensable(interfaceClass = ITransferService.class)
@Transactional
public class TransferController implements ITransferService {

    @Autowired
    @Qualifier("transferServiceTry")
    ITransferService transferService;


    @RequestMapping("/transfer")
    public void transfer(@RequestParam String sId, @RequestParam String tId, @RequestParam double amount) {
        transferService.transfer(sId,tId,amount);
    }


}
