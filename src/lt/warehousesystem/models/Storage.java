package lt.warehousesystem.models;

import java.util.List;

public interface Storage<T> {

    void loadStorage();

    List<T> getAllItemsFromStorage();
}
