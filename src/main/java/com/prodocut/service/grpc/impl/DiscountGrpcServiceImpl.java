package com.prodocut.service.grpc.impl;

import com.prodocut.grpc.DiscountServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import net.devh.boot.grpc.server.service.GrpcService;

import com.prodocut.grpc.DiscountRequest;
import com.prodocut.grpc.DiscountResponse;
import com.prodocut.service.grpc.DiscountGrpcService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

//@GrpcService  //bunu yapınca otomatik kanal vs oluştuyır
@Service

public class DiscountGrpcServiceImpl implements DiscountGrpcService {


    private DiscountServiceGrpc.DiscountServiceBlockingStub discountServiceBlockingStub;
    //tamamlanıncaya kadar bekler bloklar tamlanıncaya kadar karışı tarafa gönderilen istek için
    private ManagedChannel channel; //karşı servisin portu ve host yazılır


    //@Value("${discount.grpc.host} burada applic yaml dan gelen değeri alıcak grpc host ve port belirlenir
    public DiscountGrpcServiceImpl(@Value("localhost") String grpcHost, @Value("9090") int grpcPort) {
        System.out.println("--> Discount grpc: " + grpcHost + " " + grpcPort);
        channel = ManagedChannelBuilder.forAddress(grpcHost, grpcPort)
                .usePlaintext() //
                .build();
        //usePlaintext():Bu, geliştirme veya test sırasında, güvenliği gerektirmeyen durumlar için kullanışlı olabilir.
        // /*useTransportSecurity*/
    }

    @Override
    public DiscountResponse getDiscount(DiscountRequest discountRequest) {
        discountServiceBlockingStub = DiscountServiceGrpc.newBlockingStub(channel);//respone donunye kadar bekeldiğim yer
        DiscountResponse discountResponse = discountServiceBlockingStub.getDiscount(discountRequest);
        return discountResponse;
    }
}
