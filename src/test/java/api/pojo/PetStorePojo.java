package api.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PetStorePojo {
    private long id;
    private PetStoreCategoryPojo category;
    private String name;
    private List <String> photoUrls;
    private String status;
    private List <PetStoreTagsPojo> tags;

}
