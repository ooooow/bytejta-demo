package com.my.provider.act;

import com.my.provider.service.IAccountService;

import org.bytesoft.compensable.Compensable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p></p>
 *
 * @author ooooow
 * @Since 2017/12/19
 */

@RestController
@Compensable(interfaceClass = IAccountService.class,
            confirmableKey = "accountServiceConfirm",
            cancellableKey = "accountServiceCancel")
@Transactional
public class AccountController implements IAccountService{
    @Autowired
    @Qualifier("accountServiceImpl")
    IAccountService accountService;

    @ResponseBody
    @RequestMapping(value = "/increase", method = RequestMethod.POST)
    public void increaseAmount(@RequestParam("accountId") String accountId, @RequestParam("amount") double amount) {
        accountService.increaseAmount(accountId,amount);
    }

    @ResponseBody
    @RequestMapping(value = "/decrease", method = RequestMethod.POST)
    public void decreaseAmount(@RequestParam("accountId") String accountId, @RequestParam("amount") double amount) {
        accountService.decreaseAmount(accountId,amount);
    }

}
