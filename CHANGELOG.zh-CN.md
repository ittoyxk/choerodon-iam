# Changelog

这个项目的所有显著变化都将被记录在这个文件中。


# [0.22.0] - 2020-08-01

## 后端
### 新增
- 替换基础依赖为hzero依赖

### 优化

### 删除


# [0.21.0] - 2020-03-04

## 后端
### 新增

- 新增平台概览
- 新增组织概览
- 新增重置用户gitlab密码
- 新增组织root用户相关接口
- 新增查询拥有gitlab角色标签的用户

### 优化
- 优化组织管理员角色逻辑，组织管理员拥有组织下所有项目权限
- 优化自定义角色逻辑
- 优化导入组织用户excel模板
- 优化判断用户是否是项目所有者或项目成员

### 删除

- 删除应用市场表结构以及对应逻辑
- 删除书签相关逻辑

# [0.20.0] - 2019-12-16

## 后端

### 新增

- 新增描述维护
- 新增LookUp维护
- 新增Lov管理
- 新增自动同步ldap用户
- 添加路由关联表

### 修复

- 修复注册项目的创建人为审批人的问题