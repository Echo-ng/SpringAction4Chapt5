package spittr.data;

import org.springframework.stereotype.Component;
import spittr.bean.Spitter;

/**
 * @Author: Echo
 * @Date: 2019/1/14 17:39
 * @Description:
 */

public interface SpitterRepository {

    Spitter save(Spitter spitter);

    Spitter findByUsername(String username);
}
