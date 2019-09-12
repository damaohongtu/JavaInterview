package JavaDemo.IOTest;

/**
 * @Author MaoTian
 * @Classname AIOEchoServer
 * @Description 在AIO socket编程中，服务端通道是AsynchronousServerSocketChannel，
 * 这个类提供了一个open()静态工厂，一个bind()方法用于绑定服务端IP地址（还有端口号），
 * 另外还提供了accept()用于接收用户连接请求。在客户端使用的通道是AsynchronousSocketChannel,
 * 这个通道处理提供open静态工厂方法外，还提供了read和write方法。
 * @Date 下午10:08 2019/8/7
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.TimeUnit;


public class AIOEchoServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        AsynchronousServerSocketChannel server = AsynchronousServerSocketChannel.open().bind(new InetSocketAddress("127.0.0.1", 9001));
//异步接受请求
        server.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {
            //成功时
            @Override
            public void completed(AsynchronousSocketChannel result, Void attachment) {
                try {
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    buffer.put("我是服务端，客户端你好".getBytes());
                    buffer.flip();
                    result.write(buffer, null, new CompletionHandler<Integer, Void>(){
                        @Override
                        public void completed(Integer result, Void attachment) {
                            System.out.println("服务端发送消息成功");
                        }

                        @Override
                        public void failed(Throwable exc, Void attachment) {
                            System.out.println("发送失败");
                        }
                    });

                    ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                    result.read(readBuffer, null, new CompletionHandler<Integer, Void>() {
                        //成功时调用
                        @Override
                        public void completed(Integer result, Void attachment) {
                            System.out.println(new String(readBuffer.array()));
                        }
                        //失败时调用
                        @Override
                        public void failed(Throwable exc, Void attachment) {
                            System.out.println("读取失败");
                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            //失败时
            @Override
            public void failed(Throwable exc, Void attachment) {
                exc.printStackTrace();
            }
        });
        TimeUnit.SECONDS.sleep(1000L);
    }
}
