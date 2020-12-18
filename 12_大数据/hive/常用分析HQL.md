## hdfs数据导入到hive表

不可覆盖表内容

```
load data inpath '/opt/jskp/jinjiwei/ml-100k/u.data' 
into table testkv;
```

可覆盖表内容

```
load data local inpath '/opt/jskp/jinjiwei/ml-100k/u.data' 
overwrite into table jjw; 
```





建表导入HDFS数据

```
DROP TABLE IF EXISTS bdp.words;
create table bdp.words(name string)  
LINES TERMINATED BY '\n'
stored as textfile  
location '/user/bdp/datasource/words';
```

