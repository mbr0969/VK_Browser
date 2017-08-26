package su.pushnoe.vk.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import su.pushnoe.vk.CurrentUser;
import su.pushnoe.vk.mvp.view.MainView;

/**
 *
 */
@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    /**
     *
     */
    public void checkAuth(){
        if (!CurrentUser.isAuthorized()){
            getViewState().startSignIn();
        }else {
            getViewState().signedId();
        }
    }
}
