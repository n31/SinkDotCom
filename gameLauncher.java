import java.util.Scanner;

public class gameLauncher {
	public static void main(String[] args) {
		SinkDotCom game = new SinkDotCom();

		game.setDotCom();

		while(game.dotComAlive()) {
			game.userStrike();
		}

		System.out.println("You win! Total score: " + game.getScore());
	}
}

class SinkDotCom {
	private int[] field = new int[7];
	private int score;

	public void setDotCom() {
		int startPoint = (int)(Math.random() * 4);
		for (int i = 0; i < 7; i++) {
			field[i] = 0;
		}
		for (int i = startPoint; i < startPoint + 3; i++) {
			field[i] = 1;
		}
	}

	public boolean dotComAlive() {
		for (int i = 0; i < 7; i++) {
			if (field[i] == 1) {
				return true;
			}
		}
		
		return false;
	}

	public void userStrike() {
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter a number: ");
		int n = reader.nextInt();
		while (n < 0 || n > 6) {
			System.out.print("Enter correct number: ");
			n = reader.nextInt();
		}
		
		field[n] = 0;

		score++;
	}

	public int getScore() {
		return score;
	}
}
