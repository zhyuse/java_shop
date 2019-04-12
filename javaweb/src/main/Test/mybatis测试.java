import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ssm.Dao.AdDao;
import ssm.Service.AdService;

import java.io.IOException;
import java.io.InputStream;

public class mybatis测试 {
    @Autowired
    private AdService adService;

    @Test
    public void test1() throws IOException {
        //加载配置文件
        InputStream inputStream= Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建sqlsessionfactory工厂对象
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        //创建sqlSession对象
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //获取代理对象
        AdDao accountDao=sqlSession.getMapper(AdDao.class);

        System.out.println(accountDao.queryadrand(2));
        inputStream.close();
    }
}
