package rlbotexample.input;

import rlbot.flat.GameTickPacket;

import java.util.ArrayList;
import java.util.List;

public class DataPacket {

    /** Your own car, based on the playerIndex */
    public final CarData car;

    public final List<CarData> allCars;

    public final BallData ball;
    public final int team;

    /** The index of your player */
    public final int playerIndex;

    public DataPacket(GameTickPacket request, int playerIndex) {

        this.playerIndex = playerIndex;
        this.ball = new BallData(request.ball());

        allCars = new ArrayList<>();
        for (int i = 0; i < request.playersLength(); i++) {
            allCars.add(new CarData(request.players(i), request.gameInfo().secondsElapsed()));
        }

        this.car = allCars.get(playerIndex);
        this.team = this.car.team;
    }
}
