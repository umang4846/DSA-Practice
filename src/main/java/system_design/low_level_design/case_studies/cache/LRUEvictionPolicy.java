package system_design.low_level_design.case_studies.cache;

import java.util.Map;

public class LRUEvictionPolicy<K, V> implements EvictionPolicy<K, V> {

    @Override
    public K selectEvictionElement(Map<K, CacheElement<V>> cache) {
        K lastUsedElem = null;
        long lastUsage = Long.MAX_VALUE;
        for (Map.Entry<K, CacheElement<V>> entry : cache.entrySet()) {
            if (entry.getValue().lastUsed < lastUsage) {
                lastUsage = entry.getValue().lastUsed;
                lastUsedElem = entry.getKey();
            }
        }
        return lastUsedElem;
    }

    @Override
    public CacheElement<V> updateElement(CacheElement<V> elem) {
        elem.lastUsed = System.nanoTime();
        elem.usageFrequency++;
        return elem;
    }
}