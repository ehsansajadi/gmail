package server;

import utility.Message;
import utility.user;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServerHandler {
    private Socket socket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    public static ArrayList<user> list_users = new ArrayList<>();

    ServerHandler(Socket socket, ObjectInputStream inputStream, ObjectOutputStream outputStream) {
        this.socket = socket;
        this.inputStream = inputStream;
        this.outputStream = outputStream;
    }

    public ObjectInputStream getInputStream() {
        return inputStream;
    }

    public ObjectOutputStream getOutputStream() {
        return outputStream;
    }


    void handle(Message message) throws IOException, ClassNotFoundException {
        switch (message.getMessageType()) {
            case SignIn:



                break;

            case SignUp:
                user user = (user) inputStream.readObject();
                list_users.add(user);
                FileOutputStream newUserFile = new FileOutputStream("src/store/users/"+user.getUsername()+".txt");
                ObjectOutputStream obj = new ObjectOutputStream(newUserFile);
                obj.writeObject(user);
                obj.close();
                newUserFile.close();
                break;
        }
    }
}
