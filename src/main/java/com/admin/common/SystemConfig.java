package com.admin.common;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.springframework.stereotype.Component;

@Component
public class SystemConfig {
    private PropertiesConfiguration config = new PropertiesConfiguration();
}
