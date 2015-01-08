package com.codahale.metrics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class JSON {

    private final List<Entry<String, String>> entries;

    public void add(final String key, final Object value) {
        final String valueStr = value.toString();
        entries.add(new Entry<String, String>() {

            @Override
            public String setValue(final String value) {
                return null;
            }

            @Override
            public String getValue() {

                return valueStr;
            }

            @Override
            public String getKey() {
                return key;
            }
        });

    }

    public String render() {

        String res = "{\n";

        for (final Entry<String, String> e : entries) {
            res += "    '" + e.getKey() + "': '" + e.getValue() + "',\n";
        }

        res += "}";

        return res;

    }

    public JSON() {
        super();
        this.entries = new ArrayList<Entry<String, String>>();
    }

}
