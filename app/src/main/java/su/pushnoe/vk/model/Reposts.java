
package su.pushnoe.vk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Класс Репостов
 */

public class Reposts extends RealmObject{

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("user_reposted")
    @Expose
    private Integer userReposted;

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

    /**
     *
     * @return
     */
    public Integer getUserReposted() {
        return userReposted;
    }

    /**
     *
     * @param userReposted
     */
    public void setUserReposted(Integer userReposted) {
        this.userReposted = userReposted;
    }

}
