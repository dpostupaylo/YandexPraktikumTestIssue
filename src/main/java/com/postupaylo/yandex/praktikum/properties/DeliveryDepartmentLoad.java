package com.postupaylo.yandex.praktikum.properties;

public enum DeliveryDepartmentLoad {
    Overload(1.6),
    Highload(1.4),
    Middleload(1.2),
    Normalload(1.1);

    private double ratio;

    public double getRatio(){
        return this.ratio;
    }

    DeliveryDepartmentLoad(double ratio){
        this.ratio = ratio;
    }

}
