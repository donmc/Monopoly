package com.monopoly.domain;

public class RollResult {
	private Square location;
	private boolean passedGo;
	
	public RollResult(Square location, boolean passedGo){
		this.location = location;
		this.passedGo = passedGo;
	}
	
	public boolean passedGo() {
		return passedGo;
	}
	public Square getLocation() {
		return location;
	}
}
