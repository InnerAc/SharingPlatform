# SharingPlatform
## 江苏省水文监测资料共享平台设计
### 编写记录
- 2016.7.24 14:00 - 2016.7.24 17:53
创建项目，搭建环境,创建数据库，创建DAO
- 2016.7.24 20:09 - 2016.7.24 21:45
完善水文要素的DAO，测试水温要素维护功能
- 2016.7.25 10:17 - 2016.7.25 11:57
继续写水文要素维护功能
- 2016.7.25 14:21 - 2016.7.25 15:41
继续写水文要素维护功能(测试直接在表格上修改信息)
- 2016.7.26 15:54 - 2016.7.26 17:01
完成了直接通过表格进行数据库操作
- 2016.7.26 17:50 - 2016.7.26 20:49
完成了增加和删除
- 2016.7.27 18:20 - 2016.7.27 18:55
完美完成了动态的删除和添加，同时不报异常，水文要素维护功能完全完成。并且添加了代码注释。
- 2016.7.28 16:47 - 2016.7.28 17:44
完成了资费的修改，同时修改了要素添加后界面会乱的bug
- 2016.7.28 20:48 - 2016.7.28 21:16
完善了河流名称表的DAO
- 2016.7.29 15:24 - 2016.7.29 19:20
完成了河流名称的维护，修复了水文要素表中修改后出项两个<td>的bug
- 2016.7.30 17:00 - 2016.7.30 18:10
完成了行政区代码表的维护
- 2016.7.31 8:30 - 2016.7.31 10:51
开始进行资料申请的DAO和界面编写
- 2016.7.31 11:07 - 2016.7.31 11:50
测试了下拉框的多选按钮
- 2016.7.31 13:30 - 2016.7.31 18:09
终于调好了申请界面，日期选择组建待改进
- 2016.7.31 18:30 - 2016.7.31 19:14
继续改进界面显示，同时将每个组建加上name和id
- 2016.7.31 19:46 - 2016.7.31 20:24
成功将要素名称添加到申请内容中
- 2016.8.1 8:48 - 2016.8.1 10:35
完成了站点筛选
- 2016.8.1 10:58 - 2016.8.1 11:57
完成了站点的全选，反选，循环将站点信息填充到申请内容表中，完成了日期的选择和填充
- 2016.8.1 15:20 - 2016.8.1 17:14
完成了申请表的存储，优化了日期格式化
- 2016.8.2 9:20 - 2016.8.2 11:15
更改了日期计算算法，修复了起始日期和终止日期相同的bug，添加了计算资费
- 2016.8.2 15:30 - 2016.8.2 17:22
完成了回显的静态页面
- 2016.8.2 17:50 - 2016.8.2 18:55
测试各种打印方式，还未找到合适的方法
- 2016.8.2 19:12 - 2016.8.2 20:40
尝试了Excel导出模式，失败
- 2016.8.3 8:30 - 2016.8.3 9:56
尝试了保存到本地再下载，可行，但是不合适
- 2016.8.3 10:10 - 2016.8.3 12:48
终于搞定了下载和回显，吃饭去，吃完饭把退出取消逻辑写完
- 2016.8.3 15:30 - 2016.8.3 16:40
退出逻辑完成，需求一完成，修改了跳转bug
- 2016.8.4 10:30 - 2016.8.4 12:31
添加了修改申请表的功能，测试完成没有问题，需求二完成，目前只剩需求1.6和1.7
- 2016.8.4 16:30 - 2016.8.4 18:29
写完了资料归档的界面，眼睛受不了了，开始休息
- 2016.8.9 10:58 - 2016.8.9 11:27
写资料归档界面的前端逻辑
- 2016.8.9 14:30 - 2016.8.9 16:44
继续写资料归档界面的前端逻辑
- 2016.8.10 10:17 - 2016.8.10 11:14
梳理前后端逻辑
- 2016.8.10 15:00 - 2016.8.10 16:50
完成了增加了站点增减的逻辑
- 2016.8.12 9:05 - 2016.8.12 11:44
增加了资料归档确认键的前端逻辑
- 2016.8.12 14:00 - 2016.8.12 17:15
完成了资料归档的后端逻辑，资料归档基本完成。
- 2016.8.13 14:30 - 2016.8.13 15:58
编写资料使用情况统计的界面
- 2016.8.13 16:20 - 2016.8.13 16:43
编写资料使用情况统计的逻辑
- 2016.8.15 9:30 - 2016.8.15 11:15
修改了资料申请中，日期类型的选择方式，写完了界面
- 2016.8.15 12:49 - 2016.8.15 15:20
完成了资料申请中日期的逻辑还有更新逻辑，去除了要素类型为1时计算资费的问题
---
### 当前问题
1. 资费计算时，日期的单位为什么，暂定为天
2. 申请表提交时单位类型怎样确认
3. 在申请表填写时，根据要素类型来弹出不同类型的日期选择框未实现，原因是不好确认
改日期显示