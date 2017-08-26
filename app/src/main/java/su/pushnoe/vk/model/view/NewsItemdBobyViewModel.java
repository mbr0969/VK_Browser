package su.pushnoe.vk.model.view;

import android.view.View;

import su.pushnoe.vk.model.WallItem;
import su.pushnoe.vk.ui.holder.BaseViewHolder;
import su.pushnoe.vk.ui.holder.NewsItemBodyHolder;

/**
 * Класс просмотра новостей группы на стене
 */
public class NewsItemdBobyViewModel extends BaseViewModel {

    private int mId;
    private String mText;

    /**
     *
     * @param wallItem
     */
    public NewsItemdBobyViewModel(WallItem wallItem) {
        this.mId = wallItem.getId();
        this.mText = wallItem.getText();
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
}
