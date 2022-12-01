import com.wan.entity.User;
import com.wan.service.UserService;

/**
 * @author wan
 * @Description:
 * @date 2022/11/30 16:38
 */
public class TestClient {
    public static void main(String[] args) {
        // 构建一个使用java Socket传输的客户端
        NettyRPCClient nettyRPCClient = new NettyRPCClient("127.0.0.1", 8899);
        // 把这个客户端传入代理客户端
        RPCClientProxy rpcClientProxy = new RPCClientProxy(nettyRPCClient);
        // 代理客户端根据不同的服务，获得一个代理类， 并且这个代理类的方法以或者增强（封装数据，发送请求）
        UserService userService = rpcClientProxy.getProxy(UserService.class);
        // 调用方法
        User userByUserId = userService.getUserByUserId(10);
    }
}
