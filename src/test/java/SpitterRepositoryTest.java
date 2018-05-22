import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spittr.config.RepositoryConfig;
import spittr.db.SpitterRepository;
import spittr.domain.Spitter;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author: monkey
 * @date: 2018/5/21 22:13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RepositoryConfig.class)
public class SpitterRepositoryTest {

    @Autowired
    private SpitterRepository spitterRepository;

    @Test
    public void count(){
        assertEquals(4,spitterRepository.count());
    }

    @Test
    public void findAll() {
        List<Spitter> spitters = spitterRepository.findAll();
        assertEquals(4, spitters.size());
    }

    @Test
    public void findOne(){
        Spitter spitter=spitterRepository.findOne(1L);
        assertEquals("habuma",spitter.getUsername());
    }

}
