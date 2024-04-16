package br.com.spring.project.Exceptions;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ExceptionResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date timeStamp;
    private String message;
    private String details;

}
