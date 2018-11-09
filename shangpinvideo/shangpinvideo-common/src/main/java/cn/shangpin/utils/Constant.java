package cn.shangpin.utils;


/**
 * Created by tiziano on 2018/3/2
 * 常量类
 */
public class Constant {

    /**
     * 系统异常提示
     */
    public final static String SYSTEM_ERROR = "System error";

    public final static Integer SUCCESS_CODE=200;

    public final static Integer FAILED_CODE=400;

    public final static String SAVE_SUCCESS = "保存成功";

    public final static String UPDATE_SUCCESS = "修改成功";

    public final static String CANCEL_SUCCESS = "取消成功";

    public final static String LOGIN_SUCCESS = "登录成功";

    public final static String  UNLOGIN_SUCCESS = "退出成功";

    public final static String UPLOAD_SUCCESS = "上传成功";

    public final static String QUERY_SUCCESS = "查询成功";

    public final static String PARAMETER_ERROR = "参数错误";

    public final static String OPERATION_SUCCESS = "成功";

    public final static String WAIT_AGAIN = "稍后重试";

    public final static String LOGIN_ERROR = "用户名或密码错误";

    public final static String FROZEN = "用户被冻结";

    public final static String OPERATION_ERROR = "失败";

    /**
     * 留言板字段名取值
     */
    public final static String[] MSG_CODE_LIST = new String[]{"t1","t2","t3","t4","t5","t6"
            , "t7","t8","t9","t10","t11","t12","t13","t14","t15","t16","t17","t18","t19","t20"};
    /**
     * 导航栏链接生成取值
     */
    public final static String[] NAVIGATION_BAR_ARR = new String[]{"/message","/naviga/arttype","/naviga/artinfo"};
}
