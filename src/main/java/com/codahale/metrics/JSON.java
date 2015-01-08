package com.codahale.metrics;

import java.util.ArrayList;
import java.util.Map.Entry;

public class JSON {

    private final List<Entry<String, String>> entries;

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
        this.entries = new ArrayList<Entry<String, String>>();
    }

}
