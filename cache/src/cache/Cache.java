package cache;

import exceptions.KeyNotFoundException;
import exceptions.StorageFullException;
import policies.IEvictionPolicy;
import storage.IStorage;

public class Cache<Key,Value> {

    IEvictionPolicy<Key> evictionPolicy ;
    IStorage<Key, Value> storage;
    public Cache(IStorage<Key,Value> storage, IEvictionPolicy<Key> evictionPolicy){
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(Key key, Value value){
        try{
            storage.put(key,value);
            evictionPolicy.keyAccessed(key);
        }catch (StorageFullException storageFullException){
            storage.remove(key);
            Key keyToRemove = evictionPolicy.evictKey();
            storage.remove(keyToRemove);
            put(key,value);
        }
    }

    public Value get(Key key){
        try{
            Value value = storage.get(key);
            evictionPolicy.keyAccessed(key);
            return value;
        }catch (KeyNotFoundException keyNotFoundException){
            return null;
        }
    }
}
