# 微信应用管理 - 领域驱动设计实现微信应用(订阅号,服务号，小程序)管理
```微信应用管理``` 是一个使用```领域驱动设计(Domain-Driven Design)``` 实现的 ```REST``` 服务。

项目基于实践领域驱动设计和测试驱动开发,按步骤逐步实现一个 ```REST``` 服务。每实现一个功能点，先写测试，再来写实现逻辑。测试会使用 ```groovy``` 和 ```junit``` 。

## 应用说明
这个应用用来管理微信应用以及和微信服务器交互,包括订阅号,服务号,小程序和微信支付。

申请相应应用后,在微信公众平台后台开发配置中填写好相应配置后，在本应用中添加相应微信应用，完成微信服务配置，成为微信开发者。

使用这个应用可以添加微信应用，刷新微信 ```access_token``` ,接收微信消息,调用微信服务接口。

## 技术选型
项目基于 [Spring Boot](https://spring.io/projects/spring-boot),依赖管理使用 [Gradle](https://gradle.org/),部分测试使用  [Groovy](http://groovy-lang.org/) 编写,持久化采用 [Spring Data JPA](https://spring.io/projects/spring-data-jpa),数据库采用 ``[MySQL](https://www.mysql.com/cn/) 和 [reids](https://redis.io/)。

建议使用  ```Intellij IDEA ```  进行开发。

##  参考资料
- [领域驱动设计-软件核心复杂性应对之道](https://book.douban.com/subject/26819666/) 
- [实现领域驱动设计](https://book.douban.com/subject/25844633/) 
- [Awesome Domain-Driven Design ](https://github.com/heynickc/awesome-ddd)
- [project-manager](https://github.com/mkopylec/project-manager)
- [使用DDD实现社区服务系统](https://github.com/daoqidelv/community-ddd-demo)

## 实现步骤

每个分支代表一个任务。

任务利用领域驱动设计规则实现每一步，是单元测试能够顺利通过。

要进行领域驱动设计,首先消化知识,形成通用语言,达到设计即代码,代码即设计的效果。下面描述了使用通用语言实现的步骤。

说明中包含了如何根据业务需求设计模型的提示。

- _(E)_ - 实体(entity)
- _(EP)_ - 实体属性(entity property)
- _(VO)_ - 值对象(value object)
- _(VOP)_ - 值对象属性(value object property)
- _(DS)_ - 领域服务(domain service)
- _(R)_ - 仓储(repository)
- _(F)_ - 工厂(facotry)
_ _(C)_ - 上下文(Context)

### 第一步 - 创建账号-演示

在 **微信应用管理<sub>_C_</sub>** 上下文中,用户为应用管理者,隶属于一个团队，团队成员有不同权限。

用户要创建 **账号**<sub>_(E)_</sub> 后才能使用应用。
要区分账号，账号要有一个 **唯一编号**<sub>_EP_</sub>, **用户唯一编号自动生成**<sub>_(DS)_</sub>。
要区分用户, 账号要有一个  **名字**<sub>_EP_</sub>。

#### To do
切换到分支 

### 第二步 - 创建团队
用户可以创建 ***团队***<sub>_(E)_</sub>.

***团队***<sub>_(E)_</sub>必须要有 **名字**<sub>_(EP)_</sub> 和 **团队类型**<sub>_(EP)_</sub>,

**团队类型**<sub>_(EP)_</sub>, 分为 ```个人```,```组织``` 。

用户需要知道团队有多少个微信应用。

为了完成这个需卡，应用需要显示 **团队有多少个微信应用**<sub>_(EP)_</sub> .

一个用户只能创建一个团队






