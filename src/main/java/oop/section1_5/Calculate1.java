package oop.section1_5;

public enum Calculate1 {
    ADD {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }

    },
    MULTIPLY {
        @Override
        public double apply(double x, double y) {
            return x * y;
        }

    },
    DIVIDE {
        @Override
        public double apply(double x, double y) {
            return x / y;
        }

    };
    public abstract double apply(double x, double y);
}
