package com.oahgnez.kotlin.ngca.java;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by oahgnez on 2018/5/23.
 */

public interface Types {


    /*gender: 男生:mael 女生:female 出版:presses*/
    String MALE = "male";
    String FEMALE = "female";
    String PICTURE = "picture";
    String PRESS = "presses";

    @StringDef({MALE, FEMALE, PICTURE, PRESS})
    @Retention(RetentionPolicy.SOURCE)
    @interface GenderType {

    }

    /*type: 热门:hot 新书:selected 好评:reputation 完结: over 包月: month*/
    String HOT = "hot";
    String NEW = "new";
    String MONTHLY = "monthly";
    String OVER = "over";
    String REPUTATION = "reputation";

    @StringDef({HOT, NEW, MONTHLY, OVER, REPUTATION})
    @Retention(RetentionPolicy.SOURCE)
    @interface CatsType {

    }

    String ANIME = "Anime";// 动画
    String COMIC = "Comic"; //– 漫画
    String GAME = "Game";//– 游戏
    String NOVEL = "Novel"; //– 小说

    String YIYAN_ANIME = "a";
    String YIYAN_COMIC = "b";
    String YIYAN_GAME = "c";
    String YIYAN_NOVEL = "d";

    @StringDef({YIYAN_ANIME, YIYAN_COMIC, YIYAN_GAME, YIYAN_NOVEL})
    @Retention(RetentionPolicy.SOURCE)
    @interface YiYanType {

    }

}

