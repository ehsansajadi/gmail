package Model;

import utility.user;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Alluser {

    public static ArrayList<user> Alluser ;

    public static void loaduser() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("2.ser"));
        Alluser = (ArrayList<user>) objectInputStream.readObject();
        objectInputStream.close();
        for (int i = 0 ; i < Alluser.size() ; ++i)
            System.out.println(Alluser.get(i));
    }

}
