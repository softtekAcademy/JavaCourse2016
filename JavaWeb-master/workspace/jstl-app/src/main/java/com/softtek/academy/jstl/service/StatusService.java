package com.softtek.academy.jstl.service;

import java.util.List;

import com.softtek.academy.jstl.domain.model.Status;
import com.softtek.academy.jstl.repository.StatusRepository;

public class StatusService {
    
	private StatusRepository statusRepository = new StatusRepository();


    public List<Status> getCartStatus() {
        return this.statusRepository.getStatus("CART");
    }
}
