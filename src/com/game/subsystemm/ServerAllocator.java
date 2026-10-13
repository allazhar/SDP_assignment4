package com.game.subsystemm;

public class ServerAllocator {
    public String allocateServer(String lobbyID) {
        System.out.println("[SERVER] Reserving a dedicated game server for " + lobbyID + "...");
        return "192.168.1.150:7777";
    }
}
