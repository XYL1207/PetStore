import javax.mail.MessagingException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.GeneralSecurityException;
//
//public class Main {
//    public static void main(String[] args) {
//        //修改url中list后面的参数可查看不同股票
//        String url = "http://hq.sinajs.cn/list=sz002308";
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(url))
//                .header("Referer", "http://finance.sina.com.cn")
//                .build();
//        try {
//            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//            String data = response.body();
//            System.out.println(data);
//            System.out.println(",分隔符返回值 :" );
//            for (String retval: data.split(",")){
//                System.out.println(retval);
//            }
//        } catch (InterruptedException | IOException e) {
//            e.printStackTrace();
//        }
//    }
//}


public class Main {
    public static void main(String[] args) throws MessagingException, GeneralSecurityException {

        new Gui().createWindow();
        /*
        String url="http://hq.sinajs.cn/list=sz002308";
        Stocks stock = new Stocks();
        while (true)
        {
            try {
                Thread.currentThread().sleep(1000);
                stock = GetData.getdatas(url);
                System.out.println(stock);
                if(stock.getRate()>0)
                {
                    System.out.println("现在涨幅为:+"+stock.getRate()+"%"+"\n");
                }
                else if (stock.getRate()<-0.2)
                {
                    System.out.println("现在为降幅:"+stock.getRate()+"%"+"\n");
                    new lab.stock.SendMessages();
                    lab.stock.SendMessages.sendMessages();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
         */
    }
}
