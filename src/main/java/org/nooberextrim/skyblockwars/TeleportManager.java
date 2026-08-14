package org.nooberextrim.skyblockwars;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Objects;

public class TeleportManager {

    public void teleportPlayer(Player player, Location location) {
        Objects.requireNonNull(player, "player can not be null");
        Objects.requireNonNull(location, "location can not be null");

        player.teleport(location);
    }

    public void teleportTeam(Team team) {
        Objects.requireNonNull(team, "team can not be null");

        for(Player player : team.getPlayers()) {
            player.teleport(team.getSpawn());
        }
    }

    public void teleportTeams(List<Team> teams) {
        Objects.requireNonNull(teams, "team can not be null");

        for(Team team : teams) {
            teleportTeam(team);
        }
    }
}
