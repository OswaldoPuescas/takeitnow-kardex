package com.newhorizons.takeitnow.kardex.presentation.web.controller;

import com.newhorizons.takeitnow.kardex.application.mainmodule.dto.KardexDto;
import com.newhorizons.takeitnow.kardex.application.mainmodule.service.IKardexService;
import com.newhorizons.takeitnow.kardex.domain.entity.Kardex;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RefreshScope
@RestController
@RequestMapping("/kardexs")
public class KardexController {

    @Autowired
    private IKardexService kardexService;

    @GetMapping("/getAll")
    @ApiOperation("Get all item.")
    @ApiResponse(code=200,message = "SUCCESS")
    public List<KardexDto> getAll()
    {
        return kardexService.getAll();
    }

    @GetMapping("/getKardex/{productId}/{quantity}")

    @ApiOperation("Get item by ID")
    @ApiResponses({
            @ApiResponse(code=200,message = "SUCCESS"),
            @ApiResponse(code=404,message = "PRODUCT NOT FOUND")
    })


    public KardexDto getKardex(@ApiParam(value="This ID of item.", example = "5", required = true)
                                   @PathVariable("productId") long productId, @ApiParam(value="This cantidad of item.", example = "4", required = true) @PathVariable("quantity") long quantity)
    {
        return kardexService.getKardex(productId,quantity);
    }



}
