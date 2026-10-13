package com.game.subsystemm;

public class PlayerAuthentication {
    public boolean authenticatePlayer(String username, String authToken){
        System.out.println("[AUTH] Verifying token for player: " + username + "...");
        return authToken != null && !authToken.isEmpty();
    }
}
