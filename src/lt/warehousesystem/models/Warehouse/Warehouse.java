package lt.warehousesystem.models.Warehouse;

import lt.warehousesystem.services.WarehouseService;
import lt.warehousesystem.services.WarehouseServiceImpl;
import lt.warehousesystem.services.WarehouseStorageService;
import lt.warehousesystem.services.WarehouseStorageServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Warehouse {

    private WarehouseService warehouseService = new WarehouseServiceImpl();
    private WarehouseStorageService warehouseStorageService = new WarehouseStorageServiceImpl();

    public Warehouse() throws IOException {
    }

    public void kazkastai() {
        for(WarehouseItem warehouseItem : warehouseStorageService.kazkas()) {
            System.out.println(warehouseItem);
        }
    }

}
