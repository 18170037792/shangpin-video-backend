package cn.shangpin.exception;

/**
 * Created by qujie on 2018/11/8
 * 所有的service验证异常
 */
public class ServiceException extends  Exception{

    public ServiceException(String msg){
        super(msg);
    }
}
