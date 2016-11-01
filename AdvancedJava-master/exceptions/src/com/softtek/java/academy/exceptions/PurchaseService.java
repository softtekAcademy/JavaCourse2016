package com.softtek.java.academy.exceptions;

import java.util.UUID;

public class PurchaseService {

    public void verifyPurchase(UUID uuid) {

        System.out
            .println("Check if we need to purchase more products with ID "
                + uuid);
    }

}
