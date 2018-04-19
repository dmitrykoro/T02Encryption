import java.io.*;

public class CryptFile {

    private String key;

    public CryptFile(String key) {
        this.key = key;
    }

    public void operate(String inputFile, String outputFile) {
        XOR temp = new XOR(key);
        try {
            FileInputStream toOperate = new FileInputStream(inputFile);
            FileOutputStream operated = new FileOutputStream(outputFile);
            try {
                byte[] inBytes = toOperate.readAllBytes();
                operated.write(temp.operate(inBytes));
            } catch (IOException e) {
                throw new IllegalArgumentException();
            }
            toOperate.close();
            operated.close();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}