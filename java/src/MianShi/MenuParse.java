package MianShi;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author MaoTian
 * @Classname MenuParse
 * @Description 目录解析
 * @Date 下午9:07 2019/8/11
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */

class Category{
    int id;
    int parent;
    public Category(int id,int parent){
        this.id=id;
        this.parent=parent;
    }
}
public class MenuParse {

    public List<Category>find(int parent,List<Category> info){
        List<Category> list=new ArrayList<>();
        for(Category i:info){
            if(i.parent==parent){
                list.add(i);
            }
        }
        return list;
    }
    public String getMenu(int parent,List<Category> info){
        String sonNodes="";
        List<Category> list = find(parent,info);

        for(Category cate : list){
            sonNodes+="{id: '"+cate.id+"'";

            if(!find(cate.id,info).isEmpty()){
                sonNodes+= ", nodes: ["+getMenu(cate.id,info)+"] ";

            }
            sonNodes+= "},";
        }
        return sonNodes;
    }

    public static void main(String[] args) {
        MenuParse menuParse=new MenuParse();
        List<Category> info=new ArrayList<>();
        info.add(new Category(1,0));
        info.add(new Category(2,0));
        info.add(new Category(3,0));
        info.add(new Category(4,1));
        info.add(new Category(5,1));
        info.add(new Category(6,2));
        info.add(new Category(7,2));
        info.add(new Category(8,3));
        info.add(new Category(9,3));
        info.add(new Category(10,8));
        info.add(new Category(11,8));
        System.out.println(menuParse.getMenu(0,info));

    }

}
