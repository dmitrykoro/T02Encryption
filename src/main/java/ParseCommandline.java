import org.kohsuke.args4j.*;
import java.io.File;

public class ParseCommandline {
    @Option(name = "-c", aliases = {"-d"}, metaVar = "key", required = true,
            usage = "Encrypt or decrypt")
    private String key;

    @Option(name = "-o", metaVar = "outputName", usage = "Output file name")
    private String outputName;

    @Argument(required = true, metaVar = "inputName", usage = "Input file name")
    private String inputName;

    public void parseCommandline(String []args) {

        CmdLineParser inputted = new CmdLineParser(this);

        try {
            inputted.parseArgument(args);
        } catch (CmdLineException e) { throw new IllegalArgumentException(); }

        if (!new File(inputName).exists()) {
            throw new IllegalArgumentException("Wrong input file name or file haven't been created");
        }

        if (outputName == null) {
            outputName = inputName.substring(0, inputName.length() - 4) + "_processed.txt";
        }
    }

    public String getKey() {
        return this.key;
    }

    public String getInputName() {
        return this.inputName;
    }

    public String getOutputName() {
        return this.outputName;
    }
}
