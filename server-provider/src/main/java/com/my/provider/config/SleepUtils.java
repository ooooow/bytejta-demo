package com.my.provider.config;

import java.util.concurrent.TimeUnit;

/**
 * <p></p>
 *
 * @author ooooow
 * @Since 2017/12/20
 */
public class SleepUtils {

    public static void sleep(long time){
        try{
            Log.me().debug("任务处理中...");
            TimeUnit.MILLISECONDS.sleep(time*1000);
            Log.me().debug("任务处理完成...");
        }catch (Exception e){}
    }
}
