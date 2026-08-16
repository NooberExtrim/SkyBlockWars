package org.nooberextrim.skyblockwars;

public class GameManager {

    private final Game game;
    private final TeamManager teamManager;
    //TODO :: use GameManager or insure that the same TeamManager gets passed to SkyblockCommand
    private final TeleportManager teleportManager;

    public GameManager(Game game,  TeamManager teamManager, TeleportManager teleportManager) {
        this.game = game;
        this.teamManager = teamManager;
        this.teleportManager = teleportManager;
    }

    //TODO :: add game flow methods for starting game, teleporting to islands ending game and resetting map.
}