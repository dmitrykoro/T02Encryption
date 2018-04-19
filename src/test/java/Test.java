import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;


public class Test {

    private GetChecksum test = new GetChecksum();

    @org.junit.jupiter.api.Test
    void operate() throws IOException{
        assertEquals(true, test.operateAndGetChecksum("F76329AC", "input.txt",
                "output.txt", "output_operated.txt"));
        assertEquals(true, test.operateAndGetChecksum("ffff5764329026721874512rt", "input1.txt",
                "output1.txt", "output_operated1.txt"));
        assertEquals(true, test.operateAndGetChecksum("", "input2.txt", "output2.txt",
                "output_operated2.txt"));
        assertEquals(true, test.operateAndGetChecksum("D", "input3.txt", "output3.txt",
                "output_operated3.txt"));
        assertEquals(true, test.operateAndGetChecksum("1732839", "input4.txt",
                "output4.txt", "output_operated4.txt"));
        assertEquals(true, test.operateAndGetChecksum("F8", "input5.txt",
                "output5.txt", "output_operated5.txt"));
        assertEquals(true, test.operateAndGetChecksum("7FFF541FFF", "input6.txt",
                "output6.txt", "output_operated6.txt"));
    }
}