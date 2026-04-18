package com.ctbe.estifanos;

import com.ctbe.estifanos.dto.ProductResponse;
import com.ctbe.estifanos.model.Product;
import com.ctbe.estifanos.repository.ProductRepository;
import com.ctbe.estifanos.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceApplicationTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void findByIdReturnsProductWhenProductExists() {
        Product laptop = new Product("Laptop", 1200.0, 15, "Electronics");
        laptop.setId(1L);
        when(productRepository.findById(1L)).thenReturn(Optional.of(laptop));

        ProductResponse result = productService.findById(1L);

        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo("Laptop");
        assertThat(result.getPrice()).isEqualTo(1200.0);
        assertThat(result.getStockQty()).isEqualTo(15);
        assertThat(result.getCategory()).isEqualTo("Electronics");
    }

    @Test
    void findByIdThrowsExceptionWhenProductNotFound() {
        when(productRepository.findById(99L)).thenReturn(Optional.empty());

        org.junit.jupiter.api.Assertions.assertThrows(
            com.ctbe.estifanos.exception.ResourceNotFoundException.class,
            () -> productService.findById(99L)
        );
    }
}