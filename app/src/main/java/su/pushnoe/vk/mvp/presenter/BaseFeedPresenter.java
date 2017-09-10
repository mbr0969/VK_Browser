package su.pushnoe.vk.mvp.presenter;


import com.arellomobile.mvp.MvpPresenter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import io.realm.Realm;
import io.realm.RealmObject;
import su.pushnoe.vk.common.manager.NetworkManager;
import su.pushnoe.vk.model.view.BaseViewModel;
import su.pushnoe.vk.mvp.view.BaseFeedView;

public abstract class BaseFeedPresenter<V extends BaseFeedView> extends MvpPresenter<V> {

    public static final int START_PAGE_SIZE = 15;
    public static final int NEXT_PAGE_SIZE = 15;

    private boolean mIsInLoading;
    @Inject
    NetworkManager mNetworkManager;

    public void loadData(ProgressType progressType, int offset, int count){

        if (mIsInLoading){
            return;
        }
        mIsInLoading = true;

        mNetworkManager.getNetworkObservable()
                .flatMap(aBoolean -> {
                   if (!aBoolean && offset > 0){
                        return Observable.empty();
                   }
                   return aBoolean
                           ? onCreateLoadDataObservable(count,offset)
                           : onCreateRestoreDataObservable();
                })


                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> {
                    onLoadStart(progressType);
              })
                .doFinally(()-> {onLoadingFinish(progressType);
              })
                .subscribe(repositories ->{
                    onLoadingSuccess(progressType,repositories);
                }, error -> {
                    error.printStackTrace();;
                    onLoadingFailed(error);
                });



    }

    public abstract Observable<BaseViewModel> onCreateLoadDataObservable(int count, int offset);

    public enum ProgressType{
        Resreshing,ListProgress,Paging
    }

    public void showProgress(ProgressType progressType){
        switch (progressType){
            case Resreshing:
                getViewState().showRefreshing();
                break;
            case ListProgress:
                getViewState().showListProgress();
                break;
        }
    }

    public void hideProgress(ProgressType progressType){

        switch (progressType){
            case Resreshing:
                getViewState().hiderRefreshing();
                break;
            case ListProgress:
                getViewState().hideListProgress();;
                break;
        }
    }

    public void loadStart(){
        loadData(ProgressType.ListProgress, 0, START_PAGE_SIZE);
    }

    public void loasNext(int offset){
        loadData(ProgressType.Paging, offset, NEXT_PAGE_SIZE);
    }

    public void loadRefresh(){
        loadData(ProgressType.Resreshing, 0, START_PAGE_SIZE);
    }

    public void onLoadStart(ProgressType progressType){
        showProgress(progressType);
    }

    public void onLoadingFinish(ProgressType progressType){
        mIsInLoading = false;
        hideProgress(progressType);
    }

    public void onLoadingFailed(Throwable throwable){
        getViewState().showError(throwable.getMessage());
    }

    public void onLoadingSuccess(ProgressType progressType, List<BaseViewModel> items){
        if (progressType == ProgressType.Paging){
            getViewState().addtItems(items);

        }else {
            getViewState().setItems(items);
        }
    }

    public void saveToDb(RealmObject item){
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(realm1 -> {realm1.copyToRealmOrUpdate(item);});
    }

    public  abstract Observable<BaseViewModel> onCreateRestoreDataObservable();



}
