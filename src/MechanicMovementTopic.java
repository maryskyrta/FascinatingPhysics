import javax.swing.JPanel;

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
	private static int currentTask = 0;

	public MechanicMovementTopic(String name, String imagePath) {
		super(name, imagePath);
	}

	/**
	 * 
	 * @param answered
	 * @return next question panel if the question was answered else return current
	 *         question panel
	 */
	public static JPanel getNextPanel(boolean answered) {
		if (currentTask >= tests.length) {
			LevelChanger.levelUp();
			LevelChanger.goLevel();
		}
		if (answered)
			currentTask++;
		return new MultiAnsQuestionPanel(tests[currentTask]);

	}

}
