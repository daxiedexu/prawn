package com.bawei.library_net.Bean;

/**
 * @ProjectName: NewsZG61901
 * @Package: com.zy.net.protocol
 * @ClassName: BaseRespEntity
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/8/17 13:58
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/8/17 13:58
 * @UpdateRemark:
 * @Version: 1.0
 */
public class BaseRespEntity<T> {
    private int code;
    private T data;
    private String msg;

    public BaseRespEntity(){}

    public BaseRespEntity(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "BaseRespEntity{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
