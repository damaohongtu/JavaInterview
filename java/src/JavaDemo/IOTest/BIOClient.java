package JavaDemo.IOTest;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Date;

/**
 * @Author MaoTian
 * @Classname BIOClient
 * @Description TODO
 * @Date 下午9:23 2019/8/7
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class BIOClient {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    Socket socket = new Socket("127.0.0.1", 3333);
                    try {
                        socket.getOutputStream().write((new Date() + ": hello world :"+ finalI).getBytes());
                        int len;
                        byte[] data = new byte[1024];
                        InputStream inputStream = socket.getInputStream();
                        // 按字节流方式读取数据
                        while ((len = inputStream.read(data)) != -1) {
                            System.out.println(new String(data, 0, len));
                        }

                        Thread.sleep(5000);
                    } catch (Exception e) {
                    }finally {
                        socket.close();
                    }
                } catch (IOException e) {
                }
            }).start();
        }
    }
}
