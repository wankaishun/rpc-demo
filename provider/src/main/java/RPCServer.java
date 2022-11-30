import com.wan.entity.RPCRequest;
import com.wan.entity.RPCResponse;
import com.wan.entity.User;
import com.wan.service.Impl.UserServiceImpl;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author wan
 * @Description:
 * @date 2022/11/29 18:17
 */
public interface RPCServer {
//    public static void main(String[] args) {
//
//        UserServiceImpl userService = new UserServiceImpl();
//        try {
//            ServerSocket serverSocket = new ServerSocket(8899);
//            System.out.println("服务起启动了");
//            while(true) {
//                Socket socket = serverSocket.accept();
//                new Thread(() -> {
//                    try {
//                        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
//                        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
//                        RPCRequest rpcRequest = (RPCRequest) ois.readObject();
//                        Method method = userService.getClass().getMethod(rpcRequest.getMethedName(),
//                                rpcRequest.getParamTypes());
//                        Object invoke = method.invoke(userService, rpcRequest.getParams());
//                        // 写入User对象给客户端
//                        oos.writeObject(RPCResponse.success(invoke));
//                        oos.flush();
//                    } catch (IOException | ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e){
//                        e.printStackTrace();
//                        System.out.println("从IO中读取数据错误");
//                    }
//                }).start();
//
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    void start(int port);
    void stop();
}
