package org.nooberextrim.skyblockwars.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.nooberextrim.skyblockwars.Game;
import org.nooberextrim.skyblockwars.TeamManager;

import java.util.Objects;

public class SkyblockCommand implements CommandExecutor {

    private final TeamManager teamManager;

    public SkyblockCommand(TeamManager teamManager) {
        Objects.requireNonNull(teamManager, "teamManager can not be null");

        this.teamManager = teamManager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender,
                             @NotNull Command command,
                             @NotNull String label,
                             @NotNull String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players can use this command");
            return true;
        }

        if (args.length == 0) {
            player.sendMessage("/sbw <command>");
            return true;
        }

        switch (args[0].toLowerCase()) {

            case "jointeam":
                handleJoinTeam(player, args);
                break;

            case "leave":
                handleLeave(player);
                break;

            default:
                player.sendMessage("Unknown command.");
                break;
        }

        return true;
    }

    private void handleJoinTeam(Player player, String[] args) {

        if(args.length < 2) {
            player.sendMessage("/sbw jointeam <team>");
            return;
        }

        String teamName = args[1];

        teamManager.findTeamByName(teamName)
                .ifPresentOrElse(
                        team -> {

                            boolean joined = teamManager.joinTeam(player, team);

                            if(joined) {
                                player.sendMessage("Joined " + team.getName());
                            }
                            else {
                                player.sendMessage("Could not join team.");
                            }

                        },
                        () -> player.sendMessage("Team does not exist.")
                );
    }

    private void handleLeave(Player player) {

        boolean left = teamManager.leaveTeam(player);

        if(left) {
            player.sendMessage("Left team.");
        }
        else {
            player.sendMessage("You are not in a team.");
        }
    }
}