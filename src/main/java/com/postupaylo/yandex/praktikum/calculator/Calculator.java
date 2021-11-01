package com.postupaylo.yandex.praktikum.calculator;

import com.postupaylo.yandex.praktikum.cargo.Cargo;
import com.postupaylo.yandex.praktikum.exceptions.NondeliverableException;

import static com.postupaylo.yandex.praktikum.properties.Properties.MINIMUM_PRICE;

public class Calculator {
    private float price;

    public float calculatePriceOfDelivery(float distance, boolean big, boolean fragile, double deliveryLoad) throws NondeliverableException{
        price = MINIMUM_PRICE;

        Cargo cargo = new Cargo.Builder().setBig(big).setFragileProperty(fragile).build();
        if (distance < 2.0f){
            price += 50.0f;
        } else if (distance < 10.0f){
            price += 100.0f;
        } else if (distance < 30.0f){
            price += 200.0f;
        } else if (!cargo.isFragile()) {
            price += 300.0f;
        } else {
            throw new NondeliverableException(String.format("Unable to calculate price for %f distance because cargo is fragile", distance));
        }

        if (cargo.isFragile())
            price += 300.0f;

        if (cargo.isBig())
            price += 200.0f;
        else
            price += 100.0f;

        price *= deliveryLoad;

        return price;
    }
}
