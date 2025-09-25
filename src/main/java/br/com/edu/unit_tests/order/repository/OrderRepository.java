package br.com.edu.unit_tests.order.repository;

import br.com.edu.unit_tests.order.domain.Order;

// Repositório responsável por salvar e buscar pedidos
public interface OrderRepository {
    Order save(Order order);

    Order findById(String id);
}

