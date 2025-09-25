package br.com.edu.unit_tests.order.domain;

import java.util.UUID;

// Entidade simples de pedido
public class Order {
    private final String id;
    private final String product;
    private final double amount;

    public Order(String product, double amount) {
        this.id = UUID.randomUUID().toString();
        this.product = product;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    public double getAmount() {
        return amount;
    }
}

