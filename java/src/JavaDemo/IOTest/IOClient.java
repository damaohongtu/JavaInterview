package JavaDemo.IOTest;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @Classname IOClient
 * @Description 客户端
 * @Date 19-7-7 下午2:50
 * @Created by mao<tianmao818@qq.com>
 */
public class IOClient {
    public static void main(String[] args) {
        // 开启一个线程
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 3333);
                while (true) {
                    try {
                        socket.getOutputStream().write((new Date() + ": hello world").getBytes());
                        Thread.sleep(2000);
                    } catch (Exception e) {
                    }
                }
            } catch (IOException e) {
            }
        }).start();

    }
}
