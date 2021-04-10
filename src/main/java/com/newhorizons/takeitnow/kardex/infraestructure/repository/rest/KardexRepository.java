package com.newhorizons.takeitnow.kardex.infraestructure.repository.rest;

import com.newhorizons.takeitnow.kardex.application.mainmodule.dto.KardexDto;
import com.newhorizons.takeitnow.kardex.application.mainmodule.dto.ProductDto;
import com.newhorizons.takeitnow.kardex.application.mainmodule.mapper.IKardexMapper;
import com.newhorizons.takeitnow.kardex.application.mainmodule.mapper.IProductMapper;
import com.newhorizons.takeitnow.kardex.domain.entity.Kardex;
import com.newhorizons.takeitnow.kardex.domain.entity.Product;
import com.newhorizons.takeitnow.kardex.domain.repository.IKardexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository("repositoryRest")
public class KardexRepository implements IKardexRepository {

    @Autowired
    private RestTemplate restTemplateClient;

    @Autowired
    private IProductMapper productMapper;

    public List<KardexDto> getAll() {

        List<Product> products = Arrays.asList( restTemplateClient.getForObject("http://localhost:8001/takeitnow/api/products/getAll", Product[].class));
        List<ProductDto> productsDto =  productMapper.toProductsDto(products);


        return productsDto.stream().map(p -> new KardexDto(p, 1L)).collect(Collectors.toList());
    }

    public KardexDto getKardex(long productId, long quantity)
    {
        Map<String,String> pathVariables=new HashMap<String,String>();

        pathVariables.put("productId",Long.toString(productId));
        Product product = restTemplateClient.getForObject("http://localhost:8001/takeitnow/api/products/getProduct/{productId}", Product.class, pathVariables);
        ProductDto productDto= productMapper.toProductDto(product);
        return new KardexDto(productDto,quantity);

    }

}
