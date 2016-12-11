package com.softtek.academy.jsp.repository;

import java.util.ArrayList;
import java.util.List;

import com.softtek.academy.jsp.domain.model.State;


public class StateRepository {

	private static List<State> states = new ArrayList<State>();
	
	static {
		StateRepository.states.add(new State(1L, "Baja California"));
		StateRepository.states.add(new State(2L, "Baja California Sur"));
	}
	
	
	public State getOne(final Long id) {
		for (final State state : StateRepository.states) {
			if (state.getId().equals(id))
				return state;
		}
		
		return null;
	}
	
	public List<State> list() {
		return StateRepository.states;
	}
	
	public State save(final String description) {
		final Long id = new Long(StateRepository.states.size() + 1);
		final State state = new State(id, description);
		
		StateRepository.states.add(state);
		
		return state;
	}
	
	public State update (final Long id, final String description) {
		State state = this.getOne(id);
		state.setDescription(description);
		
		return state;
	}
}