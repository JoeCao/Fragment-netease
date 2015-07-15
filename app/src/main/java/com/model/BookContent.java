package com.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * <br/>website: <a href="http://www.crazyit.org">crazyit.org</a>
 * <br/>Copyright (C), 2001-2014, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class BookContent {
    public static class Book {

        public Integer id;
        public String title;
        public String desc;
        public String thumb;
        public String pic;
        public String src;

        public Book() {
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
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

        public Book(Integer id, String title, String desc, String thumb, String pic, String src) {
            this.id = id;
            this.title = title;
            this.desc = desc;
            this.thumb = thumb;
            this.pic = pic;
            this.src = src;
        }

        @Override
        public String toString() {
            return title;
        }
    }

    public static List<Book> ITEMS = new ArrayList<Book>();
    public static List<Map<String, String>> HEADER_LIST = new ArrayList<>();
    public static Map<Integer, Book> ITEM_MAP
            = new HashMap<Integer, Book>();

    static {
        addItem(new Book(1, "森林狼会选择拉塞尔送走卢比奥？"
                ,
                "北京时间6月13日，据ESPN选秀专家Chad Ford报道，有流言称，森林狼可能会在本届选秀大会上选择控卫丹吉洛-拉塞尔，并且将里基-卢比奥交易走。\n" +
                        "拉塞尔上个赛季为俄亥俄州大出场35次，场均上场33.9分钟得到19.3分5.7个篮板和5次助攻。\n" +
                        "在DraftExpress.com的预测中，拉塞尔将在首轮第四顺位被球队选走。\n" +
                        "根据此前的报道，拉塞尔本来会在本周末参加76人的试训，但随后他取消了这一安排。据报道，拉塞尔这么做的原因可能是收到了某支球队的承诺。\n" +
                        "森林狼今年手握状元签，目前DraftExpress.com的预测中，卡尔-安东尼-唐斯排名第一位。\n" +
                        "卢比奥本赛季因伤只打了22场比赛，场均上场31.5分钟得到10.3分5.7个篮板8.8次助攻。\n",
                "http://img04.store.sogou.com/net/a/66/link?appid=66&url=http://c2.hoopchina.com.cn/uploads/star/event/images/150613/4aa74278f8d16fcb47fc1255f0794aab742f0ad4.jpg",
                "http://img04.store.sogou.com/net/a/66/link?appid=66&url=http://c2.hoopchina.com.cn/uploads/star/event/images/150613/4aa74278f8d16fcb47fc1255f0794aab742f0ad4.jpg",
                "NBA快报"));
        addItem(new Book(2, "波尔图主席：马丁内斯已选择米兰"
                , "波尔图主席科斯塔在本周五对当地媒体确认了杰克逊-马丁内斯的离开，他这样说：“杰克逊在去度假前已经宣布了他要离开。在刚才，我了解到他已经选择了米兰。这是他的意愿，对我来说这是无所谓的，我只希望他开心就好"
                , "http://img04.store.sogou.com/net/a/66/link?appid=66&url=http://c2.hoopchina.com.cn/uploads/star/event/images/150613/244f4d5e063353f9db61883be236e100e827db42.png"
                , "http://img04.store.sogou.com/net/a/66/link?appid=66&url=http://c2.hoopchina.com.cn/uploads/star/event/images/150613/244f4d5e063353f9db61883be236e100e827db42.png"
                , "迪马济奥个人网站"));
        addItem(new Book(3, "曝曼城将开4000万求购斯特林"
                , "据《镜报》报道，曼城将在未来48小时报价4000万英镑求购利物浦边锋斯特林，这份报价将是蓝月亮的最后出价。\n" +
                "曼城今夏瞄准了多名年轻才俊，其中包括斯特林、尤文图斯中场波巴、沃尔夫斯堡边锋德布劳内以及马赛中场因布拉。他们已经为斯特林开出了一份3000万英镑报价（2500万英镑首付，外加500万英镑浮动奖金），但遭到利物浦拒绝。\n" +
                "然而这却并没有让曼城却步，他们计划在48小时里再次求购。红军为斯特林估值5000万英镑，而蓝月亮却并不愿意给出超过4000万英镑，并相信这个数字足以拿下斯特林。\n" +
                "除了报价这名边锋，曼城还准备开出5800万英镑收购波巴，并瞄准了身价3000万英镑的德布劳内以及2200万英镑的因布拉。但蓝月亮首先想要拿下的就是斯特林，他们还准备为这名小将送上为期5年、周薪19万英镑的合同。",
                "http://img04.store.sogou.com/net/a/66/link?appid=66&url=http://c1.hoopchina.com.cn/uploads/star/event/images/150613/091d66abfc41c90ff1344c0bdf1964e50c9a0d2a.jpg",
                "http://img04.store.sogou.com/net/a/66/link?appid=66&url=http://c1.hoopchina.com.cn/uploads/star/event/images/150613/091d66abfc41c90ff1344c0bdf1964e50c9a0d2a.jpg",
                "每日镜报"));
    }

    private static void addItem(Book book) {
        ITEMS.add(book);
        Map<String, String> header = new HashMap<>();
        header.put("title", book.title);
        header.put("thumb", book.thumb);
        header.put("src", book.src);
        HEADER_LIST.add(header);
        ITEM_MAP.put(book.id, book);
    }
}
