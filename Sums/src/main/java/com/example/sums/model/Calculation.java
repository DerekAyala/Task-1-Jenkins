package com.example.sums.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Calculation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int num1;
    private int num2;
    private int sum;

    // generate getters and setters here


    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Calculation)) return false;
        Calculation that = (Calculation) o;
        return num1 == that.num1 &&
                num2 == that.num2 &&
                sum == that.sum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num1, num2, sum);
    }
}
