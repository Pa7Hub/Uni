package Q3.programming.hue10.src.Expressions;

import java.util.Objects;

public class NatNumber implements Factor {
    Integer _number;

    public NatNumber(String string) {
        _number = Integer.parseInt(string);
    }

    public NatNumber(Integer number) {
        _number = number;
    }

//    public NatNumber(Integer num) {
//        _number = num;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NatNumber num = (NatNumber) o;
        return Objects.equals(_number, num._number);
    }

    @Override
    public Integer evaluate() {
        return _number;
    }
}
