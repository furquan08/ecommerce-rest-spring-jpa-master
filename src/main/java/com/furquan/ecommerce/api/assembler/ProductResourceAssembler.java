package com.furquan.ecommerce.api.assembler;

import com.furquan.ecommerce.api.controller.ProductController;
import com.furquan.ecommerce.api.resource.ProductResource;
import com.furquan.ecommerce.entity.Product;

import io.jsonwebtoken.lang.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

/**
 * Transform {@link Product} into {@link ProductResource} DTO
 *
 * @author furquan
 */
@Component
public class ProductResourceAssembler extends ResourceAssemblerSupport<Product, ProductResource> {

    @Autowired
    private CategoryResourceAssembler categoryResourceAssembler;

    public ProductResourceAssembler() {
        super(ProductController.class, ProductResource.class);
    }

    @Override
    protected ProductResource instantiateResource(Product entity) {
        return new ProductResource(
            entity.getName(),
            Product.CURRENCY,
            entity.getPrice(),
            !Collections.isEmpty(entity.getCategories()) ? categoryResourceAssembler.toResources(entity.getCategories()) : null,
            entity.getUser().getUsername()
        );
    }

    @Override
    public ProductResource toResource(Product entity) {
        return createResourceWithId(entity.getId(), entity);
    }

}
