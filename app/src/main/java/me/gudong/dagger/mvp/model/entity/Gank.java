package me.gudong.dagger.mvp.model.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *  Created by GuDong on 12/22/15 23:59.
 *  Contact with 1252768410@qq.com.
 */
public class Gank implements Cloneable,Serializable {

    /**
     * createdAt : 2015-10-06T08:23:35.565Z
     * publishedAt : 2015-10-08T01:29:48.811Z
     * used : true
     * type : 休息视频
     * url : http://v.youku.com/v_show/id_XMTY4OTE3OTQ4.html
     * who : lxxself
     * desc : 耐克还有这广告，我良辰服气
     * updatedAt : 2015-10-08T01:29:49.219Z
     */
    protected long id;
    public String objectId;

    public boolean used;
    public String type;
    public String url;
    public String who;
    public String desc;
    public Date updatedAt;
    public Date createdAt;
    public Date publishedAt;

    public boolean is妹子(){
        return "福利".equals(type);
    }

    @Override
    public Gank clone() {
        Gank gank = null;
        try{
            gank = (Gank)super.clone();
        }catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return gank;
    }
}