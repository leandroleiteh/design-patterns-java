package com.leandroleitedev.patterns.strategyV2.factory;

import com.leandroleitedev.patterns.strategyV2.enums.CustomerTypeEnum;
import com.leandroleitedev.patterns.strategyV2.impl.DiscountStrategyBasicImpl;
import com.leandroleitedev.patterns.strategyV2.impl.DiscountStrategyPremiumImpl;
import com.leandroleitedev.patterns.strategyV2.impl.DiscountStrategyRegularImpl;
import com.leandroleitedev.patterns.strategyV2.interfaces.DiscountStrategyInterface;

import java.util.HashMap;
import java.util.Map;

public class DiscountStrategyFactory {

    private final Map<CustomerTypeEnum, DiscountStrategyInterface> strategyMap = new HashMap<>();

    public DiscountStrategyFactory() {
        registerStrategy(CustomerTypeEnum.BASIC, new DiscountStrategyBasicImpl());
        registerStrategy(CustomerTypeEnum.REGULAR, new DiscountStrategyRegularImpl());
        registerStrategy(CustomerTypeEnum.PREMIUM, new DiscountStrategyPremiumImpl());
    }

    public void registerStrategy(CustomerTypeEnum customerTypeEnum, DiscountStrategyInterface strategy) {
        strategyMap.put(customerTypeEnum, strategy);
    }

    public DiscountStrategyInterface getStrategy(CustomerTypeEnum customerTypeEnum) {
        return strategyMap.get(customerTypeEnum);
    }
}

