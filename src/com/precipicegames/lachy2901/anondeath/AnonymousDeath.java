package com.precipicegames.lachy2901.anondeath;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class AnonymousDeath extends JavaPlugin {
	
	ArrayList<String> deadList = new ArrayList<String>();
	boolean isRecap = false;
	
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(new AnonymousDeathListener(this), this);
		deadList.add("derp");
		deadList.add("herp");
		deadList.add("sherp");
	}
	
	public void onDisable() {
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (commandLabel.equalsIgnoreCase("deathroll")) {
			if (sender.isOp()) {
				Server server = this.getServer();
				isRecap = true;
				server.broadcastMessage(ChatColor.DARK_GREEN + "" +  ChatColor.BOLD + "Death Recap:");
				this.getServer().getScheduler().scheduleAsyncDelayedTask(this, new DeathRoll(deadList, this));
			}
		}
		
		return true;
	}
	
}