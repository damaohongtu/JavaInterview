package JavaDemo.OutofMemoryTest;

import java.nio.ByteBuffer;

/**
 * @Author MaoTian
 * @Classname DirectBufferMemoryDemo，
 * @Description 主要是nio干翻的,零拷贝问题，不属于GC管辖  ByteBuffer.allocateDirect(capability)
 * rt.jar  ----> VM.class
 * -XX:MaxDirectMemorySize=5m
 * @Date 下午11:32 2019/8/12
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class DirectBufferMemoryDemo {
    public static void main(String[] args) {
        System.out.println("MaxDirectMemory:"+sun.misc.VM.maxDirectMemory()/(double)1024/1024+"MB");
        ByteBuffer byteBuffer=ByteBuffer.allocateDirect(6*1024*1024);
    }
}
