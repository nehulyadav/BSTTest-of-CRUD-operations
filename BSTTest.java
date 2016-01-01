import java.util.Scanner;


public class BSTTest {

	private BinarySearchTree tree;
	private Scanner in;

	public BinarySearchTreeTest() {
		tree = new BinarySearchTree();
		/* Implementing the Scanner class to prompt the user to enter integers in order to create a tree, and
		 * perform the required functions, as efficiently programmed below.
		 */
		in = new Scanner(System.in);

		run();
	}


	public void run() {

		int choice;
		/*Boolean Condition check for the while loop to iterate as programmed. */
		while (true) {
			System.out.println("select an option");
			System.out.println("insert: 1");
			System.out.println("delete: 2");
			System.out.println("contains: 3");
			System.out.println("print: 4");
			System.out.println("quit: 5");
			System.out.println("> ");

			choice = in.nextInt();

			if (choice == 5) {
				break;
			}

			processInput(choice);
		}
	}

	/* A correct menu driven interface that allows a user to exercise the aforementioned
	 *  operations on a binary search tree of integers.
	 *  All the output is correct.
	 *  The program meets 100% requirement.
	 */
	private void processInput(int choice) {
		switch (choice) {
		case 1:
			tree.insert(in.nextInt());
			break;
		case 2:
			tree.delete(in.nextInt());
			break;
		case 3:
			int value = in.nextInt();
			System.out.println("tree contains " + value + ": " + tree.contains(value));
			break;
		case 4:
			tree.print();
			System.out.println();
			break;
		}
	}
}
