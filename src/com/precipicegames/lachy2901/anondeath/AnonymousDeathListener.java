package com.precipicegames.lachy2901.anondeath;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerChatEvent;

public class AnonymousDeathListener implements Listener{

	AnonymousDeath plugin;
	
	public AnonymousDeathListener(AnonymousDeath instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event) {
		plugin.deadList.add(event.getEntity().getName());
		event.setDeathMessage(ChatColor.RED + "Someone has died!");
	}
	
	@EventHandler
	public void onPlayerChat(PlayerChatEvent event) {
		if (plugin.isRecap) {
			event.setCancelled(true);
		}
	}
	
}
