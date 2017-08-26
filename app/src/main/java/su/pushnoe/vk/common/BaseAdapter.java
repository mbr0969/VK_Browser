package su.pushnoe.vk.common;

import android.support.v7.widget.RecyclerView;
import android.support.v4.util.ArrayMap;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import su.pushnoe.vk.model.view.BaseViewModel;
import su.pushnoe.vk.ui.holder.BaseViewHolder;

/**
 * Класс базовго адаптера
 */
public class BaseAdapter extends RecyclerView.Adapter<BaseViewHolder<BaseViewModel>> {

    private List<BaseViewModel> list = new ArrayList<>();
    private ArrayMap<Integer, BaseViewModel> mTypeInstances = new ArrayMap<>();


    /**
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public BaseViewHolder<BaseViewModel> onCreateViewHolder(ViewGroup parent, int viewType) {
        return mTypeInstances.get(viewType).createViewHolder(parent);
    }

    /**
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(BaseViewHolder<BaseViewModel> holder, int position) {
        holder.bindViewHolder(getItem(position));
    }


    /**
     *
     * @param holder
     */
    @Override
    public void onViewRecycled(BaseViewHolder<BaseViewModel> holder) {
        super.onViewRecycled(holder);
        holder.unbindViewHolder();
    }

    /**
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        return getItem(position).getTypes().getValue();
    }

    /**
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return list.size();
    }

    BaseViewModel getItem(int position){
        return list.get(position);
    }


    /**
     *
     * @param item
     */
    public void registerTypeInstance(BaseViewModel item){

        if (!mTypeInstances.containsKey(item.getTypes().getValue())){
            mTypeInstances.put(item.getTypes().getValue(), item);
        }
    }

    /**
     *
     * @param newItems
     */
    public void addItems(List<? extends BaseViewModel> newItems){
        for (BaseViewModel newItem: newItems){
            registerTypeInstance(newItem);
        }

        list.addAll(newItems);
        notifyDataSetChanged();
    }

    /**
     *
     * @param items
     */
    public void setItems(List<BaseViewModel> items){
        clearList();
        addItems(items);
    }

    /**
     *
     */
    public void clearList(){
        list.clear();
    }
}
