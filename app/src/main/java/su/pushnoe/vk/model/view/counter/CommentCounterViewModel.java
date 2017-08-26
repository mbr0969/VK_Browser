package su.pushnoe.vk.model.view.counter;

import su.pushnoe.vk.model.Comments;

/**
 * Created by papa on 26.08.17.
 */

public class CommentCounterViewModel extends CounterViewModel {

    private Comments mComments;


    public CommentCounterViewModel(Comments comments) {
        super(comments.getCount());

        this.mComments = comments;
    }

    public Comments getComments() {
        return mComments;
    }
}
