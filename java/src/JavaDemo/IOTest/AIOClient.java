package JavaDemo.IOTest;

/**
 * @Author MaoTian
 * @Classname AIOClient
 * @Description TODO
 * @Date 下午10:09 2019/8/7
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class AIOClient {

    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
        AsynchronousSocketChannel client = AsynchronousSocketChannel.open();
        Future<Void> future = client.connect(new InetSocketAddress("127.0.0.1", 9001));

        //阻塞，获取连接
        future.get();

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //读数据
        client.read(buffer, null, new CompletionHandler<Integer, Void>() {
            //成功时调用
            @Override
            public void completed(Integer result, Void attachment) {
                System.out.println(new String(buffer.array()));
            }
            //失败时调用
            @Override
            public void failed(Throwable exc, Void attachment) {
                System.out.println("客户端接收消息失败");
            }
        });

        ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
        writeBuffer.put("我是客户端，服务端你好".getBytes());
        writeBuffer.flip();

        //阻塞方法
        Future<Integer> write = client.write(writeBuffer);
        Integer r = write.get();
        if(r>0){
            System.out.println("客户端消息发送成功");
        }

        //休眠线程
        TimeUnit.SECONDS.sleep(1000L);

    }
}
