package br.com.edu.unit_tests.order.service;

import br.com.edu.unit_tests.order.domain.Order;

// Serviço de pagamento que será chamado no processo de criação do pedido
public interface PaymentService {
    boolean processPayment(Order order);
}

