package spittr.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.Date;
import java.util.Objects;

/**
 * @Author: Echo
 * @Date: 2019/1/11 11:00
 * @Description:
 */
@Data
public class Spittle {
    private Long id;
    private String message;
    private Date time;
    private Double latitude;
    private Double longitude;

    public Spittle(String message,Date time){
        this(message,time,null,null);
    }

    public Spittle(String message, Date time, Double latitude, Double longitude) {
        this.id = null;
        this.message = message;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Spittle(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
           return EqualsBuilder.reflectionEquals(this,o,new String[]{"message","time","latitude","longitude"});
    }

    @Override
    public int hashCode() {

        return HashCodeBuilder.reflectionHashCode(this,new String[]{"message","time","latitude","longitude"});
    }
}
