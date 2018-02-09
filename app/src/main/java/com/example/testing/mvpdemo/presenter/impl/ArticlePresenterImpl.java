package com.example.testing.mvpdemo.presenter.impl;

import com.example.testing.mvpdemo.model.bean.ArticleInfo;
import com.example.testing.mvpdemo.model.impl.ArticleModelImpl;
import com.example.testing.mvpdemo.model.model.ArticleModel;
import com.example.testing.mvpdemo.presenter.ArticlePresenter;
import com.example.testing.mvpdemo.presenter.OnArticleListener;
import com.example.testing.mvpdemo.view.view.ArticleView;

/**
 * Created by KK on 2018/2/9.
 */

public class ArticlePresenterImpl implements ArticlePresenter,OnArticleListener {

    private ArticleView mArticleView;
    private ArticleModel mArticleModel;

    public ArticlePresenterImpl(ArticleView mArticleView){
        this.mArticleView=mArticleView;
        mArticleModel=new ArticleModelImpl();
    }

    @Override
    public void onSuccess(ArticleInfo articleInfo) {
        mArticleView.setArticleInfo(articleInfo);
    }

    @Override
    public void onStart() {
        mArticleView.showLoading();
    }

    @Override
    public void onFailed() {
        mArticleView.showError();
    }

    @Override
    public void onFinish() {
        mArticleView.hideLoading();
    }


    @Override
    public void getArticle() {
        mArticleModel.getArtcle(this);
    }
}
