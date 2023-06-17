package storage;

import exceptions.KeyNotFoundException;
import exceptions.StorageFullException;

public interface IStorage<Key, Value> {

    static final int DEFAULT_CAPACITY = 10;
    void put(Key key, Value value) throws StorageFullException;

    Value get(Key key) throws KeyNotFoundException;

    void remove(Key key);
}
