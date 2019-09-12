package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @Classname WordBreakII_140
 * @Description 单词分割,形成句子
 * 思路:首先完成判断是否可以分割的函数,然后使用求深度优先搜索?ok
 * 注意:使用的是DFS的模板代码!!!
 * @Date 19-6-25 上午8:45
 * @Created by mao<tianmao818@qq.com>
 */
public class WordBreakII_140 {
    public List<String> wordBreak(String s, List<String> dict) {
        if (s == null || s.length() == 0 || dict == null) {
            return null;
        }

        List<String> ret = new ArrayList<String>();

        // 记录切割过程中生成的字母
        List<String> path = new ArrayList<String>();

        dfs2(s, dict, path, ret, 0);

        return ret;
    }

    // 我们用DFS模板来解决这个问题吧
    public void dfs2(String s, List<String> dict, List<String> path, List<String> ret, int index) {
        int len = s.length();
        if (index == len) {
            // 结束了。index到了末尾
            StringBuilder sb = new StringBuilder();
            for (String str: path) {
                sb.append(str);
                sb.append(" ");
            }
            // remove the last " "
            sb.deleteCharAt(sb.length() - 1);
            ret.add(sb.toString());
            return;
        }

        // 如果不加上这一行会超时。就是说不能break的时候，可以直接返回
        // 但这也许只是一个treak, 其实这种方法还是不大好。
        if (!iswordBreak(s.substring(index), dict)) {
            return;
        }

        for (int i =  index; i < len; i++) {
            // 注意这些索引的取值。左字符串的长度从0到len
            String left = s.substring(index, i + 1);
            if (!dict.contains(left)) {
                // 如果左字符串不在字典中，不需要继续递归
                continue;
            }

            path.add(left);
            dfs2(s, dict, path, ret, i + 1);
            path.remove(path.size() - 1);
        }
    }
    public boolean iswordBreak(String s, List<String> wordDict) {
        int len=s.length()+1;
        boolean[] res=new boolean[len];
        res[0]=true;
        for(int i=1;i<len;i++){
            for(int j=i-1;j>=0;j--){
                if(res[j]&&wordDict.contains(s.substring(j,i))){
                    res[i]=true;
                }
            }
        }
        return res[len-1];
    }

}
