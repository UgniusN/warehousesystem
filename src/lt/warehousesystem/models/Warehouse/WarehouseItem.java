package lt.warehousesystem.models.Warehouse;

import lt.warehousesystem.models.Item;

import java.util.Objects;

public class WarehouseItem implements Item {

    private String title;
    private String code;
    private int quantity;
    private String date;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String  toString() {
        return "Item{" +
                "title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", quantity=" + quantity +
                ", date='" + date + '\'' +
                '}';
    }

    @Override
    public void builditem(String[] values) {
        this.title = values[0];
        this.code = values[1];
        this.quantity = Integer.parseInt(values[2]);
        this.date = values[3];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WarehouseItem that = (WarehouseItem) o;
        return title.equals(that.title) &&
                code.equals(that.code) &&
                date.equals(that.date);
    }
}
