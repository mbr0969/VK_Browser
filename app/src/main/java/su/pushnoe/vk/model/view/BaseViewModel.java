package su.pushnoe.vk.model.view;

import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import su.pushnoe.vk.R;
import su.pushnoe.vk.ui.holder.BaseViewHolder;

/**
 * Базовый Класс Модели View
 */
public abstract class BaseViewModel {

    public abstract LayoutTypes getTypes();


    /**
     *
     * @param parent
     * @return
     */
    public BaseViewHolder createViewHolder(ViewGroup parent){

        return onCreateViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(getTypes().getValue(), parent,false ));
    }

    /**
     *
     * @param view
     * @return
     */
    protected abstract BaseViewHolder onCreateViewHolder(View view);

    /**
     *
     */
    public enum LayoutTypes{
        NewFeedItemHeader(R.layout.item_news_header),
        NewFeedItemBody(R.layout.item_news_body),
        NewFeedItemFooter(R.layout.item_news_footer);

        private final int id;
        LayoutTypes(int resId){
            this.id = resId;
        }

        @LayoutRes
        public int getValue(){
            return id;
        }
    }

    public boolean isItemDecorator(){
        return false;
    }
}
