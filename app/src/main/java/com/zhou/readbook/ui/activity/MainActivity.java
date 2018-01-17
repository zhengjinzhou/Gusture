package com.zhou.readbook.ui.activity;

import android.annotation.SuppressLint;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.zhou.readbook.R;
import com.zhou.readbook.adapter.ViewPagerAdapter;
import com.zhou.readbook.base.BaseActivity;
import com.zhou.readbook.ui.fragment.BooksFragment;
import com.zhou.readbook.ui.fragment.CommunityFragment;
import com.zhou.readbook.ui.fragment.FindFragment;
import com.zhou.readbook.utils.ToastUtils;

import java.lang.reflect.Method;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.common_toolbar) Toolbar common_toolbar;
    @BindView(R.id.viewpager) ViewPager viewPager;
    @BindView(R.id.tab) TabLayout tabLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    protected void init() {
        setSupportActionBar(common_toolbar);
        common_toolbar.setTitle("");

        BooksFragment booksFragment = new BooksFragment();
        CommunityFragment communityFragment = new CommunityFragment();
        FindFragment findFragment = new FindFragment();

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(booksFragment, "书架");
        adapter.addFrag(communityFragment, "社区");
        adapter.addFrag(findFragment, "发现");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * 为每个menu的item设置点击事件
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:

                break;
            case R.id.action_login:

                break;
            case R.id.action_my_message:

                break;
            case R.id.action_sync_bookshelf:

                break;
            case R.id.action_scan_local_book:

                break;
            case R.id.action_wifi_book:

                break;
            case R.id.action_feedback:

                break;

            case R.id.action_night_mode:

                break;

            case R.id.action_settings:

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 显示item中的图片
     *
     * @param view
     * @param menu
     * @return
     */
    @SuppressLint("RestrictedApi")
    @Override
    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        if (menu != null) {
            if (menu.getClass() == MenuBuilder.class) {
                try {
                    Method m = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return super.onPrepareOptionsPanel(view, menu);
    }

    // 退出时间
    private long currentBackPressedTime = 0;
    // 退出间隔
    private static final int BACK_PRESSED_INTERVAL = 2000;
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN
                && event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - currentBackPressedTime > BACK_PRESSED_INTERVAL) {
                currentBackPressedTime = System.currentTimeMillis();
                ToastUtils.showToast(getString(R.string.exit_tips));
                return true;
            } else {
                finish(); // 退出
            }
        } else if (event.getKeyCode() == KeyEvent.KEYCODE_MENU) {
            return true;
        }
        return super.dispatchKeyEvent(event);
    }
}
