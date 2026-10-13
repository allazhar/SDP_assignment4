package com.game.facade;

import com.game.subsystemm.MatchmakingService;
import com.game.subsystemm.PlayerAuthentication;
import com.game.subsystemm.ResourcePreloader;
import com.game.subsystemm.ServerAllocator;

public class GameSessionFacade {
    private final PlayerAuthentication auth;
    private final MatchmakingService matchmaking;
    private final ServerAllocator serverAllocator;
    private final ResourcePreloader preloader;

    public GameSessionFacade() {
        this.auth = new PlayerAuthentication();
        this.matchmaking = new MatchmakingService();
        this.serverAllocator = new ServerAllocator();
        this.preloader = new ResourcePreloader();
    }

    public void startQuickGame(String name, String token, String gameMode) {
        System.out.println("=== INITIALIZING GAME SESSION VIA FACADE ===");
        System.out.println();

        boolean isAuthenticate = auth.authenticatePlayer(name, token);
        if (!isAuthenticate) {
            System.out.println("[ERROR] Authentication failed! Aborting match start.");
            return;
        }

        String lobbyID = matchmaking.findLobby(gameMode);
        String serverIp = serverAllocator.allocateServer(lobbyID);
        preloader.loadMapAssets(serverIp);

        System.out.println();
        System.out.println("=== GAME SUCCESSFULLY STARTED ON " + serverIp + " ===");
    }
}
