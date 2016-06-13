package com.example.csdnblog4.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

import java.util.UUID;

/**
 * Created by orange on 16/6/13.
 */
public class MobileUtils
{
    /**
     * 设备唯一表示
     */
    public static final String MOBILE_UUID = "ORANGE_MOBILE_UUID";
    /**
     * 设备唯一号存储
     */
    public static final String MOBILE_SETTING = "ORANGE_MOBILE_SETTING";
    /**
     * 得到全局唯一UUID
     */
    public static String getUUID(Context context) {
        SharedPreferences mShare = context.getSharedPreferences(MOBILE_SETTING, 0);
        String uuid = "";
        if (mShare != null && !TextUtils.isEmpty(mShare.getString(MOBILE_UUID, ""))) {
            uuid = mShare.getString(MOBILE_UUID, "");
        }
        if (TextUtils.isEmpty(uuid)) {
            uuid = UUID.randomUUID().toString();
            Log.d("orangeUU:",uuid);
            mShare.edit().putString(MOBILE_UUID, uuid).commit();
        }
        return uuid.replace("-", "");
    }

}
