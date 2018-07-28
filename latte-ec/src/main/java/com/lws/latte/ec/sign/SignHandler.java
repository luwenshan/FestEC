package com.lws.latte.ec.sign;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lws.latte.ec.database.DatabaseManager;
import com.lws.latte.ec.database.UserProfile;

public class SignHandler {
    public static void onSignUp(String response) {
        JSONObject profileJson = JSON.parseObject(response).getJSONObject("data");
        long userId = profileJson.getLong("userId");
        String name = profileJson.getString("name");
        String avatar = profileJson.getString("avatar");
        String gender = profileJson.getString("gender");
        String address = profileJson.getString("address");

        UserProfile profile = new UserProfile(userId, name, avatar, gender, address);
        DatabaseManager.getInstance().getDao().insert(profile);
    }
}
