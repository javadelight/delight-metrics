package com.codahale.metrics;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * from https://github.com/WeTheInternet/xapi
 *
 * All rights reserved.
 * 
 * Distributed under a modified BSD License as follow: Redistribution and use in
 * source and binary forms, with or without modification, are permitted provided
 * that the following conditions are met:
 * 
 * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 * 
 * Redistribution in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution, unless otherwise agreed to in
 * a written document signed by a director of We The Internet Ltd.
 * 
 * Neither the name of We The Internet nor the names of its contributors may be
 * used to endorse or promote products derived from this software without
 * specific prior written permission.
 * 
 * Public displays of software using this code may choose to credit the
 * contributors, but are not required to give attribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE
 * 
 * Very basic emulation for SkipListMap; it's just a TreeMap, to implement all
 * of the {@link NavigableMap} functionality.
 * 
 * TODO: implement ConcurrentMap extensions properly.
 * 
 * @param <K>
 *            key type
 * @param <V>
 *            value type
 */
public class ConcurrentSkipListMap<K, V> extends TreeMap<K, V> implements Cloneable, Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Ensures that RPC will consider type parameter K to be exposed. It will be
     * pruned by dead code elimination.
     */
    @SuppressWarnings("unused")
    private K exposeKey;

    /**
     * Ensures that RPC will consider type parameter V to be exposed. It will be
     * pruned by dead code elimination.
     */
    @SuppressWarnings("unused")
    private V exposeValue;

    public ConcurrentSkipListMap() {
        super();
    }

    public ConcurrentSkipListMap(final Comparator<? super K> comparator) {
        super(comparator);
    }

    /**
     * Constructs a new map containing the same mappings as the given map,
     * sorted according to the {@linkplain Comparable natural ordering} of the
     * keys.
     * 
     * @param m
     *            the map whose mappings are to be placed in this map
     * @throws ClassCastException
     *             if the keys in <tt>m</tt> are not {@link Comparable}, or are
     *             not mutually comparable
     * @throws NullPointerException
     *             if the specified map or any of its keys or values are null
     */
    public ConcurrentSkipListMap(final Map<? extends K, ? extends V> m) {
        super(m);
    }

    /**
     * Constructs a new map containing the same mappings and using the same
     * ordering as the specified sorted map.
     * 
     * @param m
     *            the sorted map whose mappings are to be placed in this map,
     *            and whose comparator is to be used to sort this map
     * @throws NullPointerException
     *             if the specified sorted map or any of its keys or values are
     *             null
     */
    public ConcurrentSkipListMap(final SortedMap<K, ? extends V> m) {
        super(m);
    }

    public V putIfAbsentN(final K key, final V value) {
        return put(key, value);
    }

}