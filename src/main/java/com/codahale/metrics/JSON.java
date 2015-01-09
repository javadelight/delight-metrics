package com.codahale.metrics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class JSON {

    private final List<Entry<String, Object>> entries;

    public void add(final String key, final Object value) {

        entries.add(new Entry<String, Object>() {

            @Override
            public String setValue(final String value) {
                return null;
            }

            @Override
            public String getValue() {

                return value;
            }

            @Override
            public String getKey() {
                return key;
            }
        });

    }

    public String render() {

        String res = "{\n";

        for (final Entry<String, Object> e : entries) {
            if (e.getValue() instanceof String) {
                res += "    '" + e.getKey() + "': '" + e.getValue() + "',\n";
            }
        }

        res += "}";

        return res;

    }

    public JSON() {
        super();
        this.entries = new ArrayList<Entry<String, String>>();
    }

}
