package com.leandroleitedev.patterns.strategyV1.service;

import com.leandroleitedev.patterns.strategyV1.enums.CustomerTypeEnum;
import com.leandroleitedev.patterns.strategyV1.interfaces.DiscountStrategyInterface;
import com.leandroleitedev.patterns.strategyV1.impl.DiscountStrategyBasicImpl;
import com.leandroleitedev.patterns.strategyV1.impl.DiscountStrategyPremiumImpl;
import com.leandroleitedev.patterns.strategyV1.impl.DiscountStrategyRegularImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DiscountService {

    private static final Map<CustomerTypeEnum, DiscountStrategyInterface> strategyMap = new HashMap<>();


    static {

        strategyMap.put(CustomerTypeEnum.BASIC, new DiscountStrategyBasicImpl());
        strategyMap.put(CustomerTypeEnum.REGULAR, new DiscountStrategyRegularImpl());
        strategyMap.put(CustomerTypeEnum.PREMIUM, new DiscountStrategyPremiumImpl());
    }

    public double applyDiscount(CustomerTypeEnum customerTypeEnum, double amount) {
        DiscountStrategyInterface strategy = strategyMap.get(customerTypeEnum);
        if (Objects.isNull(strategy)) {
            throw new IllegalArgumentException("Type of customer unknown");
        }
        return strategy.calculateDiscount(amount);
    }
}
