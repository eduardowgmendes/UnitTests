package br.com.edu.unit_tests.order.service;


import com.example.demo.infrastructure.OrderRepository;
import com.example.demo.infrastructure.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Testes unitários para OrderService usando Mockito.
 */
@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @InjectMocks
    private OrderService service; // Classe sob teste

    @Mock
    private OrderRepository repository; // Dependência mockada

    @Mock
    private PaymentService paymentService; // Outra dependência mockada

    private Order order;

    @BeforeEach
    void setUp() {
        order = new Order("Notebook", 3500.00);
    }

    @Test
    void shouldCreateOrderWhenPaymentIsSuccessful() {
        // Configura o comportamento esperado dos mocks:
        // pagamento aprovado e repositório salvando o pedido
        when(paymentService.processPayment(any(Order.class))).thenReturn(true);
        when(repository.save(any(Order.class))).thenReturn(order);

        // Executa a criação do pedido
        Order created = service.createOrder("Notebook", 3500.00);

        // Verifica se o pagamento foi processado
        verify(paymentService).processPayment(any(Order.class));

        // Verifica se o pedido foi salvo
        verify(repository).save(any(Order.class));

        // Garante que o pedido criado não é nulo e tem os dados esperados
        assertThat(created, notNullValue());
        assertThat(created.getProduct(), is("Notebook"));
        assertThat(created.getAmount(), is(3500.00));
    }

    @Test
    void shouldThrowExceptionWhenPaymentFails() {
        // Configura o mock do pagamento para falhar
        when(paymentService.processPayment(any(Order.class))).thenReturn(false);

        // Verifica que uma exceção é lançada
        assertThrows(IllegalStateException.class, () -> service.createOrder("Notebook", 3500.00));

        // Garante que o repositório nunca foi chamado, já que o pagamento falhou
        verifyNoInteractions(repository);
    }

    @Test
    void shouldReturnOrderWhenFoundInRepository() {
        // Configura o mock do repositório para retornar um pedido ao buscar por ID
        when(repository.findById(order.getId())).thenReturn(order);

        // Executa a busca
        Order found = service.getOrderById(order.getId());

        // Verifica se o método findById foi chamado com o ID correto
        verify(repository).findById(order.getId());

        // Garante que o pedido encontrado é o esperado
        assertThat(found, is(order));
    }

    @Test
    void shouldReturnNullWhenOrderNotFound() {
        // Configura o repositório para retornar null quando o ID não existir
        when(repository.findById("fake-id")).thenReturn(null);

        // Executa a busca
        Order found = service.getOrderById("fake-id");

        // Verifica se o método foi chamado
        verify(repository).findById("fake-id");

        // Confirma que o retorno é null
        assertThat(found, nullValue());
    }
}

