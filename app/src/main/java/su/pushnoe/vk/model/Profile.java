package su.pushnoe.vk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by papa on 25.08.17.
 */

public class Profile extends RealmObject implements Owner {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("photo_50")
    @Expose
    private String photo50;

    @SerializedName("photo_100")
    @Expose
    private String photo100;

    @SerializedName("first_name")
    @Expose
    private String firstName;

    @SerializedName("last_name")
    @Expose
    private String lastName;

    @SerializedName("sex")
    @Expose
    private int sex;

    @SerializedName("screen_name")
    @Expose
    private String screenName;


    @SerializedName("online")
    @Expose
    private int online;

    @SerializedName("hidden")
    @Expose
    private int hidden;

    /**
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return
     */
    public int getSex() {
        return sex;
    }

    /**
     *
     * @param sex
     */
    public void setSex(int sex) {
        this.sex = sex;
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
     * @param photo100
     */
    public void setPhoto100(String photo100) {
        this.photo100 = photo100;
    }

    /**
     *
     * @return
     */
    public int getOnline() {
        return online;
    }

    /**
     *
     * @param online
     */
    public void setOnline(int online) {
        this.online = online;
    }

    /**
     *
     * @return
     */
    public int getHidden() {
        return hidden;
    }

    /**
     *
     * @param hidden
     */
    public void setHidden(int hidden) {
        this.hidden = hidden;
    }

    /**
     *
     * @return
     */
    public boolean isGroup() {
        return false;
    }

    /**
     *
     * @return
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    /**
     *
     * @return
     */
    @Override
    public String getPhoto() {
        return photo100;
    }

    /**
     *
     * @return
     */
    public String getDisplayProfilePhoto() {
        return photo100;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }


}
