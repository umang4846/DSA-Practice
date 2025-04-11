package system_design.low_level_design.case_studies.cache;

import java.util.Map;

public class LFUEvictionPolicy<K,V> implements EvictionPolicy<K,V> {

    @Override
    public K selectEvictionElement(Map<K,CacheElement<V>> cache) {
        K minUsed = null;
        int minUsage = Integer.MAX_VALUE;
        for(Map.Entry<K, CacheElement<V>> entry:cache.entrySet()) {
            if(entry.getValue().usageFrequency < minUsage) {
                minUsage = entry.getValue().usageFrequency;
                minUsed = entry.getKey();
            }
        }
        return minUsed;
    }

    @Override
    public CacheElement<V> updateElement(CacheElement<V> elem) {
        elem.usageFrequency++;
        elem.lastUsed = System.nanoTime();
        return elem;
    }
}