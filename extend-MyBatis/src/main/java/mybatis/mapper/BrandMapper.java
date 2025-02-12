package mybatis.mapper;

import mybatis.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    List<Brand> selectAll();
    Brand selectById(Integer id);
    
    /**
     * 多条件查询品牌信息(散装参数-> 使用@Param("sql占位符名称")注解)
     *      mybatis在接收到多个参数时，会将这些参数封装到一个map中，如下：
     *          - map.put("arg0", status);
     *          - map.put("arg1", brandName);
     *          - map.put("arg2", companyName);
     *          - map.put("param1", status);
     *          - map.put("param2", brandName);
     *          - map.put("param3", companyName);
     *      注解@Param("sql占位符名称")就是替换掉arg0、arg1、arg2等参数的名称，使得SQL语句中的参数名称更加直观
     *      param1、param2、param3还是保留的。
     *
     *
     * mybatis的参数封装(源码)：
     *      - POJO对象：直接使用，属性名和参数占位符名称一致
     *      - Map集合：直接使用，key和参数占位符名称一致
     *      - Collection：封装为Map集合，可以使用@Param注解指定参数占位符名称
     *          - map.put("arg0",collection集合)
     *          - map.put("collection",collection集合)
     *      - List: 封装为Map集合，可以使用@Param注解指定参数占位符名称
     *          - map.put("arg0",list集合)
     *          - map.put("collection",list集合)
     *          - map.put("list",list集合)
     *      - Array: 封装为Map集合，可以使用@Param注解指定参数占位符名称
     *          - map.put("arg0",array数组)
     *          - map.put("array",array数组)
     *      - 其他类型：直接使用
     */
    // List<Brand> selectByCondition(@Param("status") Integer status,
    //                              @Param("brandName") String brandName,
    //                              @Param("companyName") String companyName);
    
    /**
     * 多条件查询品牌信息(对象参数-> 使用对象作为参数)
     */
    // List<Brand> selectByCondition(Brand brand);
    /**
     * 多条件查询品牌信息(map参数-> 使用map作为参数)
     */
     List<Brand> selectByCondition(Map<String,Object> map);
    
    /**
     * 单条件查询品牌信息（多选一）
     */
    List<Brand> selectBySingleCondition(Brand brand);
    
    /**
     * 添加品牌信息
     */
    void addBrand(Brand brand);
    
    /**
     * 修改品牌信息
     */
    int updateBrand(Brand brand);
    
    /**
     * 删除品牌信息
     */
    void deleteById(Integer id);
    
    /**
     * 批量删除品牌信息
     */
    void deleteBatchByIds(@Param("ids") Integer[] ids);
}
