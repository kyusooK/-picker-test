package picker.domain;

import java.util.*;
import lombok.*;
import picker.domain.*;
import picker.infra.AbstractEvent;

@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String userId;
    private Integer qty;
    private Object inventoryId;
}
