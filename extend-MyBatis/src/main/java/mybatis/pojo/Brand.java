package mybatis.pojo;

import lombok.Data;

@Data
public class Brand {
    private Integer id;
    private String brandName;
    private String companyName;
    private Integer ordered;// 排序
    private String description;
    private String status;
}
