package logic;

public interface GameStatus {
	int getCycles();

	String positionToString(Position position);

	int getSuncoins();

	int getRemainingZombies();

}
