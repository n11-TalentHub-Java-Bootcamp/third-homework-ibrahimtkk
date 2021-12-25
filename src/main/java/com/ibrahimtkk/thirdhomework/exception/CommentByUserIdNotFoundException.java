package com.ibrahimtkk.thirdhomework.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CommentByUserIdNotFoundException extends RuntimeException {

    public CommentByUserIdNotFoundException(String userId) {
        super("There are no comments for "+ userId +" user yet. ");
    }
}
