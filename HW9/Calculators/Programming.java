package Calculators;

public class Programming extends Simple {
    private double memory = 0.0;

    public void storeInMemory(double value) {

        memory = value;

    }

    public double recallFromMemory() {

        return memory;

    }
}
