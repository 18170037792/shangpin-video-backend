package cn.shangpin.utils;

/**
 * Created by qujie on 2018/11/21
 * 随机数获取
 * */
public class GetRandom {

    /**
     * 返回五位数字符串
     * @return String
     */
    public static String getRandom(){
        String random = "";
        for (int i = 0; i < 5 ; i++){
            int num = (int) (Math.random()*10);
            random += num;
        }
        return random;
    }
    /**
     * 返回指定位数字符串
     * @return String
     */
    public static String getRandom(int num){
        String random = "";
        for (int i = 0; i < num ; i++){
            int count = (int) (Math.random()*10);
            random += count;
        }
        return random;
    }
}
