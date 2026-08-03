package org.nooberextrim.skyblockwars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class Team {
    private final String name;
    private final List<Player> players = new ArrayList<>();
    private final Location spawn;
    private final int maxPlayers;


    public Team(String name, Location spawn, int maxPlayers) {
        Objects.requireNonNull(name, "name cannot be a null value");

        Objects.requireNonNull(spawn, "spawn cannot be a null value");

        if (maxPlayers <= 0) {
            throw new IllegalArgumentException("maxPlayers must be positive");
        }

        this.name = name;
        this.spawn = spawn;
        this.maxPlayers = maxPlayers;

    }

    public boolean addPlayer(Player player) {
        Objects.requireNonNull(player, "Player cannot a null value");

        if(players.size() >= maxPlayers) {
            return false;
        }
        if(players.contains(player)) {
            return false;
        }

        return players.add(player);
    }

    public boolean removePlayer(Player player) {
        Objects.requireNonNull(player, "Player cannot a null value");

        return players.remove(player);
    }

    public String getName() {
        return name;
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public Location getSpawn() {
        return spawn;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

}