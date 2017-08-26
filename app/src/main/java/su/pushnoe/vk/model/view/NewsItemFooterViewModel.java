package su.pushnoe.vk.model.view;


import android.view.View;

import su.pushnoe.vk.model.WallItem;
import su.pushnoe.vk.model.view.counter.CommentCounterViewModel;
import su.pushnoe.vk.model.view.counter.LikeCounterViewModel;
import su.pushnoe.vk.model.view.counter.RepostCounterViewModel;
import su.pushnoe.vk.ui.holder.BaseViewHolder;
import su.pushnoe.vk.ui.holder.NewsItemFooterHolder;

/**
 * Created by papa on 26.08.17.
 */

public class NewsItemFooterViewModel extends BaseViewModel {

    private int mId;
    private int ownerId;
    private LikeCounterViewModel mLikes;
    private CommentCounterViewModel mComment;
    private RepostCounterViewModel mRepost;
    private long mDataLong;

    public NewsItemFooterViewModel(WallItem wallItem) {
        this.mId = wallItem.getId();
        this.ownerId = wallItem.getOwnerId();
        this.mDataLong = wallItem.getDate();
        this.mLikes = new LikeCounterViewModel(wallItem.getLikes());
        this.mComment = new CommentCounterViewModel(wallItem.getComments());
        this.mRepost = new RepostCounterViewModel(wallItem.getReposts());

    }

    @Override
    public LayoutTypes getTypes() {
        return LayoutTypes.NewFeedItemFoter;
    }

    @Override
    protected BaseViewHolder onCreateViewHolder(View view) {
        return new NewsItemFooterHolder(view);
    }

    public int getId() {
        return mId;
    }

    public long getDataLong() {
        return mDataLong;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public LikeCounterViewModel getLikes() {
        return mLikes;
    }

    public CommentCounterViewModel getComment() {
        return mComment;
    }

    public RepostCounterViewModel getRepost() {
        return mRepost;
    }

    public void setId(int mId) {
        this.mId = mId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public void setLikes(LikeCounterViewModel mLikes) {
        this.mLikes = mLikes;
    }

    public void setComment(CommentCounterViewModel mComment) {
        this.mComment = mComment;
    }

    public void setRepost(RepostCounterViewModel mRepost) {
        this.mRepost = mRepost;
    }

    public void setDataLong(long mDataLong) {
        this.mDataLong = mDataLong;
    }
}
