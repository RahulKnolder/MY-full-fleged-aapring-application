package com.knoldus.Myspring_projectfullFleged.controlleradvice;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ResourceNotFoundException extends RuntimeException{
    private static final long id = 1L;
    private String  errorCode;
   private String errorMessage;

}
