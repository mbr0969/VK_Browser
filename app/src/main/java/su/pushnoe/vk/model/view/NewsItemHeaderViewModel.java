package su.pushnoe.vk.model.view;

import android.view.View;

import su.pushnoe.vk.model.WallItem;
import su.pushnoe.vk.ui.NewsItemHeaderHolder;
import su.pushnoe.vk.ui.holder.BaseViewHolder;

/**
 *
 */
public class NewsItemHeaderViewModel extends BaseViewModel{

    private int mId;
    private String mProfilePhoto;
    private String mProfileName;
    private String mRepostProfileName;
    private boolean mIsRepost;

    /**
     *
     * @param wallItem
     */
    public NewsItemHeaderViewModel(WallItem wallItem) {
        this.mId = wallItem.getId();
        this.mProfilePhoto = wallItem.getSenderPhoto();
        this.mProfileName = wallItem.getSenderName();

        this.mIsRepost = wallItem.haveSharedRepost();

        if (mIsRepost) {
            this.mRepostProfileName = wallItem.getSharedRepost().getSenderName();
        }
    }

    /**
     *
     * @return
     */
    @Override
    public LayoutTypes getTypes() {
        return LayoutTypes.NewFeedItemHeader;
    }

    /**
     *
     * @param view
     * @return
     */
    @Override
    protected BaseViewHolder onCreateViewHolder(View view) {
        return new NewsItemHeaderHolder(view);
    }

    public int getId() {
        return mId;
    }

    public String getProfilePhoto() {
        return mProfilePhoto;
    }

    public String getProfileName() {
        return mProfileName;
    }

    public String getRepostProfileName() {
        return mRepostProfileName;
    }

    public boolean isIsRepost() {
        return mIsRepost;
    }
}
