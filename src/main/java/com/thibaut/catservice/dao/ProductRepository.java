package com.thibaut.catservice.dao;

import com.thibaut.catservice.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("*")
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
    @RestResource( path= "/byDesignation")
    List<Product> findByDesignationContains(@Param("mc") String des);

    // products/search/byDesignationPage?mc=test&page=0&size=2
    @RestResource( path= "/byDesignationPage")
    Page<Product> findByDesignationContains(@Param("mc") String des, Pageable pageable);
}

