/**
 * 
 * Class responsible for second topic
 *
 */
public class PathTopic extends Topic {
	public static TestQuestion[] tests = {
			new TestQuestion("Уявна лінія, по якій рухається тіло, називається", "шлях", "переміщення", "траєкторія",
					"відстань", "траєкторія"),
			new TestQuestion("Довжина траєкторії - це", "шлях", "переміщення", "швидкість", "час", "шлях"),
			new TestQuestion("Рух тіла називається прямолінійним, \nякщо його траєкторією руху є", "коло", "парабола",
					"пряма", "спіраль", "пряма"),
			new TestQuestion("Вектор, що сполучає початкову і кінцеву\n точки траєкторії, називається", "шлях",
					"відстань", "швидкість", "переміщення", "переміщення"),
			new TestQuestion("Якщо тіло рухається зі сталою швидкістю,\n його рух називається", "прямолінійним",
					"рівномірним", "швидким", "повільним", "рівномірним"),
			new TestQuestion("Швидкість руху тіла визначається як відношення\n переміщення до ", "проміжку часу",
					"шляху", "траєкторії", "відстані", "проміжку часу") };

	private static String[] inputAnswerTasks = {
			"Літак пролетів 1200 км за 2 год. З якою швидкістю летів літак? (Одиниці виміру відповіді: км/год) ",
			"Потяг їде зі швидкістю 180 км/год. Який шлях долає потяг за 1 хв. (Одиниці виміру відповіді: м)"
			// "Літак вилетів з аеропорту в південному напрямку, так він пролетів 2500 км.
			// Потім літак повернув на схід і "
			// + "пролетів в цьому напрямку 6000 км. Згодом літак знову повернув, але цього
			// разу на північ і пролетів так ще 2500 км. "
			// + "Яку відстань подолав літак?"
	};
	private static int currentTestTask = 0;
	private static int currentInputTask = 0;
	private static double[] rightAnswers = { 600, 3000, 6000 };
	private static String[] levelImages = { "static/5.png", "static/6.png", "static/7.png" };
	public static String[] hints = {
			"Для того, щоб визначити швидкість літака, потрібно поділити його шлях на час польоту",
			"Для того, щоб визначити шлях потягу за хвилину, потрібно перевести його швидкість у метри за хвилину" };

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param imagePath
	 */
	public PathTopic(String name, String imagePath) {
		super(name, imagePath);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Change level to the next one
	 */
	public static void getNextLevel() {
		if (currentInputTask < 2)
			Game.getInstance().changePanel(new Level(inputAnswerTasks[currentInputTask], levelImages[currentInputTask],
					rightAnswers[currentInputTask]));
		else
			Game.getInstance().changePanel(new LevelPassedPanel());
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

	/**
	 * 
	 * @return current level
	 */
	public static int getLevel() {
		return currentInputTask;
	}

	/**
	 * Add passed level
	 */

	public static void levelUp() {
		currentInputTask++;
	}

	/**
	 * Get hint for level
	 * 
	 * @return
	 */
	public static String getHint() {
		return hints[currentInputTask];
	}

	/**
	 * Set levels to 0
	 */
	public static void clean() {
		currentTestTask = 0;
		currentInputTask = 0;
	}

}
