package com.example.testing.mvpdemo.model.impl;

import com.example.testing.mvpdemo.model.bean.ArticleInfo;
import com.example.testing.mvpdemo.model.model.ArticleModel;
import com.example.testing.mvpdemo.presenter.OnArticleListener;

import cn.finalteam.okhttpfinal.BaseHttpRequestCallback;
import cn.finalteam.okhttpfinal.HttpRequest;
import cn.finalteam.okhttpfinal.OkHttpFinal;
import cn.finalteam.okhttpfinal.OkHttpFinalConfiguration;

/**
 * Created by KK on 2018/2/9.
 */

public class ArticleModelImpl implements ArticleModel{
    @Override
    public void getArtcle(final OnArticleListener onArticleListener) {

        HttpRequest.post("http://api.1-blog.com/biz/bizserver/article/list.do",new BaseHttpRequestCallback<ArticleInfo>(){
            @Override
            protected void onSuccess(ArticleInfo articleInfo) {
                super.onStart();
                onArticleListener.onSuccess(articleInfo);
            }

            @Override
            public void onStart() {
                super.onStart();
                onArticleListener.onStart();
            }

            @Override
            public void onFailure(int errorCode, String msg) {
                super.onFailure(errorCode, msg);
                onArticleListener.onFailed();
            }

            @Override
            public void onFinish() {
                super.onFinish();
                onArticleListener.onFinish();
            }

        });
    }
}
