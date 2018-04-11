package learnspring.springmybatis;

import org.apache.ibatis.annotations.Select;

public interface BlogMapperI {
    @Select("SELECT * FROM public.user WHERE id = #{id}")
    User selectBlog(int id);
}

class test {
    {
        System.out.println("Dyn block");
    }

    test() {
        System.out.println("constructor");
    }

}