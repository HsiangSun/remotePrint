package cn.hsiangsun.sunway.service;

import cn.hsiangsun.sunway.grpc.OrderProto;
import cn.hsiangsun.sunway.grpc.RemoteOrderGrpc;
import io.grpc.stub.StreamObserver;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class OrderService extends RemoteOrderGrpc.RemoteOrderImplBase {

    private static final String ONLINE_PASSWORD = "200888";
    private static final String ONLINE_TABLE = "1060";

    @Override
    public void printOrder(OrderProto.OrderRequest request, StreamObserver<OrderProto.OrderResponse> responseObserver) {


        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setReadTimeout(8000);
        requestFactory.setConnectTimeout(8000);

        RestTemplate restTemplate = new RestTemplate(requestFactory);
        restTemplate.getMessageConverters().set(1,new StringHttpMessageConverter(StandardCharsets.UTF_8));

        List<OrderProto.Order> ordersList = request.getOrdersList();

        ordersList.forEach(System.out::println);





        String url = "http://127.0.0.1/login.php?lang_id=2&logout=1&table_id=&invoice_id=";

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cookie","mako2__check=check");

        LinkedMultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("mode","1");
        params.add("password",ONLINE_PASSWORD);
        params.add("finger_print","");

        HttpEntity<MultiValueMap<String,String>> httpEntity = new HttpEntity<MultiValueMap<String,String>>(params,headers);
        ResponseEntity<String> response = restTemplate.postForEntity(url, httpEntity, String.class);
        HttpHeaders responseHeads = response.getHeaders();

        List<String> cookies = responseHeads.get("Set-Cookie");
        String userCookieComplex = cookies.get(1);

        String userCookie  = userCookieComplex.split(";")[0].split("=")[1];


        Document document = null;
        try {
            document = Jsoup.connect(String.format("http://127.0.0.1/invoice_profile.php?lang_id=2&table_id=%s",ONLINE_TABLE))
                    .cookie("mako2__check", "check")
                    .cookie("mako2__sid", userCookie)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/97.0.4692.71 Safari/537.36 Edg/97.0.1072.55")
                    .timeout(8000).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //get invoice id
        Element invoice = document.select("input[name=invoice_id]").first();
        String invoiceID = invoice.val();

        //set user seats

        String mainUrl = String.format("http://127.0.0.1/invoice.php?lang_id=2&invoice_id=%s",invoiceID);

        HttpHeaders headersWithCookie = new HttpHeaders();
        headersWithCookie.add("Cookie","mako2__check=check");
        headersWithCookie.add("Cookie",String.format("mako2__sid=%s",userCookie));

        LinkedMultiValueMap<String, String> seatsParams = new LinkedMultiValueMap<>();
        seatsParams.add("selected_id","0");
        seatsParams.add("seats","1");//!!!!!!!!!!!!!!!!!!!!user count
        seatsParams.add("type_id","");
        seatsParams.add("submit_type","change_seats");
        seatsParams.add("scroll","0");
        seatsParams.add("sel_seat","1");
        seatsParams.add("sel_course_id","-1");
        seatsParams.add("multi_mode","0");
        seatsParams.add("sent_minimized","0");

        HttpEntity<MultiValueMap<String,String>> httpEntity2 = new HttpEntity<MultiValueMap<String,String>>(seatsParams,headersWithCookie);
        restTemplate.postForEntity(mainUrl, httpEntity2, String.class);

        //add menu to order


        //submit order
        String sendOrderUrl = String.format("http://127.0.0.1/invoice_profile.php?lang_id=2&invoice_id=%s",invoiceID);
        LinkedMultiValueMap<String, String> sendOrderParams = new LinkedMultiValueMap<>();
        sendOrderParams.add("invoice_id",invoiceID);
        sendOrderParams.add("time",String.valueOf(System.currentTimeMillis()));
        sendOrderParams.add("course_id","0");
        sendOrderParams.add("submit_type","send");
        sendOrderParams.add("_","");

        HttpEntity<MultiValueMap<String,String>> httpEntity4 = new HttpEntity<MultiValueMap<String,String>>(sendOrderParams,headersWithCookie);
        restTemplate.postForEntity(sendOrderUrl, httpEntity4, String.class);

        String checkOrderUrl = String.format("http://127.0.0.1/index.php?lang_id=2&&table_id=%s&unlock=%s",ONLINE_TABLE,invoiceID);
        ResponseEntity<String> response4 = restTemplate.exchange(checkOrderUrl,
                HttpMethod.GET,
                new HttpEntity(headersWithCookie), String.class);


        OrderProto.OrderResponse.Builder remoteResponse = OrderProto.OrderResponse.newBuilder();

        remoteResponse.setResult(true);

        responseObserver.onNext(remoteResponse.build());
        responseObserver.onCompleted();






    }
}
