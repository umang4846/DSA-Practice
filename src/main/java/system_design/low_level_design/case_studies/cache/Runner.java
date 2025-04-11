package system_design.low_level_design.case_studies.cache;

public class Runner {
    public static void main(String[] args) {
        EvictionPolicy<Integer, String> lfuPolicy = new LRUEvictionPolicy<>();
        GenericCache<Integer, String> cache = new GenericCache<>(lfuPolicy, 3);

        cache.addElement(1, "Item1");
        cache.addElement(2, "Item2");
        cache.addElement(3, "Item3");

        System.out.println("Initial Cache State:");
        System.out.println(cache.store);

        cache.getElement(1);
        cache.addElement(4, "Item4");

        System.out.println("\nCache State after Accessing Key 1 and Adding Key 4:");
        System.out.println(cache.store);

        cache.setEvictionPolicy(new LFUEvictionPolicy<>());
        cache.addElement(5, "Item5");

        System.out.println("\nCache State after Changing to LRU Policy and Adding Key 5:");
        System.out.println(cache.store);
    }
}
