package com.sun.juc;

/**
 * @author shawn
 * @descript
 * @create 2020-09-10 9:34 下午
 */
public enum CountryEnum {
    ONE(1, "齐"),
    TWO(2, "楚"),
    THREE(3, "韩"),
    FOUR(4, "赵"),
    FIVE(5, "魏"),
    SIX(6, "燕");

    private Integer code;
    private String name;

    CountryEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static CountryEnum forEach_Country(int code) {
        CountryEnum[] countryEnums = CountryEnum.values();
        for (CountryEnum element : countryEnums) {
            if (code == element.getCode()) {
                return element;
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
