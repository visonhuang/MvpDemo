package com.example.testing.mvpdemo.view.view;

import com.example.testing.mvpdemo.model.bean.ArticleInfo;

/**
 * Created by KK on 2018/2/9.
 */

public interface ArticleView {
    void setArticleInfo(ArticleInfo articleInfo);
    void showLoading();
    void hideLoading();
    void showError();
}