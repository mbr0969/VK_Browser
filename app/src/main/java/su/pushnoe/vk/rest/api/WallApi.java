package su.pushnoe.vk.rest.api;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import su.pushnoe.vk.rest.module.response.GetWallResponse;

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
    Call<GetWallResponse> get(@QueryMap Map<String,String> map);
}
