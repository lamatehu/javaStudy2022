import com.hou.mapper.brandMapper;
import com.hou.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class brandTest {

    @Test
    public void selectAllTest() throws IOException {
        // 导入配置文件
        String resource = "mybatis-config.xml";
        InputStream rAS = Resources.getResourceAsStream(resource);
        //创建sqlsession
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(rAS);
        SqlSession sqlSession = build.openSession();
        //获取mapper
        brandMapper mapper = sqlSession.getMapper(brandMapper.class);
        //执行
        List<Brand> brands = mapper.selectAll();

        System.out.println(brands);

    }
    @Test
    public void selectById() throws IOException {
        //获取配置文件
        String resource = "mybatis-config.xml";
        InputStream resourceAsStream = Resources.getResourceAsStream(resource);
        //创建sql session
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession();
        //开启查询
        brandMapper mapper = sqlSession.getMapper(brandMapper.class);
        List<Brand> brands = mapper.selectByid(2);

        System.out.println(brands);
    }

    @Test
    public void selectaa() throws IOException {
        String brandName = "华为";
        String companyName = "华为";
        Integer status = 1;
        brandName = "%" + brandName +"%";
        companyName = "%" + companyName + "%";

        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession();

        brandMapper mapper = sqlSession.getMapper(brandMapper.class);
        List<Brand> selectaa = mapper.selectaa(companyName, brandName, status);
        System.out.println(selectaa);
    }

    @Test
    public void selectChoce() throws IOException {
        //数据
        String brandName = "%华为%";
        String companyName = "%华为%";
        HashMap<String,String> ObjectHashMap = new HashMap<String,String>();
        ObjectHashMap.put("brandName",brandName);
        ObjectHashMap.put("companyName",companyName);

        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession();
        brandMapper mapper = sqlSession.getMapper(brandMapper.class);
        List<Brand> brands = mapper.selectChose(ObjectHashMap);

        System.out.println(brands);
    }

    @Test
    public void selectChoice() throws IOException {
        // 使用<where>标签动态sql
        Brand brand = new Brand();
        brand.setBrandName("%华为%");
        brand.setCompanyName("%华为%");

        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession();

        brandMapper mapper = sqlSession.getMapper(brandMapper.class);

        List<Brand> brands = mapper.selectChoice(brand);

        System.out.println(brands);

    }

    @Test
    public void selectConditionByChoice() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession();

        brandMapper mapper = sqlSession.getMapper(brandMapper.class);

        List<Brand> brands = mapper.selectConditionByChoice(null, "%华为%");

        System.out.println(brands);
    }


    @Test
    public void addOne() throws IOException {
        //创建session
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();//这里填true就是自动提交
        //获取mapper
        brandMapper mapper = sqlSession.getMapper(brandMapper.class);
        Brand brand = new Brand();
        brand.setBrandName("小米");
        brand.setCompanyName("小米科技");
        brand.setDescription("为发烧而生");
        brand.setOrdered(1);
        brand.setStatus(1);
        mapper.addOne(brand);
        sqlSession.commit();

    }
}
