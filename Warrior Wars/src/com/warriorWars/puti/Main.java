package com.warriorWars.puti;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.warriorWars.puti.Comandos.ComandoTeste;
import com.warriorWars.puti.Warrior.WarriorManager;
import com.warriorWars.puti.Warrior.WarriorClanManager.WarriorClan;
import com.warriorWars.puti.Warrior.WarriorPlayerManager.WarriorPlayer;

public class Main extends JavaPlugin{
	
	/*
	 * FEITO por: SrPuti_
	 */
	
	private static Main instance;
	
	
	private static WarriorManager Warriormanager;
	private List<WarriorClan> warriorClans = new ArrayList<WarriorClan>();
	private List<WarriorPlayer> warriorPlayers = new ArrayList<WarriorPlayer>();
	
	public static ConsoleCommandSender console = Bukkit.getConsoleSender();
	
	@Override
	public void onEnable() {
		instance = this;
		Warriormanager = new WarriorManager();
		getCommand("teste").setExecutor(new ComandoTeste());
		try {
			saveDefaultConfig();
			CarregawarriorClans();
			CarregaWarriorPlayer();
		} catch (Exception e) {
			console.sendMessage("§cNão foi possível carrega as propriedades do WarriorWars, desabilitando o plugin para evitar erros.");
			e.printStackTrace();
			getPlugin(Main.class).getPluginLoader().disablePlugin(this);
		}
		
	}
	
	
	@Override
	public void onDisable() {
		instance = null;
	
	}
	
	@SuppressWarnings("unchecked")
	private void CarregawarriorClans() {
		if (Warriormanager.getFiles() != null) {
			for (File file : Warriormanager.getFiles()) {
				if (file  != null) {
					console.sendMessage("§6FileName: §c"+file.getName());
					FileConfiguration warrriorConfig = Warriormanager.getWarriorClan(file.getName());
					if (warrriorConfig != null) {
						try {
							WarriorClan warriorClan = new WarriorClan((Player) Warriormanager.getWarriorProperty(warrriorConfig, "Lider"));
							warriorClan.setWarriorMembers((List<WarriorPlayer>) Warriormanager.getWarriorProperty(warrriorConfig, "Membros"));
							warriorClan.setWarriorChunks((List<Location>) Warriormanager.getWarriorProperty(warrriorConfig, "Chunks_Dominadas"));
							warriorClan.setWarriorDescription((List<String>) Warriormanager.getWarriorProperty(warrriorConfig, "Descricao"));
							warriorClan.setWarriorName((String) Warriormanager.getWarriorProperty(warrriorConfig, "Nome"));
							warriorClans.add(warriorClan);
						} catch (Exception e) {
							Main.console.sendMessage("§cNão foi possível carrega a WarriorClanName.");
						}
						}
				}
			}
		}else {
			console.sendMessage("§cNenhum WarriorClan encontrado crie um para que seja carregado.");
		}
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public void CarregaWarriorPlayer()
	{
		if (warriorClans.size() > 0) {
			for (WarriorClan warriorClan : warriorClans) {
				FileConfiguration warrriorConfig = Warriormanager.getWarriorClan(warriorClan.getWarriorClanName());
				if (warrriorConfig != null) {
					List<String> members = (List<String>) Warriormanager.getWarriorProperty(warrriorConfig, "Membros");
					for (String player : members) {
						if (player != null) {
							WarriorPlayer warriorPlayer = null;
							if (Bukkit.getPlayer(player) != null) {
								warriorPlayer = new WarriorPlayer(Bukkit.getPlayer(player));
							}else {
								warriorPlayer = new WarriorPlayer(Bukkit.getOfflinePlayer(player).getPlayer());								
							}
							if (warriorPlayer != null) {
								warriorPlayers.add(warriorPlayer);
							}
						}
					}
				}
			}
		}
		
	}
	
	public WarriorManager getWarriorManager() {
		return Warriormanager;
	}
	
	public static Main getInstance() {
		return instance;
	}
	
}
