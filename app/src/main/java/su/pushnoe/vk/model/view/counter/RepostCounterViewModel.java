package su.pushnoe.vk.model.view.counter;

import su.pushnoe.vk.model.Reposts;

/**
 * Created by papa on 26.08.17.
 */

public class RepostCounterViewModel extends CounterViewModel {

    private Reposts mRepost;

    public RepostCounterViewModel(Reposts repost) {
        super(repost.getCount());
        this.mRepost = repost;

        if (mRepost.getUserReposted() == 1){
            setAccentColor();
        }
    }

    public Reposts getRepost() {
        return mRepost;
    }
}
