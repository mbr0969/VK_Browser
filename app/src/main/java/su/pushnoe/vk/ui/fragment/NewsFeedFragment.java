package su.pushnoe.vk.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import su.pushnoe.vk.MyApplication;
import su.pushnoe.vk.R;
import su.pushnoe.vk.common.utils.VKListHelper;
import su.pushnoe.vk.model.WallItem;
import su.pushnoe.vk.model.view.BaseViewModel;
import su.pushnoe.vk.model.view.NewsItemBobyViewModel;
import su.pushnoe.vk.model.view.NewsItemFooterViewModel;
import su.pushnoe.vk.model.view.NewsItemHeaderViewModel;
import su.pushnoe.vk.rest.api.WallApi;
import su.pushnoe.vk.rest.module.request.WallGetRequestModel;
import su.pushnoe.vk.rest.module.response.GetWallResponse;

/**
 *Класс фрагмета новостей
 */
public class NewsFeedFragment extends BaseFeedFragment {

    @Inject
    WallApi mWallApi;

    public NewsFeedFragment() {
        // Required empty public constructor
    }

    /**
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getApplicationComponent().inject(this);
    }

    

    /**
     *
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mWallApi.get(new WallGetRequestModel(295988485).toMap()).enqueue(new Callback<GetWallResponse>() {

            @Override
            public void onResponse(Call<GetWallResponse> call, Response<GetWallResponse> response) {

                List<WallItem> wallItems = VKListHelper.getWallList(response.body().response );
                List<BaseViewModel> list = new ArrayList<>();

                for (WallItem item : wallItems){

                    list.add(new NewsItemHeaderViewModel(item));
                    list.add(new NewsItemBobyViewModel(item));
                    list.add(new NewsItemFooterViewModel(item));
                }

                mAdapter.addItems(list);
                Toast.makeText(getActivity(), "Likes: "+ response.body().response.getItems().get(0)
                        .getLikes().getCount(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<GetWallResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    /**
     *
     * @return
     */
    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_news;
    }
}
