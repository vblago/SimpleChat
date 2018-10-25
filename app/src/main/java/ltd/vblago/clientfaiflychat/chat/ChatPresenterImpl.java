package ltd.vblago.clientfaiflychat.chat;

import android.os.Handler;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.Date;

import ltd.vblago.clientfaiflychat.models.data.FixturesData;
import ltd.vblago.clientfaiflychat.models.data.MessagesFixtures;
import ltd.vblago.clientfaiflychat.models.model.Message;
import ltd.vblago.clientfaiflychat.models.utils.Constants;

public class ChatPresenterImpl implements ChatPresenter {

    private ChatView view;
    private Date lastLoadedDate;
    private static final int TOTAL_MESSAGES_COUNT = 100;

    @Override
    public void setView(@Nullable ChatView view) {
        this.view = view;
    }

    private boolean isViewSet() {
        return view != null;
    }

    @Override
    public void getMessages(int page, int totalItemsCount) {
        if (totalItemsCount >= TOTAL_MESSAGES_COUNT) return;

        new Handler().postDelayed(new Runnable() { //imitation of internet connection
            @Override
            public void run() {
                ArrayList<Message> messages = MessagesFixtures.getMessages(lastLoadedDate);
                lastLoadedDate = messages.get(messages.size() - 1).getCreatedAt();
                view.putOnMessages(messages);
            }
        }, 1000);
    }

    @Override
    public void getMessage(String text) {
        view.submitMessageView(new Message(FixturesData.getRandomId(), Constants.getUser(), text));
    }
}
