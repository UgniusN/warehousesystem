package lt.warehousesystem.models.Warehouse;

import lt.warehousesystem.models.Storage;
import java.util.ArrayList;
import java.util.List;

public class WarehouseStorage implements Storage {

    private WarehouseItemReader warehouseItemReader = new WarehouseItemReader();
    private List<WarehouseItem> warehouseItems = new ArrayList<>();

    @Override
     public void loadStorage() {
        this.warehouseItems = warehouseItemReader.readAll();
    }

    @Override
    public List<WarehouseItem> getAllItemsFromStorage() {
        return warehouseItems;
    }

    public void updateStorage(List<WarehouseItem> updatedList) {
        this.warehouseItems = updatedList;
    }
}