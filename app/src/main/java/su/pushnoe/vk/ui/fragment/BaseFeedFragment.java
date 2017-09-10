package su.pushnoe.vk.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import su.pushnoe.vk.R;
import su.pushnoe.vk.common.BaseAdapter;
import su.pushnoe.vk.common.manager.MyLinearLayoutManager;
import su.pushnoe.vk.model.view.BaseViewModel;
import su.pushnoe.vk.mvp.presenter.BaseFeedPresenter;
import su.pushnoe.vk.mvp.view.BaseFeedView;

/**
 *
 */
public abstract class BaseFeedFragment extends BaseFragment implements BaseFeedView{

    RecyclerView mRecyclerView;
    BaseAdapter mAdapter;
    protected SwipeRefreshLayout mSwipeRefreshLayout;
    protected ProgressBar mProgressBar;
    protected BaseFeedPresenter mBaseFeedPresenter;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setUpRecyclerView(view);
        setUpAdapter(mRecyclerView);
        setUpSwipeToRefreshLayout(view);

        mBaseFeedPresenter = onCreateFeedPresenter();
        mBaseFeedPresenter.loadStart();


    }

    private void setUpRecyclerView(View rootView) {
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.rv_list);
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        MyLinearLayoutManager mLinearLayoutManager = new MyLinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if(mLinearLayoutManager.isOnnextPagePosition()){
                    mBaseFeedPresenter.loasNext(mAdapter.getRealItemCount());
                }
            }
        });

        ((SimpleItemAnimator) mRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
    }

    protected void setUpAdapter(RecyclerView rv) {
        mAdapter = new BaseAdapter();
        rv.setAdapter(mAdapter);
    }

    @Override
    protected int getMainContentLayout() {
        return R.layout.fragment_feed;
    }

    @Override
    public int onCreateToolbarTitle() {
        return 0;
    }

    private void setUpSwipeToRefreshLayout(View rootView){
        mSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_refresh);
        mSwipeRefreshLayout.setOnRefreshListener(() ->onCreateFeedPresenter().loadRefresh());
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorAccent);
        mProgressBar = getBaseActivity().getProgressBar();
    }

    @Override
    public void showRefreshing() {

    }

    @Override
    public void hiderRefreshing() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showListProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideListProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getBaseActivity(),message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void setItems(List<BaseViewModel> items) {
        mAdapter.setItems(items);
    }

    @Override
    public void addtItems(List<BaseViewModel> items) {
        mAdapter.addItems(items);
    }

    protected abstract BaseFeedPresenter onCreateFeedPresenter();
}
