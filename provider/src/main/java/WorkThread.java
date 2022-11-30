import com.wan.entity.RPCRequest;
import com.wan.entity.RPCResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.Map;
import lombok.AllArgsConstructor;

/**
 * @author wan
 * @Description:
 * @date 2022/11/30 15:16
 */
@AllArgsConstructor
public class WorkThread implements Runnable{
    private Socket socket;
    private ServiceProvider serviceProvider;
    @Override
    public void run() {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            RPCRequest rpcRequest = (RPCRequest)objectInputStream.readObject();
            objectOutputStream.writeObject(getResponse(rpcRequest));
            objectOutputStream.flush();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("从io中读取数据失败");
        }
    }
    private RPCResponse getResponse(RPCRequest rpcRequest) {
        String interfaceName = rpcRequest.getIntefaceName();
        Object service = serviceProvider.getService(interfaceName);
        try {
            Method method = service.getClass().getMethod(rpcRequest.getMethedName(), rpcRequest.getParamTypes());
            Object invoke = (Object) method.invoke(service, rpcRequest.getParams());
            return RPCResponse.success(invoke);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
            return RPCResponse.fail();
        }
    }
}
