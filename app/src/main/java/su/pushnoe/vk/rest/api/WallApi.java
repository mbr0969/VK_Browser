package su.pushnoe.vk.rest.api;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import su.pushnoe.vk.rest.module.response.WallGetResponse;

/**
 *
 */
public interface WallApi {

    /**
     *
     * @param map
     * @return
     */
    @GET(ApiMethods.WALL_GET)
    Call<WallGetResponse> get(@QueryMap Map<String,String> map);
}
