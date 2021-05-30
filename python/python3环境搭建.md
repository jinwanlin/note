# 安装

修改pip源



## [Python3中安装pip3](https://www.cnblogs.com/fyly/p/11112169.html)



python3环境变量: /usr/local/bin/python3



## Mac修改默认Python版本为3.7

https://blog.csdn.net/Enidsky/article/details/104325864/

python 目录

/usr/local/Cellar/python@3.9/3.9.1_6/bin



## python3 安装 mysql 命令:

pip install PyMySQL



### 命令安装zope.interface

pip install zope.interface



### 手动下载安装 setuptools

https://pypi.org/project/setuptools/#files



安装Twisted

判断是否已安装twisted:

打开python命令行，输入“import twisted”,如果没有任何提示，说明你已经有twisted了

twisted的下载页面：https://twistedmatrix.com/trac/wiki/Downloads



## 安装crawler框架

## 1、安装scrapy

### 1.1、安装pywin32（解决python调用windows系统库的问题）

pip install -i https://pypi.tuna.tsinghua.edu.cn/simple pywin32

### 1.2、安装Twisted网络数据处理的集成包，scrapy会调用

pip install -i https://pypi.tuna.tsinghua.edu.cn/simple Twisted

### 1.3、安装scrapy模块

pip install -i https://pypi.tuna.tsinghua.edu.cn/simple scrapy

### 1.4、查看scrapy的版本号

scrapy version



# 虚拟环境

## 安装虚拟环境

Python2 安装虚拟环境

```
sudo pip install virtualenv
sudo pip install virtualenvwrapper
```

Python3 安装虚拟环境

```
sudo pip3 install virtualenv
sudo pip3 install virtualenvwrapper
```







## 配置环境变量

[![复制代码](https://common.cnblogs.com/images/copycode.gif)](javascript:void(0);)

```
# 1、在~（家目录）下创建目录用来存放虚拟环境
mkdir .virtualenvs

# 2、打开~/.bashrc文件，并添加如下：
export WORKON_HOME=$HOME/.virtualenvs
source /usr/local/bin/virtualenvwrapper.sh

# 3、运行
source ~/.bashrc
```



## 创建虚拟环境

如果不指定Python版本，默认安装的是Python2的虚拟环境

```
# 在python2中，创建虚拟环境
mkvirtualenv 虚拟环境名称
例 ：
mkvirtualenv py_flask
```

 如果是在python3中，创建虚拟环境，需要指定版本

```
mkvirtualenv -p python3 虚拟环境名称
例 ：
mkvirtualenv -p python3 py3_env
或
mkvirtualenv -p /usr/local/bin/python3 venv
```

## 查看所有的虚拟环境命令

```
workon
```

## 进入（使用）虚拟环境命令



```
workon 虚拟环境名称

例 ：使用python2的虚拟环境
workon py_flask

例 ：使用python3的虚拟环境
workon py3_flask
```

## 退出虚拟环境的命令

```
deactivate
```

## 删除虚拟环境的命令

```
rmvirtualenv 虚拟环境名称

例 ：删除虚拟环境py3_flask

先退出：deactivate
再删除：rmvirtualenv py3_flask
```

## 查看虚拟环境中安装的包 :

```
pip freeze
或
pip list
```