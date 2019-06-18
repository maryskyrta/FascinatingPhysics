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

	private static int currentTestTask = 0;
	private static int currentInputTask = 0;

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
	 * 
	 * @param answered
	 * @return next question panel if the question was answered else return current
	 *         question panel
	 */
	public static void getNextPanel(boolean answered) {
		if (answered)
			currentTestTask++;
		if (currentTestTask >= tests.length) {
			/*
			 * Add input levels here
			 */
		} else
			Game.getInstance().changePanel(new MultiAnsQuestionPanel(tests[currentTestTask]));
	}

	/**
	 * Set levels to 0
	 */
	public void clean() {
		currentTestTask = 0;
		currentInputTask = 0;
	}

}
