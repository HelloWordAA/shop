package pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * yzw
 * 2022/12/6
 */
@AllArgsConstructor
@NoArgsConstructor
public class Test {
    private String name ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
