package util;

public class Funcs {
    public String setStrSize(String str, int size) {
        while (str.length() < size) {
            str += " ";
        }
        return str;
    }
    public void clearScreen () {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
