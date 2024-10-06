package com.leandroleitedev.patterns.strategyV2;

import com.leandroleitedev.patterns.strategyV2.enums.CustomerTypeEnum;
import com.leandroleitedev.patterns.strategyV2.factory.DiscountStrategyFactory;
import com.leandroleitedev.patterns.strategyV2.model.CustomerModel;
import com.leandroleitedev.patterns.strategyV2.service.DiscountService;

public class MainStrategyPattern {

    public static void main(String[] args) {

        DiscountStrategyFactory discountStrategyFactory = new DiscountStrategyFactory();
        DiscountService discountService = new DiscountService(discountStrategyFactory);


        var customerModel1 = new CustomerModel("Victor", CustomerTypeEnum.BASIC);
        var customerModel2 = new CustomerModel("Alan", CustomerTypeEnum.REGULAR);
        var customerModel3 = new CustomerModel("Flavia", CustomerTypeEnum.PREMIUM);


        System.out.println(customerModel1.name() + " Discount Basic: " + discountService.applyDiscount(customerModel1.customerTypeEnum(), 100d) + "\n");
        System.out.println(customerModel2.name() + " Discount Regular: " + discountService.applyDiscount(customerModel2.customerTypeEnum(), 1000d) + "\n");
        System.out.println(customerModel3.name() + " Discount Premium: " + discountService.applyDiscount(customerModel3.customerTypeEnum(), 10000d) + "\n");
    }


//    private double applyDiscountWithoutStrategy(CustomerTypeEnum customerTypeEnum, double amount) {
//        if (CustomerTypeEnum.BASIC.equals(customerTypeEnum)) {
//            return amount * 0.05;
//        } else if (CustomerTypeEnum.REGULAR.equals(customerTypeEnum)) {
//            return amount * 0.10;
//        } else if (CustomerTypeEnum.PREMIUM.equals(customerTypeEnum)) {
//            return amount * 0.15;
//        } else {
//            return 0d;
//        }
//    }

}

