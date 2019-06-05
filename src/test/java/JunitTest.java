import com.alibaba.fastjson.JSON;
import com.hawk.entity.City;
import com.hawk.entity.User;
import com.hawk.service.CityService;
import com.hawk.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * @author zhangdonghao
 * @date 2019/4/17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:config/spring/applicationContext.xml",
        "classpath:config/spring/spring-mvc.xml",
        "classpath:config/mybatis/mybatis-config.xml"})
public class JunitTest {
    @Autowired
    private UserService userService;
    @Autowired
    private CityService cityService;

    @Test
    public void findUser() {
        User user = userService.getUserById(2);
        System.out.println(JSON.toJSONString(user));
    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setName("天下霸");
        user.setAge(24);
        user.setSex("女");
        userService.insert(user);
        System.out.println(user.getId());
    }

    @Test
    public void findAll() {
        List<User> users = userService.findAll();
        users.stream().filter(user -> user.getAge() > 18).forEach(user1 -> {
            System.out.println("姓名:" + user1.getName() + "  性别:" + user1.getSex() + "  年龄:" + user1.getAge());
        });
    }

    @Test
    public void findCityAll(){
        List<City> cities = cityService.findCityAll();
        System.out.println(JSON.toJSONString(cities));
    }
}
