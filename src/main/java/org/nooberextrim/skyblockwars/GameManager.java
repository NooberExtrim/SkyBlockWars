package org.nooberextrim.skyblockwars;

public class GameManager {

    private final Game game;
    private final TeamManager teamManager;
    private final TeleportManager teleportManager;

    public GameManager(Game game,  TeamManager teamManager, TeleportManager teleportManager) {
        this.game = game;
        this.teamManager = teamManager;
        this.teleportManager = teleportManager;
    }
}