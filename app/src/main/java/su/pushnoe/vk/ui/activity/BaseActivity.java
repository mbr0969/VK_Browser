package su.pushnoe.vk.ui.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.arellomobile.mvp.MvpAppCompatActivity;

import javax.inject.Inject;

import su.pushnoe.vk.MyApplication;
import su.pushnoe.vk.R;
import su.pushnoe.vk.common.manager.MyFragmentManager;
import su.pushnoe.vk.ui.fragment.BaseFragment;

/**
 * Класс базового Активити
 */
public abstract class BaseActivity extends MvpAppCompatActivity {

    @Inject
    MyFragmentManager myFragmentManager;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        MyApplication.getApplicationComponent().inject(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FrameLayout parent = (FrameLayout) findViewById(R.id.main_wrapper);
        getLayoutInflater().inflate(getMainContentLayout(),parent);
    }

    @LayoutRes
    protected abstract int getMainContentLayout();

    public void fragmentOnScreen(BaseFragment baseFragment){
        setToolbarTitle(baseFragment.createToolbarTitle(this));
    }

    //Meтод устанвоки заголовка
    private void setToolbarTitle(String title){
        if (getSupportActionBar() !=null){
            getSupportActionBar().setTitle(title);
        }
    }

    public void setContent(BaseFragment fragment){
        myFragmentManager.setFragment(this,fragment, R.id.main_wrapper);

    }

    //установка дополнительных фрагментов
    public void addContent(BaseFragment fragment){
        myFragmentManager.addFragment(this,fragment, R.id.main_wrapper);
    }

    //Удаление фрагментов
    public boolean removeCurrentFragment(){
        return myFragmentManager.removeCurrentFragment(this);
    }

    public boolean removeFragment(BaseFragment fragment){
        return myFragmentManager.removeFragment(this,fragment);
    }


    @Override
    public void onBackPressed(){
        removeCurrentFragment();
    }
}
