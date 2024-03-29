package dict;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baidu.translate.demo.TransApi;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class BaiduDict implements IDict {
    //@Override

    // 在平台申请的APP_ID 详见 http://api.fanyi.baidu.com/api/trans/product/desktop?req=developer
    private static final String APP_ID = "20375643634538891";
    private static final String SECURITY_KEY = "dsdfgsgrsehgfxdxbbsr";

    public String translate(String word) {
        TransApi api = new TransApi(APP_ID, SECURITY_KEY);
        String data = api.getTransResult(word, "auto", "zh");
        System.out.println("本地词库没有此单词，正在调用百度翻译引擎...");
        //return "baidu";

//    public static void main(String[] args) {
//        TransApi api = new TransApi(APP_ID, SECURITY_KEY);
//
//        //Trans tran = new Tran();
//
//        System.out.print("请输入你要翻译的英文单词：");
//        Scanner sc = new Scanner(System.in);
//        String word = sc.next();
//        wordSearch ws = new wordSearch();
//        System.out.println(word+"\t"+ws.translate(word));
//
//
//        //String query = "高度600米";
//        //System.out.println(api.getTransResult(word, "auto", "en"));
//    }
        JSONObject object = JSONObject.parseObject(data);
        JSONArray array = object.getJSONArray("trans_result");
        JSONObject elem = JSONObject.parseObject(array.get(0).toString());
        String dst = elem.getString("dst");
        try {
            return URLDecoder.decode(dst, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
