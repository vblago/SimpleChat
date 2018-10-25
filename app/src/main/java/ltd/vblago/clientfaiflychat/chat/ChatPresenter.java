package ltd.vblago.clientfaiflychat.chat;

import ltd.vblago.clientfaiflychat.base.BasePresenter;

public interface ChatPresenter extends BasePresenter<ChatView>{
    void getMessages(int page, int totalItemsCount);
    void getMessage(String text);
}
