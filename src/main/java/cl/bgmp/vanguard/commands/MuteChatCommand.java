package cl.bgmp.vanguard.commands;

import cl.bgmp.minecraft.util.commands.CommandContext;
import cl.bgmp.minecraft.util.commands.annotations.Command;
import cl.bgmp.minecraft.util.commands.annotations.CommandPermissions;
import cl.bgmp.minecraft.util.commands.annotations.CommandScopes;
import cl.bgmp.vanguard.Permissions;
import cl.bgmp.vanguard.staffmode.modules.MuteChatModule;
import org.bukkit.command.CommandSender;

public class MuteChatCommand {
  private MuteChatModule mcm;

  public MuteChatCommand(MuteChatModule mcm) {
    this.mcm = mcm;
  }

  @Command(
      aliases = {"mutechat"},
      desc = "Silencia el chat.",
      max = 0)
  @CommandPermissions(Permissions.MUTE_CHAT)
  @CommandScopes({"player", "console"})
  public void staffMode(CommandContext args, CommandSender sender) {
    this.mcm.muteChatBy(sender);
  }
}
