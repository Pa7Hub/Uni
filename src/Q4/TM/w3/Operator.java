package Q4.TM.w3;

public enum Operator {
    ADDITION {
        public int apply(Integer x1, Integer x2) {
            return x1 + x2;
        }
    },
    SUBTRACTION {
        public int apply(Integer x1, Integer x2) {
            return x1 - x2;
        }
    }
}
