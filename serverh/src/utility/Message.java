package utility;

import java.io.Serializable;

public class Message implements Serializable {

    private MessageType messageType;

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public MessageType getMessageType() {
        return messageType;
    }
}
