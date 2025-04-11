package system_design.low_level_design.case_studies.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GenericCache<K,V> {
    Map<K, CacheElement<V>> store = new HashMap<>();
    EvictionPolicy<K,V> evictionPolicy;
    int maxSize;

    public GenericCache(EvictionPolicy<K,V> evictionPolicy, int maxSize) {
        this.evictionPolicy = evictionPolicy;
        this.maxSize = maxSize;
    }

    public void setEvictionPolicy(EvictionPolicy<K,V> evictionPolicy) {
        this.evictionPolicy = evictionPolicy;
    }

    public EvictionPolicy<K,V> getEvictionPolicy() {
        return this.evictionPolicy;
    }

    public Optional<V> getElement(K key) {
        if (store.containsKey(key)) {
            CacheElement<V> element = store.get(key);
            element = evictionPolicy.updateElement(element);
            store.put(key, element);
            return Optional.of(element.value);
        }
        return Optional.empty();
    }

    public void addElement(K key, V ele) {
        if (store.size() == maxSize) {
            K evictionKey = evictionPolicy.selectEvictionElement(store);
            store.remove(evictionKey);
        }
        long currentTime = System.nanoTime();
        CacheElement<V> element = new CacheElement<>(ele, currentTime, 0);
        store.put(key, element);

    }

    @Override
    public String toString() {
        return store.toString();
    }
}
