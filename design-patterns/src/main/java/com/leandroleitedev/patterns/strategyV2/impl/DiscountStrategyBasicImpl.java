package com.leandroleitedev.patterns.strategyV2.impl;

import com.leandroleitedev.patterns.strategyV2.interfaces.DiscountStrategyInterface;

public class DiscountStrategyBasicImpl implements DiscountStrategyInterface {

    @Override
    public double calculateDiscount(double amount) {
        System.out.println("applying 5% discount");
        return amount * 0.05;
    }
}
