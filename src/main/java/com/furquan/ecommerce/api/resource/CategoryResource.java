package com.furquan.ecommerce.api.resource;

import org.springframework.hateoas.ResourceSupport;

/**
 * Spring HATEOAS-oriented DTO for {@see Category} entity
 *
 * @author furquan
 */
public class CategoryResource extends ResourceSupport {

    private final String name;

    public CategoryResource(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
