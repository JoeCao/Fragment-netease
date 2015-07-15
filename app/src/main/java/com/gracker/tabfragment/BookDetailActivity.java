package com.gracker.tabfragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.gracker.tabfragment.MainActivity;
import com.gracker.tabfragment.R;

import fragment_content.BookDetailFragment;

/**
 * Description:
 * <br/>website: <a href="http://www.crazyit.org">crazyit.org</a>
 * <br/>Copyright (C), 2001-2014, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class BookDetailActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载 Activity_book_detail布局文件
        // 布局文件包含 book_detail_container的FrameLayout
        setContentView(R.layout.activity_book_detail);
        // 将ActionBar上面的图标转为可点击的按钮
//        getActionBar().setDisplayHomeAsUpEnabled(true);
        if (savedInstanceState == null) {
            // 还是去加载DetailFragment，这里Fragment是重用的
            BookDetailFragment fragment = new BookDetailFragment();
            // 将Intent中的参数接力传到Bundle中
            Bundle arguments = new Bundle();
            arguments.putString(BookDetailFragment.ITEM_ID, getIntent()
                    .getStringExtra(BookDetailFragment.ITEM_ID));
            fragment.setArguments(arguments);
            //替换container中的元素
            getFragmentManager().beginTransaction()
                    .add(R.id.book_detail_container, fragment).commit();
        }
    }

    /**
     * 返回List的Activity
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            // 如果点击的是home返回，启动BookListActivity
            Intent intent = new Intent(this, MainActivity.class);
            // 不重新创建BookListActivity，而是将suspend的Activity从栈顶弹出
            // 这样之前栈会被清掉，这样就可以保证在主界面使用返回键，可以退出程序，而不是返回到前面的栈
            intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
