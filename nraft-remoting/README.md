### 远程调用方式
- 服务端写提供接口和实现类，同时在类上面增加@ServcieName注解，唯一
- 客户端引用接口即可
- 服务端需要在ServiceExposure的registry方法里面注入,后期统一扫描去实现
自己测试可以直接调用注入
- 通过ClientProxy的create方法创建对应的实例，然后直接调用即可
- 目前需要指定绑定ip,port，后期通过节点id去绑定对应的节点

### 样例
- 调用方式可参照 ServerStartTest.java 和 ClientStartTest.java

### 注意事项
- 暂时不支持，入参是dto的调用

