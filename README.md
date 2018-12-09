# staffshift
Staff Shift Allocation

问题描述:  
通过已经给出员工的数据（员工ID, 不可用工作日期，一周最大工作时长），排班表（工作日期，角色，工作时长）来分配一周的工作安排。  
我们的服务以表格的形式在页面上为用户提供一周的上班安排数据展示。访问http://deployment_ip查看。  

实现方式:  
a)controller  
响应前端请求, 请求 / 跳转到展示数据页面, 请求 /getShift 获取json格式详细数据  
b)service  
业务层封装，提供处理shift能力，提供查询已处理好的shift能力  
c)dao  
数据库交互层，封装数据库请求，每张数据库表对应一个dao封装  

技术细节:  
a)WEB后台  
使用spring boot框架  
使用mybatis框架  
使用postgresql数据库驱动  
b)WEB前端：
使用jquery框架  
c)数据库  
postgresql版本10  

本地部署:  
a)部署环境  
1.java运行环境：java version "1.8.0_191"   
2.操作系统: ubuntu   
3.数据库： postgresql 10  
b)部署方法  
1.数据库准备：运行sql.txt文件夹中包含的sql语句，创建数据库，创建表，插入数据  
2.依赖的jar包准备：使用eclipse导出项目依赖的jar包并放在lib文件夹下，拷贝lib文件夹到部署根目录  
3.项目文件准备：拷贝编译后的com文件夹，static文件夹，application.properties到部署根目录  

运行服务:  
使用启动脚本开启服务： 运行start.sh中包含的命令，启动程序(按照部署方法的描述提前准备好lib,com,static,application.properties,以及配置好数据库)。  
查看页面：如果你部署在本地，访问http://127.0.0.1查看页面  
查看数据接口：使用HTTP GET方式请求 http://127.0.0.1/getShift 获取一周上班安排的json格式数据  

改进:  
a)目前没有实现的功能:  
1.shift信息的修改功能  
2.employee信息的修改功能    
3.没有权限功能，任何人都可以访问  
b)技术的提升:  
1.前端使用js框架，美化页面  
2.后台与数据库的交互没有使用ssl加密传输  
3.web服务和数据库没有分开部署  


