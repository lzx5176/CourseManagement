package com.hnust.test;
import com.hnust.pojo.Course;
import com.hnust.pojo.School;
import com.hnust.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import java.util.List;
public class MybatisTest {

    @Test
    public void selectCourseByIdTest(){
        SqlSession sqlSession=MybatisUtils.getSession();
        Course course=sqlSession.selectOne("com.hnust.mapper.CourseMapper.selectCourseById",
                2);
        System.out.println(course);
        sqlSession.close();
    }

    @Test
    public void selectCourseByschoolnameTest(){
        SqlSession session=MybatisUtils.getSession();
        School school=session.selectOne("com.hnust.mapper.SchoolMapper.selectCourseByschoolname",
                "计算机学院");
        System.out.println(school);
        session.close();
    }

    @Test
    public void updateCourseTest(){
        SqlSession session=MybatisUtils.getSession();
        Course course =new Course();
        course.setId(4);
        course.setHours(32);
        int num=session.update("com.hnust.mapper.CourseMapper.updateHours",course);
        if(num>0){
            System.out.println("成功修改"+num+"条数据");
        }else{
            System.out.println("修改操作失败");
        }
        session.commit();
        session.close();
    }

    @Test
    public void addCourseTest(){
        SqlSession session=MybatisUtils.getSession();
        Course course=new Course();
        course.setName("大数据存储");
        course.setHours(32);
        course.setSid(1);
        int num=session.insert("com.hnust.mapper.CourseMapper.addCourse",course);
        if(num>0){
            System.out.println("成功插入"+num+"条数据");
        }else{
            System.out.println("插入操作失败");
        }
        session.commit();
        session.close();
    }

    @Test
    public void selectAllCourseTest(){
        SqlSession session=MybatisUtils.getSession();
        List<School> schools=session.selectList("com.hnust.mapper.SchoolMapper.selectAllCourse");
        for(School c:schools){
            System.out.println(c);
        }
        session.close();
    }
}
