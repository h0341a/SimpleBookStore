#Servlet+JDBC to SSM过程总结
#####仅讨论本项目中使用到的关于Servlet,Spring,Mybatis,SpringMVC的技术
* Servlet:
>>一个servlet代表继承HttpServlet的类  
使用注解@WebServlet("url")可以与具体的url绑定  
主要使用的对象有: request,response,session  
每个对象常用的方法
>>>request:  
&emsp;getParameter():根据标示名获取存入request中的数据.如提交的表单   
&emsp;getSession():获取本次的session对象  
response:  
&emsp;sendRedirect():重定向  
&emsp;getWriter():获取可以直接将数据输出到浏览器的对象   
session:
&emsp;(get/set)Attribute:session的存取数据  
&emsp;invalidate:使session失效
* SpringMVC
>>相比于servlet,SpringMVC可以用每一个方法对应一个请求地址  
支持大量的注解,常用的注解有:
>>>@Controller:告诉springMVC这是一个控制器
@RequestMapping():该类或方法绑定的请求地址  
* Mybatis
>>需要自己加载配置文件,声明sqlSessionFactory来使用  
只需要自己编写一条SQL就可以完成对数据库的操作
* Spring-Mybatis
>>在spring配置文件中设置好后,完全不需要自己额外的操作,spring会搞定配置文件,sqlSessionFactory等
* Spring
>>目前本项目只使用了自动注入功能@Autowired  
自动注入:不需要自己声明对象,当需要时直接从spring的bean工厂取出一个
