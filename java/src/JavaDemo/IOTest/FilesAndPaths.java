package JavaDemo.IOTest;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author MaoTian
 * @Classname FilesAndPaths
 * @Description Files and Paths
 * @Date 上午9:16 2019/8/8
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class FilesAndPaths {
    public static void main(String[] args) throws IOException {
        Path path=Paths.get("./..///java/src/JavaDemo/paths_files").normalize();
        //normalize()
        String s1=path.toAbsolutePath().normalize().toString();
        System.out.println(s1);
        try {
            if(!Files.exists(path))
                Files.createFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(Files.getLastModifiedTime(path));
        System.out.println(Files.size(path));
        System.out.println(Files.isSymbolicLink(path));
        System.out.println(Files.isDirectory(path));
        System.out.println(Files.readAttributes(path, "*"));

        System.out.println("======================================================");
        //遍历一个文件夹
        Path dir = Paths.get("./..///java/src/JavaDemo/IOTest");
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir)){
            for(Path e : stream){
                System.out.println(e.getFileName());
            }
        }catch(IOException e){
        }
        //遍历整个文件目录
        List<Path> result = new LinkedList<Path>();
        Files.walkFileTree(path, new FindJavaVisitor(result));
        System.out.println("======================================================");
        System.out.println("result.size()=" + result.size());
    }
    private static class FindJavaVisitor extends SimpleFileVisitor<Path>{
        private List<Path> result;
        public FindJavaVisitor(List<Path> result){
            this.result = result;
        }
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs){
            if(file.toString().endsWith(".java")){
                result.add(file.getFileName());
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
