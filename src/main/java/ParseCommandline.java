import org.kohsuke.args4j.*;
import java.io.File;
import java.util.regex.*;

public class ParseCommandline {
    @Option(name = "-c", aliases = {"-d"}, metaVar = "key", required = true,
            usage = "Encrypt or decrypt")
    private String key;

    @Option(name = "-o", metaVar = "outputName", usage = "Output file coding")
    private String outputName;

    @Argument(required = true, metaVar = "inputName", usage = "Input file name")
    private String inputName;

    public ParseCommandline() {

    }
}
