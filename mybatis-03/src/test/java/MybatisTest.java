import com.lin.dao.UserMapper;
import com.lin.pojo.User;
import com.lin.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.validator.PublicClassValidator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MybatisTest {
//    static private Logger logger = Logger.getLogger(MybatisTest.class);

    @Test
    public void getUserListByIdTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
//        logger.info("getUserListById");
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserListById(1);
        for (User user:userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void getUserListLimitTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<String,Object> map = new HashMap<>();
        map.put("startIndex",1);
        map.put("endIndex",4);

        List<User> userList = mapper.getUserListLimit(map);
        for (User user:userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void getUserListRowBoundsTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RowBounds rowBounds = new RowBounds(1, 4);
        List<User> userList = sqlSession.selectList("com.lin.dao.UserMapper.getUserByRowBounds", null, rowBounds);

        for (User user: userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

//    @Test
//    public void Log4jTest(){
//       logger.info("info : is in Log4jTest");
//       logger.debug("debug!");
//       logger.error("error!");
//    }
}
