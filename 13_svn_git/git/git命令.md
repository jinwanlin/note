让git记住账号和密码的方法：

　　在git bash 中执行命令：git config --global credential.helper store

​		后面任何一次输入账号密码都会被记住





## 查看历史

| git log             | 查看历史版本                                           |
| ------------------- | ------------------------------------------------------ |
| git show            | 查看版本号对应版本的历史, 如果参数是HEAD则查看最新版本 |
| git log -p filename | 查看某个文件的修改历史                                 |



## 覆盖本地更新代码

git reset --hard origin/master

