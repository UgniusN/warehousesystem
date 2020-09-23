package lt.warehousesystem.models.Warehouse;

import lt.warehousesystem.models.Storage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WarehouseStorage implements Storage {

    private WarehouseItemReader warehouseItemReader = new WarehouseItemReader();
    private List<WarehouseItem> warehouseItems = new ArrayList<>();

    public WarehouseStorage() throws IOException {

    }

    @Override
     public void loadStorage() {
        this.warehouseItems = warehouseItemReader.readAll();
    }

    @Override
    public List<WarehouseItem> getAllItemsFromStorage() {
        return warehouseItems;
    }

    public void printAll() {
        for(WarehouseItem warehouseItem : warehouseItems) {
            System.out.println(warehouseItem);
        }
    }

    public void updateStorage(List<WarehouseItem> updatedList) {
        this.warehouseItems = updatedList;
    }
}
