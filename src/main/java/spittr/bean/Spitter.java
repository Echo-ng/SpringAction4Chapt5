package spittr.bean;

import lombok.Data;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.validation.constraints.*;

/**
 * @Author: Echo
 * @Date: 2019/1/14 17:32
 * @Description:
 */
@Data
public class Spitter {
    private Long id;

    @NotNull
    @Size(min = 5,max = 16,message = "长度只能在5到16之间")
    private String username;

    @NotNull
    @Size(min = 5,max = 25,message = "长度只能在5到25之间")
    private String firstName;

    @NotNull
    @Size(min = 2,max = 30,message = "长度只能在2到30之间")
    private String lastName;

    @NotNull
    @Size(min = 2,max = 39,message = "长度只能在2到30之间")
    private String password;

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this,o,new String[]{"id","firstName","lastName","password"});
    }

    @Override
    public int hashCode() {

        return HashCodeBuilder.reflectionHashCode(this,new String[]{"id","firstName","lastName","password"});
    }

    public Spitter(String username) {
        this.username = username;
    }

    public Spitter(String username, String firstName, String lastName, String password) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public Spitter(Long id, String username, String firstName, String lastName, String password) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public Spitter() {
    }
}


