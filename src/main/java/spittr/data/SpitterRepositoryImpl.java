package spittr.data;

import org.springframework.stereotype.Component;
import spittr.bean.Spitter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: Echo
 * @Date: 2019/1/14 17:40
 * @Description:
 */
@Component
public class SpitterRepositoryImpl implements  SpitterRepository {
    private List<Spitter> spitterList;

    public SpitterRepositoryImpl(){
        spitterList = new ArrayList<>();
    }

    @Override
    public Spitter save(Spitter spitter) {
        spitter.setId(new Date().getTime());
        spitterList.add(spitter);
        return spitter;
    }

    @Override
    public Spitter findByUsername(String username) {
        return spitterList.get(spitterList.indexOf(new Spitter(username)));
    }
}
