# Calo

Thymeleaf and Spring Boot based modern personal blogging system.

## Introduction
Light, concise, powerful, blog system developed using Java.

## Demo:
please visit: <https://calo.52306.org>

## Quik Start

### Environmental requirements

In order to avoid unexpected accidents during use, the following recommended configurations are given

CentOS 7.x
More than 512 MB of memory

### Server configuration

```bash
sudo yum update -y
```
#### Install Java Runtime Environment

```bash
# install OpenJRE
sudo yum install java-1.8.0-openjdk -y

# Check if the installation was successful
java -version
```
### Create mysql database

In this step, you need to create a mysql database with the table name Calo and the user's Calo password: B7bq9cDL8Kju9YwkX6Yv

```bash
# Create Mysql User & Password
CREATE USER “Calo”@”localhost” IDENTIFIED BY “B7bq9cDL8Kju9YwkX6Yv”;

# Create a database and authorize the database to the created user
create database Calo default charset utf8 collate utf8_general_ci;
grant all privileges on Calo.* to “Calo”@”localhost” identified by “B7bq9cDL8Kju9YwkX6Yv”;
flush privileges;
```

### Start Cola

```bash
java -jar Cola-latest.jar
```

### Creating Administrators through Database Operations

The administrator account created here is "username" and the password is "123456"
You can create different users according to your needs.
Passwords need to be generated in MD5 format here is the link to Generator password<https://passwordsgenerator.net/md5-hash-generator/>


```bash
INSERT INTO `t_user` (`id`, `avatar`, `create_time`, `email`, `nickname`, `password`, `type`, `update_time`, `username`) VALUES
(1, 'https://calo.52306.org/images/wechat.jpg', '2019-12-19 00:00:00.000000', 'email@email.com', 'username', 'e10adc3949ba59abbe56e057f20f883e', 1, '2019-12-19 00:00:00.000000', 'username');
```

