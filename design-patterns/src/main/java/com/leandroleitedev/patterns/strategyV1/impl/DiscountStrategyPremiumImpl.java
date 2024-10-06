package com.leandroleitedev.patterns.strategyV1.impl;

import com.leandroleitedev.patterns.strategyV1.interfaces.DiscountStrategyInterface;

public class DiscountStrategyPremiumImpl implements DiscountStrategyInterface {
    @Override
    public double calculateDiscount(double amount) {
        System.out.println("applying 15% discount");
        return amount * 0.15;
    }
}
