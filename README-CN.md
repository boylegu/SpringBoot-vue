## SprintBoot-Vue

SpringBoot ＋ 前端MVVM 基于Java的微服务全栈快速开发实践

<p align="center">
  <a href ="##"><img alt="spring_vue" src="https://github.com/boylegu/SpringBoot-vue/blob/master/images/newlogo.jpg?raw=true"></a></p>

<h4 align="center" style="color:	#3399FF">
Convenient & efficient and better performance for Java microservice full stack.
</h4>

<p align="center" style="color: #FF66FF">Commemorate the 6 anniversary of enter the profession.</p>

<p align="center" style="color: #FF9933">Give beginner as a present.</p>

<p align="right" style="color: #3399FF">———————By Boyle Gu</p>

## 背景
如今Web开发领域，当有人提到Java时，总会让人觉得臃肿、古老而过时且开发效率没有某些动态语言高效，甚至在此之前还有人高喊“Java 已死！”，但是事实真是如此吗？其实如果你一直关注着Java，那你的感悟会更深，尽管它有很多的缺点和啰嗦，但不可否认，Java依然是工业界中最优秀的语言，而且它一直保持着与时俱进。本项目将使用SpringBoot + Vue2 ＋ Webpack2 配合最简单CRUD的逻辑来展示一个基于Java的微服务全栈快速开发实践的Demo。

在某些时候，其开发效率已经并不比某些动态语言低。

## 为什么是SpringBoot

首先先来简单的介绍一下Spring，它是目前Java生态中最广为人知、流行的企业级Web框架。不像其他一些框架仅聚焦在某个领域，Spring框架通过其容器化组件式管理及开发，可提供或定制各式各样的功能来满足企业化需求。

那么相较于Spring，Spring Boot的目标是更加容易的创建Spring应用、建立自动化、最少人为干预的生产级配置，真正意义做到开箱即用，并且对于新用户及Spring平台的用户极易上手，快速开发。

下图主要展示了Spring Boot在Spring庞大的生态圈中的层级关系

<p align="center">
  <a href ="##"><img alt="spring_vue" src="https://github.com/boylegu/SpringBoot-vue/blob/master/images/springboot.png?raw=true"></a></p>
  
SpringBoot的目标主要：

- 为所有Spring开发提供一个从根本上更快，且随处可得的入门体验。

- 开箱即用，但通过不采用默认设置可以快速摆脱这种方式。

- 提供一系列大型项目常用的非功能性特征，比如：内嵌服务器，安全，指标，健康检测，外部化配置。

**绝对没有代码生成，也不需要XML配置。**

下面展示的是本项目的SpringBoot相关代码片段，你觉得简单么？

~~~~java
@RestController
@RequestMapping("/api/persons")
public class MainController {

