package lt.warehousesystem.models;

import java.io.IOException;
import java.util.List;

public interface Reader<T> {

    List<T> readAll();

    String loadFileName() throws IOException;
}
