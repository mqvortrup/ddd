package qm.ddd;

import java.util.HashMap;
import java.util.Map;

public class AnEntityRepository extends Repository<AnEntity> {

    protected AnEntityRepository() {
        super();
    }

    @Override
    protected AnEntity create(long id) {
        return new AnEntity(id);
    }

}
