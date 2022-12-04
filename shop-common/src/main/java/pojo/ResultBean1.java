package pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * yzw
 * 2022/11/22
 */
@Data
@Component
public class ResultBean1<T> implements Serializable {
    private String statusCode;
    private T data;
    public ResultBean1(){}
    public ResultBean1(String statusCode, T data){
        this.data = data;
        this.statusCode = statusCode;
    }
}
