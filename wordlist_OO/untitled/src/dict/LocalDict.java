package dict;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;


public class LocalDict implements IDict {


    @Override
    public String translate(String word) throws IOException {
            Dictionary<String,String> dict = new Hashtable<>();
            FileReader fis = new FileReader("/Users/xyl/Library/Mobile Documents/com~apple~CloudDocs/Personal/06 Java Programming Language/wordlist_memory/src/words.txt");
            BufferedReader buf = new BufferedReader(fis);
            String str;
            while(buf.ready()){
                str = buf.readLine() ;	// 读取一行数据
                String[] str1=str.split("\t");
                if(str1.length==2){
                    dict.put(str1[0],str1[1]);
                }
            }

//            Scanner sc = new Scanner(System.in);
//        System.out.println("输入单词：");
//        String user=sc.nextLine();
       String value=dict.get(word);
        if(value!=null){
            //System.out.println(value);
        }else {
            System.out.println("查询失败");
        }
//            while(true){
//                System.out.println("输入单词：");
//                String user=sc.nextLine();
//                String value=dict.get(user);
//                if(value!=null){
//                    System.out.println(value);
//                }else {
//                    System.out.println("没有此单词");
//                }
//                System.out.println("是否继续：（y/n）");
//                if(sc.nextLine().equals("n")){
//                    break;
//                }
//                return value;
//            }

        //return value;
        //return str;
        return value;
    }
    }

