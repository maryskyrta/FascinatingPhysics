/**
 * Class responsible for Acceleration movement topic
 * 
 * @author Masha
 *
 */
public class AccelerationMovementTopic extends Topic {

	public static TestQuestion[] tests = {
			new TestQuestion(
					"Рух, при якому за будь-які рівні проміжки часу\n швидкість змінюється однаково, називається",
					"рівномірним", "рівноприскореним", "прямолінійним", "безперервним", "рівноприскореним"),
			new TestQuestion(
					"Відношення зміни швидкості тіла до інтервалу часу, за який ця зміна відбулася, називається",
					"сповільнення", "переміщення", "прискорення", "шлях", "прискорення"),
			new TestQuestion("Прискорення позначається літерою", "v", "S", "t", "a", "a") };

	private static int currentTestTask = 0;
	private static int currentInputTask = 0;

	/**
	 * Constructor
	 * 
	 * @param name
	 * @param imagePath
	 */
	public AccelerationMovementTopic(String name, String imagePath) {
		super(name, imagePath);
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
