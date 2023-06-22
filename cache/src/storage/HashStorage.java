package storage;

import exceptions.KeyNotFoundException;
import exceptions.StorageFullException;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

public class HashStorage<Key,Value> implements IStorage<Key,Value> {
    private Map<Key,Value> map;
    private int capacity = IStorage.DEFAULT_CAPACITY;
    public HashStorage(){
        map = new HashMap<>();
    }
    public HashStorage(int capacity){
        this();
        this.capacity = capacity;
    }
    @Override
    public void put(Key key, Value value) throws StorageFullException {
        if(map.size() == capacity) throw new StorageFullException("Storage is full");
        map.put(key,value);
    }

    @Override
    public Value get(Key key) {
        Value value = map.get(key);
        if(value == null) throw new KeyNotFoundException("Key not found in the storage");
        return map.get(key);
    }

    @Override
    public void remove(Key key) {
        map.remove(key);
    }
}
