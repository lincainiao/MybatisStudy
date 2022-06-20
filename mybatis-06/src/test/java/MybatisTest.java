import com.lin.dao.StudentMapper;
import com.lin.dao.TeacherMapper;
import com.lin.dao.UserMapper;
import com.lin.pojo.Student;
import com.lin.pojo.Teacher;
import com.lin.pojo.User;
import com.lin.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MybatisTest {
    @Test
    public void getUserTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        for (User user:userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void getTeaTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teaList = mapper.getTeaList();
        for (Teacher teacher:teaList) {
            System.out.println(teacher);
        }
        sqlSession.close();
    }
    // 多对一
    @Test
    public void getStuWithTeaTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> stuListWithTeaList = mapper.getStuListWithTea();
        for (Student student:stuListWithTeaList) {
            System.out.println(student);
        }
        sqlSession.close();
    }
    @Test
    public void getStuWithTeaTes2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> stuListWithTeaList = mapper.getStuListWithTea2();
        for (Student student:stuListWithTeaList) {
            System.out.println(student);
        }
        sqlSession.close();
    }

}
