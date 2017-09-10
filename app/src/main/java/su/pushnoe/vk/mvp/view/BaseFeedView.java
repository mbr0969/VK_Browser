package su.pushnoe.vk.mvp.view;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import su.pushnoe.vk.model.view.BaseViewModel;

public interface BaseFeedView extends MvpView{

    /**
     * Поакзывем, скрываем загрузку
     */
    void showRefreshing();
    void hiderRefreshing();
    void showListProgress();
    void hideListProgress();

    void showError(String message);

    // устаовка дабавления списков
    void setItems(List<BaseViewModel> items);
    void addtItems(List<BaseViewModel> items);


}
