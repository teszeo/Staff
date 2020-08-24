package cl.bgmp.staff.commands;

import cl.bgmp.staff.ChatConstant;
import cl.bgmp.staff.Staff;
import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import com.sk89q.minecraft.util.commands.CommandPermissions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class InventorySeeCommand {
  @Command(
      aliases = {"invsee", "inventorysee"},
      desc = "Revisa el inventario de un jugador.",
      min = 1,
      max = 1)
  @CommandPermissions("staff.invsee")
  public static void invsee(final CommandContext args, final CommandSender sender) {
    if (sender instanceof ConsoleCommandSender) {
      sender.sendMessage(ChatColor.RED + ChatConstant.NO_CONSOLE.getMessage());
      return;
    }

    String viewedPlayerName = args.getString(0);
    Player viewedPlayer = Bukkit.getPlayer(viewedPlayerName);
    if (viewedPlayer == null)
      sender.sendMessage(ChatColor.RED + ChatConstant.NO_SUCH_PLAYER.getMessage());
    else {
      Player viewer = (Player) sender;
      Staff.get().getInventoryTracker().previewInventory(viewer, viewedPlayer.getInventory());
    }
  }
}