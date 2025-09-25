package br.com.edu.unit_tests.order.service;

import br.com.edu.unit_tests.order.domain.Order;
import br.com.edu.unit_tests.order.repository.OrderRepository;

public class OrderService {

    private final OrderRepository repository;
    private final PaymentService paymentService;

    public OrderService(OrderRepository repository, PaymentService paymentService) {
        this.repository = repository;
        this.paymentService = paymentService;
    }

    public Order createOrder(String product, double amount) {
        Order order = new Order(product, amount);

        // Primeiro processa o pagamento
        boolean paid = paymentService.processPayment(order);
        if (!paid) {
            throw new IllegalStateException("Pagamento recusado para o pedido " + order.getId());
        }

        // Depois salva no repositório
        return repository.save(order);
    }

    public Order getOrderById(String id) {
        return repository.findById(id);
    }
}

