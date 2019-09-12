//package RedisTest;
//
//import redis.clients.jedis.Jedis;
//
//import java.util.Iterator;
//import java.util.List;
//import java.util.Set;
//
///**
// * @Classname RedisJava
// * @Description TODO
// * @Date 19-7-4 下午5:16
// * @Created by mao<tianmao818@qq.com>
// */
//public class RedisJava {
//    public static void main(String[] args) {
//        //连接本地的 Redis 服务
//        Jedis jedis = new Jedis("127.0.0.1");
//        System.out.println("连接成功");
//        //查看服务是否运行
//        System.out.println("服务正在运行: "+jedis.ping());
//
//        //设置 redis 字符串数据
//        jedis.set("jun", "1996-03-5");
//        // 获取存储的数据并输出
//        System.out.println("redis 存储的字符串为: "+ jedis.get("jun"));
//
//        for(Integer i=0;i<233;i++){
//            jedis.lpush("numbers",i.toString());
//        }
//
//
//        // 获取存储的数据并输出
//        List<String> list = jedis.lrange("site-list", 0 ,2);
//        for(int i=0; i<list.size(); i++) {
//            System.out.println("列表项为: "+list.get(i));
//        }
//
//
//        // 获取数据并输出
//        Set<String> keys = jedis.keys("*");
//        Iterator<String> it=keys.iterator() ;
//        while(it.hasNext()){
//            String key = it.next();
//            System.out.println(key);
//        }
//
//    }
//}
