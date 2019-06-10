import msghandler.InputHandler;

import static msghandler.IConstants.MENU;
import static msghandler.IConstants.WELCOME_MSG;

public class Main {
    public static void main(String[] args) {
        System.out.println(WELCOME_MSG);
        System.out.println(String.join("", MENU));

        InputHandler inputHandler = new InputHandler();
        inputHandler.scannerInputData();
    }
}
