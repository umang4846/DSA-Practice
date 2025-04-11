package system_design.low_level_design.case_studies.cache;

public class CacheElement<V> {
    public V value;
    public long lastUsed;
    public int usageFrequency;

    public CacheElement(V value, long lastUsed, int usageFrequency) {
        this.value = value;
        this.lastUsed = lastUsed;
        this.usageFrequency = usageFrequency;
    }

    @Override
    public String toString() {
        return "CacheElement{" +
                "Value=" + value +
                ", lastUsed=" + lastUsed +
                ", usageFrequency=" + usageFrequency +
                '}';
    }
}
