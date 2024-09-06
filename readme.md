# Spring Cloud Alibaba Example Project

Spring Cloud Alibaba 最佳实践示例

> 原始代码来源：https://github.com/alibaba/spring-cloud-alibaba/tree/2023.x/spring-cloud-alibaba-examples/integrated-example

## 自述

本项目源自 spring cloud alibaba 官方示例，为适配本地（windows环境）开发学习，进行了部分修改。

- 修改了 `docker-compose-env.yml` 文件，添加rocketmq控制台（`rmqdashboard`容器）。

- 调整项目pom结构，将多个父pom打平到一个父pom中。



## 使用

### 前提准备

- 安装了git

- 安装了Docker Desktop



### 本地运行步骤

1. 修改`\config-init\rocketmq\broker.conf`中的 `brokerIP1`改为自己本地电脑实际的ip地址。

2. 执行 `\docker-compose\start-docker.bat`启动依赖的中间件（rocketmq、nacos、seata、mysql）

3. 待docker实例都启动完成之后，将 `\config-init\sql\init.sql`导入到docker容器的mysql数据库中。

4. 在git bash中执行 `\config-init\scripts\nacos-config-quick.sh`将服务配置导入到nacos中。（注意：integrated-consumer.yaml 可能只能导入部分配置，配置导入之后需要去nacos控制台检查，如果缺少配置需要手动将缺少的配置填入）

5. 执行项目下各个子模块的 xxxApplication.java 方法，启动各个子项目。



### 体验 Demo

参考alibaba官方说明：

> https://github.com/alibaba/spring-cloud-alibaba/blob/2022.x/spring-cloud-alibaba-examples/integrated-example/docs/zh/docker-compose-deploy-zh.md#%E4%BD%93%E9%AA%8C-demo



### 附加功能

可以访问 http://localhost:19876 查看消息的消费情况。
