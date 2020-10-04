package com.warriorWars.puti.Warrior;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.warriorWars.puti.Main;
import com.warriorWars.puti.Warrior.WarriorPlayerManager.WarriorPlayer;

public class WarriorManager {

	/*
	 * FEITO por: SrPuti_
	 */
	
	private static String diretory = "plugins/WarriorWars/WarriorClans/";

	public boolean Exist(String WarriorClanName) {
		File arquivo = new File(diretory + WarriorClanName + ".yml");
		FileConfiguration local = YamlConfiguration.loadConfiguration(arquivo);

		if (local.getString(WarriorClanName + ".Nome") != null) {
			return true;
		}
		return false;
	}

	public void CreateNewWarriorClan(String name, String owner, List<String> description, List<WarriorPlayer> members,
			List<Location> chunksDomination) {
		if (!Exist(name)) {
			File file = new File(diretory + name + ".yml");
			FileConfiguration local = YamlConfiguration.loadConfiguration(file);

			local.set("WarriorClan.Nome", name);
			local.set("WarriorClan.Lider", owner);
			local.set("WarriorClan.Descricao", description);
			if (members != null) {
			local.set("WarriorClan.Membros", members);
			}
			if (chunksDomination != null) {
			local.set("WarriorClan.Chunks_Dominadas", chunksDomination);
			}
			try {
				local.save(file);
			} catch (IOException e) {
				Main.console.sendMessage("§cNão foi possível criar o WarriorClanName `" + name
						+ "`, erro causado por: §f" + e.getCause());
			}
		}
	}

	public void RemoveWarriorClan(String WarriorClanName) {
		if (Exist(WarriorClanName)) {
			File arquivo = new File(diretory + WarriorClanName + ".yml");

			try {
				arquivo.delete();
			} catch (Exception e) {
				Main.console.sendMessage("§cNão foi possível excluir o WarriorClanName `" + WarriorClanName
						+ "`, erro causado por: §f" + e.getCause());
			}
		}
	}

	public File[] getFiles(){
		File directories = new File(diretory);
        if (!directories.exists()) {
            directories.mkdir();
        }
        File[] fileList = directories.listFiles();
        
        return fileList;
	}
	
	public FileConfiguration getWarriorClan(String WarriorClanName) {
		File arquivo = new File(diretory + WarriorClanName + ".yml");
		FileConfiguration local = YamlConfiguration.loadConfiguration(arquivo);

		if (local.getString(WarriorClanName + ".Nome") != null) {
			return local;
		}
		return null;
	}
	
	public Object  getWarriorProperty(FileConfiguration file,String value) {
		return file.getString("WarriorClan."+ value);
	}

}
