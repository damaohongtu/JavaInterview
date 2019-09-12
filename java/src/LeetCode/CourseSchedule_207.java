package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname CourseSchedule_207
 * @Description 有先验课程,判断可以完成的课程
 * 思路:使用的是邻接矩阵
 * @Date 19-5-21 上午9:56
 * @Created by mao<tianmao818@qq.com>
 */

public class CourseSchedule_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];

        for (int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<Integer>();

        //建立邻接表
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            //找到一个环路,就完成不了课程
            if (hasLoop(graph, visited, i))
                return false;
        }
        return true;
    }

    private boolean hasLoop(List<Integer>[] graph, int[] visited, int course) {
        visited[course] = 1;

        for (int depend : graph[course]) {

            //课程
            if (visited[depend] == 1)
                return true;
            else if (visited[depend] == 0) {
                if (hasLoop(graph, visited, depend))
                    return true;
            }
        }
        visited[course] = 2;
        return false;
    }
}
