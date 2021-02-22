package com.example.myapplication.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PostInfo  extends BaseResponseParams {

    /**
     * code : 200
     * message : 成功!
     * result : [{"sid":"31568341","text":"原来我一直抗拒的不是广场舞，而是大妈哈哈哈哈哈","type":"video","thumbnail":"http://wimg.spriteapp.cn/picture/2020/0831/37bed0f8-eb5e-11ea-9899-1866daeb0df0_wpd.jpg","video":"http://uvideo.spriteapp.cn/video/2020/0831/37bed0f8-eb5e-11ea-9899-1866daeb0df0_wpd.mp4","images":null,"up":"486","down":"8","forward":"16","comment":"9","uid":"22904192","name":"百思爆笑","header":"http://wimg.spriteapp.cn/profile/20180809175405412650.jpg","top_comments_content":null,"top_comments_voiceuri":null,"top_comments_uid":null,"top_comments_name":null,"top_comments_header":null,"passtime":"2020-10-23 21:20:04"},{"sid":"31568340","text":"人家都没许愿呢～","type":"video","thumbnail":"http://wimg.spriteapp.cn/picture/2020/0831/1e13e10c-eb5e-11ea-9763-1866daea6abd_wpd.jpg","video":"http://uvideo.spriteapp.cn/video/2020/0831/1e13e10c-eb5e-11ea-9763-1866daea6abd_wpd.mp4","images":null,"up":"280","down":"6","forward":"19","comment":"2","uid":"23077922","name":"愿得一人心","header":"http://wimg.spriteapp.cn/profile/20190413151328574023.jpg","top_comments_content":null,"top_comments_voiceuri":null,"top_comments_uid":null,"top_comments_name":null,"top_comments_header":null,"passtime":"2020-10-23 21:10:04"}]
     */

    private List<PostInfo.ResultBean> result;

    public static BaseResponseParams objectFromData(String str) {

        return new Gson().fromJson(str, BaseResponseParams.class);
    }

    public static List<BaseResponseParams> arrayBaseResponseParamsFromData(String str) {

        Type listType = new TypeToken<ArrayList<BaseResponseParams>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }


    public List<PostInfo.ResultBean> getResult() {
        return result;
    }

    public void setResult(List<PostInfo.ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * sid : 31568341
         * text : 原来我一直抗拒的不是广场舞，而是大妈哈哈哈哈哈
         * type : video
         * thumbnail : http://wimg.spriteapp.cn/picture/2020/0831/37bed0f8-eb5e-11ea-9899-1866daeb0df0_wpd.jpg
         * video : http://uvideo.spriteapp.cn/video/2020/0831/37bed0f8-eb5e-11ea-9899-1866daeb0df0_wpd.mp4
         * images : null
         * up : 486
         * down : 8
         * forward : 16
         * comment : 9
         * uid : 22904192
         * name : 百思爆笑
         * header : http://wimg.spriteapp.cn/profile/20180809175405412650.jpg
         * top_comments_content : null
         * top_comments_voiceuri : null
         * top_comments_uid : null
         * top_comments_name : null
         * top_comments_header : null
         * passtime : 2020-10-23 21:20:04
         */

        private String sid;
        private String text;
        private String type;
        private String thumbnail;
        private String video;
        private Object images;
        private String up;
        private String down;
        private String forward;
        private String comment;
        private String uid;
        private String name;
        private String header;
        private Object top_comments_content;
        private Object top_comments_voiceuri;
        private Object top_comments_uid;
        private Object top_comments_name;
        private Object top_comments_header;
        private String passtime;

        public static PostInfo.ResultBean objectFromData(String str) {

            return new Gson().fromJson(str, PostInfo.ResultBean.class);
        }

        public static List<PostInfo.ResultBean> arrayResultBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<PostInfo.ResultBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public String getSid() {
            return sid;
        }

        public void setSid(String sid) {
            this.sid = sid;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getVideo() {
            return video;
        }

        public void setVideo(String video) {
            this.video = video;
        }

        public Object getImages() {
            return images;
        }

        public void setImages(Object images) {
            this.images = images;
        }

        public String getUp() {
            return up;
        }

        public void setUp(String up) {
            this.up = up;
        }

        public String getDown() {
            return down;
        }

        public void setDown(String down) {
            this.down = down;
        }

        public String getForward() {
            return forward;
        }

        public void setForward(String forward) {
            this.forward = forward;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHeader() {
            return header;
        }

        public void setHeader(String header) {
            this.header = header;
        }

        public Object getTop_comments_content() {
            return top_comments_content;
        }

        public void setTop_comments_content(Object top_comments_content) {
            this.top_comments_content = top_comments_content;
        }

        public Object getTop_comments_voiceuri() {
            return top_comments_voiceuri;
        }

        public void setTop_comments_voiceuri(Object top_comments_voiceuri) {
            this.top_comments_voiceuri = top_comments_voiceuri;
        }

        public Object getTop_comments_uid() {
            return top_comments_uid;
        }

        public void setTop_comments_uid(Object top_comments_uid) {
            this.top_comments_uid = top_comments_uid;
        }

        public Object getTop_comments_name() {
            return top_comments_name;
        }

        public void setTop_comments_name(Object top_comments_name) {
            this.top_comments_name = top_comments_name;
        }

        public Object getTop_comments_header() {
            return top_comments_header;
        }

        public void setTop_comments_header(Object top_comments_header) {
            this.top_comments_header = top_comments_header;
        }

        public String getPasstime() {
            return passtime;
        }

        public void setPasstime(String passtime) {
            this.passtime = passtime;
        }
    }
}
