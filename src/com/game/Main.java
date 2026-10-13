package com.game;

import com.game.facade.GameSessionFacade;

public class Main {
    public static void main (String[] args) {
        GameSessionFacade gameFacade = new GameSessionFacade();
        gameFacade.startQuickGame("Allazhar", "TOKEN_XYZ_123","Battle Royal");
    }
}
