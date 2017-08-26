package su.pushnoe.vk.rest.module.response;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 *
 * @param <T>
 */
public class Full<T> {

    @SerializedName("response")
    @Expose
    public T response;

}
