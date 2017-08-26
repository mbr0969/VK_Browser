package su.pushnoe.vk.ui.holder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import su.pushnoe.vk.MyApplication;
import su.pushnoe.vk.R;
import su.pushnoe.vk.common.utils.Utils;
import su.pushnoe.vk.model.view.NewsItemFooterViewModel;
import su.pushnoe.vk.model.view.counter.CommentCounterViewModel;
import su.pushnoe.vk.model.view.counter.LikeCounterViewModel;
import su.pushnoe.vk.model.view.counter.RepostCounterViewModel;

/**
 * Created by papa on 26.08.17.
 */

public class NewsItemFooterHolder extends BaseViewHolder<NewsItemFooterViewModel> {

    private TextView tvDate;
    private TextView tvLikesCount;
    private TextView tvLikesIcon;
    private TextView tvCommentsIcon;
    private TextView tvCommentsCount;
    private TextView tvRepostIcon;
    private TextView tvRepostCount;
    private Resources mResources;
    private Context mContext;
    @Inject
    Typeface mGoogleFontface;


    public NewsItemFooterHolder(View itemView) {
        super(itemView);
        MyApplication.getApplicationComponent().inject(this);

        mContext = itemView.getContext();
        mResources = itemView.getResources();

        tvDate = (TextView) itemView.findViewById(R.id.tv_date);
        tvLikesIcon = (TextView) itemView.findViewById(R.id.tv_likes_icon);
        tvLikesCount = (TextView) itemView.findViewById(R.id.tv_likes_count);
        tvCommentsIcon = (TextView) itemView.findViewById(R.id.tv_comments_icon);
        tvCommentsCount = (TextView) itemView.findViewById(R.id.tv_comments_count);
        tvRepostIcon = (TextView) itemView.findViewById(R.id.tv_reposts_icon);
        tvRepostCount = (TextView) itemView.findViewById(R.id.tv_reposts_count);

        tvLikesIcon.setTypeface(mGoogleFontface);
        tvCommentsIcon.setTypeface(mGoogleFontface);
        tvRepostIcon.setTypeface(mGoogleFontface);


    }

    @Override
    public void bindViewHolder(NewsItemFooterViewModel item) {
        tvDate.setText(Utils.parseDate(item.getDataLong(), mContext));
        bindLikes(item.getLikes());
        bindComments(item.getComment());
        bindRepost(item.getRepost());
    }

    /**
     *
     * @param likes
     */
    private void bindLikes(LikeCounterViewModel likes){
        tvLikesCount.setText(String.valueOf(likes.getCount()));
        tvLikesCount.setTextColor(mResources.getColor(likes.getTextColor()));
        tvLikesIcon.setTextColor(mResources.getColor(likes.getIconColor()));
    }

    /**
     *
     * @param comment
     */
    private void bindComments(CommentCounterViewModel comment){
        tvCommentsCount.setText(String.valueOf(comment.getCount()));
        tvCommentsCount.setTextColor(mResources.getColor(comment.getTextColor()));
        tvCommentsIcon.setTextColor(mResources.getColor(comment.getIconColor()));
    }

    /**
     *
     * @param repost
     */
    private void bindRepost(RepostCounterViewModel repost){
        tvRepostCount.setText(String.valueOf(repost.getCount()));
        tvRepostCount.setTextColor(mResources.getColor(repost.getTextColor()));
        tvRepostIcon.setTextColor(mResources.getColor(repost.getIconColor()));
    }

    @Override
    public void unbindViewHolder() {

        tvDate.setText(null);
        tvLikesCount.setText(null);
        tvCommentsCount.setText(null);
        tvRepostCount.setText(null);

    }
}
