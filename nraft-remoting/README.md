### 远程调用方式
- 服务端写提供接口和实现类，同时在类上面增加@ServcieName注解，唯一
- 客户端引用接口即可
- 通过CommunicateServer的create方法创建对应的实例，然后直接调用即可

### 样例
- 调用方式可参照 ServerStartTest.java 和 ClientStartTest.java

### 注意事项
- 暂时不支持，入参是dto的调用

