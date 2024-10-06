package com.leandroleitedev.patterns.strategyV1;

import com.leandroleitedev.patterns.strategyV1.enums.CustomerTypeEnum;
import com.leandroleitedev.patterns.strategyV1.model.CustomerModel;
import com.leandroleitedev.patterns.strategyV1.service.DiscountService;

public class MainStrategyPattern {

    public static void main(String[] args) {

        DiscountService discountService = new DiscountService();

        var customerModel1 = new CustomerModel("Leandro", CustomerTypeEnum.BASIC);
        var customerModel2 = new CustomerModel("Pedro", CustomerTypeEnum.REGULAR);
        var customerModel3 = new CustomerModel("Maria", CustomerTypeEnum.PREMIUM);


        System.out.println(customerModel1.name() + " Discount Basic: " + discountService.applyDiscount(customerModel1.customerTypeEnum(), 100d) + "\n");
        System.out.println(customerModel2.name() + " Discount Regular: " + discountService.applyDiscount(customerModel2.customerTypeEnum(), 1000d) + "\n");
        System.out.println(customerModel3.name() + " Discount Premium: " + discountService.applyDiscount(customerModel3.customerTypeEnum(), 10000d) + "\n");
    }

    private double applyDiscountWithoutStrategy(CustomerTypeEnum customerTypeEnum, double amount) {
        if (CustomerTypeEnum.BASIC.equals(customerTypeEnum)) {
            return amount * 0.05;
        } else if (CustomerTypeEnum.REGULAR.equals(customerTypeEnum)) {
            return amount * 0.10;
        } else if (CustomerTypeEnum.PREMIUM.equals(customerTypeEnum)) {
            return amount * 0.15;
        } else {
            return 0d;
        }
    }
}
