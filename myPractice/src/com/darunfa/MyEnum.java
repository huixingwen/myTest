package com.darunfa;

public enum MyEnum {

    ONE(1,"小蓝"),TWO(2,"小红"),THREE(3,"小黑"),FOUR(4,"小黄"),FIVE(5,"小白");

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    MyEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static String findMsgByCode(Integer code) {
        MyEnum[] values = MyEnum.values();
        for (MyEnum myEnum : values) {
            if (code == myEnum.getCode().intValue()) {
                return myEnum.getMsg();
            }
        }
        return null;
    }
}
