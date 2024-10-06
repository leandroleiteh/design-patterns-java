package com.leandroleitedev.patterns.strategyV1.model;

import com.leandroleitedev.patterns.strategyV1.enums.CustomerTypeEnum;

public record CustomerModel(String name, CustomerTypeEnum customerTypeEnum) {}

