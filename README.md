# AndroidComponentDemo

Android组件化,插件自动完成依赖特性



[ComponentPlugin](https://github.com/Allure0/AndroidComponentPlugin)

|自动完成特性       |含义| 
| :--------: | :-----: | 
|  组件单独运行    | 如何将一个庞大的项目分而治之,可单独运行和集成为一个整体   | 
|  UI跳转      | 每个业务组件之间如何跳转   | 
|  组件通信   | 如何在业务之间进行数据传递   |
| 代码隔离      | 组件与组件之间如何避免直接引用   | 

## 插件使用方式

### Step1:整个项目build.gralde之下添加以下代码

```
/**--引用插件----**/
apply plugin: 'com.allure.appconfig'

buildscript {
    repositories {
        maven {
             url  "http://dl.bintray.com/allure0/maven"
        }
    }
    dependencies {
        //格式为-->group:module:version
        classpath 'com.allure.plugin:Component:1.0.0'
    }
}
/**--引用插件----**/

/**--插件配置宿主壳App与组件----**/
hostAppConfig {
    isDebug true

    //宿主载体
    apps {
        app {

            mainActivity "com.allure.modularization.SplashActivity"
            modules ':modules:login',
                    ':modules:shop',
                    ':modules:main'
        }
    }

//组件
    modules {
        login {
            isRunAlone true
            name ":modules:login"
            applicationId "com.allure.login"
            mainActivity ".LoginActivity"

        }
        shop {
            isRunAlone false
            name ":modules:shop"
            applicationId "com.allure.shop"
            mainActivity ".ShopActivity"

        }
        main {
            isRunAlone false
            name ":modules:main"
            applicationId "com.allure.main"
            mainActivity ".MainActivity"

        }
    }
}
/**--插件配置宿主壳App与组件----**/
```
###  Step2:在每一个组件的build.gradle下定义插件的引用
```
apply plugin: 'com.allure.appmodules'
```

## 插件解释

##### hostAppConfig:

| hostAppConfig       |解释| 
| :--------: | :-----: | 
| isDebug    | 是否开启debug模式，只有当isDebug为true时，modules的isRunAlone才能生效。同时注意更改此属性后需要清除app的壳工程app的缓存在运行 |
| apps    | 壳工程列表,可以有多个壳工程 | 
| modules    | 各个组件Lib | 


##### app:

| app       |解释|
| :--------: | :-----: | 
|  modules  | 依赖的组件列表 | 
|   applicationId  | 启动的application,可默认为空,在测试微信支付分享时可以动态配置使用测试 | 
|   mainActivity  | 启动Activity |

##### Modules:

| app       |解释|
| :--------: | :-----: | 
|  name  | 依赖的组件列表 | 
|  isRunAlone    | 是否可以单独运行（必须在isDebug=true情况下可运行) | 
|   applicationId  | 启动的application,必须设置 | 
|   mainActivity  | 启动Activity |


[具体插件使用以及具体分析请查看Demo](https://www.jianshu.com/p/23b0239c45aa)

**Tips:注意isDebug更改后一定要清除app的缓存在重新sync and run**
