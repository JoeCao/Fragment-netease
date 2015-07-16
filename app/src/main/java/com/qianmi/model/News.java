package com.qianmi.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by caozupeng on 15-6-16.
 */
public class News {
    public Integer objectId;
    public String title;
    public String desc;
    public String thumb;
    public String pic;
    public String src;

    public News() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    @Override
    public String toString() {
        return title;
    }
    public static int index = 0;
    public static final List<Map<String, String>> HEADER_LIST = new ArrayList<>();
    public static final Map<String, Map<String, String>> ITEM_MAP = new HashMap<>();
}
