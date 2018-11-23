package cn.shangpin.utils;

/**
 * Created by qujie on 2018/11/22
 * */
public class ValidateUtil {


    public static final boolean isNull(Object obj){
        if(obj == null){
            return true;
        }
        if(obj instanceof String){
            String str = String.valueOf(obj);
            if(str == null || str.trim().length() == 0){
                return true;
            }else{
                return false;
            }
        }else if(obj instanceof Integer){
            Integer i = (Integer)obj;
            if(i < 0){
                return true;
            }else{
                return false;
            }
        }else if(obj instanceof Long){
            Long i = (Long)obj;
            if(i < 0){
                return true;
            }else{
                return false;
            }
        }
        return true;
    }

    public static final boolean maxLength(String str,Integer len){
        if(str.length() > len){
            return true;
        }else{
            return false;
        }
    }

    public static final boolean minLength(String str,Integer len){
        if(str.length() < len){
            return true;
        }else{
            return false;
        }
    }
}
