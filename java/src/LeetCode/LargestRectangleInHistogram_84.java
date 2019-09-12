package LeetCode;/**
 * @Classname LargestRectangleInHistogram_84
 * @Description 在柱装图中的最大矩阵
 * @Date 19-5-23 上午11:12
 * @Created by mao<tianmao818@qq.com>
 */
public class LargestRectangleInHistogram_84 {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        if(n==0){
            return 0;
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(i+1<n && heights[i]<heights[i+1]){
                continue;
            }
            int minH=heights[i];
            for(int j=i;j>=0;j--){
                minH=Math.min(minH,heights[j]);
                ans=Math.max(ans,minH*(i-j+1));
            }
        }
        return ans;
    }
}
