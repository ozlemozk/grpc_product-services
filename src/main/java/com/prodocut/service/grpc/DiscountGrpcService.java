package com.prodocut.service.grpc;

import com.prodocut.grpc.DiscountRequest;
import com.prodocut.grpc.DiscountResponse;

public interface DiscountGrpcService {
    DiscountResponse getDiscount(DiscountRequest discountRequest); //proto ile aynı olmak zorunda olamayabilir

}
