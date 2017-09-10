
package su.pushnoe.vk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Класс группы
 */
public class Group extends RealmObject implements Owner{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("screen_name")
    @Expose
    private String screenName;
    @SerializedName("is_closed")
    @Expose
    private Integer isClosed;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("is_admin")
    @Expose
    private Integer isAdmin;
    @SerializedName("is_member")
    @Expose
    private Integer isMember;
    @SerializedName("photo_50")
    @Expose
    private String photo50;
    @SerializedName("photo_100")
    @Expose
    private String photo100;
    @SerializedName("photo_200")
    @Expose
    private String photo200;

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getScreenName() {
        return screenName;
    }

    /**
     *
     * @param screenName
     */
    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    /**
     *
     * @return
     */
    public Integer getIsClosed() {
        return isClosed;
    }

    /**
     *
     * @param isClosed
     */
    public void setIsClosed(Integer isClosed) {
        this.isClosed = isClosed;
    }

    /**
     *
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     */
    public Integer getIsAdmin() {
        return isAdmin;
    }

    /**
     *
     * @param isAdmin
     */
    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }

    /**
     *
     * @return
     */
    public Integer getIsMember() {
        return isMember;
    }

    /**
     *
     * @param isMember
     */
    public void setIsMember(Integer isMember) {
        this.isMember = isMember;
    }

    /**
     *
     * @return
     */
    public String getPhoto50() {
        return photo50;
    }

    /**
     *
     * @param photo50
     */
    public void setPhoto50(String photo50) {
        this.photo50 = photo50;
    }

    /**
     *
     * @return
     */
    public String getPhoto100() {
        return photo100;
    }

    /**
     *
     * @param photo100
     */
    public void setPhoto100(String photo100) {
        this.photo100 = photo100;
    }

    /**
     *
     * @return
     */
    public String getPhoto200() {
        return photo200;
    }

    /**
     *
     * @param photo200
     */
    public void setPhoto200(String photo200) {
        this.photo200 = photo200;
    }

    /**
     *
     * @return
     */
    @Override
    public String getFullName() {
        return name;
    }

    /**
     *
     * @return
     */
    @Override
    public String getPhoto() {
        return photo100;
    }
}