    @RequestMapping(
            value = "/detail/{id}", 
            method = RequestMethod.GET, 
            produces = MediaType.APPLICATION_JSON_VALUE
            )
    public ResponseEntity<Persons> getUserDetail(@PathVariable Long id) {

        /*
        *    @api {GET} /api/persons/detail/:id  details info
        *    @apiName GetPersonDetails
        *    @apiGroup Info Manage
        *    @apiVersion 1.0.0
        *
        *    @apiExample {httpie} Example usage:
        *
        *        http GET http://127.0.0.1:8000/api/persons/detail/1
        *
        *    @apiSuccess {String} email
        *    @apiSuccess {String} id
        *    @apiSuccess {String} phone
        *    @apiSuccess {String} sex
        *    @apiSuccess {String} username
        *    @apiSuccess {String} zone
        */

        Persons user = personsRepository.findById(id);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
~~~~

### 为什么是MVVM

那么在我继续之前，我也想和大家回顾一下Web开发的发展简史：

- 第一阶段: 网页三剑客，生猛的通过原生javascript直接操作Dom树;

- 第二阶段: JQuery诞生，配合前端MVC为代表的Backbone.js, 让我们可以优雅而简单的操作Dom树;

- 第三阶段: 后端架构升级为MVC，前后端分工更清晰，前端工程化、ECMAScript规范开始崭露头角;

- 第四阶段: 后端架构进入了微服务时代，前端架构不仅升级为MVVM，ES6更是成为目前事实上的标准;

在这里，我不想过于神化MVVM有多么的先进，JQuery为代表的MVC有多么的落后，但确实MVVM有着很多先进的特性:

- 低开销

- 易维护

- 可重用

### 为什么选择Vue.js

Vue.js是MVVM设计模式中目前最火热的一个前端框架之一，除了性能表现优异之外，与类似React相比，更轻量级、更容易上手。

通过Vue中的“单文件组件”特性，更灵活的定义组件，不仅使代码结构更清晰，而且能与任何其他组件进行随意组合，更具复用性。

<p align="center">
  <a href ="##"><img style="box-shadow: 8px 8px 5px #888888;"alt="sanic_vue" src="http://i2.muimg.com/536217/5ae4b10becac44b0.png"></a>

### Webpack是什么
Webpack提供了一整套前端工程自动化的解决方案

## Demo

一个简单的“上海人员信息查询系统”作为例子

[![demo-image](https://github.com/boylegu/SpringBoot-vue/blob/master/images/demo.gif?raw=true)]()

### 具备的功能(v0.1)

- Spring Boot (后端)
  
  - 通过在Spring Boot中建立基于RestFul-API并使用`@ RequestMapping`实现一个基本的CRUD逻辑
  
  - 处理CORS(跨域资源共享)
  
  - 在Spring Boot中进行单元测试

  - 支持热加载
  
  - 增加api接口文档 
  
  - 通过SpringBoot配合JPA来实现RestFul-API的分页
   
- VueJS & webpack (前端)

  - 遵循ECMAScript 6 规范
  
  - 如何在vue中使用‘单文件组件’进行开发编码
  
  - 演示‘非父子组件’如何进行简单的通信以及‘父子组件’之间如何传递数据
  
  - 如何和后端进行数据交互

  - 如何在vue中优雅的引入第三方JS库

  - 格式化时间
  
  - 分页实现
  
  - 可复用组件
 
     - DbHeader.vue
     - DbFooter.vue  (sticky footer) 
     - DbFilterinput.vue
     - DbModal.vue
     - DbSidebar.vue
     - DbTable.vue 
     
     >> 得益于类似vue、react等MVVM模式，本项目的任何组件，只要您觉得合适，都可以复用在您的任何项目中，避免重复造轮子。
  
  - 如何通过webpack2配置来自动化构建前端环境(包括如何配置vue2、处理静态文件,构建不同环境等等)  

### 本项目主要技术栈
- Java 1.7
- Spring Boot 1.5.x
- Maven
- sqlite (not recommend, only convenience example)
- vueJS 2.x
- webpack 2.x
- element ui
- axios

### 准备工作

- 安装JDK1.7或更新的版本
- 安装Node.js/NPM
- 克隆仓库

        git clone https://github.com/boylegu/SpringBoot-vue.git
        
        cd springboot_vue

### 安装  
        
- 编译前端开发环境

        cd springboot_vue/frontend

        npm install 

### 使用

- 运行Spring Boot后端服务

        cd springboot_vue/target/

        java -jar springboot_vue-0.0.1-SNAPSHOT.jar


[![](https://github.com/boylegu/SpringBoot-vue/blob/master/images/spring_run.png?raw=true)]()

- 运行前端服务

        cd springboot_vue/frontend

        npm run dev


> 你也可以在生产环境中运行`cd springboot_vue/frontend;npm run build`进行编译并配合Nginx
        
## 未来计划

本项目可以作为工作参考、学习或者教学演示，之后将陆续以版本的形式，即每个版本都会新增不同的功能演示项，不定期进行发布更新，有以下功能已经在计划之中：

1. 用户认证
2. 引入更高级的vuex组件通信机制
3. 演示vue-route的使用
4. 加入docker部署环境
5. 新增针对yarn的支持
... ...

## 技术、教学支持

由于个人时间暂时有限，关于Spring、Vue、webpack等所有的核心的议题内容非常庞大，因此我将以以下形式来回答和解释关于本项目Demo问题：

1. 以Github Issue的形式进行提问
2. 电子邮件的形式 gubaoer@hotmail.com
3. QQ群：315308272

## 相关项目

- [Sanic-Vue for Python](https://github.com/boylegu/SanicCRUD-vue)


## My Final Thoughts

```
      .   ____          _
     /\\ / ___'_ __ _ _(_)_ __  __ _
    ( ( )\___ | '_ | '_| | '_ \/ _` |
     \\/  ___)| |_)| | | | | || (_| |
      '  |____| .__|_| |_|_| |_\__, |
\  ===========|_|==============|___/== ▀
\- ▌          SpringBoot-vue             ▀
 - ▌                            (o)        ▀
/- ▌            Go Go Go !               ▀
/  =================================== ▀
                    ██


```

