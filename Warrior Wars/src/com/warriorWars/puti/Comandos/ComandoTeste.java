package com.warriorWars.puti.Comandos;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.warriorWars.puti.Main;

public class ComandoTeste implements CommandExecutor {
	/*
	 * FEITO por: SrPuti_ Comando teste para criar um WarriorClan
	 */

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if (!(sender instanceof Player)) {
			String nome = null;

			try {
				nome = args[0];
			} catch (Exception e) {

			}
			if (nome != null) {
				List<String> description = new ArrayList<>();
				description.add("");
				description.add("&eDescricao teste");
				description.add("");
				Main.getInstance().getWarriorManager().CreateNewWarriorClan(nome, "SrPuti_", description, null, null);
				Main.console.sendMessage("§cCriado");
			} else {
				sender.sendMessage("§cInsira o nome do WarriorClan.");
			}
		}
		return true;
	}

}
