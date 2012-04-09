package com.precipicegames.lachy2901.anondeath;

import java.util.ArrayList;

import org.bukkit.ChatColor;

public class DeathRoll implements Runnable{

	ArrayList<String> deadList;
	AnonymousDeath plugin;
	
	public DeathRoll(ArrayList<String> dead, AnonymousDeath instance) {
		deadList = dead;
		plugin = instance;
	}

	@Override
	public void run() {
		
		for (String s : deadList) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			plugin.getServer().broadcastMessage(ChatColor.DARK_PURPLE + s);
		}
		
		plugin.isRecap = false;
		plugin.getServer().broadcastMessage(ChatColor.DARK_GREEN + "" +  ChatColor.BOLD + "End Death Recap");
		
	}
}
