package BiShi;

public class StringBufferTest {
    public static void main(String[] args) {
        String s="A2BB3";
        StringBuilder ss=new StringBuilder(s);
        for(int j=0;j<ss.length();j++){
            if(Character.isDigit(ss.charAt(j))&&Character.isLetter(ss.charAt(j-1))){
                ss.insert(j-1,'(');
                ss.insert(j+1,')');
            }
        }
        System.out.println(ss.toString());
    }
}
