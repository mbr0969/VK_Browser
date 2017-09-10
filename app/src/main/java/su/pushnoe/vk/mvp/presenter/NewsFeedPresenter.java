package su.pushnoe.vk.mvp.presenter;


import com.arellomobile.mvp.InjectViewState;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;
import su.pushnoe.vk.MyApplication;
import su.pushnoe.vk.common.utils.VKListHelper;
import su.pushnoe.vk.model.WallItem;
import su.pushnoe.vk.model.view.BaseViewModel;
import su.pushnoe.vk.model.view.NewsItemBobyViewModel;
import su.pushnoe.vk.model.view.NewsItemFooterViewModel;
import su.pushnoe.vk.model.view.NewsItemHeaderViewModel;
import su.pushnoe.vk.mvp.view.BaseFeedView;
import su.pushnoe.vk.rest.api.WallApi;
import su.pushnoe.vk.rest.module.request.WallGetRequestModel;

@InjectViewState
public class NewsFeedPresenter extends BaseFeedPresenter<BaseFeedView>{

    @Inject
    WallApi mWallApi;

    public NewsFeedPresenter(){
        MyApplication.getApplicationComponent().inject(this);
    }

    @Override
    public Observable<BaseViewModel> onCreateLoadDataObservable(int count, int offset) {
        return mWallApi.get(new WallGetRequestModel(-86529522, count,offset).toMap())
                .flatMap(full ->Observable.fromIterable(VKListHelper.getWallList(full.response)))
                .doOnNext(wallItem -> {
                    saveToDb(wallItem);
                })
                .flatMap(wallitem ->{
                    List<BaseViewModel> baseItems = new ArrayList<>();
                    baseItems.add(new NewsItemHeaderViewModel(wallitem));
                    baseItems.add(new NewsItemBobyViewModel(wallitem));
                    baseItems.add(new NewsItemFooterViewModel(wallitem));
                    return Observable.fromIterable(baseItems);
                });
    }

    public Callable<List<WallItem>> getListFromRealmCallable(){

        return () ->{
            String[] sortFields ={"date"};
            Sort[] sortOrder = {Sort.DESCENDING};
            Realm realm = Realm.getDefaultInstance();

            RealmResults<WallItem> realmResults = realm.where(WallItem.class)
                    .findAllSorted(sortFields, sortOrder);
            return  realm.copyFromRealm(realmResults);
        };
    }

    @Override
    public Observable<BaseViewModel> onCreateRestoreDataObservable() {
        return Observable.fromCallable(getListFromRealmCallable())
                .flatMap(Observable::fromIterable)
                .flatMap(wallItem -> Observable.fromIterable(parserPojoModel(wallItem)));
    }

    private List<BaseViewModel> parserPojoModel(WallItem wallItem){
        List<BaseViewModel> baseItem = new ArrayList<>();
        baseItem.add(new NewsItemHeaderViewModel(wallItem));
        baseItem.add(new NewsItemBobyViewModel(wallItem));
        baseItem.add(new NewsItemFooterViewModel(wallItem));

        return baseItem;
    }
}
