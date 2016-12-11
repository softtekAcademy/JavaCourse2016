package com.softtek.academy.servlet.repository;

import java.util.ArrayList;
import java.util.List;

import com.softtek.academy.servlet.domain.model.State;


public class StateRepository {

	private static List<State> states = new ArrayList<State>();
	
	static {
		StateRepository.states.add(new State(1L, "Baja California"));
		StateRepository.states.add(new State(2L, "Baja California Sur"));
	}
	
	
	public State getOne(final Long id) {
		for (final State state : StateRepository.states) {
			if (state.getId() == id)
				return state;
		}
		
		return null;
	}
	
	public List<State> list() {
		return StateRepository.states;
	}
	
	public void save(final State state) {
		StateRepository.states.add(state);
	}
}