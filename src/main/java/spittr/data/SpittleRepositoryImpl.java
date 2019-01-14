package spittr.data;

import org.springframework.stereotype.Component;
import spittr.bean.Spittle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: Echo
 * @Date: 2019/1/14 11:26
 * @Description:
 */
@Component
public class SpittleRepositoryImpl implements SpittleRepository {

    private List<Spittle> spittles = new ArrayList<>();

    public SpittleRepositoryImpl(){
        for(int i = 230000; i < 240000;i++){
            Spittle spittle = new Spittle("spittle"+i,new Date());
            spittle.setId((long)i);
            spittles.add(spittle);
        }
    }

    @Override
    public List<Spittle> findSpittles(long max, int count) {
        int endIndex = spittles.indexOf(new Spittle(max));
        return spittles.subList(endIndex - count + 1,endIndex + 1);
    }

    @Override
    public Spittle findOne(long spittleId) {
        return spittles.get(spittles.indexOf(new Spittle(spittleId)));
    }
}
