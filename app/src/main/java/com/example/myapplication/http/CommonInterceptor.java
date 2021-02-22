package com.example.myapplication.http;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CommonInterceptor implements Interceptor {
    private static Map<String, String> commonParams;

    public synchronized static void setCommonParam(Map<String, String> commonParams) {
        if (commonParams != null) {
            if (CommonInterceptor.commonParams != null) {
                CommonInterceptor.commonParams.clear();
            } else {
                CommonInterceptor.commonParams = new HashMap<>();
            }
            for (String paramKey : commonParams.keySet()) {
                CommonInterceptor.commonParams.put(paramKey, commonParams.get(paramKey));
            }
        }
    }
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = rebuildRequest(chain.request());
        return chain.proceed(request);
    }

    private Request rebuildRequest(Request request) {
        Map<String, String> signParams = new HashMap<>(); // 假设你的项目需要对参数进行签名
        RequestBody originalRequestBody  = request.body();
        RequestBody newRequestBody = null;
        if (originalRequestBody instanceof FormBody) { // 传统表单
            FormBody.Builder builder = new FormBody.Builder();
            FormBody requestBody = (FormBody) request.body();
            int fieldSize = requestBody == null ? 0 : requestBody.size();
            for (int i = 0; i < fieldSize; i++) {
                builder.add(requestBody.name(i), requestBody.value(i));
                signParams.put(requestBody.name(i), requestBody.value(i));
            }
            if (commonParams != null && commonParams.size() > 0) {
                signParams.putAll(commonParams);
                for (String paramKey : commonParams.keySet()) {
                    builder.add(paramKey, commonParams.get(paramKey));
                }
            }
            // ToDo 此处可对参数做签名处理 signParams
            /**
             * String sign = SignUtil.sign(signParams);
             * builder.add("sign", sign);
             */
            newRequestBody = builder.build();
        }
        return request.newBuilder().method(request.method(), newRequestBody).build();
    }


    /**
     * 对get请求做统一参数处理
     */
    private Request rebuildGetRequest(Request request) {
        if (commonParams == null || commonParams.size() == 0) {
            return request;
        }
        String url = request.url().toString();
        int separatorIndex = url.lastIndexOf("?");
        StringBuilder sb = new StringBuilder(url);
        if (separatorIndex == -1) {
            sb.append("?");
        }
        for (String commonParamKey : commonParams.keySet()) {
            sb.append("&").append(commonParamKey).append("=").append(commonParams.get(commonParamKey));
        }
        Request.Builder requestBuilder = request.newBuilder();
        return requestBuilder.url(sb.toString()).build();
    }
}
