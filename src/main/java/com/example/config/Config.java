package com.example.config;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Config {

    public static String monetaryItem = "EUR";

    private Map<String, String> settings;

    public static Map<String, String> lang = new HashMap<String, String>() {
        {
            put("0", "en");
            put("1", "bs-Latn-BA");
            put("2", "ba");
        }
    };

    public static Map<String, String> confSet = new HashMap<String, String>() {
        {
            put("lab-codes", "lab-codes");
            put("rend", "rend");
            put("def", "def");
            put("pre", "pre");
            put("tab", "tab");
        }
    };

    public static Map<String, String> moduleSet = new HashMap<String, String>() {
        {
            put("pre", "pre");
            put("rend", "rend");
            put("lab-codes", "lab-codes");
        }
    };

    public static Map<String, String> createInstance = new HashMap<String, String>() {
        {
            put("rend", "rend");
            put("def", "def");
        }
    };

    public static String owner = "www.eba.europa.eu";

    public Config(Map<String, String> settings) {
        this.settings = settings;
    }

    public static String publicDir() {
        return storagePath("app/public/tax");
    }

    public static String prefixOwner = "fba";

    public static String setLogoPath() {
        return Paths.get(publicPath(), "images", "logo.svg").toString();
    }

    public static Map<String, Map<String, String>> owners() {
        Map<String, Map<String, String>> owners = new HashMap<>();
        owners.put("fba", new HashMap<String, String>() {
            {
                put("namespace", "http://www.fba.ba");
                put("officialLocation", "http://www.fba.ba/xbrl");
                put("prefix", "fba");
                put("copyright", "(C) FBA");
            }
        });
        owners.put("eba", new HashMap<String, String>() {
            {
                put("namespace", "http://www.eba.europa.eu/xbrl/crr");
                put("officialLocation", "http://www.eba.europa.eu/eu/fr/xbrl/crr");
                put("prefix", "eba");
                put("copyright", "(C) EBA");
            }
        });
        owners.put("audt", new HashMap<String, String>() {
            {
                put("namespace", "http://www.auditchain.finance/");
                put("officialLocation", "http://www.auditchain.finance/fr/dpm");
                put("prefix", "audt");
                put("copyright", "(C) Auditchain");
            }
        });
        return owners;
    }

    public static String tmpPdfDir() {
        return Paths.get(storagePath("logs")).toString();
    }

    private static String storagePath(String subPath) {

        return Paths.get(System.getProperty("user.dir"), subPath).toString();
    }

    private static String publicPath() {

        return System.getProperty("user.dir");
    }

    public String get(String key) {
        return this.settings.get(key);
    }
}