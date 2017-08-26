package su.pushnoe.vk.ui.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import su.pushnoe.vk.model.view.BaseViewModel;

/**
 * Базовый класс простора новостей
 * @param <Item>
 */
public abstract class BaseViewHolder<Item> extends RecyclerView.ViewHolder {

    /**
     *
     * @param itemView
     */
    public BaseViewHolder(View itemView) {
        super(itemView);
    }


    /**
     *
     * @param item
     */
    public abstract void bindViewHolder(Item item);

    //public abstract void bindViewHolder(BaseViewModel baseViewModel);

    /**
     *
     */
    public abstract void unbindViewHolder();
}
