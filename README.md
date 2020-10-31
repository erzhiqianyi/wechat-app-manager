# 微信应用管理 - 领域驱动设计实现微信应用(订阅号,服务号，小程序)管理
```微信应用管理``` 是一个使用```领域驱动设计(Domain-Driven Design)``` 实现的 ```REST``` 服务。

项目基于实践领域驱动设计和测试驱动开发,按步骤逐步实现一个 ```REST``` 服务。每实现一个功能点，先写测试，再来写实现逻辑。测试会使用 ```groovy``` 和 ```junit``` 。

## 应用说明

实现[微信第三方平台功能](https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/Third_party_platform_appid.html)。

管理微信应用以及和微信服务器交互,包括订阅号,服务号,小程序和微信支付。支持多商户,商户可以添加成员,管理应用。


## 技术选型
项目基于 [Spring Boot](https://spring.io/projects/spring-boot),依赖管理使用 [Gradle](https://gradle.org/),部分测试使用  [Groovy](http://groovy-lang.org/) 编写,持久化采用 [Spring Data JPA](https://spring.io/projects/spring-data-jpa),数据库采用 ``[MySQL](https://www.mysql.com/cn/) 和 [reids](https://redis.io/)。

建议使用  ```Intellij IDEA ```  进行开发。

##  参考资料
- [领域驱动设计-软件核心复杂性应对之道](https://book.douban.com/subject/26819666/) 
- [实现领域驱动设计](https://book.douban.com/subject/25844633/) 
- [Awesome Domain-Driven Design ](https://github.com/heynickc/awesome-ddd)
- [project-manager](https://github.com/mkopylec/project-manager)
- [使用DDD实现社区服务系统](https://github.com/daoqidelv/community-ddd-demo)

## 错误码说明 
业务操作失败，统一返回错误码和错误信息。错误码用数字表示，示例如下
```json
{
    "errorCode":40001,
    "errorMsg":"invlid appid ,appid can't be null'
}
```
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
- _(C)_ - 上下文(Context)

## 第一步 - 添加微信应用
参考[微信开放平台的说明](https://developers.weixin.qq.com/doc/oplatform/Third-party_Platforms/api/api_get_authorizer_info.html#business_info-%E8%AF%B4%E6%98%8E),创建一个微信应用,需要一些基本信息，即授权方的基本账号信息。如果开通了微信开放平台第三方平台开发权限,可以直接通过微信接口获取授权方账号基本信息。如果没有开通，则可以手动输入相关信息。

用户可以添加 **微信应用**<sub>_(E)_</sub> 。
为了区分应用属于哪一个商户,微信应用应该有一个 **商户id**<sub>_(EP)_</sub>。
需要的授权方账号信息有 **授权账号基本信息**<sub>_(VO)_</sub>和 **授权信息**<sub>_(VO)_</sub>。
目前暂不考虑授权信息,授权信息需要开通微信开放平台第三方平台开发权限,为了达到相同的效果，需要获取微信应用的 **开发配置**<sub>_(VO)_</sub> 和 **应用密钥**<sub>_(VO)_</sub>。

账号基本信息有 **昵称**<sub>_(VOP)_</sub>,**头像**<sub>_(VOP)_</sub>,**原始 ID**<sub>_(VOP)_</sub>,**主体名称**<sub>_(VOP)_</sub>,**应用编号**<sub>_(VOP)_</sub>,**应用类型**<sub>_(VOP)_</sub>,**认证状态**<sub>_(VOP)_</sub>。

微信应用不能重复,通过应用编号判断应用是否重复,基本信息不能为空。
开发配置和应用密钥可以为空。
### To do
check _step-1-start_ 分支。
实现  ```WechatAppController.createApp(...)``` 方法,运行单元测试。
测试通过后，切换到 _step-1-finish_ 分支。 




