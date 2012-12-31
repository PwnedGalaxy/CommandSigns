package org.zonedabone.commandsigns.handler;

import org.bukkit.ChatColor;
import org.zonedabone.commandsigns.SignExecutor;

public class RandomHandler extends Handler {

	@Override
	public void handle(SignExecutor e, String command, boolean silent,
			boolean negate) {
		if (command.startsWith("`")) {
			double amount = 0;
			try {
				amount = Double.parseDouble(command.substring(1));
			} catch (NumberFormatException ex) {
				return;
			}
			amount /= 100;
			if ((Math.random() < amount) ^ negate) {
				e.getRestrictions().push(true);
			} else {
				e.getRestrictions().push(false);
				if (!silent && e.getPlayer() != null)
					e.getPlayer()
							.sendMessage(
									ChatColor.RED
											+ "You aren't lucky enough to use this sign.");
			}
		}

	}

}