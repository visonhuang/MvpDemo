package com.example.testing.mvpdemo.presenter;

import com.example.testing.mvpdemo.model.bean.ArticleInfo;

/**
 * Created by KK on 2018/2/9.
 */

public interface OnArticleListener {
    void onSuccess(ArticleInfo articleInfo);
    void onStart();
    void onFailed();
    void onFinish();
}