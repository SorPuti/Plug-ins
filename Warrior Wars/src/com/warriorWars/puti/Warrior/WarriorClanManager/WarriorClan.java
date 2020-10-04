package com.warriorWars.puti.Warrior.WarriorClanManager;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import com.warriorWars.puti.Warrior.WarriorPlayerManager.WarriorPlayer;

public class WarriorClan {

	/*
	 * FEITO por: SrPuti_
	 */
	
	public String WarriorClanName;
	public List<Location> chunks = new ArrayList<Location>();
	public List<WarriorPlayer> WarriorMembers = new ArrayList<WarriorPlayer>();
	public Player WarriorOwner;
	public OfflinePlayer WarriorOwnerOff;
	public List<String> WarriorDescription = new ArrayList<String>();

	public WarriorClan(Player owner) {
		this.WarriorOwner = owner;
		this.WarriorMembers.add(new WarriorPlayer(owner));
	}

	@SuppressWarnings("deprecation")
	public WarriorClan(String owner) {
		try {
			this.WarriorOwner = Bukkit.getPlayer(owner);
		} catch (Exception e) {
			this.WarriorOwnerOff = Bukkit.getOfflinePlayer(owner);
		}
	}

	public void adWarriorChunk(Location chunk) {
		this.chunks.add(chunk);
	}

	public void setWarriorChunks(List<Location> chunks) {
		this.chunks = chunks;
	}

	public void setWarriorMembers(List<WarriorPlayer> WarriorMembers) {
		this.WarriorMembers = WarriorMembers;
	}

	public void addWarriorMember(WarriorPlayer WarriorPlayer) {
		this.WarriorMembers.add(WarriorPlayer);
	}

	public void setWarriorDescription(List<String> WarriorDescription) {
		this.WarriorDescription = WarriorDescription;
	}

	public void addWarriorDescrition(String WarriorDescription) {
		this.WarriorDescription.add(WarriorDescription);
	}

	public void setWarriorOwner(Player owner) {
		this.WarriorOwner = owner;
	}

	public void setWarriorName(String warriorClanName) {
	this.WarriorClanName = warriorClanName;	
	}
	
	public List<String> getWarriorDescription() {
		return this.WarriorDescription;
	}

	public Player getWarriorOwner() {
		return this.WarriorOwner;
	}

	public OfflinePlayer getWarriorOwnerOff() {
		return this.WarriorOwnerOff;
	}
	
	public String getWarriorClanName() {
		return this.WarriorClanName;
	}

	public List<WarriorPlayer> getWarriorMembers() {
		return this.WarriorMembers;
	}

	public WarriorPlayer getWarriorMember(String value) {
		for (WarriorPlayer warriorPlayer : WarriorMembers) {
			return warriorPlayer;
		}
		return null;
	}
	
	public List<Location> getWarriorChunks(){
		return this.chunks;
	}
	
	public Location getWarriorChunk(Location value) {
		Location location = new Location(value.getWorld(), value.getX(), value.getY(), value.getZ());
		return location;
	}

}
