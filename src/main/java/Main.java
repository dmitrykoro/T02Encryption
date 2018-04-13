
public class Main {
    public static void main(String[] args) {
        ParseCommandline inputted = new ParseCommandline();
        inputted.parseCommandline(args);
        CryptFile operated = new CryptFile(inputted.getKey());
        operated.operate(inputted.getInputName(), inputted.getOutputName());
    }
}
