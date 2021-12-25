package com.ibrahimtkk.thirdhomework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import java.util.Date;

@Document(collection = "PRODUCT_COMMENT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductComment {

    @Id
    private String id;
    private String comment;
    private Date commentDate;
    private String productId;
    private Long userId;


}
