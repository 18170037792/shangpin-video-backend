package cn.shangpin.exception;

/**
 * Created by qujie on 2018/11/8
 * 数据未找到异常
 */
public class DataNotFoundException extends ServiceException {

    public DataNotFoundException(String msg){
        super(msg);
    }
}
