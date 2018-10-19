package com.example.democache;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "The resource requested does not exist")
public class ResourceNotFoundException extends RuntimeException {
}
