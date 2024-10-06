package com.leandroleitedev.patterns.strategyV2.service;

import com.leandroleitedev.patterns.strategyV2.enums.CustomerTypeEnum;
import com.leandroleitedev.patterns.strategyV2.factory.DiscountStrategyFactory;
import com.leandroleitedev.patterns.strategyV2.interfaces.DiscountStrategyInterface;

import java.util.Objects;

public class DiscountService {

    private final DiscountStrategyFactory discountStrategyFactory;

    public DiscountService(DiscountStrategyFactory discountStrategyFactory) {
        this.discountStrategyFactory = discountStrategyFactory;
    }


    public double applyDiscount(CustomerTypeEnum customerTypeEnum, double amount) {
        DiscountStrategyInterface strategy = discountStrategyFactory.getStrategy(customerTypeEnum);
        if (Objects.isNull(strategy)) {
            throw new IllegalArgumentException("Unknown customer type: " + customerTypeEnum);
        }
        return strategy.calculateDiscount(amount);
    }
}
