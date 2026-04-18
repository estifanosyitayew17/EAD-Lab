package com.ctbe.estifanos.service;

import com.ctbe.estifanos.dto.ProductRequest;
import com.ctbe.estifanos.dto.ProductResponse;
import com.ctbe.estifanos.exception.ResourceNotFoundException;
import com.ctbe.estifanos.model.Product;
import com.ctbe.estifanos.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    public List<ProductResponse> findAll() {
        return productRepository.findAll().stream()
            .map(this::toResponse)
            .collect(Collectors.toList());
    }
    
    public ProductResponse findById(Long id) {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(id));
        return toResponse(product);
    }
    
    public ProductResponse create(ProductRequest request) {
        Product product = new Product(
            request.getName(),
            request.getPrice(),
            request.getStockQty(),
            request.getCategory()
        );
        Product saved = productRepository.save(product);
        return toResponse(saved);
    }
    
    public ProductResponse update(Long id, ProductRequest request) {
        Product existing = productRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(id));
        existing.setName(request.getName());
        existing.setPrice(request.getPrice());
        existing.setStockQty(request.getStockQty());
        existing.setCategory(request.getCategory());
        Product updated = productRepository.save(existing);
        return toResponse(updated);
    }
    
    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        productRepository.deleteById(id);
    }
    
    private ProductResponse toResponse(Product product) {
        return new ProductResponse(
            product.getId(),
            product.getName(),
            product.getPrice(),
            product.getStockQty(),
            product.getCategory()
        );
    }
}