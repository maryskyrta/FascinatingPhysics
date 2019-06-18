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
	public static String[] inputAnswerTasks = {
			"Щоб доїхати до магазину від дому потрібно здолати 2500 м, а до музичного театру в тому самому напрямку - "
					+ "6700 м. Який шлях проїде машина від магазину до театру?",
			"Після того як м'яч випустили на висоті 1.5 м, " + "він підскочив на висоту 1м. Який шлях пройшов м'яч?",
			"Літак пролетів 1200 км за 2 год. З якою швидкістю летів літак? (Одиниці виміру відповіді: км/год) ",
			"Потяг їде зі швидкістю 180 км/год. Який шлях долає потяг за 1 хв. (Одиниці виміру відповіді: м)",
			"Літак вилетів з аеропорту в південному напрямку, так він пролетів 2500 км. Потім літак повернув на схід і "
			+ "пролетів в цьому напрямку 6000 км. Згодом літак знову повернув, але цього разу на північ і пролетів так ще 2500 км. "
			+ "Яку відстань подолав літак?"};
	public static double rightAnswers[] = { 4200, 2.5, 600, 3000, 6000 };
	public static String[] levelImages = { "static/3.png", "static/4.png", "static/5.png", "static/6.png", "static/7.png" };
	private static int currentTestTask = 4;
	private static int currentInputTask = 4;

	/**
	 * HINTS TEXT
	 */
	public static String[] hints = {
			"Для того, щоб визначити шлях від магазину до театру, потрібно від шляху від дому до театру відняти шлях від дому до магазину",
			"Для того, щоб дізнатися який загальний шлях пройшов м'яч, потрібно додати його шлях, який він пролетів при падінні, до шляху, який він пролетів після відбивання" };

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param imagePath
	 */
	public MechanicMovementTopic(String name, String imagePath) {
		super(name, imagePath);
	}

	/**
	 * Add passed level
	 */
	public static void levelUp() {
		currentInputTask++;
	}

	/**
	 * Change level to the next one
	 */
	public static void getNextLevel() {
		if (currentInputTask < 5)
			Game.getInstance().changePanel(new Level(inputAnswerTasks[currentInputTask], levelImages[currentInputTask],
					rightAnswers[currentInputTask]));
		else
			Game.getInstance().changePanel(new LevelPassedPanel());
	}

	/**
	 * 
	 * @return current level
	 */
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
