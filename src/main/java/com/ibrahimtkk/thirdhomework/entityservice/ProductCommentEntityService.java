package com.ibrahimtkk.thirdhomework.entityservice;

import com.ibrahimtkk.thirdhomework.converter.ProductCommentConverter;
import com.ibrahimtkk.thirdhomework.dto.ProductCommentDto;
import com.ibrahimtkk.thirdhomework.entity.ProductComment;
import com.ibrahimtkk.thirdhomework.repository.ProductCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductCommentEntityService {

    @Autowired
    private ProductCommentRepository productCommentRepository;

    public List<ProductComment> findAll() {
        return productCommentRepository.findAll();
    }

    public List<ProductComment> findByProductId(String productId) {
        return productCommentRepository.findByProductId(productId);
    }

    public ProductCommentDto save(ProductCommentDto productCommentDto) {
        final ProductComment productComment = productCommentRepository.save(ProductCommentConverter.INSTANCE.toProductComment(productCommentDto));

        return ProductCommentConverter.INSTANCE.toDto(productComment);
    }

    public void deleteById(String id) {
        productCommentRepository.deleteById(id);
    }

}