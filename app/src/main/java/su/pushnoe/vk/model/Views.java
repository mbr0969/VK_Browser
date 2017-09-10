
package su.pushnoe.vk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Класс просмотров
 */
public class Views extends RealmObject {

    @SerializedName("count")
    @Expose
    private Integer count;

    /**
     *
     * @return
     */
    public Integer getCount() {
        return count;
    }

    /**
     *
     * @param count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

}
