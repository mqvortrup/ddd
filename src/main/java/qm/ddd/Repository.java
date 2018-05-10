package qm.ddd;

import java.util.HashMap;
import java.util.Map;

public abstract class Repository<T extends Entity> {
    protected final Map<Long, T> repo;

    public Repository() {
        repo = new HashMap<>();
    }

    public T getById(long id) {
        return repo.get(id);
    }

    public T createById(long id) {
        T result = repo.get(id);
        if (result != null)
            throw new IllegalArgumentException("Entity with id already exists: " + id);
        else {
            result = create(id);
            repo.put(id, result);
            return result;
        }
    }

    protected abstract T create(long id);
}
