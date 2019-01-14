package spittr.data;

import spittr.bean.Spittle;

import java.util.List;

/**
 * @Author: Echo
 * @Date: 2019/1/11 10:48
 * @Description:
 */
public interface SpittleRepository {

    List<Spittle> findSpittles(long max, int count);

    Spittle findOne(long spittleId);
}
