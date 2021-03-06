package com.furquan.ecommerce.exception;

/**
 * Defines an exception to be thrown when an entity is not found.
 *
 * @author furquan
 */
public class NotFoundException extends RuntimeException {

    public NotFoundException(String entity) {
        super(entity + " not found");
    }

}
