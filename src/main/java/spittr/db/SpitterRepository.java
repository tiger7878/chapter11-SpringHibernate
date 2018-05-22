package spittr.db;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import spittr.domain.Spitter;

import java.util.List;

/**
 * 集成hibernate4之后，最小事务级别必须是Required，如果是以下的级别，或者没有开启事务的话，无法得到当前的Session
 * 生产环境一般service层是有事务的，测试环境直接加到dao层的接口中
 * User: monkey
 * Date: 2018-05-21 20:21
 */
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public interface SpitterRepository {
    long count();

    Spitter save(Spitter spitter);

    Spitter findOne(long id);

    Spitter findByUsername(String username);

    List<Spitter> findAll();
}
