package su.pushnoe.vk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import su.pushnoe.vk.model.attachment.ApiAttachment;

/**
 * Класс записей стены
 */
public class WallItem extends RealmObject{

    private String attachmentString;
    private String senderName;
    private String senderPhoto;

    @PrimaryKey
    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("from_id")
    @Expose
    private Integer fromId;

    @SerializedName("owner_id")
    @Expose
    private Integer ownerId;

    @SerializedName("date")
    @Expose
    private Integer date;

    @SerializedName("marked_as_ads")
    @Expose
    private Integer markedAsAds;

    @SerializedName("post_type")
    @Expose
    private String postType;

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("can_pin")
    @Expose
    private Integer canPin;

    @SerializedName("attachments")
    @Expose
    private RealmList<ApiAttachment> attachments = new RealmList<>();

    @SerializedName("copy_history")
    @Expose
    private RealmList<WallItem> copyHistory = new RealmList<>();

    @SerializedName("post_source")
    @Expose
    private PostSource postSource;

    @SerializedName("comments")
    @Expose
    private Comments comments;

    @SerializedName("likes")
    @Expose
    private Likes likes;

    @SerializedName("reposts")
    @Expose
    private Reposts reposts;

    @SerializedName("views")
    @Expose
    private Views views;

    public String getAttachmentString() {
        return attachmentString;
    }

    public void setAttachmentString(String attachmentString) {
        this.attachmentString = attachmentString;
    }

    /**
     *
     * @return
     */
    public Integer getId() {
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
    public Integer getFromId() {
        return fromId;
    }

    /**
     *
     * @param fromId
     */
    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    /**
     *
     * @return
     */
    public Integer getOwnerId() {
        return ownerId;
    }

    /**
     *
     * @param ownerId
     */
    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    /**
     *
     * @return
     */
    public Integer getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(Integer date) {
        this.date = date;
    }

    /**
     *
     * @return
     */
    public Integer getMarkedAsAds() {
        return markedAsAds;
    }

    /**
     *
     * @param markedAsAds
     */
    public void setMarkedAsAds(Integer markedAsAds) {
        this.markedAsAds = markedAsAds;
    }

    /**
     *
     * @return
     */
    public String getPostType() {
        return postType;
    }

    /**
     *
     * @param postType
     */
    public void setPostType(String postType) {
        this.postType = postType;
    }

    /**
     *
     * @return
     */
    public String getText() {
        return text;
    }

    /**
     *
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     *
     * @return
     */
    public Integer getCanPin() {
        return canPin;
    }

    /**
     *
     * @param canPin
     */
    public void setCanPin(Integer canPin) {
        this.canPin = canPin;
    }

    /**
     *
     * @return
     */
    public RealmList<ApiAttachment> getAttachments() {
        return attachments;
    }

    /**
     *
     * @param attachments
     */
    public void setAttachments(RealmList<ApiAttachment> attachments) {
        this.attachments = attachments;
    }

    /**
     *
     * @return
     */
    public PostSource getPostSource() {
        return postSource;
    }

    /**
     *
     * @param postSource
     */
    public void setPostSource(PostSource postSource) {
        this.postSource = postSource;
    }

    /**
     *
     * @return
     */
    public Comments getComments() {
        return comments;
    }

    /**
     *
     * @param comments
     */
    public void setComments(Comments comments) {
        this.comments = comments;
    }

    /**
     *
     * @return
     */
    public Likes getLikes() {
        return likes;
    }

    /**
     *
     * @param likes
     */
    public void setLikes(Likes likes) {
        this.likes = likes;
    }

    /**
     *
     * @return
     */
    public Reposts getReposts() {
        return reposts;
    }

    /**
     *
     * @param reposts
     */
    public void setReposts(Reposts reposts) {
        this.reposts = reposts;
    }

    /**
     *
     * @return
     */
    public Views getViews() {
        return views;
    }

    /**
     *
     * @param views
     */
    public void setViews(Views views) {
        this.views = views;
    }

    /**
     *
     * @return
     */
    public String getSenderName() {
        return senderName;
    }

    /**
     *
     * @param senderName
     */
    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    /**
     *
     * @return
     */
    public String getSenderPhoto() {
        return senderPhoto;
    }

    /**
     *
     * @param senderPhoto
     */
    public void setSenderPhoto(String senderPhoto) {
        this.senderPhoto = senderPhoto;
    }


    public boolean haveSharedRepost() {
        return copyHistory.size() > 0;
    }

    public WallItem getSharedRepost() {
        if (haveSharedRepost()) {
            return copyHistory.get(0);
        }
        return null;
    }

}
