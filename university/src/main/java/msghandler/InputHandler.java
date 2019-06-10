package msghandler;

import dao.impl.DepartmentDao;
import persistence.HibernateUtil;
import java.util.Scanner;

public class InputHandler implements IConstants {
    private DepartmentDao departmentDao;

    public InputHandler() {
        departmentDao = new DepartmentDao();
    }

    public void scannerInputData() {
        System.out.print("\nYou request: ");

        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        if (inputLine.toLowerCase().equals("exit")) {
            HibernateUtil.shutdown();
            System.exit(0);
        } else {
            questionHandler(inputLine);
            scannerInputData();
        }
    }

    private void questionHandler(String inputQuestion) {
        boolean matchFound = false;

        for (QuestionHandler choice : QuestionHandler.values()) {
            if (inputQuestion.toLowerCase().contains(choice.getTitle())) {
                matchFound = true;
                System.out.println(choice.getData(departmentDao, inputQuestion));
            }
        }

        if (!matchFound) {
            System.out.println(INCORRECT_REQUEST_MSG);
        }
    }
}
