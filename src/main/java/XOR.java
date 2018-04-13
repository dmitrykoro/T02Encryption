
public class XOR {

    private byte key[];

    XOR(String stringKey) {
        key = stringKey.getBytes();
    }

    public byte[] operate(byte text[]) {
        byte result[] = new byte[text.length];
        for (int i = 0; i < text.length; i++) {
            result[i] = (byte)(text[i] ^ key[i % key.length]);
        }
        return result;
    }
}
