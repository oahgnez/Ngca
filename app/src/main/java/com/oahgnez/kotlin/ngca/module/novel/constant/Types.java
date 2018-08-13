package com.oahgnez.kotlin.ngca.module.novel.constant;

import android.support.annotation.StringDef;


import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by oahgnez on 2018/8/6.
 * 代替枚举类型
 */

public class Types {
    /*Novel 请求参数限定*/
    //gender: 男生:mael 女生:female 出版:presses
    static final String MALE = "male";
    static final String FEMALE = "female";
    static final String PICTURE = "picture";
    static final String PRESS = "presses";

    @StringDef({MALE, FEMALE, PICTURE, PRESS})
    @Retention(RetentionPolicy.SOURCE)
    @interface GenderType {}
}
