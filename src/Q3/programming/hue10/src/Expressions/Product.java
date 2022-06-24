package Q3.programming.hue10.src.Expressions;

import java.util.Objects;

public class Product implements Summand {
    Factor _factor;
    Summand _summand;

    public Product(Factor factor, Summand summand) {
        _factor = factor;
        _summand = summand;
    }

    @Override
    public Integer evaluate() {
        return _factor.evaluate() * _summand.evaluate();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(_factor, product._factor) && Objects.equals(_summand, product._summand);
    }
}
