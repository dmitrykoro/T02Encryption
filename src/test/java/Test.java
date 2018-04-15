import static org.junit.jupiter.api.Assertions.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.CheckedInputStream;
import java.util.zip.CRC32;


class Test {

    @org.junit.jupiter.api.Test
    void checkXOR() throws IOException {

        CryptFile temp = new CryptFile("F9232");
        temp.operate("input.txt", "output.txt");
        temp.operate("output.txt", "output_operated.txt");
        FileInputStream toOperate = new FileInputStream("input.txt");
        FileInputStream operated = new FileInputStream(("output_operated.txt"));

        try {
            CheckedInputStream original;
            CheckedInputStream processed;
            original = new CheckedInputStream(
                    new FileInputStream("input.txt"), new CRC32());
            processed = new CheckedInputStream(
                    new FileInputStream("output_operated.txt"), new CRC32());

            byte[] buf = new byte[128];

            while (original.read(buf) >= 0 && processed.read(buf) >= 0) {
            }

            long checksumInput = original.getChecksum().getValue();
            long checksumOutput = processed.getChecksum().getValue();
            assertEquals(checksumInput, checksumOutput);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        toOperate.close();
        operated.close();
    }
}