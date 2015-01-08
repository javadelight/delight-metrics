package com.codahale.metrics;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class JSON {

    private final Map<String, String> entries;

    public void add(final String key, final Object value) {
        entries.put(key, value.toString());
    }

    public String render() {

        String res = "{\n";

        for (final Entry<String, String> e : entries.entrySet()) {
            res += "    " + e.getKey() + ": '" + e.getValue() + "',\n";
        }

        res += "}";

        return res;

    }

    public JSON() {
        super();
        this.entries = new HashMap<String, String>();
    }

}
