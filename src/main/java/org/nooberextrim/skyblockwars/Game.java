package org.nooberextrim.skyblockwars;

import java.util.Objects;

public class Game {

    private final TeamManager teamManager;
    private GameState state;

    public Game(TeamManager teamManager){
        Objects.requireNonNull(teamManager, "teamManager can not be null");

        this.teamManager = teamManager;
        this.state = GameState.WAITING;
    }

    public boolean canStart() {
        if(state != GameState.WAITING) {
            return false;
        }

        return teamManager.getTeams()
                .stream()
                .allMatch(Team::isFull);
    }

    public boolean startCountdown() {
        if(!canStart()) {
            return false;
        }

        state = GameState.COUNTDOWN;
        return true;
    }

    public boolean startGame() {
        if (state != GameState.COUNTDOWN) {
            return false;
        }

        state = GameState.PLAYING;
        return true;
    }

    public boolean endGame() {
        if (state != GameState.PLAYING) {
            return false;
        }

        state = GameState.ENDING;
        return true;
    }

    public boolean resetGame() {
        if(state != GameState.ENDING) {
            return false;
        }

        state = GameState.WAITING;
        return true;
    }

    public GameState getState() {
        return state;
    }
}