package net.kayega;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PlayerCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("playercommand") ||
                command.getName().equalsIgnoreCase("pcommand")) {
            if (!(sender instanceof Player)) {
                performCommandInPlayer(sender, args, false);
            } else {
                Player player = (Player) sender;
                if (player.hasPermission("commandexecutor.use")) {
                    performCommandInPlayer(sender, args, true);
                } else {
                    sender.sendMessage("§6[§aCommand Executor§6] §cYou are not authorized to use this command!");
                }
            }
        }
        return true;
    }

    public void performCommandInPlayer(CommandSender sender, String[] args, boolean player) {
        if (args.length >= 2) {
            Player target = Bukkit.getServer().getPlayer(args[0]);
            if (target != null) {
                target.performCommand(getFinalArg(args, 1));
                if (player) {
                    sender.sendMessage("§6[§aCommand Executor§6] §aCommand sending successful!");
                }
            } else {
                sender.sendMessage("§6[§aCommand Executor§6] §cPlayer not found!");
            }
        }
    }

    public static String getFinalArg(String[] args, int start) {
        StringBuilder bldr = new StringBuilder();
        for (int i = start; i < args.length; i++) {
            if (i != start)
                bldr.append(" ");
            bldr.append(args[i]);
        }
        return bldr.toString();
    }
}
