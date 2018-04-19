import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.CheckedInputStream;
import java.util.zip.CRC32;


public class GetChecksum {

    public Boolean operateAndGetChecksum
            (String key, String originalName, String operatedName, String operatedTwiceName) throws IOException {

        long checksumInput = 0, checksumOutput = 0;

        CryptFile temp = new CryptFile(key);
        temp.operate(originalName, operatedName);
        temp.operate(operatedName, operatedTwiceName);
        FileInputStream toOperate = new FileInputStream(originalName);
        FileInputStream operated = new FileInputStream((operatedTwiceName));

        try {

            CheckedInputStream original;
            CheckedInputStream processed;

            original = new CheckedInputStream(
                    new FileInputStream(originalName), new CRC32());
            processed = new CheckedInputStream(
                    new FileInputStream(operatedTwiceName), new CRC32());

            byte[] buf = new byte[128];

            while (original.read(buf) >= 0 && processed.read(buf) >= 0) {
            }

            checksumInput = original.getChecksum().getValue();
            checksumOutput = processed.getChecksum().getValue();

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        toOperate.close();
        operated.close();
        return checksumInput == checksumOutput;
    }
}
