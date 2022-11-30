import com.wan.entity.RPCRequest;
import com.wan.entity.RPCResponse;
import com.wan.entity.User;
import com.wan.service.UserService;
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
public interface RPCClient {

//        try {
//            Socket socket = new Socket("127.0.0.1", 8899);
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
//            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
//            objectOutputStream.writeInt(new Random().nextInt());
//            objectOutputStream.flush();
//            User user = (User)objectInputStream.readObject();
//            System.out.println("服务端返回的User:"+user);
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//            System.out.println("客户端启动失败");
//        }


//        ClientProxy clientProxy = new ClientProxy("127.0.0.1", 8899);
//        UserService proxy = clientProxy.getProxy(UserService.class);
//        User userByUserId = proxy.getUserByUserId(10);
//        System.out.println("从服务端得到user为:" + userByUserId);
//        User user = User.builder().userName("张三").id(100).sex(true).build();
//        Integer id = proxy.insertUserId(user);
//        System.out.println("向服务端插入数据：" + id);

        RPCResponse sendRequest(RPCRequest request);

}
