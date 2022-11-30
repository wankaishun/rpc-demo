import com.wan.entity.RPCRequest;
import com.wan.entity.RPCResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author wan
 * @Description:
 * @date 2022/11/30 14:23
 */
public class IOClient {
    public static RPCResponse sendRequest(String host, int port, RPCRequest rpcRequest) {
        try {
            Socket socket = new Socket(host, port);
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            System.out.println(rpcRequest);
            objectOutputStream.writeObject(rpcRequest);
            objectOutputStream.flush();
            RPCResponse rpcResponse = (RPCResponse) objectInputStream.readObject();
            return rpcResponse;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
