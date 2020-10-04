package com.warriorWars.puti.Warrior.WarriorPlayerManager;

import org.bukkit.entity.Player;

import com.warriorWars.puti.Warrior.WarriorClanManager.WarriorClan;
import com.warriorWars.puti.Warrior.WarriorClanManager.WarriorMember;

public class WarriorPlayer {

	/*
	 * FEITO por: SrPuti_
	 */
	
	public String WarriorPlayerName = null;
	public Player WarriorPlayer = null;
	public WarriorMember Warriormember = null;
	public WarriorClan Warriorclan = null;
	
	public WarriorPlayer(Player warriorPlayer) {
		this.WarriorPlayer = warriorPlayer;
		this.WarriorPlayerName = warriorPlayer.getName();
		this.Warriormember = WarriorMember.SEM_CARGO;
	}
	
	public String getName() {
		return this.WarriorPlayerName;
	}
	
	public Player getPlayer() {
		return this.WarriorPlayer;
	}
	
	public WarriorMember getWarriorGroup() {
		return this.Warriormember;
	}
	
	public void setWarriorGroup(WarriorMember Warriormember) {
		this.Warriormember = Warriormember;
	}
	
	public WarriorClan getWarriorclan() {
		return this.Warriorclan;
	}
	
	public void setWarriorclan(WarriorClan Warriorclan) {
		this.Warriorclan = Warriorclan;
	}
	
	
}
