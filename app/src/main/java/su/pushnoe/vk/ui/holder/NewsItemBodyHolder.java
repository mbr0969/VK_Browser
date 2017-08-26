package su.pushnoe.vk.ui.holder;


import android.view.View;
import android.widget.TextView;

import su.pushnoe.vk.R;
import su.pushnoe.vk.model.view.NewsItemdBobyViewModel;

public class NewsItemBodyHolder extends BaseViewHolder<NewsItemdBobyViewModel> {
    public TextView mText;


    public NewsItemBodyHolder(View itemView) {
        super(itemView);
        mText = (TextView) itemView.findViewById(R.id.tv_text);

    }

    @Override
    public void bindViewHolder(NewsItemdBobyViewModel newsItemBobyViewModel) {
        mText.setText(newsItemBobyViewModel.getText());

    }

    @Override
    public void unbindViewHolder() {
        mText.setText(null);
    }
}
