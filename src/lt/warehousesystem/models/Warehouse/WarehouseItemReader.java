package lt.warehousesystem.models.Warehouse;

import lt.warehousesystem.models.Reader;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class WarehouseItemReader implements Reader<WarehouseItem> {

    private final String STORAGE_FILE = loadFileName();
    private final String ERROR_MESSAGE = "**************** File not found. Please restart the program. ****************";

    @Override
    public List readAll() {
        List<WarehouseItem> warehouseItems = new ArrayList<>();
        Path path = Paths.get(STORAGE_FILE);
        try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.US_ASCII)) {
            String header = br.readLine();
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(",");
                WarehouseItem warehouseItem = new WarehouseItem();
                warehouseItem.buildItem(attributes);
                warehouseItems.add(warehouseItem);
                line = br.readLine();
            }
        } catch (IOException ioException) {
            System.out.println(ERROR_MESSAGE);
        }
        return warehouseItems;
    }

    @Override
    public String loadFileName() {
        try {
            InputStream inputStream = new FileInputStream("program.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            return (String) properties.get("storage_file");
        } catch (FileNotFoundException e) {
            System.out.println(ERROR_MESSAGE);
        } catch (IOException e) {
            System.out.println(ERROR_MESSAGE);
        }
        return null;
    }
}