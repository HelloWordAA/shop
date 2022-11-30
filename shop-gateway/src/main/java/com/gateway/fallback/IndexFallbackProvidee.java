//package com.gateway.fallback;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.client.ClientHttpResponse;
//
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * yzw
// * 2022/11/30
// * 服务失败回调
// */
//public class IndexFallbackProvidee implements FallbackProvider {
//    @Override
//    public String getRoute() {
//        //返回处理的serviceId
//        //如果需要所有调用都支持失败处理，则返回return "*"
//        return "*";
//    }
//
//    @Override
//    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
//        //如果内部调用失败，则返回调用信息给客户端调用者
//        return new ClientHttpResponse() {
//            @Override
//            public HttpStatus getStatusCode() throws IOException {
//                return HttpStatus.OK;
//            }
//
//            @Override
//            public int getRawStatusCode() throws IOException {
//                return HttpStatus.OK.value();
//            }
//
//            @Override
//            public String getStatusText() throws IOException {
//                return HttpStatus.OK.getReasonPhrase();
//            }
//
//            @Override
//            public void close() {
//
//            }
//
//            @Override
//            public InputStream getBody() throws IOException {
//                ObjectMapper mapper = new ObjectMapper();
//                Map<String,Object> map = new HashMap<>();
//                map.put("statusCode",200);
//                map.put("message","当前系统繁忙，请稍后再试");
//                return new ByteArrayInputStream(mapper.writeValueAsString(map).getBytes("utf-8"));
//            }
//
//            @Override
//            public HttpHeaders getHeaders() {
//                HttpHeaders headers = new HttpHeaders();
//                headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
//                return headers;
//            }
//        };
//    }
//}
