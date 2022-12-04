package enumEntity;

import lombok.Getter;

/**
 * yzw
 * 2022/12/4
 * 自定义返回状态码类型
 */
@Getter
public enum ResultCode {
//    private String code;
//    private String msg;
    /**
     * 成功状态码
     */
    SUCCESS("200","成功"),
    /**
     * 系统异常：4001-4999
     */
    SYS_ERROR("4000","系统异常请稍后再试"),
    /**
     * 参数错误：1001-1999
     */
    PAPAM_IS_INVALID("1001","参数无效"),
    PAPAM_IS_BLANK("1002","参数为空"),
    PAPAM_TYPE_BIND_ERROR("1003", "参数类型错误"),
    PAPAM_NOT_COMPLETE("1003", "参数缺失"),

    /*用户错误：2001-2999*/
    USER_NOT_LOGGED_IN("2001", "用户未登录，请登录后重试"),
    USER_LOGIN_ERROR("2002", "账号不存在或密码错误"),
    USER_ACCOUNT_FORBIDDERN("2003", "账号已被禁用"),
    USER_NOT_EXIST("2004", "用户不存在"),
    USER_HAS_EXISTED("2005", "账号已存在");
    /**
     * 状态码
     */
    private String code;
    /**
     * 提示信息
     */
    private String message;

    ResultCode() {
    }

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResultCode{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
