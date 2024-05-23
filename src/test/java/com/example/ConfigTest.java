package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.example.config.Config;

import java.util.HashMap;
import java.util.Map;

public class ConfigTest {

    @Test
    public void testGet() {
        Map<String, String> settings = new HashMap<>();
        settings.put("key1", "value1");
        Config config = new Config(settings);

        assertEquals("value1", config.get("key1"));
    }
}
