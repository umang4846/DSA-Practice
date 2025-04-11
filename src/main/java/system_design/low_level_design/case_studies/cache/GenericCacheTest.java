package system_design.low_level_design.case_studies.cache;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GenericCacheTest {
    private GenericCache<String, String> cache;

    @BeforeEach
    void setUp() {
        cache = new GenericCache<>(new LRUEvictionPolicy<>(), 3);
    }

    @Test
    void testAddAndRetrieveItems_LRU() {
        cache.addElement("key1", "value1");
        cache.addElement("key2", "value2");
        cache.addElement("key3", "value3");

        assertEquals("value1", cache.getElement("key1").get());
        assertEquals("value2", cache.getElement("key2").get());
        assertEquals("value3", cache.getElement("key3").get());
    }

    @Test
    void testLRUEviction() {
        cache.addElement("key1", "value1");
        cache.addElement("key2", "value2");
        cache.addElement("key3", "value3");

        //access key 1 to make is recently used
        cache.getElement("key1");

        //add new key, which should remove key
        cache.addElement("key4", "value4");

        assertNull(cache.getElement("key2").orElse(null));
        assertEquals("value1", cache.getElement("key1").get());
        assertEquals("value3", cache.getElement("key3").get());
        assertEquals("value4", cache.getElement("key4").get());

    }

    @Test
    void testSwitchToLFUEviction() {
        cache.addElement("key1", "value1");
        cache.addElement("key2", "value2");
        cache.addElement("key3", "value3");

        // Switch to LFU policy
        cache.setEvictionPolicy(new LFUEvictionPolicy<>());

        cache.getElement("key1");
        cache.getElement("key1");
        cache.getElement("key2");

        cache.addElement("key4", "value4");
        assertNull(cache.getElement("key3").orElse(null));
        assertEquals("value1", cache.getElement("key1").get());
        assertEquals("value2", cache.getElement("key2").get());
        assertEquals("value4", cache.getElement("key4").get());


    }

    @Test
    void testLFUEviction() {
        cache.setEvictionPolicy(new LFUEvictionPolicy<>());

        cache.addElement("key1", "value1");
        cache.addElement("key2", "value2");
        cache.addElement("key3", "value3");

        cache.getElement("key1");
        cache.getElement("key2");
        cache.getElement("key1");

        // Add a new key, which should evict key3 (Least Frequently Used)
        cache.addElement("key4", "value4");

        assertNull(cache.getElement("key3").orElse(null));
        assertEquals("value1", cache.getElement("key1").get());
        assertEquals("value2", cache.getElement("key2").get());
        assertEquals("value4", cache.getElement("key4").get());
    }

    @Test
    void testCapacityLimit() {
        cache.addElement("key1", "value1");
        cache.addElement("key2", "value2");
        cache.addElement("key3", "value3");
        cache.addElement("key4", "value4"); // Exceeds capacity, triggers eviction

        assertNull(cache.getElement("key1").orElse(null)); // LRU eviction for key1
        assertEquals("value2", cache.getElement("key2").get());
        assertEquals("value3", cache.getElement("key3").get());
        assertEquals("value4", cache.getElement("key4").get());
    }

    @Test
    void updateValue() {
        cache.addElement("key1", "value1");
        cache.addElement("key1", "newValue1");

        assertEquals("newValue1", cache.getElement("key1").get());
    }

    @Test
    void testEvictionPolicyChange() {

        cache.addElement("key1", "value1");
        cache.addElement("key2", "value2");
        cache.addElement("key3", "value3");

        // Switch eviction policy
        cache.setEvictionPolicy(new LFUEvictionPolicy<>());

        //Verify the cache still retains the data after switching
        assertEquals("value1", cache.getElement("key1").get());
        assertEquals("value2", cache.getElement("key2").get());
        assertEquals("value3", cache.getElement("key3").get());


    }

}
