package com.qianmi.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qianmi.utils.utils.Common;
import com.gracker.tabfragment.R;
import com.qianmi.model.News;

import junit.framework.Assert;

import java.util.Map;


/**
 * 生成图文混合
 */
public class BookDetailFragment extends Fragment {
    public static final String ITEM_ID = "item_id";
    private static final String TAG = "MyAPP";
    //核心数据
    Map<String, String> book;
    GestureDetector gesture_detector = null;
    private MyGestureListener myGestureListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //判断是否包含参数
        if (getArguments().containsKey(ITEM_ID)) {
            book = News.ITEM_MAP.get(getArguments().getString(ITEM_ID));
        }
        myGestureListener = new MyGestureListener(this.getActivity());
        gesture_detector = new GestureDetector(this.getActivity(), myGestureListener);
    }


    @Override
    public View onCreateView(final LayoutInflater inflater
            , final ViewGroup container, Bundle savedInstanceState) {
        // 加载book detail的layout
        View rootView = inflater.inflate(R.layout.fragment_book_detail,
                container, false);
        //这行是必须的
        rootView.setLongClickable(true);
        rootView.setOnTouchListener(myGestureListener);
        if (book != null) {
            //设置图片
            ImageView iv = (ImageView) rootView.findViewById(R.id.book_img);
            Common.IMAGE_CACHE.get(book.get("pic"), iv);
            //设置点击图片弹出详情大图的功能
            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //使用单独的布局
                    View imgEntryView = inflater.inflate(R.layout.dialog_photot_entry, null);
                    //通过alert窗口弹出显示
                    final AlertDialog dialog = new AlertDialog.Builder(container.getContext(), AlertDialog.THEME_HOLO_LIGHT).create();
                    ImageView detailImage = (ImageView) imgEntryView.findViewById(R.id.large_image);
                    //还是要异步加载图片
                    Common.IMAGE_CACHE.get(book.get("pic"), detailImage);
                    dialog.setView(imgEntryView);
                    dialog.show();
                    imgEntryView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.cancel();
                        }
                    });

                }
            });


            // 设置标题
            ((TextView) rootView.findViewById(R.id.book_title))
                    .setText(book.get("title"));
            // 设置描述
            TextView view = (TextView) rootView.findViewById(R.id.book_desc);
            view.setText(book.get("desc"));

        }
        return rootView;
    }

    public static int getDrawable(Context context, String name)//method to get id
    {
        Assert.assertNotNull(context);
        Assert.assertNotNull(name);
        return context.getResources().getIdentifier(name, "drawable", context.getPackageName());
    }


    class MyGestureListener extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener {
        Activity activity = null;

        public MyGestureListener(Activity activity) {
            this.activity = activity;
        }

        public boolean onTouch(View v, MotionEvent event) {

            //这里面第一个参数v，就是用户单击的那个view，
            //在本例中就是那View2中的TextView
            //同时，你也可以使用这个参数来判定用户单击了哪一个View

            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                //如有需要，可以在这样增加相关的代码进行处理
            } else if (event.getAction() == MotionEvent.ACTION_UP) {
            }

            return gesture_detector.onTouchEvent(event);

        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            //在这里，可以判断左右手势，或者增加自己的手势判断
            //同时，在这里增加相应的手势处理函数来完成相应的界面切换效果
            if (e1.getX() - e2.getX() > 100 && Math.abs(velocityX) > 50) {
                //animShowNextPage();
            } else if (e2.getX() - e1.getX() > 100 && Math.abs(velocityX) > 50) {
                activity.onBackPressed();
                return true;
            }
            return false;
        }
    }
}
