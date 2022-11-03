import com.hou.mapper.brandMapper;
import com.hou.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
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
}
