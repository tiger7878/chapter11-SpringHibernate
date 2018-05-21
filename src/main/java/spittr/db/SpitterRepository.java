package spittr.db;

import spittr.domain.Spitter;

import java.util.List;

/**
 * User: monkey
 * Date: 2018-05-21 20:21
 */
public interface SpitterRepository {
    long count();

    Spitter save(Spitter spitter);

    Spitter findOne(long id);

    Spitter findByUsername(String username);

    List<Spitter> findAll();
}
