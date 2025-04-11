package system_design.low_level_design.case_studies.cache;

import java.util.Map;

public interface EvictionPolicy<K, V> {
    K selectEvictionElement(Map<K, CacheElement<V>> store);

    CacheElement<V> updateElement(CacheElement<V> element);

}
