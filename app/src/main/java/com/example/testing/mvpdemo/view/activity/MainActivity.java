package com.example.testing.mvpdemo.view.activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testing.mvpdemo.R;
import com.example.testing.mvpdemo.model.bean.ArticleInfo;
import com.example.testing.mvpdemo.presenter.ArticlePresenter;
import com.example.testing.mvpdemo.presenter.impl.ArticlePresenterImpl;
import com.example.testing.mvpdemo.view.view.ArticleView;

import java.util.List;

import cn.finalteam.okhttpfinal.OkHttpFinal;
import cn.finalteam.okhttpfinal.OkHttpFinalConfiguration;

public class MainActivity extends BaseActivity implements ArticleView {

    private Button bt_getarticle;
    private TextView tv_article_title;
    private TextView tv_article_othertitle;
    private ArticlePresenter mArticlePresenter;
    private Dialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OkHttpFinalConfiguration.Builder builder = new OkHttpFinalConfiguration.Builder();
        OkHttpFinal.getInstance().init(builder.build());
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {

        mArticlePresenter=new ArticlePresenterImpl(this);
        mDialog=new ProgressDialog(this);
        mDialog.setTitle("获取数据中");
        bt_getarticle = findView(R.id.bt_getarticle);
        tv_article_title = findView(R.id.tv_article_title);
        tv_article_othertitle = findView(R.id.tv_article_othertitle);
        bt_getarticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mArticlePresenter.getArticle();
            }
        });
    }

    @Override
    public void setArticleInfo(ArticleInfo articleInfo) {
        if(null!=articleInfo) {
            List<ArticleInfo.detail> list = articleInfo.getDetail();
            if(null!=list&&list.size()>0)
                tv_article_title.setText(list.get(0).getTitle());
            tv_article_othertitle.setText(list.get(1).getTitle());
        }

    }

    @Override
    public void showLoading() {
        mDialog.show();
    }

    @Override
    public void hideLoading() {
        if(mDialog.isShowing()) {
            mDialog.dismiss();
        }
    }

    @Override
    public void showError() {
        Toast.makeText(getApplicationContext(),"网络出错",Toast.LENGTH_SHORT).show();
    }
}
