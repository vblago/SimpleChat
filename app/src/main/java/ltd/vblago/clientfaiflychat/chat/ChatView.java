package ltd.vblago.clientfaiflychat.chat;

import java.util.ArrayList;

import ltd.vblago.clientfaiflychat.base.BaseView;
import ltd.vblago.clientfaiflychat.models.model.Message;

public interface ChatView extends BaseView {
    void putOnMessages(ArrayList<Message> messages);
    void submitMessageView(Message message);
}
