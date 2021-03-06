package su.pushnoe.vk.common.manager;

import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;

import java.util.Stack;

import su.pushnoe.vk.ui.activity.BaseActivity;
import su.pushnoe.vk.ui.fragment.BaseFragment;

/**
 *
 */
public class MyFragmentManager  {
    private static final int EMPTY_FRAGMENT_STACK_SIZE = 1;

    private Stack<BaseFragment> mFragmentStack = new Stack<>();
    private BaseFragment mCurrentFragment;

    /**
     *установка корневого фрагмента
     * @param activity
     * @param fragment
     * @param containerid
     */
    public void setFragment(BaseActivity activity, BaseFragment fragment, @IdRes int containerid){

        if (activity != null && !activity.isFinishing() && !isAlreadyContains(fragment)){

            FragmentTransaction fragmentTransaction = createAddTransaction(activity,fragment,false);
            fragmentTransaction.replace(containerid,fragment);
            commitAddTransaction(activity,fragment,fragmentTransaction,false);
        }

    }

    /**
     * добавление фрагмента поверх коневого
     * @param activity
     * @param fragment
     * @param containerid
     */
    public void addFragment(BaseActivity activity,  BaseFragment fragment, @IdRes int containerid ){

        if (activity !=null && !activity.isFinishing() && !isAlreadyContains(fragment)){
            FragmentTransaction fragmentTransaction = createAddTransaction(activity,fragment,true);
            fragmentTransaction.add(containerid, fragment);
            commitAddTransaction(activity,fragment,fragmentTransaction,true);
        }

    }

    /**
     *Удаление фрагмента
     * @param activity
     * @param fragment
     * @return
     */
    public boolean removeFragment(BaseActivity activity, BaseFragment fragment){

        boolean canRemove = fragment !=null && mFragmentStack.size() > EMPTY_FRAGMENT_STACK_SIZE;

        if (canRemove){
            FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();

            mFragmentStack.pop();
            mCurrentFragment = mFragmentStack.lastElement();

            transaction.remove(fragment);
            commitTransaction(activity,transaction);
        }
        return canRemove;
    }

    /**
     *Ужадение текущего фрагмента
     * @param activity
     * @return
     */
    public boolean removeCurrentFragment(BaseActivity activity){
        return removeFragment(activity,mCurrentFragment);
    }



    private FragmentTransaction createAddTransaction(BaseActivity activity,BaseFragment fragment,
                                                     boolean addToBackStack){
        FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();

        if (addToBackStack){
            fragmentTransaction.addToBackStack(fragment.getTag());
        }
        return  fragmentTransaction;
    }


    private void commitAddTransaction(BaseActivity activity, BaseFragment fragment, FragmentTransaction transaction,
                                      boolean addToBackStack){
        if (transaction != null){
            mCurrentFragment = fragment;

            if (!addToBackStack){
                mFragmentStack = new Stack<>();
            }

        mFragmentStack.add(fragment);
        commitTransaction(activity, transaction);
        }
    }

    private void commitTransaction(BaseActivity activity, FragmentTransaction transaction){
        transaction.commit();
        activity.fragmentOnScreen(mCurrentFragment);
    }

    /**
     *
     * @param baseFragment
     * @return
     */
    public boolean isAlreadyContains(BaseFragment baseFragment){
        if (baseFragment == null){
            return  false;
        }
        return mCurrentFragment != null && mCurrentFragment.getClass().getName().equals(
                    baseFragment.getClass().getName());
    }


}
