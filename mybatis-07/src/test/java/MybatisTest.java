import com.lin.dao.StudentMapper;
import com.lin.dao.TeacherMapper;
import com.lin.pojo.Student;
import com.lin.pojo.Teacher;
import com.lin.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 一对多
public class MybatisTest {
    @Test
    public void getTeaTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teacherList = mapper.getTeaWithStu();
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
        sqlSession.close();
    }
    @Test
    public void getTeaTes2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Map<String,Integer> map = new HashMap<>();
        map.put("tid",1);
        List<Teacher> teacherList = mapper.getTeaWithStu2(map);
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
        sqlSession.close();
    }
}
