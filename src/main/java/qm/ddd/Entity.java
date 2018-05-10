package qm.ddd;

public abstract class Entity<T extends Entity> {

    protected final long id;

    protected Entity(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

}
