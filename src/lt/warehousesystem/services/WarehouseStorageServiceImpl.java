package lt.warehousesystem.services;

import lt.warehousesystem.models.Warehouse.WarehouseItem;
import lt.warehousesystem.models.Warehouse.WarehouseStorage;

import java.io.IOException;
import java.util.List;

public class WarehouseStorageServiceImpl implements WarehouseStorageService {

    private WarehouseStorage warehouseStorage = new WarehouseStorage();

    public WarehouseStorageServiceImpl() throws IOException {
    }

    public List<WarehouseItem> kazkas() {
        warehouseStorage.loadStorage();
        return warehouseStorage.getAllItemsFromStorage();
    }
}
