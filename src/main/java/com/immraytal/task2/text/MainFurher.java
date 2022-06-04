package com.immraytal.task2.text;

import java.util.ArrayList;
import java.util.List;

abstract class Flower {
    String name;
    Double price;

    public Flower(Double price) {
        this.price = price;
    }
}

class Rosa extends Flower {
    String color;

    public Rosa(Double price) {
        super(price);
    }
}

class Fialka extends Flower {
    String rating;

    public Fialka(Double price) {
        super(price);
    }
}



class Bucket {

    private List<Flower> flowers;

    public Bucket(List<Flower> flowers) {
        this.flowers = flowers;
    }

    @Override
    public String toString() {
        double sum = 0;
        for (Flower flower:flowers) {
            sum+=flower.price;
        }
        System.out.println(sum);
        return String.valueOf(sum);
    }
}

class MainFurher {
    public static void main(String[] args) {
        List<Flower> flowers = new ArrayList<>();
        flowers.add(new Rosa(123D));
        flowers.add(new Fialka(22D));
        Bucket bucket = new Bucket(flowers);
        System.out.println(bucket);
    }
}
