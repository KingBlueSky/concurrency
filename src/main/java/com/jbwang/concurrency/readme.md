### synchronized
1. java语言层面提供的一个关键字，可以使线程同步进行
2. synchronized是独占锁
3. synchronized是不可中断的
4. synchronized是非公平锁，可重入的
5. synchronized在并发小的时候使用
6. synchronized可以实现原子性，可见性和重排序

### 有序性 happen-before
1. 程序次序规则
2. 锁定规则
3. volatile读写变量规则
4. 传递规则
5. 线程启动规则
6. 线程中断规则
7. 线程终止规则
8. 对象终止规则

### 发布对象
1. 发布对象：使一个对象能够被当前范围之外的代码使用
2. 对象逃逸：一种错误的发布，当一个对象还没有构造完成时，就使其他线程可见。

### final 修饰类，方法和变量
1. final修改类，说明这个类不可被继承
2. final修改方法 子类不能进行重写
3. final修饰变量 不能改变变量的值，包括直接值和引用值

### 不可变对象
1. 使用final修饰，修饰的对象不能改变引用，但可以修改值
2. 使用Collections.unmodifiableXXX创建的集合类对象，同时也不能修改对象的值，以部分方法抛出异常来实现的
3. 使用guava提供的immutablexx系列的集合创建不可变对象

### 线程封闭
1. 堆栈封闭：即局部变量，不存在并发问题
2. ThreadLocal封闭：不存在并发问题

### 常用的线程安全与不安全类
1. StirngBuilder和StringBuffr.
2. SimpleDateFormat
3. ArrayList,HashSet,HashMap和Collections

### 线程安全的同步容器
1. vector，stack等
2. hashtable等
3. collections.synchronizedXXX等创建的对象


### 并发容器
1. copyOnWriteArrayList
2. copyOnWriteArraySet, concurrentSkipListSet
3. concurrentHashMap, concurrentSkipListMap

### 常用AQS组件
1. countDownLatch
2. semaphore
3. cyclicBarrier
4. reentrankLock
5. 