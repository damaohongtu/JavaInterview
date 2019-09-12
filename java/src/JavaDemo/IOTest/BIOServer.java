package JavaDemo.IOTest;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.Selector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author MaoTian
 * @Classname BIOServer
 * @Description TODO
 * @Date 下午9:23 2019/8/7
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */

class ConnectIOnHandler extends Thread{
    private Socket socket;
    public ConnectIOnHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        try{
            int len;
            byte[] data = new byte[1024];
            InputStream inputStream = socket.getInputStream();

             // 按字节流方式读取数据
            while ((len = inputStream.read(data)) != -1) {
                System.out.println(new String(data, 0, len));
            }
        } catch (IOException e) {
        }
    }
}
public class BIOServer {
    public static void main(String[] args) throws IOException {

        ExecutorService executor = Executors.newFixedThreadPool(10);//线程池
        ServerSocket serverSocket = new ServerSocket(3333);
        while(!Thread.currentThread().isInterrupted()) {//主线程死循环等待新连接到来
            Socket socket = serverSocket.accept();
            System.out.println("accept()方法是一个阻塞的方法");
            executor.submit(new ConnectIOnHandler(socket));//为新的连接创建新的线程
        }
        Selector selector;
    }
}
