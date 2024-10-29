package picker.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import picker.InventoryApplication;
import picker.domain.StockDecreased;

@Entity
@Table(name = "Inventory_table")
@Data
//<<< DDD / Aggregate Root
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productName;

    private Integer stock;

    @PostPersist
    public void onPostPersist() {
        StockDecreased stockDecreased = new StockDecreased(this);
        stockDecreased.publishAfterCommit();
    }

    public static InventoryRepository repository() {
        InventoryRepository inventoryRepository = InventoryApplication.applicationContext.getBean(
            InventoryRepository.class
        );
        return inventoryRepository;
    }

    //<<< Clean Arch / Port Method
    public static void decreaseStock(OrderPlaced orderPlaced) {
        //implement business logic here:
        
        // repository().findById(orderPlaced.getId()).ifPresent(inventory->{
            
        //     inventory.setStock(inventory.getStock() - orderPlaced.getInventoryId().getStock()); // do something
        //     repository().save(inventory);

        //     StockDecreased stockDecreased = new StockDecreased(inventory);
        //     stockDecreased.publishAfterCommit();

        //  });

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
