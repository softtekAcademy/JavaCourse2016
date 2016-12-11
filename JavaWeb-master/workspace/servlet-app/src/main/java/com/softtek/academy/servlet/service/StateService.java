package com.softtek.academy.servlet.service;

import java.util.List;

import com.softtek.academy.servlet.domain.model.State;
import com.softtek.academy.servlet.repository.StateRepository;

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
	
	public State save(final Long id, final String description) {
		final State state = new State(id, description);
		
		stateRepository.save(state);
		
		return state;
	}
}
