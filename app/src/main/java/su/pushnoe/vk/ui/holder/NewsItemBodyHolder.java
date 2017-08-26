package su.pushnoe.vk.ui.holder;


import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import su.pushnoe.vk.MyApplication;
import su.pushnoe.vk.R;
import su.pushnoe.vk.model.view.NewsItemBobyViewModel;

/**
 *
 */
public class NewsItemBodyHolder extends BaseViewHolder<NewsItemBobyViewModel> {
    private TextView mText;
    private TextView tvAttachments;
    @Inject
    protected Typeface mFontGoogle;

    /**
     *
     * @param itemView
     */

    public NewsItemBodyHolder(View itemView) {
        super(itemView);
        MyApplication.getApplicationComponent().inject(this);

        mText = (TextView) itemView.findViewById(R.id.tv_text);
        tvAttachments = (TextView) itemView.findViewById(R.id.tv_attachments);

        if (tvAttachments != null){
            tvAttachments.setTypeface(mFontGoogle);
        }

    }

    /**
     *
     * @param item
     */

    @Override
    public void bindViewHolder(NewsItemBobyViewModel item) {
        mText.setText(item.getText());
        tvAttachments.setText(item.getmAttachmentString());


    }

    /**
     *
     */
    @Override
    public void unbindViewHolder() {
        mText.setText(null);
        tvAttachments.setText(null);
    }


}
