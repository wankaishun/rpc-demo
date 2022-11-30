import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

/**
 * @author wan
 * @Description:
 * @date 2022/11/30 15:12
 */
public class SimpleRPCServer implements RPCServer{
    // 存着服务接口名-> service对象的map
    private ServiceProvider serviceProvider;

    public SimpleRPCServer(ServiceProvider serviceProvider){
        this.serviceProvider = serviceProvider;
    }
    @Override
    public void start(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("服务端启动了");
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new WorkThread(socket, serviceProvider)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stop() {

    }
}
