package com.my.consumer.config;

/**
 * <p></p>
 *
 * @author ooooow
 * @Since 2017/12/20
 */
public class Log {

    private static final Log instance = new Log();
    private Log(){}
    static final String prefix = "====>  ";

    public static Log me(){
        return instance;
    }

    public void debug(Object o,Object ...args){
        String str = o.toString().replace("{}","%s");
        System.out.println(prefix+String.format(str,args));
    }

    public void error(Object o,Object ...args){
        String str = o.toString().replace("{}","%s");
        System.err.println(prefix+String.format(str,args));
    }

    public static void main(String[] args) {

        Log log = new Log();
        log.debug("aaa:{}","11");
    }
}
