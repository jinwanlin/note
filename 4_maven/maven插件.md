

### 自动发布插件

1. Pom.xml需要添加plugin

   ```
   			<plugin>
   				<artifactId>exec-maven-plugin</artifactId>
   				<groupId>org.codehaus.mojo</groupId>
   				<executions>
   					<execution>
   						<id>deploy</id>
   						<phase>install</phase>
   						<goals>
   							<goal>exec</goal>
   						</goals>
   						<configuration>
   							<executable>${basedir}/shell/remote-deploy.sh</executable>
   						</configuration>
   					</execution>
   				</executions>
   			</plugin>
   ```

2. 需要shell配置文件 remote-deploy.sh

```
#!/bin/bash
set -x
#folder=/ICESX/ICESX/workSpace/114118/trunk/xjgz-weixin-v2-mvn
user="xjgzbj"
host="114.247.216.6"
password="zgjxqazwsx"
remote_tomcat="/home/jin/apache-tomcat-7.0.64_recite_words/webapps"
folder=`pwd`
cd $folder
app=`cat pom.xml |grep \<finalName\>|awk -F "<|>" {'print $3'}`
zip_file=$app.zip
cd target
rm -rf ./$zip_file


# libs=`ls ./$app/WEB-INF/lib/`
# for i in $libs
# do
	# rm -rf ./$app/WEB-INF/lib/$i
# done

zip -r $zip_file $app


scp ${zip_file} ${user}@${host}:${remote_tomcat}/
ssh ${user}@${host} <<EOF
/home/jin/apache-tomcat-7.0.64_recite_words/bin/killall
sleep 3
cd ${remote_tomcat}
unzip -o ${app}.zip
touch ${remote_tomcat}/${app}/WEB-INF/web.xml
/home/jin/apache-tomcat-7.0.64_recite_words/bin/startup.sh
EOF


echo "deploy finish!"

```

### 自动测试插件



### 打包插件

