package JianZhiOffer;/**
 * @Classname FindInMatrix
 * @Description 在数组中查找一个数字,采用右上角或者左下角作为分界点
 * @Date 19-3-2 下午1:08
 * @Created by mao<tianmao818@qq.com>
 */
public class FindInMatrix {
    public boolean find(int[][] matrix,int target){
        int rows=matrix.length;
        int cols=matrix[0].length;
        if(rows<=0||cols<=0){
            return false;
        }
        int row=0;
        int col=cols-1;
        while (row<rows && col>=0){
            if(matrix[row][col]==target){
                return true;
            }
            if(matrix[row][col]>target){
                col--;
            }else {
                row++;
            }
        }
        return false;
    }
    public static void main(String[] args){
        FindInMatrix findInMatrix=new FindInMatrix();
        int[][] matrix={{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        int target=5;
        System.out.println(findInMatrix.find(matrix,target));
    }
}