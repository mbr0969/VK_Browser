package su.pushnoe.vk.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import su.pushnoe.vk.MyApplication;
import su.pushnoe.vk.R;
import su.pushnoe.vk.common.BaseAdapter;
import su.pushnoe.vk.common.utils.VKListHelper;
import su.pushnoe.vk.model.WallItem;
import su.pushnoe.vk.model.view.BaseViewModel;
import su.pushnoe.vk.model.view.NewsItemdBobyViewModel;
import su.pushnoe.vk.model.view.NewsItemHeaderViewModel;
import su.pushnoe.vk.rest.api.WallApi;
import su.pushnoe.vk.rest.module.request.WallGetRequestModel;
import su.pushnoe.vk.rest.module.response.WallGetResponse;

/**
 *Класс фрагмета новостей
 */
public class NewsFeedFragment extends BaseFragment {

    @Inject
    WallApi mWallApi;

    RecyclerView mRecyclerView;
    BaseAdapter mBaseAdapter;

    /**
     *
     */
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

        mWallApi.get(new WallGetRequestModel(-86529522).toMap()).enqueue(new Callback<WallGetResponse>() {

            @Override
            public void onResponse(Call<WallGetResponse> call, Response<WallGetResponse> response) {

                List<WallItem> wallItems = VKListHelper.getWallList(response.body().response );
                List<BaseViewModel> list = new ArrayList<>();

                for (WallItem item : wallItems){
                    list.add(new NewsItemHeaderViewModel(item));
                    list.add(new NewsItemdBobyViewModel(item));
                }

                mBaseAdapter.addItems(list);
                Toast.makeText(getActivity(), "Likes: "+ response.body().response.getItems().get(0)
                        .getLikes().getCount(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<WallGetResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    /**
     *
     * @return
     */
    @Override
    protected int getMainContentLayout() {
        return R.layout.fragment_feed;
    }

    /**
     *
     * @return
     */
    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_news;
    }

    /**
     *
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpRecyclerView(view);
        setUpAdapter(mRecyclerView);
    }

    /**
     *
     * @param rootView
     */
    private void setUpRecyclerView(View rootView){
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rv_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    /**
     *
     * @param recyclerView
     */
    private void setUpAdapter(RecyclerView recyclerView){
        mBaseAdapter = new BaseAdapter();
        recyclerView.setAdapter(mBaseAdapter);
    }
}
