package com.bwie.sunli;

import java.util.List;

public class FragmentBean {

    public List<Data> data;
    public List<Data> getData() { return data; }
    public void setData(List<Data> data) { this.data = data; }

    public static class Data {
        public String news_id;
        public String news_summary;
        public String news_title;
        public String pic_url;

        public String getNews_id() { return news_id; }
        public void setNews_id(String news_id) { this.news_id = news_id; }

        public String getNews_summary() { return news_summary; }
        public void setNews_summary(String news_summary) { this.news_summary = news_summary; }

        public String getNews_title() { return news_title; }
        public void setNews_title(String news_title) { this.news_title = news_title; }

        public String getPic_url() { return pic_url; }
        public void setPic_url(String pic_url) { this.pic_url = pic_url; }
    }

}
