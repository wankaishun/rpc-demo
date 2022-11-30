import com.wan.service.BlogService;
import com.wan.service.Impl.BlogServiceImpl;
import com.wan.service.Impl.UserServiceImpl;
import com.wan.service.UserService;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wan
 * @Description:
 * @date 2022/11/30 15:07
 */
public class TestServer {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        BlogService blogService = new BlogServiceImpl();
        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.provideServiceInterface(userService);
        serviceProvider.provideServiceInterface(blogService);
        RPCServer RPCServer = new SimpleRPCServer(serviceProvider);
        RPCServer.start(8899);
    }
}
