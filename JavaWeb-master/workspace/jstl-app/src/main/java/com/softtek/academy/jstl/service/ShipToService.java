package com.softtek.academy.jstl.service;

import java.util.List;

import com.softtek.academy.jstl.domain.model.ShipTo;
import com.softtek.academy.jstl.repository.ShipToRepository;

public class ShipToService {
	
    private ShipToRepository shipToRepository = new ShipToRepository();

    public List<ShipTo> list() {
        return this.shipToRepository.list();
    }
}
