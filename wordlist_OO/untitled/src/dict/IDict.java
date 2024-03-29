package dict;

import java.io.IOException;

public interface IDict {
    String translate(String word) throws IOException;
}

