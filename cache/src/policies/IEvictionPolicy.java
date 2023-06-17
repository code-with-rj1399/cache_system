package policies;

public interface IEvictionPolicy<Key> {
    public void keyAccessed(Key element);

    Key evictKey();
}
