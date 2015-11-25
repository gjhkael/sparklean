## di-spark-demo
包括Java和Scala版本的Spark测试程序WordCout，以及用于生成随机数文件的测试程序Util

### 下载项目
 - git clone http://git.dev.sh.ctripcorp.com/guoj/di-spark-demo.git

### 编译打包
 - mvn clean package
 - 将target路径下的di-spark-test.jar复制到提交代码的客户端服务器上

### 准备数据
 - 将随机数生成文件上传到HDFS 到hadoop路径下使用：bin/hadoop -put xxx.txt  /xxx/

### 提交任务
 - 到spark路径下使用如下命令提交任务：

``` bash

./bin/spark-submit --class com.ctrip.di.scala.spark.ScalaWordCount --master yarn-client --num-executors 2 --driver-memory 1g --executor-cores 2 /home/op1/jhguo/di-sh-test.jar yarn-client /gjh/data.txt /gjh/out
```

