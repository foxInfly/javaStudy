package com.pupu.designPattern.design14_faced.points;

/**
 * Created by Tom.
 */
public class FacadeService {
    private QualifyService qualifyService = new QualifyService();
    private PaymentService paymentService = new PaymentService();
    private ShippingService shippingService = new ShippingService();


    public void exchange(GiftInfo giftInfo){
        if(qualifyService.isAvailable(giftInfo)){
            if(paymentService.pay(giftInfo)){
                String shippingNo = shippingService.delivery(giftInfo);
                System.out.println("物流系统下单成功，物流单号是：" + shippingNo);
            }
        }
    }
}
