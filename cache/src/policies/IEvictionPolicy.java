package policies;

public interface IEvictionPolicy<Key> {
    void keyAccessed(Key element);
    Key evictKey();
}
