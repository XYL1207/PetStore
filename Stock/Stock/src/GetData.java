import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import java.net.*;
import java.io.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.*;
import java.text.*;
import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

public class GetData {
    private static Stocks stock = new Stocks();

    public static Stocks getdatas(String url) {
        //String url = "http://hq.sinajs.cn/list=sz002307";


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Referer", "http://finance.sina.com.cn")
                .build();
        try {

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String data = response.body();

            String[] datas = data.split(",");

            String code = datas[0].trim().substring(13, 19);
            String name = datas[0].trim().substring(21);
            float CorrentPrice = Float.valueOf(datas[3]).floatValue();
            float YestoOpenprice = Float.valueOf(datas[2]).floatValue();
            String time = datas[31];
            float rate = (float) (CorrentPrice - YestoOpenprice) / YestoOpenprice * 100;

            stock.setCode(code);
            stock.setCorrentPrice(CorrentPrice);
            stock.setName(name);
            stock.setRate(rate);
            stock.setTime(time);
            stock.setYestoOpenprice(YestoOpenprice);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return stock;
    }

    public static void main(String[] args){
        //修改url中list后面的参数可查看不同股票
        String url = "http://hq.sinajs.cn/list=sz002307";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Referer", "http://finance.sina.com.cn")
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String data = response.body();
            System.out.println(data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
