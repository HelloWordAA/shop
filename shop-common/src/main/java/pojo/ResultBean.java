package pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import enumEntity.ResultCode;
import lombok.Data;

/**
 * yzw
 * 2022/12/4
 * 通用返回响应
 */
@JsonInclude(JsonInclude.Include.NON_NULL)  //为null的字段不序列化
@Data
public class ResultBean<T>  {
    private String code;
    private String message;
    private T data;

    public ResultBean(ResultCode resultCode){
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public ResultBean(ResultCode resultCode, T data){
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }
    
    public static <T> ResultBean create(ResultCode resultCode){
        return new ResultBean(resultCode);
    }

    public static <T> ResultBean getErrorResult(String message){
        return new ResultBean("-1",message);
    }
    public static <T> ResultBean create(ResultCode resultCode, T data){
        return new ResultBean(resultCode,data);
    }

    

    public ResultBean(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultBean(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
