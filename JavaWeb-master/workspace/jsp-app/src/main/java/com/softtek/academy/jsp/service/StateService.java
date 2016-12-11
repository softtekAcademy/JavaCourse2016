package com.softtek.academy.jsp.service;

import java.util.List;

import com.softtek.academy.jsp.domain.model.State;
import com.softtek.academy.jsp.repository.StateRepository;

public class StateService {
	
	private StateRepository stateRepository;
	
	
	public StateService() {
		stateRepository = new StateRepository();
	}
	
	
	public State getOne(final Long id) {
		return stateRepository.getOne(id);
	}
	
	public List<State> list() {
		return stateRepository.list();
	}
	
	public State save(final String description) {
		State state = null;
		
		if (!description.trim().isEmpty())
			state = stateRepository.save(description);
		
		return state;
	}
	
	public State update(final Long id, final String description) {
		State state = null;
		
		if (!description.trim().isEmpty())
			state = stateRepository.update(id, description);
		
		return state;
	}
}
