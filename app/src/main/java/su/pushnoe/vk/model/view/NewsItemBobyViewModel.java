package su.pushnoe.vk.model.view;

import android.view.View;

import su.pushnoe.vk.model.WallItem;
import su.pushnoe.vk.ui.holder.BaseViewHolder;
import su.pushnoe.vk.ui.holder.NewsItemBodyHolder;

/**
 * Класс просмотра новостей группы на стене
 */
public class NewsItemBobyViewModel extends BaseViewModel {

    private int mId;
    private String mText;
    private String mAttachmentString;
    private boolean mIsRepost;

    /**
     *
     * @param wallItem
     */
    public NewsItemBobyViewModel(WallItem wallItem) {
        this.mId = wallItem.getId();
        this.mIsRepost = wallItem.haveSharedRepost();

        if (mIsRepost){

            this.mText = wallItem.getSharedRepost().getText();
            this.mAttachmentString = wallItem.getSharedRepost().getAttachmentString();
        }else {
            this.mText = wallItem.getText();
            this.mAttachmentString = wallItem.getAttachmentString();
        }
    }

    /**
     *
     * @return
     */
    @Override
    public LayoutTypes getTypes() {
        return LayoutTypes.NewFeedItemBody;
    }

    /**
     *
     * @param view
     * @return
     */
    @Override
    protected BaseViewHolder onCreateViewHolder(View view) {
        return new NewsItemBodyHolder(view);
    }

    /**
     *
     * @return
     */
    public int getId() {
        return mId;
    }

    /**
     *
     * @return
     */
    public String getText() {
        return mText;
    }

    public String getmAttachmentString() {
        return mAttachmentString;
    }

    @Override
    public boolean isItemDecorator() {
        return true;
    }
}
