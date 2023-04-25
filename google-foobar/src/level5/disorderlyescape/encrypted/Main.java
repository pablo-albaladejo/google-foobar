package level5.disorderlyescape.encrypted;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String message = "C0YRGQxNBB8RRkxbREINHUsMEVRYUkITDg4ACk8GGQdGTFtEQg8cWggAHhEWQlxBRQkJSA4eFhJLQV5FTQZADhcWEBsHHARFQE8JAA8KCAkXAQgPAVpKRUlUVRAeDQ0PBEsFS05BSxMFBwgGWh5CU05SQgMABAlIAkFLBA4DRkRfSkhZBAtSUw8=";
        String key = "pablo.albaladejo.mestre";

        byte[] keyBytes = key.getBytes("UTF-8");
        byte[] decodedBytes = Base64.getDecoder().decode(message);

        byte[] xoredBytes = new byte[decodedBytes.length];
        for (int i = 0; i < decodedBytes.length; i++) {
            xoredBytes[i] = (byte) (decodedBytes[i] ^ keyBytes[i % keyBytes.length]);
        }

        System.out.println(new String(xoredBytes));
    }
}