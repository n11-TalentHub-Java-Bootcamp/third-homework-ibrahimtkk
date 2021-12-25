package com.ibrahimtkk.thirdhomework.controller;

import com.ibrahimtkk.thirdhomework.converter.ProductCommentConverter;
import com.ibrahimtkk.thirdhomework.dto.ProductCommentDto;
import com.ibrahimtkk.thirdhomework.entity.ProductComment;
import com.ibrahimtkk.thirdhomework.entityservice.ProductCommentEntityService;
import com.ibrahimtkk.thirdhomework.exception.CommentByUserIdNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/comments/")
public class CommentController {

    @Autowired
    private ProductCommentEntityService productCommentEntityService;

    @GetMapping("")
    public List<ProductCommentDto> findAllComments() {

        List<ProductComment> productComments = productCommentEntityService.findAll();

        return productComments.stream()
                .map(ProductCommentConverter.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/product/{productId}")
    public List<ProductComment> findByProductId(@PathVariable String productId) {
        List<ProductComment> productComments = productCommentEntityService.findByProductId(productId);
        if (productComments.size() == 0)
            throw new CommentByUserIdNotFoundException(productId);
        return productComments;
    }

    @PostMapping("")
    public ProductCommentDto save(@RequestBody ProductCommentDto productCommentDto) { //TODO: Input değeri dto tipinde olmalı

        productCommentDto = productCommentEntityService.save(productCommentDto);
        return productCommentDto;
    }

    @DeleteMapping("{commentId}")
    public void deleteUser(@PathVariable String commentId) {
        productCommentEntityService.deleteById(commentId);
    }

}
