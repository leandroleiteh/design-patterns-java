package com.leandroleitedev.patterns.strategyV2.model;

import com.leandroleitedev.patterns.strategyV2.enums.CustomerTypeEnum;

public record CustomerModel(String name, CustomerTypeEnum customerTypeEnum) {}

