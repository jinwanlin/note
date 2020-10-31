# Spring boot



## 准备

### 安装eclipse插件, 

插件地址 http://dist.springsource.com/release/TOOLS/update/e4.3/

注意: 不要选自动更新



### 新建hello wold项目

新建: Spring Starter Project

注意: Packaging选择jar;   java version选择8

### 常用Maven依赖
springboot 每一个框架的集成都是一个starter
```
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-tomcat</artifactId>
			<scope>provided</scope>
		</dependency>
		
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
			<exclusions>
				<exclusion>
					<groupId>org.junit.vintage</groupId>
					<artifactId>junit-vintage-engine</artifactId>
				</exclusion>
			</exclusions>
		</dependency>
		
		<!-- jap实现 -->
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-jdbc</artifactId>
		</dependency>

		<!-- mybatis实现 -->
		<dependency>
			<groupId>org.mybatis.spring.boot</groupId>
			<artifactId>mybatis-spring-boot-starter</artifactId>
			<version>2.0.0</version>
		</dependency>

		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
		</dependency>

```



## web相关

### Thymeleaf

```
Spring boot不建议使用jsp开发web。而是推荐使用Thymeleaf来作为模板引擎开发web项目。
```

我们用vue.js



### controller  json接口

```
@RestController
public class HelloController {
    @RequestMapping("/getUser")
    public User getUser() {
    	User user=new User();
    	user.setUserName("小明");
    	user.setPassWord("xxxx");
        return user;
    }
}
```
### 自定义 Filter

```
@Configuration
public class WebConfiguration {
    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }
    
    @Bean
    public FilterRegistrationBean testFilterRegistration() {
    
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("MyFilter");
        registration.setOrder(1);
        return registration;
    }
    
    public class MyFilter implements Filter {
    	@Override
    	public void destroy() {
    		// TODO Auto-generated method stub
    	}
    
    	@Override
    	public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain filterChain)
    			throws IOException, ServletException {
    		// TODO Auto-generated method stub
    		HttpServletRequest request = (HttpServletRequest) srequest;
    		System.out.println("this is MyFilter,url :"+request.getRequestURI());
    		filterChain.doFilter(srequest, sresponse);
    	}
    
    	@Override
    	public void init(FilterConfig arg0) throws ServletException {
    		// TODO Auto-generated method stub
    	}
    }
}
```

### 配置文件Property

敏捷开发特点: 约定优于配置

**配置文件 application.properties**

```
com.neo.title=纯洁的微笑
com.neo.description=分享生活和技术
```
**自定义配置类**
```
@Component
public class NeoProperties {
	@Value("${com.neo.title}")
	private String title;
	@Value("${com.neo.description}")
	private String description;

	//省略getter settet方法
	
	}
```

### log配置

```
logging.path=/user/local/log
logging.level.com.favorites=DEBUG
logging.level.org.springframework.web=INFO
logging.level.org.hibernate=ERROR
```

### Test

```
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Test
	public void hello() {
		System.out.println("hello world");
	}

}
```

引入了`MockMvc`支持了对 Controller 层的测试，简单示例如下：

```
public class HelloControlerTests {

    private MockMvc mvc;

    //初始化执行
    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    //验证controller是否正常响应并打印返回结果
    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
    
    //验证controller是否正常响应并判断返回结果是否正确
    @Test
    public void testHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello World")));
    }

}
```

### 开发支持热部署

```
 <dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <optional>true</optional>
    </dependency>
</dependencies>

<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
            <configuration>
                <fork>true</fork>
            </configuration>
        </plugin>
    </plugins>
</build>
```





### 打包, 服务器启动

分为两种；一种是打包成 jar 包直接执行，另一种是打包成 war 包放到 tomcat 服务器下。

**打包jar**

maven 项目，执行以下命令既可以

```
cd 项目跟目录（和pom.xml同级）

mvn clean package

## 或者执行下面的命令
## 排除测试代码后进行打包
mvn clean package  -Dmaven.test.skip=true
```

打包完成后 jar 包会生成到 target 目录下，命名一般是 项目名+版本号.jar

启动 jar 包命令

```
java -jar  target/spring-boot-scheduler-1.0.0.jar
```

这种方式，只要控制台关闭，服务就不能访问了。下面我们使用在后台运行的方式来启动:

```
nohup java -jar target/spring-boot-scheduler-1.0.0.jar &
```

也可以在启动的时候选择读取不同的配置文件

