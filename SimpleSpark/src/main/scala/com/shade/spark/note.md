### Spark中map和flatMap的区别
map是将每一个元素分为单位1，执行了传入的函数之后，返回的是每个单位1就变成了一个数组
例如=>
val rdd1 = sc.parallelize(List(1,2,3,3))
rdd1.map(x=>x.to(3)).collect
返回的类型是：Array[scala.collection.immutable.Range.Inclusive] = Array(Range(1, 2, 3), Range(2, 3), Range(3), Range(3))
而flatMap是将每一个元素转化成map之后然后再flat(拍平)返回的是单个的元素
val rdd1 = sc.parallelize(List(1,2,3,3))
rdd1.flagMap(x=>x.to(3)).collect
返回的类型是：Array[Int] = Array(1, 2, 3, 2, 3, 3, 3)