package com.my.consumer.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p></p>
 *
 * @author ooooow
 * @Since 2017/12/20
 */
@FeignClient(value = "server-provider")
public interface AccountServiceClient {

    @RequestMapping(value = "/increase", method = RequestMethod.POST)
    void increaseAmount(@RequestParam("accountId") String accountId, @RequestParam("amount") double amount);

    @RequestMapping(value = "/decrease", method = RequestMethod.POST)
    void decreaseAmount(@RequestParam("accountId") String accountId, @RequestParam("amount") double amount);

}
