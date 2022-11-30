import com.sun.deploy.net.proxy.ProxyHandler;
import com.wan.entity.RPCRequest;
import com.wan.entity.RPCResponse;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import lombok.AllArgsConstructor;

/**
 * @author wan
 * @Description:
 * @date 2022/11/30 16:43
 */
@AllArgsConstructor
public class RPCClientProxy implements InvocationHandler {
    private RPCClient rpcClient;


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RPCRequest request = RPCRequest.builder().intefaceName(method.getDeclaringClass().getName())
                .methedName(method.getName())
                .params(args)
                .paramTypes(method.getParameterTypes())
                .build();
        // 数据传输
        RPCResponse response = rpcClient.sendRequest(request);
        return response.getData();
    }
    public <T> T getProxy(Class<T> clazz) {
        Object object = (Object) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, this);
        return (T)object;
    }
}
