import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

/**
 * @author wan
 * @Description:
 * @date 2022/11/29 18:00
 */
public class RPCClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8899);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            objectOutputStream.writeInt(new Random().nextInt());
            objectOutputStream.flush();
            User user = (User)objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
