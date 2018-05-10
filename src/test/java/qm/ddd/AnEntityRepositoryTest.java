package qm.ddd;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnEntityRepositoryTest {

    private static final long EXISTS = 1;
    private static final long DOESNT_EXIST = 0;
    private static final long NEW = 2;

    private AnEntityRepository repository;

    @Before
    public void setUp() {
        repository = new AnEntityRepository();
        repository.createById(EXISTS);
    }

    @Test
    public void getById() {
        AnEntity byId = repository.getById(EXISTS);
        assertNotNull("an entity should exist", byId);
        assertEquals("id should be the same", EXISTS, byId.getId());
        assertNull("an entity should not exist", repository.getById(DOESNT_EXIST));
    }

    @Test
    public void createByIdOfNew() {
        AnEntity byId = repository.createById(NEW);
        assertNotNull("an entity should now exist", byId);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createByIdExists() {
        AnEntity byId = repository.createById(EXISTS);
    }
}
