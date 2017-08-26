package su.pushnoe.vk.rest.module.request;

import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.VKApiConst;

import java.util.HashMap;
import java.util.Map;

import su.pushnoe.vk.CurrentUser;
import su.pushnoe.vk.consts.ApiConstants;

/**
 * Базовый Класс подели запросов
 */
public abstract class BaseRequestModel {


    @SerializedName(VKApiConst.VERSION)
    Double version = ApiConstants.DEFAULT_VERSION;

    @SerializedName(VKApiConst.ACCESS_TOKEN)
    String accessToken = CurrentUser.getAccessToken();

    /**
     *
     * @return
     */
    public Double getVersion() {
        return version;
    }

    /**
     *
     * @return
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     *
     * @return
     */
    public Map<String,String> toMap(){
        Map<String,String> map = new HashMap<>();

        map.put(VKApiConst.VERSION, String.valueOf(getVersion()));
        if (accessToken != null ){
            map.put(VKApiConst.ACCESS_TOKEN, getAccessToken());
        }

        onMapCreate(map);
        return map;
    }

    /**
     *
     * @param map
     */
    public abstract void onMapCreate(Map<String,String> map);
}
