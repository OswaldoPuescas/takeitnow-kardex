package com.newhorizons.takeitnow.kardex.domain.repository;

import com.newhorizons.takeitnow.kardex.application.mainmodule.dto.KardexDto;
import com.newhorizons.takeitnow.kardex.application.mainmodule.dto.ProductDto;

import java.util.List;

public interface IKardexRepository {

    List<KardexDto> getAll();
    KardexDto getKardex(long productId,long quantity) ;
}
