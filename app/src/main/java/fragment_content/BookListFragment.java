package fragment_content;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.and.netease.utils.Common;
import com.and.netease.utils.DownloadTask;
import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVObject;
import com.avos.avoscloud.AVQuery;
import com.avos.avoscloud.FindCallback;
import com.gracker.tabfragment.R;
import com.model.BookContent;
import com.model.News;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.trinea.android.common.service.impl.ImageCache;
import cn.trinea.android.common.util.CacheManager;


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
public class BookListFragment extends ListFragment {
    private Callbacks mCallbacks;


    public interface Callbacks {
        void onItemSelected(String id);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AVQuery<AVObject> query = new AVQuery<AVObject>("news");
        query.findInBackground(new FindCallback<AVObject>() {
                                   public void done(List<AVObject> avObjects, AVException e) {
                                       if (e == null) {
                                           Log.d("成功", "查询到" + avObjects.size() + " 条符合条件的数据");
                                           for (AVObject avObject : avObjects) {
                                               Map<String, String> header = new HashMap<>();
                                               header.put("id", avObject.getObjectId());
                                               header.put("title", String.valueOf(avObject.get("title")));
                                               header.put("thumb", String.valueOf(avObject.get("thumb")));
                                               header.put("pic", String.valueOf(avObject.get("pic")));
                                               header.put("desc", String.valueOf(avObject.get("desc")));
                                               header.put("src", String.valueOf(avObject.get("src")));
                                               News.HEADER_LIST.add(header);
                                               News.ITEM_MAP.put(String.valueOf(avObject.getObjectId()), header);
                                               News.index++;

                                           }
                                           setListAdapter(new MySimpleAdapter(getActivity(), News.HEADER_LIST,
                                                   R.layout.news_item,
                                                   new String[]{"title", "thumb", "src"},
                                                   new int[]{R.id.news_title, R.id.item_header, R.id.news_src}));
                                       } else {
                                           Log.d("失败", "查询错误: " + e.getMessage());
                                       }
                                   }

                               }

        );


    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!(activity instanceof Callbacks)) {
            throw new IllegalStateException(
                    "BookListFragment need a callback");
        }
        mCallbacks = (Callbacks) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks = null;
    }

    @Override
    public void onListItemClick(ListView listView
            , View view, int position, long id) {
        super.onListItemClick(listView, view, position, id);
        mCallbacks.onItemSelected(News.HEADER_LIST.get(position).get("id"));
    }

    public void setActivateOnItemClick(boolean activateOnItemClick) {
        getListView().setChoiceMode(
                activateOnItemClick ? ListView.CHOICE_MODE_SINGLE
                        : ListView.CHOICE_MODE_NONE);
    }

    private class MySimpleAdapter extends SimpleAdapter {
        private Context mContext;
        public LayoutInflater inflater = null;

        public MySimpleAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to) {
            super(context, data, resource, from, to);
            mContext = context;
            inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View vi = convertView;
            if (convertView == null)
                vi = inflater.inflate(R.layout.news_item, null);

            HashMap<String, String> data = (HashMap<String, String>) getItem(position);
            ((TextView) vi.findViewById(R.id.news_title)).setText(data.get("title"));
            ((TextView) vi.findViewById(R.id.news_src)).setText(data.get("src"));
            Common.IMAGE_CACHE.get(data.get("thumb"), vi.findViewById(R.id.item_header));
            return vi;
        }
    }


}
