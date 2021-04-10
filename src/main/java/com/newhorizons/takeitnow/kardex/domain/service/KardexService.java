package com.newhorizons.takeitnow.kardex.domain.service;

import com.newhorizons.takeitnow.kardex.application.mainmodule.dto.KardexDto;
import com.newhorizons.takeitnow.kardex.application.mainmodule.service.IKardexService;
import com.newhorizons.takeitnow.kardex.domain.repository.IKardexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class KardexService implements IKardexService {

    @Autowired
    @Qualifier("repositoryFeign")
    private IKardexRepository kardexRepository;

    public  List<KardexDto> getAll() {

        return kardexRepository.getAll();
    }

    public KardexDto getKardex(long productId, long quantity) {

        return kardexRepository.getKardex(productId,quantity);

    }
}


