import com.wan.entity.RPCRequest;
import com.wan.entity.RPCResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ProtocolException;
import java.net.Socket;
import javax.xml.ws.Response;
import lombok.AllArgsConstructor;

/**
 * @author wan
 * @Description:
 * @date 2022/11/30 16:24
 */
@AllArgsConstructor
public class SimpleRPCClient implements RPCClient{
    private String host;
    private int port;
    @Override
    public RPCResponse sendRequest(RPCRequest request) {
        try {
            Socket socket = new Socket(host, port);
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            System.out.println(request);
            objectOutputStream.writeObject(request);
            objectOutputStream.flush();
            RPCResponse rpcResponse = (RPCResponse) objectInputStream.readObject();
            return rpcResponse;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
