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

    /*pixiv */
    String PIXIV_ILLUST = "illust";//	作品详情
    String PIXIV_MEMBER = "member";    //用户详情
    String PIXIV_MEMBER_ILLUST = "member_illust";    //	用户作品
    String PIXIV_FAVORITE = "favorite";    //	用户收藏
    String PIXIV_RANK = "rank";    //	排行榜
    String PIXIV_SEARCH = "search";    //	搜索
    String PIXIV_TAGS = "tags";    //	热门标签
    String PIXIV_RELATED = "related	";    //相关作品
    String PIXIV_UGOIRA_METADATA = "ugoira_metadata";    //

    @StringDef({PIXIV_ILLUST, PIXIV_MEMBER, PIXIV_MEMBER_ILLUST, PIXIV_FAVORITE, PIXIV_RANK, PIXIV_SEARCH, PIXIV_TAGS, PIXIV_RELATED, PIXIV_UGOIRA_METADATA})
    @Retention(RetentionPolicy.SOURCE)
    @interface PixivType {
    }
    /*  day	日榜
        week	周榜
        month	月榜
        week_rookie	新人
        week_original	原创
        day_male	男性向
        day_female	女性向*/
    String PIXIV_RANK_DAY = "day";
    String PIXIV_RANK_WEEK = "week";
    String PIXIV_RANK_MONTH = "month";
    String PIXIV_RANK_WEEK_ROOKIE = "week_rookie";
    String PIXIV_RANK_WEEK_ORIGINAL = "week_original";
    String PIXIV_RANK_DAY_MALE = "day_male";
    String PIXIV_RANK_DAY_FEMALE = "day_female";

    @StringDef({PIXIV_RANK_DAY, PIXIV_RANK_DAY_FEMALE, PIXIV_RANK_DAY_MALE, PIXIV_RANK_MONTH, PIXIV_RANK_WEEK, PIXIV_RANK_WEEK_ORIGINAL, PIXIV_RANK_WEEK_ROOKIE})
    @Retention(RetentionPolicy.SOURCE)
    @interface PixivRankMode {
    }

    String PIXIV_DESC = "date_desc";//	按日期倒序
    String PIXIV_ASC = "date_asc";//日期正序

    @StringDef({PIXIV_DESC, PIXIV_ASC})
    @Retention(RetentionPolicy.SOURCE)
    @interface PixivOrder {
    }

}

