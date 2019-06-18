/**
 * 
 * Class that stores Mechanic Movement topic information
 *
 */

public class MechanicMovementTopic extends Topic {
	public static TestQuestion[] tests = {
			new TestQuestion("Зміна з часом положення тіла в просторі відносно інших\n тіл називається",
					"відносний рух", "кінетичний рух", "механічний рух", "молекулярний рух", "механічний рух"),
			new TestQuestion("Якщо ви їдете на велосипеді, то відносно нерухомого\n ліхтаря ви знаходитесь у стані",
					"руху", "спокою", "збентеження", "коливання", "руху"),
			new TestQuestion("Тіло, відносно якого фіксується рух іншого тіла,\n називається ", "рухомим тілом",
					"тілом спокою", "тілом руху", "тілом відліку", "тілом відліку") };
	private static String[] inputAnswerTasks = {
			"Щоб доїхати до магазину від дому потрібно здолати 2500 м, а до музичного театру в тому самому напрямку - "
					+ "6700 м. Який шлях проїде машина від магазину до театру?",
			"Після того як м'яч випустили на висоті 1.5 м, " + "він підскочив на висоту 1м. Який шлях пройшов м'яч?" };
	private static double rightAnswers[] = { 4200, 2.5 };
	private static String[] levelImages = { "static/3.png", "static/4.png" };
	private static int currentTestTask = 0;
	private static int currentInputTask = 0;

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param imagePath
	 */
	public MechanicMovementTopic(String name, String imagePath) {
		super(name, imagePath);
	}

	public static void levelUp() {
		currentInputTask++;
	}

	public static void getNextLevel() {
		if (currentInputTask < 2)
			Game.getInstance().changePanel(new Level(inputAnswerTasks[currentInputTask], levelImages[currentInputTask],
					rightAnswers[currentInputTask]));
		else
			Game.getInstance().changePanel(new LevelPassedPanel());
	}

	public static int getLevel() {
		return currentInputTask;
	}

	/**
	 * 
	 * @param answered
	 * @return next question panel if the question was answered else return current
	 *         question panel
	 */
	public static void getNextPanel(boolean answered) {
		if (answered)
			currentTestTask++;
		if (currentTestTask >= tests.length) {
			getNextLevel();
		} else
			Game.getInstance().changePanel(new MultiAnsQuestionPanel(tests[currentTestTask]));
	}

}
