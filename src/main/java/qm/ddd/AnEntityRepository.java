package qm.ddd;

import java.util.HashMap;
import java.util.Map;

public class AnEntityRepository extends Repository<AnEntity> {

    private Map<Long, AnEntity> repo = new HashMap<>();

    public AnEntity getById(long id) {
        return repo.get(id);
    }

    public AnEntity createById(long id) {
        AnEntity result = repo.get(id);
        if (result != null)
            throw new IllegalArgumentException("Entity with id already exists: " + id);
        else {
            result = new AnEntity(id);
            repo.put(id, result);
            return result;
        }
    }
}
