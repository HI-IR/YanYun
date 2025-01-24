package com.example.yanyun.view.home.poem;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.yanyun.R;
import com.example.yanyun.model.bean.json.PoemJson;
import com.example.yanyun.presenter.home.poem.PoemPresenter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * description ： Home页的子Fragment--Poem
 * author : HI-IR
 * email : qq2420226433@outlook.com
 * date : 2025/1/20 19:40
 */
public class PoemView extends Fragment implements IPoemView {
    private TextView mContent;
    private TextView mFrom;
    private ProgressBar mProgressBar;
    private PoemPresenter mPoemPresenter;
    private int clickCount = 0;//点击c次数
    private TextView mTitle;
    private TextView mDynasty;
    private BottomNavigationView mBottomNavigationView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_poem, container, false);
        initView(view);
        initEvent();
        return view;
    }

    private void initEvent() {
        doUpdateInfo();

        //点击爱心收藏，
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_collection: {
                        clickCount++;
                        //如果点击数为奇数则显示收藏，为偶数则显示未收藏

                        if (clickCount % 2 == 1) {
                            item.setIcon(R.drawable.collected);
                            String content = mTitle.getText().toString() + "\n" + mContent.getText().toString();
                            String author = "["+mDynasty.getText().toString()+"]"+mFrom.getText().toString();
                            mPoemPresenter.Collect(content, author);
                        } else {
                            item.setIcon(R.drawable.uncollected);
                            String content = mTitle.getText().toString() + "\n" + mContent.getText().toString();
                            mPoemPresenter.unCollect(content);
                        }
                        break;
                    }
                    case R.id.menu_refresh: {
                        doUpdateInfo();//更新数据
                        mBottomNavigationView.getMenu().findItem(R.id.menu_collection).setIcon(R.drawable.uncollected);//更新图标
                        clickCount = 0;
                    }
                }
                return true;
            }
        });
    }

    private void initView(View view) {
        mContent = view.findViewById(R.id.tv_poem_content);
        mFrom = view.findViewById(R.id.tv_poem_from);
        mProgressBar = view.findViewById(R.id.progressBar_poem);
        mTitle = view.findViewById(R.id.tv_poem_title);
        mDynasty = view.findViewById(R.id.tv_poem_dynasty);
        mPoemPresenter = new PoemPresenter(this, PoemView.this.getContext());
        mBottomNavigationView = view.findViewById(R.id.bottomNavigationView2);
        mBottomNavigationView.setItemIconTintList(null);
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void doUpdateInfo() {
        showLoading();
        mPoemPresenter.doUpdateInfo();

    }

    @Override
    public void setInfo(PoemJson poemJson) {
        hideLoading();
        //将诗词拼接起来
        StringBuilder stringBuilder = new StringBuilder();
        for (String i : poemJson.data.origin.content) {
            stringBuilder.append(i).append("\n");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);//删掉最后的换行
        mContent.setText(stringBuilder.toString());
        mFrom.setText(poemJson.data.origin.author);
        mTitle.setText(poemJson.data.origin.title);
        mDynasty.setText(poemJson.data.origin.dynasty);
    }

    @Override
    public void showError(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setCollected() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mBottomNavigationView.getMenu().findItem(R.id.menu_collection).setIcon(R.drawable.collected);
                clickCount=1;
            }
        });

    }
    //设置未收藏状态（因为是其他线程回调而来的所以需要切换一下线程）
    @Override
    public void setUnCollected() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mBottomNavigationView.getMenu().findItem(R.id.menu_collection).setIcon(R.drawable.uncollected);
                clickCount=0;
            }
        });
    }
}
