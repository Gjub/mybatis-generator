package com.jxkj.manage.util;

import com.jxkj.manage.comm.ResultBody;

public class ResultUtils {
    public static ResultBody success(Object object){
        ResultBody result = new ResultBody();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }
    public static ResultBody success(){
        return success(null);
    }
    public static ResultBody error(Integer code,String msg){
        ResultBody result = new ResultBody();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