```
java -jar app.jar --spring.profiles.active=dev
```

也可以在启动的时候设置 jvm 参数

```
java -Xms10m -Xmx80m -jar app.jar &
```



**如何重启**

直接 kill 掉进程再次启动 jar 包





**打成 war 包**

打成 war 包一般可以分两种方式来实现，第一种可以通过 eclipse 这种开发工具来导出 war 包，另外一种是使用命令来完成，这里主要介绍后一种

1、maven 项目，修改 pom 包

将

```
<packaging>jar</packaging>  
```

改为

```
<packaging>war</packaging>
```

2、打包时排除tomcat.

```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-tomcat</artifactId>
	<scope>provided</scope>
</dependency>
```

在这里将 scope 属性设置为 provided，这样在最终形成的 WAR 中不会包含这个 JAR 包，因为 Tomcat 或 Jetty 等服务器在运行时将会提供相关的 API 类。





## 数据库

### JPA, mybatis, Hibernate之间关系
```
Jpa 是一套规范，不是一套产品，像 Hibernate,TopLink,JDO 这些是产品，如果说这些产品实现了这个 Jpa 规范，那么我们就可以叫他们为 Jpa 的实现产品。
```

### JPA

准确说是Spring boot基于 ORM 框架、Jpa规范的基础上封装的一套产品.

	  <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
		</dependency>

示例代码 https://github.com/ityouknow/spring-boot-examples/tree/master/spring-boot-jpa/spring-boot-jpa



### Hibernate

1...



### mybatis

准确说是mybatis的spring-boot实现

```
	<dependency>
		  <groupId>org.mybatis.spring.boot</groupId>
		  <artifactId>mybatis-spring-boot-starter</artifactId>
		  <version>2.0.0</version>
	</dependency>
  <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
  </dependency>
```
**配置文件(约定优于配置)**

```
mybatis.type-aliases-package=com.neo.model

spring.datasource.url=jdbc:mysql://localhost:3306/test?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&useSSL=true
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

Spring Boot 会自动加载 `spring.datasource.*` 相关配置，数据源就会自动注入到 sqlSessionFactory 中，sqlSessionFactory 会自动注入到 Mapper 中，对了，你一切都不用管了，直接拿起来使用就行了。

在启动类中添加对 mapper 包扫描`@MapperScan`

```
@SpringBootApplication
@MapperScan("com.neo.mapper")
public class MybatisAnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisAnnotationApplication.class, args);
	}
}
```

或者直接在 Mapper 类上面添加注解`@Mapper`，建议使用上面那种，不然每个 mapper 加个注解也挺麻烦的

**Mapper/Dao**

```
import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

@Repository
public interface UserMapper {
	@Select("SELECT * FROM person WHERE id = #{id}") // 具体dao层方法的实现
	Person selectUser(int id);// 返回一个person对象

	@Select("select * from person order by id")
	ArrayList<Person> selectAllUser();// 返回一个person对象
}
```

**实体/模型/Pojo/普通JavaBeans**

```
public class Person {
	 
    private Integer id;
    private String name;
    private Integer age;
 
    public Integer getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public Integer getAge() {
        return age;
    }
 
    public void setAge(Integer age) {
        this.age = age;
    }
 
    @Override
    public String toString() {
        return
                "id=" + id +
                        ", name='" + name + '\'' +
                        ", age=" + age
                ;
    }
}
```

**Service**

```
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.UserMapper;
import com.example.demo.model.Person;
 
 
@Service
public class UserService {
 
    @Autowired
    public UserMapper userMapper;
 
   // 获取单个用户信息
   @Transactional     //添加事务管理
    public Person selectUser(int id) {
        return userMapper.selectUser(id);
    }
 
    //获取所有的用户信息
    @Transactional
    public ArrayList<Person> selectAllUser() {
 
        return userMapper.selectAllUser();
 
    }
 
}
```

**Controller**

```

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.model.UserBean;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("person")
public class HelloWorldController {
	
    @Autowired
    private UserService userService;

	/**
	 * 查数据库
	 * @param id 
	 * @return
	 */
	@RequestMapping("show")
	public Person person(@PathVariable int id) {
		Person person = userService.selectUser(id);
		log.info("---person---"+person);
		return person;
	}
	
}
```



## 总结

1. 配置文件使用更简单
2. 可以打jar包 用java命令启动
3. 拥有敏捷开发的特点, 约定优于配置, 几乎没有xml配置文件
4. 