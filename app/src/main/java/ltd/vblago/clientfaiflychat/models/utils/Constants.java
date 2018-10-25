package ltd.vblago.clientfaiflychat.models.utils;

import ltd.vblago.clientfaiflychat.models.model.User;

public final class Constants {

    public static User getUser(){
        return new User(Integer.toString(0), "user1", "http://i.imgur.com/pv1tBmT.png", true);
    }
}
