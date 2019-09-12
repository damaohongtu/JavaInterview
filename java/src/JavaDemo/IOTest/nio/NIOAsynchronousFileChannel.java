package JavaDemo.IOTest.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

/**
 * @Author MaoTian
 * @Classname NIOAsynchronousFileChannel
 * @Description 异步文件通道
 * @Date 下午10:25 2019/8/7
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class NIOAsynchronousFileChannel {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("/home/mao/workspace/java/src/JavaDemo/IOTest/nio/test");

        AsynchronousFileChannel fileChannel_1 = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
        ByteBuffer buffer_1 = ByteBuffer.allocate(1024);

        long position_1 = 0;

        //(1)通过Future读取数据（Reading Data Via a Future）
        Future<Integer> operation = fileChannel_1.read(buffer_1, position_1);

        while(!operation.isDone());

        buffer_1.flip();
        byte[] data = new byte[buffer_1.limit()];
        buffer_1.get(data);
        System.out.println(new String(data));
        buffer_1.clear();
        //(2)通过CompletionHandler读取数据（Reading Data Via a CompletionHandler）
        System.out.println("===================================================");
        AsynchronousFileChannel fileChannel_2 = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
        ByteBuffer buffer_2 = ByteBuffer.allocate(1024);
        long position_2 = 0;

        fileChannel_2.read(buffer_2, position_2, buffer_2, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                System.out.println("result = " + result);

                attachment.flip();
                byte[] data = new byte[attachment.limit()];
                attachment.get(data);
                System.out.println(new String(data));
                attachment.clear();
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {

            }
        });

        //通过Future写数据（Writing Data Via a Future）

        Path path_3 = Paths.get("/home/mao/workspace/java/src/JavaDemo/IOTest/nio/test_3");
        if(!Files.exists(path_3)){
            Files.createFile(path_3);
        }
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);

        ByteBuffer buffer_3 = ByteBuffer.allocate(1024);
        long position_3 = 0;

        buffer_3.put("test data".getBytes());
        buffer_3.flip();

        Future<Integer> operation3 = fileChannel.write(buffer_3, position_3);
        buffer_3.clear();

        while(!operation.isDone());

        System.out.println("Write done");


        Path path_4 = Paths.get("/home/mao/workspace/java/src/JavaDemo/IOTest/nio/test_4");
        if(!Files.exists(path_4)){
            Files.createFile(path_4);
        }
        AsynchronousFileChannel fileChannel_4 = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);

        ByteBuffer buffer_4 = ByteBuffer.allocate(1024);
        long position_4 = 0;

        buffer_4.put("test data".getBytes());
        buffer_4.flip();

        fileChannel.write(buffer_4, position_4, buffer_4, new CompletionHandler<Integer, ByteBuffer>() {

            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                System.out.println("bytes written: " + result);
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                System.out.println("Write failed");
                exc.printStackTrace();
            }
        });

    }
}
