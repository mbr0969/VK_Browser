package su.pushnoe.vk.model.view.counter;

import su.pushnoe.vk.model.Likes;

/**
 * Created by papa on 26.08.17.
 */

public class LikeCounterViewModel extends CounterViewModel {
    private Likes mLikes;

    public LikeCounterViewModel(Likes likes) {
        super(likes.getCount());

        this.mLikes = likes;
        if (mLikes.getUserLikes() == 1){
            setAccentColor();
        }
    }

    public Likes getLikes(){
        return mLikes;
    }
}
