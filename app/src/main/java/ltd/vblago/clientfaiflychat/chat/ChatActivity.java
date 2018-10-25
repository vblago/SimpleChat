package ltd.vblago.clientfaiflychat.chat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.stfalcon.chatkit.commons.ImageLoader;
import com.stfalcon.chatkit.messages.MessageInput;
import com.stfalcon.chatkit.messages.MessagesList;
import com.stfalcon.chatkit.messages.MessagesListAdapter;

import java.util.ArrayList;

import ltd.vblago.clientfaiflychat.R;
import ltd.vblago.clientfaiflychat.models.model.Message;

public class ChatActivity extends AppCompatActivity implements ChatView, MessagesListAdapter.OnLoadMoreListener, MessageInput.InputListener{

    private ChatPresenter presenter;
    protected ImageLoader imageLoader;
    protected MessagesListAdapter<Message> messagesAdapter;

    private MessagesList messagesList;
    protected final String senderId = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        presenter = new ChatPresenterImpl();
        this.messagesList = findViewById(R.id.messagesList);
        initAdapter();

        MessageInput input = findViewById(R.id.input);
        input.setInputListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.setView(this);
        onLoadMore(1, 2);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.setView(null);
    }

    @Override
    public void showProgress(boolean show) {

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public boolean onSubmit(CharSequence input) {
        presenter.getMessage(input.toString());
        return true;
    }

    @Override
    public void onLoadMore(int page, int totalItemsCount) {
        presenter.getMessages(page, totalItemsCount);
    }

    @Override
    public void putOnMessages(ArrayList<Message> messages) {
        messagesAdapter.addToEnd(messages, false);
    }

    @Override
    public void submitMessageView(Message message) {
        messagesAdapter.addToStart(message, true);
    }

    private void initAdapter() {
        messagesAdapter = new MessagesListAdapter<>(senderId, imageLoader);
        messagesAdapter.setLoadMoreListener(this);
        messagesList.setAdapter(messagesAdapter);
    }
}
