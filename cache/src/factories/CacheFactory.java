package factories;

import cache.Cache;
import policies.LRCEvictionPolicy;
import storage.HashStorage;

public class CacheFactory<Key, Value> {
    public Cache<Key,Value> getCache(int capacity){
        return new Cache<Key,Value>(new HashStorage<Key,Value>(capacity), new LRCEvictionPolicy<Key>());
    }
}
