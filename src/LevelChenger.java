
public class LevelChenger {

	private static String task1 = "Щоб доїхати до магазину від дому потрібно здолати 2500 м, в до музичного театру в тому самому напрямку -- "
			+ "6700 м. Який шлях проїде машина від магазину до театру?";
	private static String task2 = "Після того як м'яч випустили на висоті 1.5 м, "
			+ "він підскочив на висоту 1м. Який шлях пройшов м'яч?";

	private static double rightAnswer1 = 4200;
	private static double rightAnswer2 = 2.5;

	private static String img1 = "static/3.png";
	private static String img2 = "static/2.png";
	private static int currentLevel = 0;

	public static void levelUp() {
		currentLevel++;
	}

	public static void goLevel() {
		if (currentLevel == 1)
			Game.getInstance().changePanel(new Level(task1, img1, rightAnswer1));
		else if (currentLevel == 2)
			Game.getInstance().changePanel(new Level(task2, img2, rightAnswer2));
		else
			Game.getInstance().changePanel(new LevelPassedPanel());
	}

	public static int getLevel() {
		return currentLevel;
	}
}
