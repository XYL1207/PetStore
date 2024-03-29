package dict;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        IDict localDict = new LocalDict();
        IDict baiduDict = new BaiduDict();
        Scanner sc = new Scanner(System.in);
        System.out.println("输入单词：");
        String word=sc.nextLine();
        //String value=dict.get(user);

        String res = localDict.translate(word);
        if(res==null){
            res = baiduDict.translate(word);
        }
        System.out.println(res);
    }
}
