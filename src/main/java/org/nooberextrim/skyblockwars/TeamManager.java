package org.nooberextrim.skyblockwars;

import org.bukkit.entity.Player;

import java.util.*;

public class TeamManager {
    private final List<Team> teams;

    public TeamManager(List<Team> teams) {
        Objects.requireNonNull(teams, "teams cannot be null");

        if (teams.isEmpty()) {
            throw new IllegalArgumentException("teams cannot be empty");
        }

        this.teams = new ArrayList<>(teams);
    }

    public Optional<Team> findTeam(Player player) {
        Objects.requireNonNull(player, "player can not be a null value");

        return teams.stream()
                .filter(team -> team.containsPlayer(player))
                .findFirst();
    }

    public boolean isPlayerInTeam(Player player) {
        return findTeam(player).isPresent();
    }

    public boolean joinTeam(Player player, Team teamToJoin) {
        Objects.requireNonNull(player, "player can not be a null value");
        Objects.requireNonNull(teamToJoin, "teamToJoin can not be a null value");

        // if team not in managed teams
        if(!teams.contains(teamToJoin)) {
            return false;
        }

        return teamToJoin.addPlayer(player);
    }

    public boolean leaveTeam(Player player) {
        Objects.requireNonNull(player, "player can not be a null value");

        return findTeam(player)
                .map(team -> team.removePlayer(player))
                .orElse(false);
    }

    public List<Team> getTeams() {
        return Collections.unmodifiableList(teams);
    }
}