import org.kohsuke.args4j.*;
import java.io.File;
import java.util.regex.*;

public class PasreCommandline {
    @Option(name = "-c", aliases = {"-d"}, metaVar = "key", required = true,
            usage = "Set connection coding/decoding")
    private String key;

    @Option(name = "-o", metaVar = "outputName", usage = "Output file coding")
    private String outputName;

    @Argument(required = true, metaVar = "inputName", usage = "Input file name")
    private String inputName;

    public PasreCommandline() {

    }
}
