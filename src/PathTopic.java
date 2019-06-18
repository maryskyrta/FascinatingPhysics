
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
	/*
	 * private static String[] inputAnswerTasks = {
	 * "Щоб доїхати до магазину від дому потрібно здолати 2500 м, а до музичного театру в тому самому напрямку - "
	 * + "6700 м. Який шлях проїде машина від магазину до театру?",
	 * "Після того як м'яч випустили на висоті 1.5 м, " +
	 * "він підскочив на висоту 1м. Який шлях пройшов м'яч?" }; private static
	 * double rightAnswers[] = { 4200, 2.5 }; private static String[] levelImages =
	 * { "static/3.png", "static/4.png" };
	 */
	private static int currentTestTask = 0;
	private static int currentInputTask = 0;

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

}
