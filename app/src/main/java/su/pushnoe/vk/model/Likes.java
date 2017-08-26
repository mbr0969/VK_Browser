
package su.pushnoe.vk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Класс Лайков
 */
public class Likes {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("user_likes")
    @Expose
    private Integer userLikes;
    @SerializedName("can_like")
    @Expose
    private Integer canLike;
    @SerializedName("can_publish")
    @Expose
    private Integer canPublish;

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
    public Integer getUserLikes() {
        return userLikes;
    }

    /**
     *
     * @param userLikes
     */
    public void setUserLikes(Integer userLikes) {
        this.userLikes = userLikes;
    }

    /**
     *
     * @return
     */
    public Integer getCanLike() {
        return canLike;
    }

    /**
     *
     * @param canLike
     */
    public void setCanLike(Integer canLike) {
        this.canLike = canLike;
    }

    /**
     *
     * @return
     */
    public Integer getCanPublish() {
        return canPublish;
    }

    /**
     *
     * @param canPublish
     */
    public void setCanPublish(Integer canPublish) {
        this.canPublish = canPublish;
    }

}
