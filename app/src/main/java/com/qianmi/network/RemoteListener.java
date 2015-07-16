package com.qianmi.network;


import com.qianmi.model.NewsEntity;

import java.util.ArrayList;

/**
 * Created by caozupeng on 15-6-25.
 */
public interface RemoteListener {
    void onSuccess(ArrayList<NewsEntity> items);
}
