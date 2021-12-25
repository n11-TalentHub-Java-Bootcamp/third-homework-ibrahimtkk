package com.ibrahimtkk.thirdhomework.repository;

import com.ibrahimtkk.thirdhomework.entity.ProductComment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductCommentRepository extends MongoRepository<ProductComment, String> {

    List<ProductComment> findByProductId(String productId);
}