package com.example.myapplication.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BaseResponseParams {

    /**
     * code : 200
     * message : 成功!
     * result : [{"sid":"31568341","text":"原来我一直抗拒的不是广场舞，而是大妈哈哈哈哈哈","type":"video","thumbnail":"http://wimg.spriteapp.cn/picture/2020/0831/37bed0f8-eb5e-11ea-9899-1866daeb0df0_wpd.jpg","video":"http://uvideo.spriteapp.cn/video/2020/0831/37bed0f8-eb5e-11ea-9899-1866daeb0df0_wpd.mp4","images":null,"up":"486","down":"8","forward":"16","comment":"9","uid":"22904192","name":"百思爆笑","header":"http://wimg.spriteapp.cn/profile/20180809175405412650.jpg","top_comments_content":null,"top_comments_voiceuri":null,"top_comments_uid":null,"top_comments_name":null,"top_comments_header":null,"passtime":"2020-10-23 21:20:04"},{"sid":"31568340","text":"人家都没许愿呢～","type":"video","thumbnail":"http://wimg.spriteapp.cn/picture/2020/0831/1e13e10c-eb5e-11ea-9763-1866daea6abd_wpd.jpg","video":"http://uvideo.spriteapp.cn/video/2020/0831/1e13e10c-eb5e-11ea-9763-1866daea6abd_wpd.mp4","images":null,"up":"280","down":"6","forward":"19","comment":"2","uid":"23077922","name":"愿得一人心","header":"http://wimg.spriteapp.cn/profile/20190413151328574023.jpg","top_comments_content":null,"top_comments_voiceuri":null,"top_comments_uid":null,"top_comments_name":null,"top_comments_header":null,"passtime":"2020-10-23 21:10:04"}]
     */

    private int code;
    private String message;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
