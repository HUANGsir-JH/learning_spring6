package mybatis;

import mybatis.mapper.BrandMapper;
import mybatis.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class MyBatisTest {
    
    @Test
    public void testSelectAll() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        
        // 2.获取SqlSession对象
         SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3.执行SQL, 获取Mapper代理对象
        sqlSession.getMapper(BrandMapper.class).selectAll().forEach(System.out::println);
        // 4.关闭SqlSession
        sqlSession.close();
    }
    @Test
    public void testSelectById() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        
        // 2.获取SqlSession对象
         SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3.执行SQL, 获取Mapper代理对象
        System.out.println(sqlSession.getMapper(BrandMapper.class).selectById(1));
        // 4.关闭SqlSession
        sqlSession.close();
    }
    @Test
    public void testSelectByCondition() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        
        String status = "1";
        String brandName = "%华为%";
        String companyName = "%华为%";
        
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        
        Map<String,Object> map =new HashMap<>();
        map.put("status",status);
        map.put("brandName",brandName);
        map.put("companyName",companyName);
        
        // 2.获取SqlSession对象
         SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3.执行SQL, 获取Mapper代理对象
            // todo 散装参数
            // 模糊查询，查询状态为1，品牌名称和公司名称中包含“华为”的品牌信息
            // sqlSession.getMapper(BrandMapper.class).selectByCondition(1, "%华为%",
            //    "%华为%").forEach(System.out::println);
            // todo 使用对象作为参数
            // sqlSession.getMapper(BrandMapper.class).selectByCondition(brand).forEach(System.out::println);
            // todo 使用map作为参数
            sqlSession.getMapper(BrandMapper.class).selectByCondition(map).forEach(System.out::println);
        // 4.关闭SqlSession
        sqlSession.close();
    }
    @Test
    public void testSelectBySingleCondition() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        
        Brand brand = new Brand();
        brand.setStatus("1");
//        brand.setBrandName("%华为%");
//        brand.setCompanyName("%华为%");
        
        // 2.获取SqlSession对象
         SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3.执行SQL, 获取Mapper代理对象
        // 查询状态为1的品牌信息
        sqlSession.getMapper(BrandMapper.class).selectBySingleCondition(brand).forEach(System.out::println);
        // 4.关闭SqlSession
        sqlSession.close();
    }
    @Test
    public void testAddBrand(){
        Brand brand = new Brand();
        brand.setBrandName("bilibili");
        brand.setCompanyName("上海宽娱有限公司");
        brand.setDescription("国内知名的年轻人文化社区");
        brand.setStatus("1");
        brand.setOrdered(100);
        
        String resource = "mybatis-config.xml";
        try (InputStream inputStream = Resources.getResourceAsStream(resource);
             SqlSession sqlSession = new SqlSessionFactoryBuilder().build(inputStream).openSession()) {
            sqlSession.getMapper(BrandMapper.class).addBrand(brand);
            sqlSession.commit(); // test方法内会自动回滚，所以需要手动提交
            // 或者
            // SqlSession sqlSession = new SqlSessionFactoryBuilder().build(inputStream).openSession(true)
            System.out.println("添加成功");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("添加失败");
        }
        
        System.out.println(brand);
    }
    @Test
    public void testUpdateBrand(){
        Brand brand = new Brand();
        brand.setId(5);
        brand.setBrandName("bili哔哩");
        brand.setCompanyName("上海宽娱有限公司");
        brand.setDescription("国内知名的年轻人文化社区,但是抽象");
        brand.setStatus("1");
        brand.setOrdered(100);
        
        String resource = "mybatis-config.xml";
        try (InputStream inputStream = Resources.getResourceAsStream(resource);
             SqlSession sqlSession =
                     new SqlSessionFactoryBuilder().build(inputStream).openSession(true)) {
            int i = sqlSession.getMapper(BrandMapper.class).updateBrand(brand);
            System.out.println("修改成功，修改了" + i + "条数据");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("修改失败，请检查");
        }
        
        System.out.println(brand);
    }
    @Test
    public void testDeleteById(){
        String resource = "mybatis-config.xml";
        try (InputStream inputStream = Resources.getResourceAsStream(resource);
             SqlSession sqlSession =
                     new SqlSessionFactoryBuilder().build(inputStream).openSession(true)) {
            sqlSession.getMapper(BrandMapper.class).deleteById(6);
            System.out.println("删除成功");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("删除失败，请检查");
        }
    }
    @Test
    public void testDeleteBatchByIds(){
        String resource = "mybatis-config.xml";
        try (InputStream inputStream = Resources.getResourceAsStream(resource);
             SqlSession sqlSession =
                     new SqlSessionFactoryBuilder().build(inputStream).openSession(true)) {
            sqlSession.getMapper(BrandMapper.class).deleteBatchByIds(new Integer[]{4,5,7});
            System.out.println("删除成功");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("删除失败，请检查");
        }
    }
}
