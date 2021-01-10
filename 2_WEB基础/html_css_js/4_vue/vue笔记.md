# vue

## 简介

Vue (读音 /vjuː/，类似于 **view**) 是一套用于构建用户界面的**渐进式框架**。与其它大型框架不同的是，Vue 被设计为可以自底向上逐层应用。Vue 的核心库只关注视图层，不仅易于上手，还便于与第三方库或既有项目整合。

## 安装

**NPM方法（推荐使用）**

   在用Vue.js构建大型应用的时候推荐使用NPM安装方法，NPM能很好的和诸如[Webpack](https://webpack.js.org/)或者[Browserify ](http://browserify.org/)模块打包器配合使用。Vue.js 也提供配套工具来开发单文件组件。

   首先，先列出我们接下来需要的东西：

- node.js环境（npm包管理器）
- vue-cli 脚手架构建工具
- cnpm npm的淘宝镜像    

**1） 安装node.js**

 从[node.js官网](https://nodejs.org/en/)下载并安装node，安装过程很简单，一直点下一步就ok了，安装完之后，我们通过打开命令行工具（win+R）,输入 `node -v` 命令，查看node的版本，若出现相应的版本号，则说明你安装成功了。

 npm包管理器，是集成在node中的，所以安装了node也就有了npm,直接输入 npm -v 命令，显示npm的版本信息。

**2） 安装cnpm**



​      在命令行中输入 `npm install -g cnpm --registry=http://registry.npm.taobao.org` 

​	 配置环境node环境变量

 **3） 安装vue-cli 脚手架构建工具（必须在全局中进行安装）**

​      在命令行中运行命令 `npm install -g vue-cli` ，然后等待安装完成。

​      是否安装成功：`vue -V`

​      webpack的版本查询：`webpack -v`

​      通过以上三部，我们需要准备的环境和工具都准备好了，接下来就开始使用vue-cli来构建项目。

​    首先我们要选择存放项目的位置，然后再用命令行cd到项目的目录中，在这里，我选择在c盘下创建新的目录,用cd 将目录切到该目录下,在命令行中运行命令 `vue init webpack firstApp`（初始化一个完整版的项目）  。解释一下这个命令，这个命令的意思是初始化一个项目，其中webpack是构建工具，也就是整个项目是基webpack的。其中firstApp是整个项目文件夹的名称，这个文件夹会自动生成在你指定的目录中若我们在编辑器中已经手动创建了这个项目存放的文件夹cd到项目中： vue init webpack;初始化一下即可,同时还会加载webpack所依赖的包:输入命令后，会询问我们几个简单的选项，我们根据自己的需要进行填写就可以了。

- Project name :项目名称 ，如果不需要更改直接回车就可以了。注意：这里不能使用大写，所以我把名称改成了vueclitest
- Project description:项目描述，默认为A Vue.js project,直接回车，不用编写。
- Author：作者，如果你有配置git的作者，他会读取。
- Install  vue-router? 是否安装vue的路由插件，我们这里需要安装，所以选择Y
- Use ESLint to lint your code? 是否用ESLint来限制你的代码错误和风格。我们这里不需要输入n（建议），如果你是大型团队开发，最好是进行配置。
- setup unit tests with  Karma + Mocha? 是否需要安装单元测试工具Karma+Mocha，我们这里不需要，所以输入n。
- Setup e2e tests with Nightwatch?是否安装e2e来进行用户行为模拟测试，我们这里不需要，所以输入n

  运行初始化命令的时候会让用户输入几个基本的配置选项，如项目名称、项目描述、作者信息，对于有些不明白或者不想填的信息可以一直按回车去填写就好了，等待一会，就会显示创建项目创建成功.

**4)	目录及其作用：**

   build：最终发布的代码的存放位置。

   config：配置路径、端口号等一些信息，我们刚开始学习的时候选择默认配置。

   node_modules：npm 加载的项目所需要的各种依赖模块。

   src：这里是我们开发的主要目录（源码），基本上要做的事情都在这个目录里面，里面包含了几个目录及文件：

​       assets:放置一些图片，如logo等

​       components:目录里放的是一个个的组件文件

​       router/index.js：配置路由的地方

​       App.vue：项目入口组件（跟组件），我们也可以将组件写这里，而不使用components目录。主要作用就是将我们自己定义的组件通过它与页面建立联系进行渲染，这里面的<router-view/>必不可少。

​       main.js ：项目的核心文件（整个项目的入口js）引入依赖包、默认页面样式等（项目运行后会在index.html中形成一个app.js文件）。

   static：静态资源目录，如图片、字体等。

   test：初始测试目录，可删除

   .XXXX文件：配置文件。

   index.html：html单页面的入口页面，可以添加一些meta信息或者同统计代码啥的或页面的重置样式等。

   package.json：项目配置信息文件/所依赖的开发包的版本信息及所依赖的插件信息。

   README.md：项目的说明文件。

   webpack.config.js：webpack的配置文件，把.vue的文件打包成浏览器能读懂的文件。

   .babelrc:是检测es6语法的文件的配置

   .getignore:忽略文件的配置（比如模拟本地数据mock不让他在get提交/打包上线的时候忽略不使用可在这里配置）

   .postcssrc.js:前缀的配置 

   .eslintrc.js:配置eslint语法规则（在这里面的rules属性中配置让哪个语法规则失效）

   .eslintignore:忽略eslint对项目某些文件的语法规则的检查

  这就是整个项目的目录结构，其中，我们主要在src目录中做修改（模块化开发）。这个项目现在还只是一个结构框架，整个项目需要的依赖资源都还没有安装。 cd 项目名；进入项目中安装项目所需要的依赖包/插件（在package.json可查看）：执行 `cnpm install`  (npm可能会有警告，这里可以用cnpm代替npm了，运行别人的代码需要先安装依赖)如果创建项目的时候没有报错，这一步可以省略。如果报错了 cd到项目里面运行 `cnpm install  / npm install`若拿到别人的项目或从gethub上下载的项目第一步就是要在项目中cnpm install;下载项目所依赖的插件，然后`npm run dev` 运行项目

安装完成之后，我们到自己的项目中去看，会多一个node_modules文件夹，这里面就是我们所需要的依赖包资源。 安装完依赖包资源后，我们就可以运行整个项目了。

## 一 基础语法

### 1 vue写法（声明式）

1. 创建一个div元素，设置id属性
2. 定义一个vue对象，将div挂载在vue对象上
3. 在vue对象内定义变量message，并绑定数据
4. 将message变量放在div元素上显示
5. 修改vue对象中的变量message，div元素数据自动改变

```
<div id="app">
      <h2>{{message}}</h2>
      <p>{{name}}</p>
  </div>
  <script>
    //let变量/const常量
    //编程范式：声明式编程
    const app = new Vue({
      el:"#app",//用于挂载要管理的元素
      data:{//定义数据
        message:"HelloVuejs",
        name:"zzz"
      }
    })
  </script>
```

### 2 Mustache语法

 mustache是胡须的意思，因为`{{}}`像胡须，又叫大括号语法。 在vue对象挂载的dom元素中，`{{}}`不仅可以直接写变量，还可以写简单表达式。

#### 2.1 v-once

```
  <div id="app">
    <h2>{{message}}</h2>
    <!-- 只会渲染一次，数据改变不会再次渲染 -->
    <h2 v-once>{{message}}</h2>

  </div>
```

#### 2.2 v-html

 在某些时候我们不希望直接输出`<a href='http://www.baidu.com'>百度一下</a>`这样的字符串，而输出被html自己转化的超链接。此时可以使用v-html。

```
  <div id="app">
    <h2>不使用v-html</h2>
    <h2>{{url}}</h2>
    <h2>使用v-html，直接插入html</h2>
    <h2 v-html="url"></h2>

  </div>
  <script src="https://cdn.jsdelivr.net/npm/vue@2.6.10/dist/vue.js"></script>
  <script>
    const app = new Vue({
      el:"#app",
      data:{
        message:"你好啊",
        url:"<a href='http://www.baidu.com'>百度一下</a>"
      }
    })
  </script>
```

#### 2.3 v-text

```
 <div id="app">
    <h2>不使用v-text</h2>
    <h2>{{message}}，啧啧啧</h2>
    <h2>使用v-text，以文本形式显示,会覆盖</h2>
    <h2 v-text="message">，啧啧啧</h2>

  </div>
  <script src="https://cdn.jsdelivr.net/npm/vue@2.6.10/dist/vue.js"></script>
  <script>
    const app = new Vue({
      el:"#app",
      data:{
        message:"你好啊"
      }
    })
  </script>
```

#### 2.4 v-pre

有时候我们期望直接输出`{{message}}`这样的字符串，而不是被`{{}}`语法转化的message的变量值，此时我们可以使用`v-pre`标签。

```
 <div id="app">
    <h2>不使用v-pre</h2>
    <h2>{{message}}</h2>
    <h2>使用v-pre,不会解析</h2>
    <h2 v-pre>{{message}}</h2>

  </div>
  <script src="https://cdn.jsdelivr.net/npm/vue@2.6.10/dist/vue.js"></script>
  <script>
    const app = new Vue({
      el:"#app",
      data:{
        message:"你好啊"
      }
    })
  </script>
```

#### 2.5 v-cloak

 有时候因为加载延时问题，例如卡掉了，数据没有及时刷新，就造成了页面显示从`{{message}}`到message变量“你好啊”的变化，这样闪动的变化，会造成用户体验不好。此时需要使用到`v-cloak`的这个标签。在vue解析之前，div属性中有`v-cloak`这个标签，在vue解析完成之后，v-cloak标签被移除。简单，类似div开始有一个css属性`display:none;`，加载完成之后，css属性变成`display:block`，元素显示出来。

```
<div id="app" v-cloak>
    <h2>{{message}}</h2>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/vue@2.6.10/dist/vue.js"></script>
  <script>
    //在vue解析前，div中有一个属性cloak
    //在vue解析之后，div中没有一个属性v-cloak
    setTimeout(() => {
      const app = new Vue({
        el: "#app",
        data: {
          message: "你好啊"
        }
      })
    }, 1000);
  </script>
```

### 3 **动态绑定属性**

#### 3.1 v-bind

 某些时候我们并不想将变量放在标签内容中，像这样`<h2>{{message}}</h2>`是将变量h2标签括起来，类似js的innerHTML。但是我们期望将变量`imgURL`写在如下位置，想这样`<img src="imgURL" alt="">`导入图片是希望动态获取图片的链接，此时的imgURL并非变量而是字符串imgURL，如果要将其生效为变量，需要使用到一个标签`v-bind:`，像这样`<img v-bind:src="imgURL" alt="">`，而且这里也不能使用Mustache语法，类似`<img v-bind:src="{{imgURL}}" alt="">`，这也是错误的。

```
 <div id="app">
    <!-- 错误的做法这里不能使用Mustache语法 -->
    <!-- <img v-bind:src="{{imgURL}}" alt=""> -->
    <!-- 正确的做法使用v-bind指令 -->
    <img v-bind:src="imgURL" alt="">
    <a v-bind:href="aHerf"></a>
    <!-- 语法糖写法 -->
    <img :src="imgURL" alt="">
    <a :href="aHerf"></a>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/vue@2.6.10/dist/vue.js"></script>
  <script>
    const app = new Vue({
      el:"#app",
      data:{
        message:"你好啊",
        imgURL:"https://cn.bing.com/th?id=OIP.NaSKiHPRcquisK2EehUI3gHaE8&pid=Api&rs=1",
        aHerf:"http://www.baidu.com"
      }
    })
  </script>
```



##### 3.1.1 v-bind:class

 有时候我们期望对Dom元素的节点的class进行动态绑定，选择此Dom是否有指定class属性。例如，给h2标签加上`class="active"`，当Dom元素有此class时候，变红`<style>.active{color:red;}</style>`，在写一个按钮绑定事件，点击变黑色，再次点击变红色。

```
 <style>
    .active{
      color:red;
    }
  </style>
</head>
<body>
  <div id="app">
    <!-- <h2 class="active">{{message}}</h2>
    <h2 :class="active">{{message}}</h2> -->

    <!-- 动态绑定class对象用法  -->
    <!-- <h2 :class="{key1:value1,key2:value2}">{{message}}</h2>
    <h2 :class="{类名1:true,类名2:boolean}">{{message}}</h2> -->
    <h2 class="title" :class="{active:isActive}">{{message}}</h2>
    <h2 class="title" :class="getClasses()">{{message}}</h2>
    <button @click="change">点击变色</button>

  </div>
  <script src="https://cdn.jsdelivr.net/npm/vue@2.6.10/dist/vue.js"></script>
  <script>
    const app = new Vue({
      el:"#app",
      data:{
        message:"你好啊",
        active:"active",
        isActive:true
      },
      methods: {
        change(){
          this.isActive = !this.isActive
        },
        getClasses(){
          return {active:this.isActive}
        }
      },
    })
  </script>
</body>
```

##### 3.1.2 v-bind:class(数组用法)

```
<div id="app">
    <!-- 加上单引号当成字符串 -->
    <h2 class="title" :class="['active','line']">{{message}}</h2>
    <!-- 不加会被当成变量 -->
    <h2 class="title" :class="[active,line]">{{message}}</h2>
    <h2 class="title" :class="getClasses()">{{message}}</h2>

  </div>
  <script src="https://cdn.jsdelivr.net/npm/vue@2.6.10/dist/vue.js"></script>
  <script>
    const app = new Vue({
      el:"#app",
      data:{
        message:"你好啊",
        active:"aaaa",
        line:'bbbb'
      },
      methods: {

        getClasses(){
          return [this.active,this.line]
        }
      },
    })
  </script>
```

##### 3.1.3 v-bind:style

```
<!-- <h2 :style="{key(属性名):value(属性值)}">{{message}}</h2> -->
<!-- 加单引号，当成字符串解析 -->
<h2 :style="{fontSize:'50px'}">{{message}}</h2>
<!-- 不加单引号，变量解析 -->
<h2 :style="{fontSize:fontSize}">{{message}}</h2>
<h2 :style="getStyle()">{{message}}</h2>
```

##### 3.1.4 v-bind:style(数组语法)

```
  <div id="app">
    <h2 :style="[baseStyle]">{{message}}</h2>
    <h2 :style="getStyle()">{{message}}</h2>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/vue@2.6.10/dist/vue.js"></script>
  <script>
    const app = new Vue({
      el:"#app",
      data:{
        message:"你好啊",
        baseStyle:{backgroundColor:'red'}
      },
      methods: {
        getStyle(){
          return [this.baseStyle]
        }
      },
    })
  </script>
```

### 4 计算属性的基本使用

```
<div id="app">
    <!-- Mastache语法 -->
    <h2>{{firstName+ " " + lastName}}</h2>
    <!-- 方法 -->
    <h2>{{getFullName()}}</h2>
    <!-- 计算属性 -->
    <h2>{{fullName}}</h2>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/vue@2.6.10/dist/vue.js"></script>
  <script>
    const app = new Vue({
      el:"#app",
      data:{
        firstName:"skt t1",
        lastName:"faker"
      },
      computed: {
        fullName:function(){
          return this.firstName + " " + this.lastName
        }
      },
      methods: {
        getFullName(){
          return this.firstName + " " + this.lastName
        }
      },
    })
  </script>
```

#### 4.1 setter和getter

在计算属性中其实是由这样两个方法setter和getter,在计算属性中其实是由这样两个方法setter和getter。

```
      computed: {
        fullName:{
          //计算属性一般没有set方法，只读属性
          set:function(newValue){
            console.log("-----")
            const names = newValue.split(" ")
            this.firstName = names[0]
            this.lastName = names[1]
          },
          get:function(){
            return this.firstName + " " + this.lastName
          }
        }
      }
```

#### 4.2 计算属性和methods的对比

```
 <div id="app">
    <!-- methods，即使firstName和lastName没有改变，也需要再次执行 -->
    <h2>{{getFullName()}}</h2>
    <h2>{{getFullName()}}</h2>
    <h2>{{getFullName()}}</h2>
    <h2>{{getFullName()}}</h2>
    <!-- 计算属性有缓存，只有关联属性改变才会再次计算 -->
    <h2>{{fullName}}</h2>
    <h2>{{fullName}}</h2>
    <h2>{{fullName}}</h2>
    <h2>{{fullName}}</h2>


  </div>
  <script src="https://cdn.jsdelivr.net/npm/vue@2.6.10/dist/vue.js"></script>
  <script>
    const app = new Vue({
      el:"#app",
      data:{
        firstName:"skt t1",
        lastName:"faker"
      },
      computed: {
        fullName(){
          console.log("调用了计算属性fullName");

          return this.firstName + " " + this.lastName
        }
      },
      methods: {
        getFullName(){
          console.log("调用了getFullName");

          return this.firstName + " " + this.lastName
        }
      },
    })
  </script>
```

分别使用方法和计算属性获取四次fullName，在`this.firstName + " " + this.lastName`的属性不变的情况下，methods调用了四次，而计算属性才调用了一次，性能上计算属性明显比methods好。而且在改动firstName的情况下，计算属性只调用一次，methods依然要调用4次。

> 测试结论：

1. 使用computed计算了fullName属性，值为firstName+lastName。计算属性具有`缓存功能`，当firstName和lastName都不改变的时候，fullName不会重新计算，比如我们改变age的值，fullName的值是不需要重新计算的。
2. methods并没有缓存特性，比如我们改变age的值，fullName2()方法会被执行一遍。
3. 当一个功能可以用上面三个方法来实现的时候，明显使用computed更合适，代码简单也有缓存特性。
4. 计算属性范围在vue实例内，修改vue实例外部对象，不会重新计算渲染，但是如果先修改了vue实例外对象，在修改vue计算属性的对象，那么外部对象的值也会重新渲染。

### 5 事件监听

#### 5.1 v-on

 使用`v-on:click`给button绑定监听事件以及回调函数，@是`v-on:`的语法糖，也就是简写也可以使用`@click`。方法一般是需要写方法名加上()，在`@click`中可以省掉，如上述的`<button @click="increment">加</button>`

```
 <div id="app">
      <h2>{{count}}</h2>
      <!-- <button v-on:click="count++">加</button>
      <button v-on:click="count--">减</button> -->
      <button @click="increment">加</button>
      <button @click="decrement()">减</button>
  </div>
  <script>
    const app = new Vue({
      el:"#app",
      data:{
        count:0
      },
      methods: {
        increment(){
          this.count++
        },
        decrement(){
          this.count--
        }
      }
    })
  </script>
```

#### 5.2 v-on的参数传递

1. 事件没传参，可以省略()
2. 事件调用方法传参了，写函数时候省略了小括号，但是函数本身是需要传递一个参数的，这个参数就是原生事件event参数传递进去
3. 如果同时需要传入某个参数，同时需要event是，可以通过`$event`传入事件。

按钮4调用`btnClick2(value){}`，此时`undefined`。按钮5调用时省略了()，会自动传入原生event事件，如果我们需要event对象还需要传入其他参数，可以使用`$event`对象。

```
 <div id="app">
    <!-- 事件没传参 -->
    <button @click="btnClick">按钮1</button>
    <button @click="btnClick()">按钮2</button>
    <!-- 事件调用方法传参，写函数时候省略小括号，但是函数本身需要传递一个参数 -->
    <button @click="btnClick2(123)">按钮3</button>
    <button @click="btnClick2()">按钮4</button>
    <button @click="btnClick2">按钮5</button>
    <!-- 事件调用时候需要传入event还需要传入其他参数 -->
    <button @click="btnClick3($event,123)">按钮6</button>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/vue@2.6.10/dist/vue.js"></script>
  <script>
    const app = new Vue({
      el:"#app",
      methods:{
        btnClick(){
          console.log("点击XXX");
        },
        btnClick2(value){
          console.log(value+"----------");
        },
        btnClick3(event,value){
          console.log(event+"----------"+value);
        }
      }
    })
  </script>
```

#### 5.3 v-on的修饰词

1. `.stop`的使用，btn的click事件不会传播，不会冒泡到上层，调用`event.stopPropagation()`。
2. `.prevent` 调用`event.preeventDefault`阻止默认行为。
3. `.enter`监听键盘事件

```
 <div id="app">
    <!--1. .stop的使用，btn的click事件不会传播，不会冒泡到上层，调用event.stopPropagation() -->
    <div @click="divClick">
        <button @click.stop="btnClick">按钮1</button>
    </div>
    <!-- 2. .prevent 调用event.preeventDefault阻止默认行为  -->
    <form action="www.baidu.com">
      <button type="submit" @click.prevent="submitClick">提交</button>
    </form>
    <!--3. 监听键盘的事件 -->
    <input type="text" @click.enter="keyup">

  </div>
  <script src="https://cdn.jsdelivr.net/npm/vue@2.6.10/dist/vue.js"></script>
  <script>
    const app = new Vue({
      el:"#app",
      methods:{
        btnClick(){
          console.log("点击button");
        },
        divClick(){
          console.log("点击div");
        },
        submitClcik(){
          console.log("提交被阻止了")
        },
        keyup(){
          console.log("keyup点击")
        }
      }
    })
  </script>
```

### 6 **条件判断**

#### 6.1 v-if、v-else、v-elseif

1. 单独使用v-if，变量为布尔值，为true才渲染Dom
2. v-show的变量也是布尔值，为true才显示内容，类似css的display
3. v-if、v-else、v-else-if联合使用相当于if、elseif、else，但是在条件比较多的时候建议使用计算属性。

```
<div id="app">
    <h2 v-if="isFlag">isFlag为true显示这个</h2>
    <h2 v-show="isShow">isShow为true是显示这个</h2>
    <div v-if="age<18">小于18岁未成年</div>
    <div v-else-if="age<60">大于18岁小于60岁正值壮年</div>
    <div v-else="">大于60岁,暮年</div>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/vue@2.6.10/dist/vue.js"></script>
  <script>
    const app = new Vue({
      el:"#app",
      data:{
        isFlag:true,
        isShow:false,
        age:66
      }
    })
  </script>
```

#### 6.2 v-if的demo

使用`v-if`和`v-else`选择渲染指定的Dom，点击按钮对`isUser`变量取反。

这里需要了解一下vue底层操作，此时input输入框值被复用了。

1. vue在进行DOM渲染是，处于性能考虑，会复用已经存在的元素，而不是每次都创建新的DOM元素。

2. 在上面demo中，Vue内部发现原来的input元素不再使用，所以直接将其映射对应虚拟DOM，用来复用。

3. 如果不希望出现类似复用问题，可以给对应的dom元素加上`key`值，并保证`key`不同。

   ```
   <input type="text" id="username" placeholder="请输入用户名" key="username">
   <input type="text" id="email" placeholder="请输入用户邮箱" key="email">
   ```

```
 <div id="app">
    <span v-if="isUser">
      <label for="username">用户账号</label>
      <input type="text" id="username" placeholder="请输入用户名" >
    </span>
    <span v-else="isUser">
        <label for="email">用户邮箱</label>
        <input type="text" id="email" placeholder="请输入用户邮箱" >
    </span>
    <button @click="isUser=!isUser">切换类型</button>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/vue@2.6.10/dist/vue.js"></script>
  <script>
    const app = new Vue({
      el:"#app",
      data:{
        isUser:true
      }
    })
  </script>
```

#### 6.3 v-show

 v-if 在首次渲染的时候，如果条件为假，什么也不操作，页面当作没有这些元素。当条件为真的时候，开始局部编译，动态的向DOM元素里面添加元素。当条件从真变为假的时候，开始局部编译，卸载这些元素，也就是删除。

 v-show 不管条件是真还是假，第一次渲染的时候都会编译出来，也就是标签都会添加到DOM中。之后切换的时候，通过display: none;样式来显示隐藏元素。可以说只是改变css的样式，几乎不会影响什么性能。

```
 <div id="app">
    <h2 v-show="isFlag">v-show只是操作元素的style属性display</h2>
    <h2 v-if="isFlag">v-if是新增和删除dom元素</h2>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/vue@2.6.10/dist/vue.js"></script>
  <script>
    const app = new Vue({
      el:"#app",
      data:{
        isFlag:true
      }
    })
  </script>
```

### 7 **循环遍历**

####  7.1 v-for遍历数组

```
 <div id="app">
    <!-- 1.遍历过程没有使用索引（下标值） -->
    <ul>
      <li v-for="item in names" >{{item}}</li>
    </ul>
    <!-- 2.遍历过程有使用索引（下标值） -->
    <ul>
        <li v-for="(item,index) in names"  >{{index+":"+item}}</li>
    </ul>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/vue@2.6.10/dist/vue.js"></script>
  <script>
    const app = new Vue({
      el:"#app",
      data:{
        names:["zzz","ttt","yyy"]
      }
    })
  </script>
```

#### 7.2 v-for遍历对象

```
 <div id="app">
    <!-- 1.遍历过程没有使用index索引-->
    <!-- 格式为：(value, name) -->
    <ul>
      <li v-for="(item,key) in user" >{{key+"-"+item}}</li>
    </ul>
    <!-- 格式为：(value, name, index) -->
    <ul>
      <li v-for="(item,key,index) in user" >{{key+"-"+item+"-"+index}}</li>
    </ul>

  </div>
  <script src="https://cdn.jsdelivr.net/npm/vue@2.6.10/dist/vue.js"></script>
  <script>
    const app = new Vue({
      el:"#app",
      data:{
        user:{
          name:"zzz",
          height:188,
          age:24
        }
      }
    })
  </script>
```

#### 7.3 v-for使用key

```
  <div id="app">
    <!-- 不加key如果要插入f依次改变 -->
    <ul>
      <li v-for="item in letters">{{item}}</li>
    </ul>
    <button @click="add1">没有key</button>
    <!-- 加key如果要插入f使用diff算法高效,如果使用index做key一直变，所以item如果唯一可以使用item-->
    <ul>
        <li v-for="item in letters" :key="item">{{item}}</li>
    </ul>
    <button @click="add2">有key</button>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/vue@2.6.10/dist/vue.js"></script>
  <script>
    const app = new Vue({
      el:"#app",
      data:{
        letters:['a','b','c','d','e']
      },
      methods: {
        add1(){
          this.letters.splice(2,0,'f')
        },
        add2(){
          this.letters.splice(2,0,'f')
        }
      }
    })
  </script>
```



### 8 v-model的基本使用

v-model双向绑定，既输入框的value改变，对应的message对象值也会改变，修改message的值，input的value也会随之改变。无论改变那个值，另外一个值都会变化。

```
<div id="app">
  <input type="text" v-model="message">{{message}}
</div>
<script src="../js/vue.js"></script>
<script>
  const app = new Vue({
    el: '#app',
    data: {
      message: "hello"
    }
  })
</script>
```

#### 8.1 v-model的原理

 `v-model = v-bind + v-on`，实现双向绑定需要是用v-bind和v-on，使用v-bind给input的value绑定message对象，此时message对象改变，input的值也会改变。但是改变input的value并不会改变message的值，此时需要一个v-on绑定一个方法，监听事件，当input的值改变的时候，将最新的值赋值给message对象。`$event`获取事件对象，target获取监听的对象dom，value获取最新的值。

```
<div id="app">
  <!-- $event获取事件对象，$event.target.value获取input值 -->
<!--  <input type="text" :value="message" @input="changeValue($event.target.value)">{{message}}-->
  <!--事件调用方法传参了，写函数时候省略了小括号，但是函数本身是需要传递一个参数的，这个参数就是原生事件event参数传递进去-->
  <input type="text" :value="message" @input="changeValue">{{message}}
</div>
<script src="../js/vue.js"></script>
<script>
  const app = new Vue({
    el: '#app',
    data: {
      message: "hello world"
    },
    methods: {
      changeValue(event){
        console.log("值改变了");
        this.message = event.target.value
      }
    }
  })
</script>
```



#### 8.2 v-model结合radio类型使用

```
v-model绑定`sex`属性，初始值为“男”，选择女后`sex`属性变成“女”，因为此时是双向绑定。
```

```
  <div id="app">
    <!-- name属性radio互斥 使用v-model可以不用name就可以互斥 -->
    <label for="male">
      <input type="radio" id="male" name="sex" value="男" v-model="sex">男
    </label>
    <label for="female">
        <input type="radio" id="female" name="sex" value="女" v-model="sex">女
    </label>
    <div>你选择的性别是：{{sex}}</div>

  </div>
  <script src="../js/vue.js"></script>
  <script>
    const app = new Vue({
      el:"#app",
      data:{
        message:"zzz",
        sex:"男"
      },

    })
  </script>
```

#### 8.3 v-model结合checkbox类型使用

```
<div id="app">
  <!--单选框-->
  <h2>单选框</h2>
  <label for="agree">
    <input type="checkbox" id="agree" v-model="isAgree">同意协议
  </label>
  <!--多选框-->
  <h2>多选框</h2>
  <label :for="item" v-for="(item,index) in hobbies" :key="index">
    <input type="checkbox" name="hobby" :value="item" :id="item" v-model="hobbies">{{item}}
  </label>
  <h2>你的爱好是：{{hobbies}}</h2>
</div>
<script src="../js/vue.js"></script>
<script>
  const app = new Vue({
    el: '#app',
    data: {
      isAgree: false,
      hobbies: ["篮球","足球","乒乓球","羽毛球"]
    }
  })
</script>
```

1. checkbox结合v-model实现单选框，定义变量`isAgree`初始化为`false`，点击checkbox的值为`true`，`isAgree`也是`true`。
2. checkbox结合v-model实现多选框，定义数组对象`hobbies`，用于存放爱好，将`hobbies`与checkbox对象双向绑定，此时选中，一个多选框，就多一个true，`hobbies`就添加一个对象

#### 8.4 v-model结合select

```
<div id="app">
    <!-- select单选 -->
    <select name="fruit" v-model="fruit">
      <option value="苹果">苹果</option>
      <option value="香蕉">香蕉</option>
      <option value="西瓜">西瓜</option>
    </select>
    <h2>你选择的水果是：{{fruit}}</h2>

    <!-- select多选 -->
    <select name="fruits" v-model="fruits" multiple>
      <option value="苹果">苹果</option>
      <option value="香蕉">香蕉</option>
      <option value="西瓜">西瓜</option>
    </select>
    <h2>你选择的水果是：{{fruits}}</h2>
  </div>
  <script src="../js/vue.js"></script>
  <script>
    const app = new Vue({
      el:"#app",
      data:{
        fruit:"苹果",
        fruits:[]
      },

    })
  </script>
```

#### 8.5 v-model的修饰符的使用

```
 <div id="app">
    <h2>v-model修饰符</h2>
    <h3>lazy,默认情况是实时更新数据，加上lazy，从输入框失去焦点，按下enter都会更新数据</h3>
    <input type="text" v-model.lazy="message">
    <div>{{message}}</div>
    <h3>修饰符number,默认是string类型，使用number赋值为number类型</h3>
    <input type="number" v-model.number="age">
    <div>{{age}}--{{typeof age}}</div>
    <h3>修饰符trim:去空格</h3>
    <input type="text" v-model.trim="name">

  </div>
  <script src="../js/vue.js"></script>
  <script>
    const app = new Vue({
      el:"#app",
      data:{
        message:"zzz",
        age:18,
        name:"ttt"
      },

    })
  </script>
```

## 二 **组件化开发**

### 1 组件化基本使用

 简单的组件示例 ，组件是可复用的 Vue 实例，且带有一个名字：在这个例子中是 `my-cpn`。我们可以在一个通过 `new Vue` 创建的 Vue 根实例中，把这个组件作为自定义元素来使用： `<my-cpn></my-cpn>`。

```
<div id="app">
  <!-- 3.使用组件 -->
  <my-cpn></my-cpn>
  <my-cpn></my-cpn>
  <my-cpn></my-cpn>
  <cpnc></cpnc>
</div>
<script src="../js/vue.js"></script>
<script>
  // 1.创建组件构造器对象
  const cpnc = Vue.extend({
    template:`
        <div>
          <h2>标题</h2>
          <p>内容1...<p>
          <p>内容2...<p>
        </div>`
  })
  // 2.全局注册组件
  Vue.component('my-cpn', cpnc)
  const app = new Vue({
    el:"#app",
    data:{
    },
    components:{
      //局部组件创建
      cpnc:cpnc
    }
  })
</script>
```

#### 1.1 创建组件构造器对象

`template`中是组件的DOM元素内容。

#### 1.2 注册组件

1. 全局注册，通过 `Vue.component `。
2. 局部注册，通过 `components:{cpnc:cpnc}`。

#### 1.3 使用组件

 像使用html标签一样使用。

```
  <div id="app">
    <!-- 3.使用组件 -->
    <my-cpn></my-cpn>
    <my-cpn></my-cpn>
    <my-cpn></my-cpn>
    <cpnc></cpnc>
  </div>
```

### 2 全局组件和局部组件

```
  <div id="app">
    <h2>全局组件</h2>
    <my-cpn></my-cpn>
    <h2>局部组件</h2>
    <cpnc></cpnc>
  </div>
  <script src="../js/vue.js"></script>
  <script>
    // 1.创建组件构造器对象
    const cpnc = Vue.extend({
      template:`
        <div>
          <h2>标题</h2>
          <p>内容1</p>
          <p>内容2</p>
        </div>`
    })
    // 2.注册组件（全局组件，可以在多个vue实例中使用）
    Vue.component('my-cpn', cpnc)

    const app = new Vue({
      el:"#app",
      components:{//局部组件创建
        cpnc:cpnc
      }
    })
  </script>
```

#### 2.1 全局组件

 全局组件，可以在多个vue实例中使用，类似于全局变量。

 使用`Vue.component('my-cpn', cpnc)`方式注册，直接使用`<my-cpn></my-cpn>`调用。`my-cpn`是全局组件的名字，`cpnc`是定义的组件对象。

#### 2.2 局部组件

 局部组件，只能在当前vue实例挂载的对象中使用，类似于局部变量，有块级作用域。

>  注册方式

```
    const app = new Vue({
      el:"#app",
      components:{//局部组件创建
        cpnc:cpnc
      }
    })
```

 使用方式与全局变量一样，直接使用`<cpnc></cpnc>`调用。`cpnc:cpnc`第一个cpnc是给组件命名的名字，第二个是定义的组件对象。如果俩个同名也可以直接使用es6语法：

```
components:{//局部组件创建
        cpnc
}
```

### 3. 父组件和子组件的区别

```
  <div id="app">
    <cpn2></cpn2>
  </div>
  <script src="../js/vue.js"></script>
  <script>
    // 1.创建组件构造器对象
    const cpn1 = Vue.extend({
      template:`
        <div>
          <h2>标题1</h2>
          <p>组件1</p>
        </div>`
    })
    // 组件2中使用组件1
    const cpn2 = Vue.extend({
      template:`
        <div>
          <h2>标题2</h2>
          <p>组件2</p>
          <cpn1></cpn1>
        </div>`,
      components:{
        cpn1:cpn1
      }
    })

    const app = new Vue({
      el:"#app",
      components:{//局部组件创建
        cpn2:cpn2
      }
    })
  </script>
```

 上述代码中定义了两个组件对象`cpn1`和`cpn2`，在组件`cpn2`中使用局部组件注册了`cpn1`，并在`template`中使用了注册的`cpn1`，然后在vue实例中使用注册了局部组件`cpn2`，在vue实例挂载的div中调用了`cpn2`，`cpn2`与`cpn1`形成父子组件关系。

### 4. 注册组件的语法糖

```
  <div id="app">
    <cpn1></cpn1>
    <cpn2></cpn2>
  </div>
  <script src="../js/vue.js"></script>
  <script>
    // 1.注册全局组件语法糖
    Vue.component('cpn1', {
      template:`
        <div>
          <h2>全局组件语法糖</h2>
          <p>全局组件语法糖</p>
        </div>`
    })

    const app = new Vue({
      el:"#app",
      components:{//局部组件创建
        cpn2:{
          template:`
        <div>
          <h2>局部组件语法糖</h2>
          <p>局部组件语法糖</p>
        </div>`
        }
      }
    })
  </script>
```

注册组件时候可以不实例化组件对象，直接在注册的时候实例化。`{}`就是一个组件对象。

### 5. 组件模板的分离写法

#### 5.1 script标签

 使用`script`标签定义组件的模板，`script`标签注意类型是`text/x-template`。

```
  <!-- 1.script标签注意类型是text/x-template -->
  <script type="text/x-template" id="cpn1">
    <div>
        <h2>组件模板的分离写法</h2>
        <p>script标签注意类型是text/x-template</p>
      </div>
  </script>
```

#### 5.2 template标签

 使用`template`标签，将内容写在标签内。

```
  <!-- 2.template标签 -->
  <template id="cpn2">
    <div>
      <h2>组件模板的分离写法</h2>
      <p>template标签</p>
    </div>
  </template>
```

> 调用分离的模板，使用`template:'#cpn1'`

```
  <script src="../js/vue.js"></script>
  <script>

    const app = new Vue({
      el: "#app",
      components: { //局部组件创建
        cpn1:{
          template:'#cpn1'
        },
        cpn2: {
          template: '#cpn2'
        }
      }
    })
  </script>
```

### 6. 组件的数据

#### 6.1 存放问题

 前面说过vue组件就是一个vue实例，相应的vue组件也有`data`属性来存放数据。

```
  <div id="app">
    <cpn1></cpn1>
  </div>

  <script src="../js/vue.js"></script>
  <script>

    const app = new Vue({
      el: "#app",
      components: { //局部组件创建
        cpn1:{
          template:'<div>{{msg}}</div>',
          data(){
            return {
              msg:"组件的数据存放必须要是一个函数"
            }
          }
        }
      }
    })
  </script>
```



### 7. 父组件给子组件传递数据

#### 7.1 使用`props`属性，父组件向子组件传递数据

> 使用组件的`props`属性

```
const cpn = {
  template: "#cpn",
  props: { 
          cmessage: {
          type: String,
          default: 'zzzzz',
          required: true //在使用组件必传值
          }
  }
}
```

> 向cmessage对象传值

```
<div id="app">
    <cpn :cMessage="message"></cpn>
</div>
<script>    
const app = new Vue({
      el: "#app",
      data: {
        message: "你好",
        movies: ["复仇者联盟", "钢铁侠", "星际穿越", "哪吒传奇"]
      },
      components: {
        cpn
      }
    })
  </script>
```

#### 7.2 props属性使用

> 数组写法

```
props: ['cmovies', 'cmessage']
```

> 对象写法

```
  props: { 
          cmessage: {
          type: String,
          default: 'zzzzz',
          required: true //在使用组件必传值
          }
  }
```

> props属性的类型限制

```
//1.类型限制(多个类使用数组)
cmovies:Array,//限制为数组类型
cmessage:String,//限制为Strin类型
cmessage:['String','Number']//限制为String或Number类型
```

> props属性的默认值

```
// 2.提供一些默认值，以及必传值
        cmessage: {
          type: String,
          default: 'zzzzz',//默认值
        }
```

> props属性的必传值

```
cmessage: {
          type: String,
          default: 'zzzzz',
          required: true //在使用组件必传值
        }
```

> 类型是Object/Array，默认值必须是一个函数

```
//类型是Object/Array，默认值必须是一个函数
cmovies: {
	type: Array,
	default () {
		return [1, 2, 3, 4]
	}
},
```

> 自定义验证函数

```
vaildator: function (value) {
	//这个传递的值必须匹配下列字符串中的一个
	return ['zzzzz', 'ttttt', 'yyy'].indexOf(value) !== -1
}
```

> 自定义类型

```
    function Person(firstName,lastName) {
      this.firstName = firstName
      this.lastName = lastName
    }
	cmessage:Person//限定了cmeessage必须是Person类型
```

> 综合使用

```
  <div id="app">
    <cpn :cMovies="movies" :cMessage="message"></cpn>
  </div>
  <template id="cpn">
    <div>
      <ul>
        <li v-for="(item, index) in cmovies" :key="index">{{item}}</li>
      </ul>
      <h2>{{cmessage}}</h2>
    </div>
  </template>
  <script src="../js/vue.js"></script>

  <script>
    function Person(firstName,lastName) {
      this.firstName = firstName
      this.lastName = lastName
    }
    // 父传子：props
    const cpn = {
      template: "#cpn",
      // props: ['cmovies', 'cmessage'],//数组写法
      props: { //对象写法
        // 1.类型限制(多个类使用数组)
        // cmovies:Array,
        // cmessage:String,
        // cmessage:['String','Number'],
        // 2.提供一些默认值，以及必传值
        cmessage: {
          type: String,
          default: 'zzzzz',
          required: true //在使用组件必传值
        },
        //类型是Object/Array，默认值必须是一个函数
        cmovies: {
          type: Array,
          default () {
            return [1, 2, 3, 4]
          }
        },
        // 3.自定义验证函数
        // vaildator: function (value) {
        //   //这个传递的值必须匹配下列字符串中的一个
        //   return ['zzzzz', 'ttttt', 'yyy'].indexOf(value) !== -1
        // }
        // 4.自定义类型
        // cmessage:Person,
      },
      data() {
        return {
        }
      },
      methods: {

      },
    };
    const app = new Vue({
      el: "#app",
      data: {
        message: "你好",
        movies: ["复仇者联盟", "钢铁侠", "星际穿越", "哪吒传奇"]
      },
      components: {
        cpn
      }
    })
  </script>
```

### 8. 组件通信

#### 8.1 父传子（props的驼峰标识）

 v-bind是 不支持使用驼峰标识的，例如`cUser`要改成`c-User`。

```
  <div id="app">
    <!-- v-bind不支持驼峰 :cUser改成 :c-User-->
    <!-- <cpn :cUser="user"></cpn> -->
    <cpn :c-User="user"></cpn>
    <cpn :cuser="user" ></cpn>
  </div>
  <template id="cpn">
    <div>
      <!-- 使用驼峰 -->
      <h2>{{cUser}}</h2>
      <!-- 不使用 -->
      <h2>{{cuser}}</h2>
    </div>
  </template>
  <script src="../js/vue.js"></script>
  <script>
    // 父传子：props
    const cpn = {
      template: "#cpn",
      props: { //对象写法
        //驼峰
        cUser:Object,
        //未使用驼峰
        cuser:Object
      },
      data() {return {}},
      methods: {},
    };
    const app = new Vue({
      el: "#app",
      data: {
        user:{
          name:'zzz',
          age:18,
          height:175
        }
      },
      components: {
        cpn
      }
    })
  </script>
```

#### 8.2 子传父`$emit`

 子组件向父组件传值，使用自定义事件`$emit`。

```
  <!-- 父组件 -->
  <div id="app">
    <!-- 不写参数默认传递btnClick的item -->
    <cpn @itemclick="cpnClcik"></cpn>

  </div>

  <!-- 子组件 -->
  <template id="cpn">

    <div>
      <button v-for="(item, index) in categoties" :key="index" @click="btnClick(item)">{{item.name}}</button>
    </div>
  </template>

  <script src="../js/vue.js"></script>

  <script>
    const cpn = {
      template: "#cpn",
      data() {
        return {
          categoties: [{
              id: 'aaa',
              name: '热门推荐'
            },
            {
              id: 'bbb',
              name: '手机数码'
            },
            {
              id: 'ccc',
              name: '家用家电'
            },
            {
              id: 'ddd',
              name: '电脑办公'
            },
          ]
        }
      },
      methods: {
        btnClick(item) {
          this.$emit('itemclick', item)
        }
      },
    };
    const app = new Vue({
      el: "#app",
      data() {
        return {

        }
      },
      methods: {
        cpnClcik(item) {
          console.log('cpnClick'+item.name);
        }
      },
      components: {
        cpn
      },
    })
  </script>
```

1.在子组件中定义一个方法`btnClick(item)`，使用`$emit`，'itemclick'是事件名，`item`是传过去的值。

```
      methods: {
        btnClick(item) {
          this.$emit('itemclick', item)
        }
      },
```

2.在子组件中监听点击事件并回调此方法

```
<div>
      <button v-for="(item, index) in categoties" :key="index" @click="btnClick(item)">{{item.name}}</button>
    </div>
```

3.在父组件中定义一个方法cpnClcik(item)

```
methods: {
	cpnClcik(item) {
		console.log('cpnClick'+item.name);
	}
},
```

4.并在父组件（vue实例）中调用`<cpn @itemclick="cpnClcik"></cpn>`（*不写参数默认传递btnClick的item* ），父组件监听事件名为`itemclick`的子组件传过来的事件。

### 9. 父访问子（children-ref）

 父组件访问子组件，有时候需要直接操作子组件的方法，或是属性，此时需要用到`$children`和`$ref`。

```
  <!-- 父组件 -->
  <div id="app">
    <cpn></cpn>
    <cpn></cpn>
    <cpn ref="aaa"></cpn>
    <button @click="btnClick" >按钮</button>
  </div>
  <!-- 子组件 -->
  <template id="cpn">
    <div>
      我是子组件
    </div>
  </template>
  <script src="../js/vue.js"></script>
  <script>
    // 父传子：props
    const cpn = {
      template: "#cpn",
      data() {
        return {
          name:"我是子组件的name"
        }
      },
      methods: {
        showMessage(){
          console.log("showMessage");
        }
      },
    };
    const app = new Vue({
      el: "#app",
      data() {
        return {
          message:"hello"
        }
      },
      methods: {
        btnClick(){
          // 1.children
          // console.log(this.$children[0].showMessage)
          // for (let cpn of this.$children) {
          //   console.log(cpn.showMessage)
          // }
          // 2.$ref
          console.log(this.$refs.aaa.name)
        }
      },
      components: {
        cpn
      },
    })
  </script>
```

> `$children`方式

```
// 1.children
console.log(this.$children[0].showMessage)
for (let cpn of this.$children) {
    console.log(cpn.showMessage)
}
```

使用`this.$children`直接获取**当前实例的直接子组件，需要注意 `$children` 并不保证顺序，也不是响应式的。**如果你发现自己正在尝试使用 `$children` 来进行数据绑定，考虑使用一个数组配合 `v-for` 来生成子组件，并且使用 Array 作为真正的来源。

### 10 slot-插槽的基本使用

```
 <!-- 父组件 -->
  <div id="app">

    <cpn></cpn>
    <cpn>
      <span style="color:red;">这是插槽内容222</span>
    </cpn>
    <cpn>
      <i style="color:red;">这是插槽内容333</i>
    </cpn>
    <cpn></cpn>

  </div>

  <!-- 插槽的基本使用使用<slot></slot> -->
  <!-- 子组件 -->
  <template id="cpn">

    <div>
      <div>
        {{message}}
      </div>
      <!-- 插槽默认值 -->
      <slot><button>button</button></slot>
    </div>
  </template>

  <script src="../js/vue.js"></script>

  <script>
    const cpn = {
      template: "#cpn",
      data() {
        return {
          message: "我是子组件"
        }
      },
    }
    const app = new Vue({
      el: "#app",
      data() {
        return {
          message: "我是父组件消息"
        }
      },
      components: {
        cpn
      },
    })
  </script>
```

> 简单使用插槽，定义template时候使用`slot`

```
  <!-- 子组件 -->
  <template id="cpn">
    <div>
      <div>
        {{message}}
      </div>
      <!-- 插槽默认值 -->
      <slot><button>button</button></slot>
    </div>
  </template>
```



#### 10.1 slot-具名插槽的使用

 具名插槽，就是可以让插槽按指定的顺序填充，而没有具名的插槽是按照你填充的顺序排列的，而具名插槽可以自定义排列。

```
<!-- 父组件 -->
  <div id="app">

    <cpn>
      <span>具名插槽</span>
      <span slot="left">这是左边具名插槽</span>
      <!-- 新语法 -->
      <template v-slot:center>这是中间具名插槽</template>
      <!-- 新语法缩写 -->
      <template #right>这是右边具名插槽</template>


    </cpn>


  </div>

  <!-- 插槽的基本使用使用<slot></slot> -->
  <!-- 子组件 -->
  <template id="cpn">

    <div>

      <slot name="left">左边</slot>
      <slot name="center">中间</slot>
      <slot name="right">右边</slot>
      <slot>没有具名的插槽</slot>
    </div>
  </template>

  <script src="../js/vue.js"></script>

  <script>
    const cpn = {
      template: "#cpn",
      data() {
        return {
          message: "我是子组件"
        }
      },
    }
    const app = new Vue({
      el: "#app",
      data() {
        return {
          message: "我是父组件消息"
        }
      },
      components: {
        cpn
      },
    })
  </script>
```

#### 10.2 编译的作用域

```
 <!-- 父组件 -->
  <div id="app">
    <!-- 使用的vue实例作用域的isShow -->
    <cpn v-show="isShow"></cpn>
  </div>
<!-- 插槽的基本使用使用<slot></slot> -->
  <!-- 子组件 -->
  <template id="cpn">
    <div>
      <h2>我是子组件</h2>
      <p>哈哈哈</p>
      <!-- 组件作用域，使用的子组件的作用域 -->
      <button v-show="isShow"></button>
    </div>
  </template>

  <script src="../js/vue.js"></script>

  <script>
    const cpn = {
      template: "#cpn",
      data() {
        return {
          isShwo:false
        }
      },
    }
    const app = new Vue({
      el: "#app",
      data() {
        return {
          message: "我是父组件消息",
          isShow:true
        }
      },
      components: {
        cpn
      },
    })
  </script>
```

## **三 Vue实例的生命周期**

![](https://camo.githubusercontent.com/0ce030ce911b90465a27e40645ac087e6018cfab/68747470733a2f2f63646e2e6a7364656c6976722e6e65742f67682f6b7269736c696e7a68616f2f494d47636c6f75642f696d672f32303230303531363038353234322e706e67)

测试代码

```
<div id="app">
  <h1>测试生命周期</h1>
  <div>{{msg}}</div>
  <hr>
  <h3>测试beforeUpdate和update两个钩子函数</h3>
  <button @click="handlerUpdate">更新数据</button>
</div>
<script src="../js/vue.js"></script>
<script>
  const app = new Vue({
    el: '#app',
    data: {
      msg: "12345"
    },
    methods: {
      handlerUpdate() {
        this.msg=this.msg.split("").reverse().join("")
      }
    },
    //按照示意图依次调用
    beforeCreate(){
      console.log("调用了beforeCreate钩子函数");
    },
    created(){
      console.log("调用了created钩子函数");
    },
    beforeMount(){
      console.log('调用了beforeMount钩子函数');
    },
    mounted(){
      console.log('调用了mounted钩子函数');
    },
    beforeUpdate(){
      console.log("调用了beforeUpdate钩子函数")
    },
    updated(){
      console.log("调用了updated钩子函数");
    },
    beforeDestroy(){
      console.log("调用了beforeDestroy钩子函数");
    },
    destroyed(){
      console.log("调用了destroyed钩子函数");
    }
  })
</script>
```

#### 1 beforeCreate之前

初始化钩子函数和生命周期

#### 2 beforeCreate和created钩子函数间的生命周期

在beforeCreate和created之间，进行数据观测(data observer) ，也就是在这个时候开始监控data中的数据变化了，同时初始化事件。

#### 3 created钩子函数和beforeMount间的生命周期

对于created钩子函数和beforeMount有判断： [![img](https://camo.githubusercontent.com/050d208505e822f2432e729b73e483b7782925aa/68747470733a2f2f63646e2e6a7364656c6976722e6e65742f67682f6b7269736c696e7a68616f2f494d47636c6f75642f696d672f32303230303531363039313434382e706e67)](https://camo.githubusercontent.com/050d208505e822f2432e729b73e483b7782925aa/68747470733a2f2f63646e2e6a7364656c6976722e6e65742f67682f6b7269736c696e7a68616f2f494d47636c6f75642f696d672f32303230303531363039313434382e706e67)

#### 4 el选项对生命周期影响

> 1. 有el选项

```
new Vue({
    el: '#app',
    beforeCreate: function () {
        console.log('调用了beforeCreat钩子函数')
    },
    created: function () {
        console.log('调用了created钩子函数')
    },
    beforeMount: function () {
        console.log('调用了beforeMount钩子函数')
    },
    mounted: function () {
        console.log('调用了mounted钩子函数')
    }
})
```

结果: [![img](https://camo.githubusercontent.com/78f3f86ba66a714fb7c728e6a07cc88116ad9619/68747470733a2f2f63646e2e6a7364656c6976722e6e65742f67682f6b7269736c696e7a68616f2f494d47636c6f75642f696d672f32303230303531363039313634362e706e67)](https://camo.githubusercontent.com/78f3f86ba66a714fb7c728e6a07cc88116ad9619/68747470733a2f2f63646e2e6a7364656c6976722e6e65742f67682f6b7269736c696e7a68616f2f494d47636c6f75642f696d672f32303230303531363039313634362e706e67)

> 1. 无el选项

```
new Vue({
    beforeCreate: function () {
        console.log('调用了beforeCreat钩子函数')
    },
    created: function () {
        console.log('调用了created钩子函数')
    },
    beforeMount: function () {
        console.log('调用了beforeMount钩子函数')
    },
    mounted: function () {
        console.log('调用了mounted钩子函数')
    }
})
```

结果： [![img](https://camo.githubusercontent.com/fa5ed38143f701f9a964994bab2d4d8768ef2f10/68747470733a2f2f63646e2e6a7364656c6976722e6e65742f67682f6b7269736c696e7a68616f2f494d47636c6f75642f696d672f32303230303531363039323233382e706e67)](https://camo.githubusercontent.com/fa5ed38143f701f9a964994bab2d4d8768ef2f10/68747470733a2f2f63646e2e6a7364656c6976722e6e65742f67682f6b7269736c696e7a68616f2f494d47636c6f75642f696d672f32303230303531363039323233382e706e67)

> 证明没有el选项，则停止编译，也意味着暂时停止了生命周期。生命周期到created钩子函数就结束了。而当我们不加el选项，但是手动执行vm.$mount(el)方法的话，也能够使暂停的生命周期进行下去，例如：

```
var app = new Vue({
    beforeCreate: function () {
        console.log('调用了beforeCreat钩子函数')
    },
    created: function () {
        console.log('调用了created钩子函数')
    },
    beforeMount: function () {
        console.log('调用了beforeMount钩子函数')
    },
    mounted: function () {
        console.log('调用了mounted钩子函数')
    }
})
app.$mount('#app')
```

结果： [![img](https://camo.githubusercontent.com/78f3f86ba66a714fb7c728e6a07cc88116ad9619/68747470733a2f2f63646e2e6a7364656c6976722e6e65742f67682f6b7269736c696e7a68616f2f494d47636c6f75642f696d672f32303230303531363039313634362e706e67)](https://camo.githubusercontent.com/78f3f86ba66a714fb7c728e6a07cc88116ad9619/68747470733a2f2f63646e2e6a7364656c6976722e6e65742f67682f6b7269736c696e7a68616f2f494d47636c6f75642f696d672f32303230303531363039313634362e706e67)

#### 5 template

[![img](https://camo.githubusercontent.com/f9aebbff636b4a036b0e767041b6b913857e7b6d/68747470733a2f2f63646e2e6a7364656c6976722e6e65742f67682f6b7269736c696e7a68616f2f494d47636c6f75642f696d672f32303230303531363039323630322e706e67)](https://camo.githubusercontent.com/f9aebbff636b4a036b0e767041b6b913857e7b6d/68747470733a2f2f63646e2e6a7364656c6976722e6e65742f67682f6b7269736c696e7a68616f2f494d47636c6f75642f696d672f32303230303531363039323630322e706e67)

> 同时使用`template`和`HTML`，查看优先级：

```
    <h1>测试template和HTML的优先级</h1>
    <div id="app">
        <p>HTML优先</p>
    </div>
    <script>
        var app = new Vue({
            el:"#app",
            data:{
                msg:"template优先"
            },
            template:"<p>{{msg}}</p>",
        });
    </script>
```

结果： [![img](https://camo.githubusercontent.com/7652bede5054079f1dbaacaa6c11fc75f36415a5/68747470733a2f2f63646e2e6a7364656c6976722e6e65742f67682f6b7269736c696e7a68616f2f494d47636c6f75642f696d672f32303230303531363039323735302e706e67)](https://camo.githubusercontent.com/7652bede5054079f1dbaacaa6c11fc75f36415a5/68747470733a2f2f63646e2e6a7364656c6976722e6e65742f67682f6b7269736c696e7a68616f2f494d47636c6f75642f696d672f32303230303531363039323735302e706e67)

> 结论

1. 如果Vue实例对象中有template参数选项，则将其作为模板编译成render函数
2. 如果没有template参数选项，则将外部的HTML作为模板编译（template），也就是说，template参数选项的优先级要比外部的HTML高
3. 如果1,2条件都不具备，则报错

> 注意

1. Vue需要通过el去找对应的template，Vue实例通过el的参数，首先找自己有没有template，如果没有再去找外部的html，找到后将其编译成render函数。
2. 也可以直接调用[render](https://cn.vuejs.org/v2/api/#render)选项，优先级：`render函数选项 > template参数 > 外部HTML`。

```
new Vue({
    el: '#app',
    render (createElement) {
        return (....)
    }
})
```

#### 6 beforeMount和mounted钩子函数间的生命周期

[![img](https://camo.githubusercontent.com/93b0267f7bdf4f5c6cc788eb2a3ebf73037c861e/68747470733a2f2f63646e2e6a7364656c6976722e6e65742f67682f6b7269736c696e7a68616f2f494d47636c6f75642f696d672f32303230303531363039323933392e706e67)](https://camo.githubusercontent.com/93b0267f7bdf4f5c6cc788eb2a3ebf73037c861e/68747470733a2f2f63646e2e6a7364656c6976722e6e65742f67682f6b7269736c696e7a68616f2f494d47636c6f75642f696d672f32303230303531363039323933392e706e67)

> beforeMount

载入前（完成了data和el数据初始化），但是页面中的内容还是vue中的占位符，data中的message信息没有被挂在到Dom节点中，在这里可以在渲染前最后一次更改数据的机会，不会触发其他的钩子函数，一般可以在这里做初始数据的获取。

> Mount

载入后html已经渲染(ajax请求可以放在这个函数中)，把vue实例中的data里的message挂载到DOM节点中去

> 这里两个钩子函数间是载入数据。

#### 7 beforeUpdate钩子函数和updated钩子函数间的生命周期

[![img](https://camo.githubusercontent.com/7994f45576fe9687a749ea567787ba1b40e29766/68747470733a2f2f63646e2e6a7364656c6976722e6e65742f67682f6b7269736c696e7a68616f2f494d47636c6f75642f696d672f32303230303531363039333233322e706e67)](https://camo.githubusercontent.com/7994f45576fe9687a749ea567787ba1b40e29766/68747470733a2f2f63646e2e6a7364656c6976722e6e65742f67682f6b7269736c696e7a68616f2f494d47636c6f75642f696d672f32303230303531363039333233322e706e67)

在Vue中，修改数据会导致重新渲染，依次调用beforeUpdate钩子函数和updated钩子函数

如果待修改的数据没有载入模板中，不会调用这里两个钩子函数

```
var app = new Vue({
    el: '#app',
    data: {
        msg: 1
    },
    template: '<div id="app"><p></p></div>',
    beforeUpdate: function () {
        console.log('调用了beforeUpdate钩子函数')
    },
    updated: function () {
        console.log('调用了updated钩子函数')
    }
})
app.msg = 2
```

结果： [![img](https://camo.githubusercontent.com/c6da3a5c89617a65fe3d144d1abaa00c53fdc789/68747470733a2f2f63646e2e6a7364656c6976722e6e65742f67682f6b7269736c696e7a68616f2f494d47636c6f75642f696d672f32303230303531363039333530392e706e67)](https://camo.githubusercontent.com/c6da3a5c89617a65fe3d144d1abaa00c53fdc789/68747470733a2f2f63646e2e6a7364656c6976722e6e65742f67682f6b7269736c696e7a68616f2f494d47636c6f75642f696d672f32303230303531363039333530392e706e67) 如果绑定了数据，会调用两个钩子函数：

```
<h1>测试有数据绑定修改数据，钩子函数调用情况</h1>
<div id="app">
</div>
<script>
    var app = new Vue({
        el:"#app",
        template:"<p>{{msg}}</p>",
        data:{
            msg:"原数据"
        },
        beforeUpdate: function () {
            console.log("调用了beforeUpdate钩子函数")
        },
        updated: function () {
            console.log("调用了updated钩子函数");
        },
    });
    app.msg = "数据被修改了";
</script>
```

结果： [![img](https://camo.githubusercontent.com/6975dbb73f1a1b62f67278eb3db45e437f65ae3e/68747470733a2f2f63646e2e6a7364656c6976722e6e65742f67682f6b7269736c696e7a68616f2f494d47636c6f75642f696d672f32303230303531363039333535312e706e67)](https://camo.githubusercontent.com/6975dbb73f1a1b62f67278eb3db45e437f65ae3e/68747470733a2f2f63646e2e6a7364656c6976722e6e65742f67682f6b7269736c696e7a68616f2f494d47636c6f75642f696d672f32303230303531363039333535312e706e67)

> 注意只有写入模板的数据才会被追踪

#### 8 beforeDestroy和destroyed钩子函数间的生命周期

[![img](https://camo.githubusercontent.com/b1b244438ffe04bedca441fb2de835c2f62fa0ec/68747470733a2f2f63646e2e6a7364656c6976722e6e65742f67682f6b7269736c696e7a68616f2f494d47636c6f75642f696d672f32303230303531363039333633382e706e67)](https://camo.githubusercontent.com/b1b244438ffe04bedca441fb2de835c2f62fa0ec/68747470733a2f2f63646e2e6a7364656c6976722e6e65742f67682f6b7269736c696e7a68616f2f494d47636c6f75642f696d672f32303230303531363039333633382e706e67)

#### 9 beforeDestroy

销毁前执行（$destroy方法被调用的时候就会执行）,一般在这里善后:清除计时器、清除非指令绑定的事件等等…’)

#### 10 destroyed

销毁后 （Dom元素存在，只是不再受vue控制）,卸载watcher，事件监听，子组件

#### 总结

- beforecreate : 可以在这加个loading事件
- created ：在这结束loading，还做一些初始数据的获取，实现函数自-执行
- mounted ： 在这发起后端请求，拿回数据，配合路由钩子做一些事情
- beforeDestroy： 你确认删除XX吗？
- destroyed ：当前组件已被删除，清空相关内容



### 四 **前端模块化**

#### 1  使用导出全局变量模块解决全局变量同名问题

```
//模块对象
var moduleA = (function (param) {
  //导出对象
  var obj = {}
  var name = '小明'
  var age = 22

  function sum(num1, num2) {
    return num1 + num2
  }
  var flag = true
  if (flag) {
    console.log(sum(10, 20))
  }
  obj.flag=false
  return obj
})()
```

> mmm.js

```
//小明
//使用全局变量moduleA
if(moduleA.flag){
  console.log("flag是true")
}
```

#### 2 CommonJS的模块化实现

```
var name = '小明'
var age = 22

function sum(num1, num2) {
  return num1 + num2
}
var flag = true
if (flag) {
  console.log(sum(10, 20))
}

// module.exports = {
//   flag : flag,
//   sum : sum
// }
//导出对象
module.exports = {
  flag,
  sum
}
```

使用`module.exports = {}`导出需要的对象。

> mmm.js

```
//导入对象,nodejs语法,需要node支持,从aaa.js取出对象
var {flag,sum} = require("./aaa")

console.log(sum(10,20));

if(flag){
  console.log("flag is true");
}
```

使用 `var {flag,sum} = require("./aaa")`获取已经导出的对象中自己所需要的对象。

#### 3 ES6的模块化实现

 如何实现模块化，在html中需要使用`type='module'`属性。

```
  <script src="aaa.js" type="module"></script>
  <script src="bbb.js" type="module"></script>
  <script src="mmm.js" type="module"></script>
```

此时表示aaa.js是一个单独的模块，此模块是有作用域的。如果要使用aaa.js内的变量，需要在aaa.js中先导出变量，再在需要使用的地方导出变量。

##### 3.1 直接导出

```
export let name = '小明'
```

> 使用

```
import {name} from './aaa.js'
console.log(name)
```

`./aaa.js`表示aaa.js和mmm.js在同级目录。

##### 3.2 统一导出

```
var age = 22
function sum(num1, num2) {
  return num1 + num2
}
var flag = true
if (flag) {
  console.log(sum(10, 20))
}
//2.最后统一导出
export {
  flag,sum,age
}
```

> 使用`import {name,flag,sum} from './aaa.js'`导入多个变量

```
import {name,flag,sum} from './aaa.js'

console.log(name)

if(flag){
  console.log("小明是天才");
}

console.log(sum(20,30));
```

##### 3.3 导出函数/类

> 在aaa.js中添加

```
//3.导出函数/类
export function say(value) {
  console.log(value);
}
export class Person{
  run(){
    console.log("奔跑");
  }
}
```

> 在mmm.js中添加

```
import {name,flag,sum,say,Person} from './aaa.js'

console.log(name)

if(flag){
  console.log("小明是天才");
}

console.log(sum(20,30));

say('hello')
const p = new Person();
p.run();
```

##### 3.4 默认导入 export default

> 导出

```
export default {
  flag,sum,age
}
```

> 导入

```
//4.默认导入 export default
import aaa from './aaa.js'
console.log(aaa.sum(10,110));
```

> 注意：使用默认导出会将所有需要导出的变量打包成一个对象，此时导出一个对象，此时我在`mmm.js`中导入变量时候命名为aaa，如果要调用变量需要使用aaa.变量。

##### 3.5 统一全部导入

>  使用`import * as aaa from './aaa.js'`统一全部导入

```
// 5.统一全部导入
import * as aaa from './aaa.js'
console.log(aaa.flag);
console.log(aaa.name);
```

### 五  webpack

#### 1 什么是webpack

webpack是一个JavaScript应用的静态模块打包工具。

### 六 vue-cli

#### 1 什么是vue-cli

Vue CLI 是一个基于 Vue.js 进行快速开发的完整系统，提供：

- 通过 `@vue/cli` 搭建交互式的项目脚手架。

- 通过 `@vue/cli` + `@vue/cli-service-global` 快速开始零配置原型开发。

- 一个运行时依赖 (

  ```
  @vue/cli-service
  ```

  )，该依赖：

  - 可升级；
  - 基于 webpack 构建，并带有合理的默认配置；
  - 可以通过项目内的配置文件进行配置；
  - 可以通过插件进行扩展。

- 一个丰富的官方插件集合，集成了前端生态中最好的工具。

- 一套完全图形化的创建和管理 Vue.js 项目的用户界面。

Vue CLI 致力于将 Vue 生态中的工具基础标准化。它确保了各种构建工具能够基于智能的默认配置即可平稳衔接，这样你可以专注在撰写应用上，而不必花好几天去纠结配置的问题。与此同时，它也为每个工具提供了调整配置的灵活性，无需 eject。

#### 2 **CLI是什么意思？**

- CLI是Command-Line Interface，即命令行界面，也叫脚手架。
- vue cli 是vue.js官方发布的一个vue.js项目的脚手架
- 使用vue-cli可以快速搭建vue开发环境和对应的webpack配置

#### 3 vue cli使用

**vue cli使用前提node**

vue cli依赖nodejs环境，vue cli就是使用了webpack的模板。

安装vue脚手架，现在脚手架版本是vue cli3

```
npm install -g @vue/cli
```

如果使用yarn

```
yarn global add @vue/cli
```

安装完成后使用命令查看版本是否正确：

```
vue --version
```

> 注意安装cli失败

1. 以管理员使用cmd
2. 清空npm-cache缓存

```
npm clean cache -force
```

**拉取2.x模板（旧版本）**

Vue CLI >= 3 和旧版使用了相同的 `vue` 命令，所以 Vue CLI 2 (`vue-cli`) 被覆盖了。如果你仍然需要使用旧版本的 `vue init` 功能，你可以全局安装一个桥接工具：

```
npm install -g @vue/cli-init
# `vue init` 的运行效果将会跟 `vue-cli@2.x` 相同
vue init webpack my-project
```

**1.在根目录新建一个文件夹`16-vue-cli`，cd到此目录，新建一个vue-cli2的工程。**

```
cd 16-vue-cli
//全局安装桥接工具
npm install -g @vue/cli-init
//新建一个vue-cli2项目
vue init webpack 01-vuecli2test
```

> 注意：如果是创建vue-cli3的项目使用：

```
vue create 02-vuecli3test
```

2.创建工程选项含义

[![img](https://camo.githubusercontent.com/9bab2140c95a65b1cb2ebfe619d8ac6f16518d6b/68747470733a2f2f67697465652e636f6d2f6b7269736c696e5f7a68616f2f494d47636c6f75642f7261772f6d61737465722f696d672f32303230303531373135333431372e706e67)](https://camo.githubusercontent.com/9bab2140c95a65b1cb2ebfe619d8ac6f16518d6b/68747470733a2f2f67697465652e636f6d2f6b7269736c696e5f7a68616f2f494d47636c6f75642f7261772f6d61737465722f696d672f32303230303531373135333431372e706e67)

- project name：项目名字（默认）
- project description：项目描述
- author：作者（会默认拉去git的配置）
- vue build：vue构建时候使用的模式
  - runtime+compiler：大多数人使用的，可以编译template模板
  - runtime-only：比compiler模式要少6kb，并且效率更高，直接使用render函数
- install vue-router：是否安装vue路由
- user eslint to lint your code：是否使用ES规范
- set up unit tests：是否使用unit测试
- setup e2e tests with nightwatch：是否使用end 2 end，点到点自动化测试
- Should we run `npm install` for you after the project has been created? (recommended)：使用npm还是yarn管理工具

等待创建工程成功。

> 注意：如果创建工程时候选择了使用ESLint规范，又不想使用了，需要在config文件夹下的index.js文件中找到useEslint，并改成false。

```
    // Use Eslint Loader?
    // If true, your code will be linted during bundling and
    // linting errors and warnings will be shown in the console.
    useEslint: true,
```

#### 4 vue-cli2的目录结构

创建完成后，目录如图所示：

[![img](https://camo.githubusercontent.com/d5ec500e70c3f6a485a2a1b4fc6782668ac4b3da/68747470733a2f2f67697465652e636f6d2f6b7269736c696e5f7a68616f2f494d47636c6f75642f7261772f6d61737465722f696d672f32303230303531373135333335392e706e67)](https://camo.githubusercontent.com/d5ec500e70c3f6a485a2a1b4fc6782668ac4b3da/68747470733a2f2f67697465652e636f6d2f6b7269736c696e5f7a68616f2f494d47636c6f75642f7261772f6d61737465722f696d672f32303230303531373135333335392e706e67)

其中build和config都是配置相关的文件。

##### 4.1 build和config

[![img](https://camo.githubusercontent.com/4e5b3283b56f06c1af5530d7336cf68cf53d274f/68747470733a2f2f67697465652e636f6d2f6b7269736c696e5f7a68616f2f494d47636c6f75642f7261772f6d61737465722f696d672f32303230303531373135333630322e706e67)](https://camo.githubusercontent.com/4e5b3283b56f06c1af5530d7336cf68cf53d274f/68747470733a2f2f67697465652e636f6d2f6b7269736c696e5f7a68616f2f494d47636c6f75642f7261772f6d61737465722f696d672f32303230303531373135333630322e706e67)

如图所示，build中将webpack的配置文件做了分离：

- `webpack.base.conf.js`（公共配置）
- `webpack.dev.conf.js`（开发环境）
- `webpack.prod.conf.js`（生产环境）

我们使用的脚本命令配置在`package.json`中。

[![img](https://camo.githubusercontent.com/dcbc35c24610d8c8de0864e481eadf11f7f96f6b/68747470733a2f2f67697465652e636f6d2f6b7269736c696e5f7a68616f2f494d47636c6f75642f7261772f6d61737465722f696d672f32303230303531373135333731302e706e67)](https://camo.githubusercontent.com/dcbc35c24610d8c8de0864e481eadf11f7f96f6b/68747470733a2f2f67697465652e636f6d2f6b7269736c696e5f7a68616f2f494d47636c6f75642f7261772f6d61737465722f696d672f32303230303531373135333731302e706e67)

打包构建：

```
npm run build
```

如果搭建了本地服务器`webpack-dev-server`，本地开发环境：

```
npm run dev
```

此时`npm run build`打包命令相当于使用node 执行build文件夹下面的build.js文件。

> build.js

[![img](https://camo.githubusercontent.com/549bba6a24e9e05f1bd84a0fbec81c27ac9f88a7/68747470733a2f2f67697465652e636f6d2f6b7269736c696e5f7a68616f2f494d47636c6f75642f7261772f6d61737465722f696d672f32303230303531373135333734382e706e67)](https://camo.githubusercontent.com/549bba6a24e9e05f1bd84a0fbec81c27ac9f88a7/68747470733a2f2f67697465652e636f6d2f6b7269736c696e5f7a68616f2f494d47636c6f75642f7261772f6d61737465722f696d672f32303230303531373135333734382e706e67)

1. 检查dist文件夹是否已经存在，存在先删除
2. 如果没有err，就使用webpack的配置打包dist文件夹

在生产环境，即使用build打包时候，使用的是`webpack.prod.conf.js`配置文件。

[![img](https://camo.githubusercontent.com/78292072b9bbf038a29497f151f71d7708b8ffba/68747470733a2f2f67697465652e636f6d2f6b7269736c696e5f7a68616f2f494d47636c6f75642f7261772f6d61737465722f696d672f32303230303531373135333835392e706e67)](https://camo.githubusercontent.com/78292072b9bbf038a29497f151f71d7708b8ffba/68747470733a2f2f67697465652e636f6d2f6b7269736c696e5f7a68616f2f494d47636c6f75642f7261772f6d61737465722f696d672f32303230303531373135333835392e706e67)

源码中，显然使用了`webpack-merge`插件来合并prod配置文件和公共的配置文件，合并成一个配置文件并打包，而`webpack.dev.conf.js`也是如此操作，在开发环境使用的是dev的配置文件。

config文件夹中是build的配置文件中所需的一些变量、对象，在`webpack.base.conf.js`中引入了`index.js`。

```
const config = require('../config')
```

##### 4.2 src和static

src源码目录，就是我们需要写业务代码的地方。

static是放静态资源的地方，static文件夹下的资源会原封不动的打包复制到dist文件夹下。

##### 4.3 其他相关文件

###### 4.3.1 .babelrc文件

.babelrc是ES代码相关转化配置。

```
{
  "presets": [
    ["env", {
      "modules": false,
      "targets": {
        "browsers": ["> 1%", "last 2 versions", "not ie <= 8"]
      }
    }],
    "stage-2"
  ],
  "plugins": ["transform-vue-jsx", "transform-runtime"]
}
```

1. browsers表示需要适配的浏览器，份额大于1%，最后两个版本，不需要适配ie8及以下版本
2. babel需要的插件

###### 4.3.2 .editorconfig文件

.editorconfig是编码配置文件。

```
root = true

[*]
charset = utf-8
indent_style = space
indent_size = 2
end_of_line = lf
insert_final_newline = true
trim_trailing_whitespace = true
```

一般是配置编码，代码缩进2空格，是否清除空格等。

###### 4.3.3 .eslintignore文件

.eslintignore文件忽略一些不规范的代码。

```
/build/
/config/
/dist/
/*.js
```

忽略build、config、dist文件夹和js文件。

###### 4.3.4 .gitignore文件

.gitignore是git忽略文件，git提交忽略的文件。

###### 4.3.5 .postcssrc.js文件

css转化是配置的一些。

###### 4.3.6 index.html文件

index.html文件是使用`html-webpack-plugin`插件打包的index.html模板。

###### 4.3.7 package.json和package-lock.json

1. package.json(包管理,记录大概安装的版本)
2. package-lock.json(记录真实安装版本)

#### 5 runtime-compiler和runtime-only区别

新建两个vuecli2项目：

```
//新建一个以runtime-compiler模式
vue init webpack 02-runtime-compiler
//新建一个以runtime-only模式
vue init webpack 03-runtime-only
```

两个项目的main.js区别

> runtime-compiler

```
import Vue from 'vue'
import App from './App'

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  components: { App },
  template: '<App/>'
})
```

> runtime-only

```
import Vue from 'vue'
import App from './App'

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  render: h => h(App)
})
render: h => h(App)
render:function(h){
  return h(App)
}
```

**compiler编译解析template过程**

[![img](https://camo.githubusercontent.com/a315aec606a71248ad1030d653632c08b7e5e82e/68747470733a2f2f67697465652e636f6d2f6b7269736c696e5f7a68616f2f494d47636c6f75642f7261772f6d61737465722f696d672f32303230303531373135343530342e706e67)](https://camo.githubusercontent.com/a315aec606a71248ad1030d653632c08b7e5e82e/68747470733a2f2f67697465652e636f6d2f6b7269736c696e5f7a68616f2f494d47636c6f75642f7261772f6d61737465722f696d672f32303230303531373135343530342e706e67)

`vm.options.template`解析成`ast(abstract syntax tree)`抽象语法树，抽象语法树编译成`vm.options.render(functions)`render函数。render函数最终将template解析的ast渲染成虚拟DOM（`virtual dom`），最终虚拟dom映射到ui上。

**runtime-compiler** template会被解析 => ast(抽象语法树) => 然后编译成render函数 => 渲染成虚拟DOM（vdom）=> 真实dom(UI) **runtime-only** render => vdom => UI

1.性能更高，2.需要代码量更少

> render函数

```
render:function(createElement){
  //1.createElement('标签',{标签属性},[''])
  return createElement('h2',
    {class:'box'},
    ['Hello World',createElement('button',['按钮'])])
  //2.传入组件对象
  //return createElement(cpn)
}
```

h就是一个传入的createElement函数，.vue文件的template是由vue-template-compiler解析。

将02-runtime-compiler的main.js修改

```
new Vue({
  el: '#app',
  // components: { App },
  // template: '<App/>'
  //1.createElement('标签',{标签属性},[''])
  render(createElement){
    return createElement('h2',
    {class:'box'},
    ['hello vue', createElement('button',['按钮'])])
  }
})
```

并把config里面的inedx.js的`useEslint: true`改成false，即关掉eslint规范，打包项目`npm run dev`，打开浏览器。

[![img](https://camo.githubusercontent.com/c630f0ff8db1e9821414ad305b584f3b0b308bf2/68747470733a2f2f67697465652e636f6d2f6b7269736c696e5f7a68616f2f494d47636c6f75642f7261772f6d61737465722f696d672f32303230303531373135343732312e706e67)](https://camo.githubusercontent.com/c630f0ff8db1e9821414ad305b584f3b0b308bf2/68747470733a2f2f67697465652e636f6d2f6b7269736c696e5f7a68616f2f494d47636c6f75642f7261772f6d61737465722f696d672f32303230303531373135343732312e706e67)

在修改main.js

```
new Vue({
  el: '#app',
  // components: { App },
  // template: '<App/>'
  //1.createElement('标签',{标签属性},[''])
  render(createElement){
    // return createElement('h2',
    // {class:'box'},
    // ['hello vue', createElement('button',['按钮'])])
    //2.传入组件
    return createElement(App)
  }
```

再次打包，发现App组件被渲染了。

[![img](https://camo.githubusercontent.com/9772c47f75906c77bb52f0008143de478ec8c2ba/68747470733a2f2f67697465652e636f6d2f6b7269736c696e5f7a68616f2f494d47636c6f75642f7261772f6d61737465722f696d672f32303230303531373135343734312e706e67)](https://camo.githubusercontent.com/9772c47f75906c77bb52f0008143de478ec8c2ba/68747470733a2f2f67697465652e636f6d2f6b7269736c696e5f7a68616f2f494d47636c6f75642f7261772f6d61737465722f696d672f32303230303531373135343734312e706e67)

#### 6 vue-cli3

##### 6.1 vue-cli3起步

**vue-cli3与2版本区别**

- vue-cli3基于webpack4打造，vue-cli2是基于webpack3
- vue-cli3的设计原则是"0配置"，移除了配置文件，build和config等
- vue-cli3提供`vue ui`的命令，提供了可视化配置
- 移除了static文件夹，新增了public文件夹，并将index.html移入了public文件夹

**创建vue-cli3项目**

```
vue create 04-vuecli3test
```

**目录结构：**

[![img](https://camo.githubusercontent.com/e746c10a74c7638d6ec2ade4b4d8142c9b332cd6/68747470733a2f2f67697465652e636f6d2f6b7269736c696e5f7a68616f2f494d47636c6f75642f7261772f6d61737465722f696d672f32303230303531373135353035352e706e67)](https://camo.githubusercontent.com/e746c10a74c7638d6ec2ade4b4d8142c9b332cd6/68747470733a2f2f67697465652e636f6d2f6b7269736c696e5f7a68616f2f494d47636c6f75642f7261772f6d61737465722f696d672f32303230303531373135353035352e706e67)

- public 类似 static文件夹，里面的资源会原封不动的打包
- src源码文件夹

使用`npm run serve`运行服务器，打开浏览器输入http://localhost:8080/

打开src下的main.js

```
import Vue from 'vue'
import App from './App.vue'

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
}).$mount('#app')
```

`Vue.config.productionTip = false`构建信息是否显示

如果vue实例有el选项，vue内部会自动给你执行`$mount('#app')`，如果没有需要自己执行。

##### 6.2 vue-cli3的配置

在创建vue-cli3项目的时候可以使用`vue ui`命令进入图形化界面创建项目，可以以可视化的方式创建项目，并配置项。

vue-cli3配置被隐藏起来了，可以在`node_modules`文件夹中找到`@vue`模块，打开其中的`cli-service`文件夹下的`webpack.config.js`文件。

[![img](https://camo.githubusercontent.com/b5442f0f54838b1dfc2d50771854b4bcb97dd098/68747470733a2f2f67697465652e636f6d2f6b7269736c696e5f7a68616f2f494d47636c6f75642f7261772f6d61737465722f696d672f32303230303531373135353131352e706e67)](https://camo.githubusercontent.com/b5442f0f54838b1dfc2d50771854b4bcb97dd098/68747470733a2f2f67697465652e636f6d2f6b7269736c696e5f7a68616f2f494d47636c6f75642f7261772f6d61737465722f696d672f32303230303531373135353131352e706e67)

再次打开当前目录下的`lib`文件夹，发现配置文件`service.js`，并导入了许多模块，来自与lib下面的config、util等模块

[![img](https://camo.githubusercontent.com/e68452e96e55d550927e971f678af7a9805f115b/68747470733a2f2f67697465652e636f6d2f6b7269736c696e5f7a68616f2f494d47636c6f75642f7261772f6d61737465722f696d672f32303230303531373135353133372e706e67)](https://camo.githubusercontent.com/e68452e96e55d550927e971f678af7a9805f115b/68747470733a2f2f67697465652e636f6d2f6b7269736c696e5f7a68616f2f494d47636c6f75642f7261772f6d61737465722f696d672f32303230303531373135353133372e706e67)

**如何要自定义配置文件**

在项目根目录下新建一个`vue.config.js`配置文件，必须为`vue.config.js`，vue-cli3会自动扫描此文件，在此文件中修改配置文件。

```
//在module.exports中修改配置
module.exports = {
  
}
```

### 六 **Vue-Router**

#### 1. 路由简介

**什么是路由？**

- 路由就是通过互联的网络把信息从源地址传送到目的地的活动
- 路由提供了两种机制：路由和传送
  - 路由是决定数据包从来源到目的地的路径
  - 转送就是将数据转移
- 路由表
  - 路由表本质就是一个映射表，决定了数据包的指向

### 七 Vuex

**Vuex**是一个专为**Vue.js**应用程序开发的状态管理模式。它采用集中式存储管理应用的所有组件的状态，并以相应的规则保证状态以一种可预测的方式发生变化。

其实最简单理解为，在我们写Vue组件中，一个页面多个组件之间想要通信数据，那你可以使用**Vuex**

- Vuex 是一个专为 Vue.js 应用程序开发的状态管理模式
- Vuex状态管理 === 管理组件数据流动 === 全局数据管理
- Vue的全局数据池，在这里它存放着大量的复用或者公有的数据，然后可以分发给组件
- Vue双向数据绑定的MV框架，数据驱动(区别节点驱动)，模块化和组件化，所以管理各组件和模块之间数据的流向至关重要
- Vuex是一个前端非持久化的数据库中心，Vuex其实是Vue的重要选配，一般小型不怎么用，大型项目运用比较多，所以页面刷新，Vuex数据池会重置

#### 1 数据流层

[![img](https://camo.githubusercontent.com/0104576ab104db4b96b98283aacfaac1a018a1d3/68747470733a2f2f67697465652e636f6d2f6b7269736c696e5f7a68616f2f494d47636c6f75642f7261772f6d61737465722f696d672f32303230303532303039313334362e706e67)](https://camo.githubusercontent.com/0104576ab104db4b96b98283aacfaac1a018a1d3/68747470733a2f2f67697465652e636f6d2f6b7269736c696e5f7a68616f2f494d47636c6f75642f7261772f6d61737465722f696d672f32303230303532303039313334362e706e67)

### 注意事项

1. 数据流都是单向的
2. 组件能够调用action
3. action用来派发mutation
4. 只有mutation可以改变状态
5. store是响应式的，无论state什么时候更新，组件都将同步更新



### 八  Axios的使用和配置

#### 1 安装

```
   npm install axios --save
```

或者使用cdn

```
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
```

#### 2 基本使用

##### 2.1 Get请求

```
axios.get('/user', {
  params: {
    name: 'krislin'
  }
}).then(function (response) {
  console.log(response);
}).catch(function (error) {
  console.log(error)
}
```

##### 2.2 Post请求

```
axios.post('/user',{
    name:'krislin',
    address:'china'
})
.then(function(response){
    console.log(response);
})
.catch(function(error){
    console.log(error);
});
```

##### 2.3 并发操作

```
function getUserAccount(){
    return axios.get('/user/12345');
}

function getUserPermissions(){
    return axios.get('/user/12345/permissions');
}

axios.all([getUerAccount(),getUserPermissions()])
    .then(axios.spread(function(acc,pers){
        //两个请求现在都完成
}));
```

### 九 什么是Promies

**简单说Promise是异步编程的一种解决方案。**

Promise是ES6中的特性。

> 什么是异步操作？

网络请求中，对端服务器处理需要时间，信息传递过程需要时间，不像我们本地调用一个js加法函数一样，直接获得`1+1=2`的结果。这里网络请求不是同步的有时延，不能立即得到结果。

> 如何处理异步事件？

对于网络请求这种，一般会使用回调函数，在服务端传给我数据成功后，调用回调函数。例如ajax调用。

```
$.ajax({
	success:function(){
		...
	}
})
```

> 如果碰到嵌套网络请求，例如第一次网络请求成功后回调函数再次发送网络请求，这种代码就会让人很难受。

```
$.ajax({
	success:function(){
		$.ajax({
			...
        })
	}
})
```

如果还需要再次网络请求，那么又要嵌套一层，这样的代码层次不分明很难读，也容易出问题。

#### 1 Promise的基本使用

##### 1.1 什么时候使用Promise

解决异步请求冗余这样的问题，promise就是用于封装异步请求的。

##### 1.2 Promise对象

```
new Promise((resolve, reject) => {})
```

Promise对象的参数是一个函数`(resolve, reject) => {}`，这个函数又有2个参数分别是`resolve`和`reject`。这2个参数本身也是函数，是不是有点绕？后面还有回调函数`then(func)`的参数也是一个函数。

> 模拟定时器的异步事件

用定时器模拟网络请求，定时一秒为网络请求事件，用console.log()表示需要执行的代码。

```
//1.使用setTimeout模拟嵌套的三次网络请求
setTimeout(() => {//第一次请求
    console.log("hello world")//第一次处理代码
    setTimeout(() => {//第二次请求
        console.log("hello vuejs")//第二次处理代码
        setTimeout(() => {//第三次请求
            console.log("hello java")//第三次处理代码
        }, 1000)
    }, 1000)
}, 1000)
```

一层套一层，看起是不是很绕。

使用promise来处理异步操作

```
//参数 -> 函数
// resolve和reject本身也是函数
//then()的参数也是一个函数
new Promise((resolve, reject) => {
    setTimeout(() => {//第一次网络请求
        resolve()
    }, 1000)
}).then(() => {
    console.log("hello world")//第一次处理代码
    return new Promise((resolve, reject) => {
        setTimeout(() => {//第二次网络请求
            resolve()
        }, 1000).then(() => {
            console.log("hello vuejs")//第二次处理代码
            return new Promise((resolve, reject) => {
                setTimeout(() => {//第三次网络请求
                    resolve()
                }, 1000)
            }).then(() => {
                console.log("hello java")//第三次处理代码
            })
        })
    })
})
```

是不是觉得代码还要更复杂了？仔细看看第一个如果使用了多个就找不到对应关系了。相反第二个流程就很清楚，调用`resolve()`就能跳转到`then()`方法就能执行处理代码，`then()`回调的返回值又是一个`Promise`对象。层次很明显，只要是`then()`必然就是执行处理代码，如果还有嵌套必然就是返回一个Promise对象，这样调用就像java中的StringBuffer的append()方法一样，链式调用。

```
new Promise((resolve, reject) => {
    setTimeout(() => {
    	resolve('success')
    }, 1000).then(success => {
    	console.log(success)
    })
})
```

setTimeout()模拟的是网络请求，而then()执行的是网络请求后的代码，这就将网络请求和请求得到响应后的操作分离了，每个地方干自己的事情。在resolve中传参了，那么在then()方法中的参数就有这个参数，例如data。

**网络请求中也会有失败情况？例如网络堵塞。**

如何处理失败情况，此时就要用到reject()

```
new Promise((resolve, reject) => {
    setTimeout(() => {
    	reject('error message')
    }, 1000).catch(error => {
    	console.log(error)
    })
})
```

此时`reject(error)`，`catch()`方法捕获到`reject()`中的error。

> 合起来

```
new Promise((resolve, reject) => {
    setTimeout(() => {
        // 成功的时候调用resolve()
        // resolve('hello world')

        // 失败的时候调用reject()
        reject('error message')
    }, 1000).then(success => {
        console.log(success)
    }).catch(error => {
        console.log(error)
    })
})
```

拿ajax来举例子：

```
new Promise((resolve, reject) => {
    $.ajax({
        success:function(){
            // 成功的时候调用resolve()
            // resolve('hello world')

            // 失败的时候调用reject()
            reject('error message')
        }
    }).then(success => {
        console.log(success)
    }).catch(error => {
        console.log(error)
    })
})
```

#### 2 Promise的三种状态

[![img](https://camo.githubusercontent.com/c93066eef52fa2c3fa52a6bfc63127de45e6a41b/68747470733a2f2f67697465652e636f6d2f6b7269736c696e5f7a68616f2f494d47636c6f75642f7261772f6d61737465722f696d672f32303230303531383039333532332e706e67)](https://camo.githubusercontent.com/c93066eef52fa2c3fa52a6bfc63127de45e6a41b/68747470733a2f2f67697465652e636f6d2f6b7269736c696e5f7a68616f2f494d47636c6f75642f7261772f6d61737465722f696d672f32303230303531383039333532332e706e67)

- pending:等待状态，比如正在进行的网络请求还未响应，或者定时器还没有到时间
- fulfill:满足状态，当我们主动回调了resolve函数，就处于满足状态，并会回调then()
- reject:拒绝状态，当我们主动回调reject函数，就处于该状态，并且会回调catch()

#### 3 Promies的链式调用

1. 网络请求响应结果为 hello ,打印hello
2. 处理： hello world ,打印hello world
3. 处理： hello world，vuejs ,打印hello world，vuejs

```
    new Promise((resolve, reject) => {
      setTimeout(() => {
        resolve('hello')
      }, 1000)
    }).then(res => {
      console.log(res)//打印hello
      return new Promise(resolve => {
          resolve(res + ' world')
      }).then(res => {
        console.log(res)//打印hello world
        return new Promise(resolve => {
          resolve(res + ',vuejs')
        }).then(res => {
          console.log(res)//打印hello world,vuejs
        })
      })
    })
```

链式调用就是`then()`方法的返回值返回一个Promise对象继续调用`then()`，此外还有简写`Promise.resolve()`。

```
new Promise((resolve, reject) => {
      setTimeout(() => {
        resolve('hello')
      }, 1000)
    }).then(res => {
      console.log(res)//打印hello
      return Promise.resolve(res + ' world')
    }).then(res => {
        console.log(res)//打印hello world
        return Promise.resolve(res + ',vuejs')
    }).then(res => {
      console.log(res)//打印hello world,vuejs
    })
```

还可以直接省略掉`Promise.resolve()`

```
    new Promise((resolve, reject) => {
      setTimeout(() => {
        resolve('hello')
      }, 1000)
    }).then(res => {
      console.log(res)//打印hello
      return res + ' world'
    }).then(res => {
        console.log(res)//打印hello world
        return res + ',vuejs'
    }).then(res => {
      console.log(res)//打印hello world,vuejs
    })
```

如果中途发生异常，可以通过`catch()`捕获异常

```
    new Promise((resolve, reject) => {
      setTimeout(() => {
        resolve('hello')
      }, 1000)
    }).then(res => {
      console.log(res)//打印hello
      return res + ' world'
    }).then(res => {
        console.log(res)
        // return Promise.reject('error message')//发生异常
        throw 'error message' //抛出异常
    }).then(res => {
      console.log(res)//打印hello world,vuejs
    }).catch(error => {
      console.log(error)
    })
```

也可以通过`throw`抛出异常，类似java

```
throw 'error message' //抛出异常
```

#### 4 Promies的all使用

有这样一个情况，一个业务需要请求2个地方（A和B）的数据，只有A和B的数据都拿到才能走下一步。

> ajax实现

```
$.ajax({
    ...//结果A
    resultA = true
    callback()
})
$.ajax({
    ...//结果B
    resultB = true
    callback()
})
//回调函数
function callback(){
    if(resultA&&resultB){
        ...
    }
}
```

由于不知道网络请求A和网络请求B哪个先返回结果，所以需要定义一个函数只有2个请求都返回数据才回调成功。

> Promise实现

```
    Promise.all([
      new Promise((resolve, resjct) => {
        $.ajax({
          url: 'url1',
          success: function (data) {
            resolve(data)
          }
        })
      }),
      new Promise((resolve, resjct) => {
        $.ajax({
          url: 'url2',
          success: function (data) {
            resolve(data)
          }
        })
      }).then(results => {
        console.log(results)
      })
    ])
```

上面是伪代码，只是包装了ajax，ajaxA和ajaxB的结果都放在`resolve()`中，Promise将其放在`results`中了，使用`setTimeout`模拟。

```
    Promise.all([
      new Promise((resolve, reject) => {
        setTimeout(() => {//  请求A
          resolve('结果A')
        }, 1000)
      }),
      new Promise((resolve, reject) => {
        setTimeout(() => {//  请求B
          resolve('结果B')
        }, 1000)
      })
    ]).then(results => {
      console.log(results)
    })
```









### 十 常用代码

#### 1 参数跳转

#####  1.1 携带参数跳转1

路由配置 必须为test1页面配置参数属性比如:id

```
{// 数据测试test
  path: '/introduce/test',
  component: resolve => (require(['@/views/introduce/test'], resolve)), // 懒加载
 },
 {// 数据测试test1
  path: '/introduce/test1/:id',
  component: resolve => (require(['@/views/introduce/test1'], resolve)), // 懒加载
 }
```

test.vue 跳转页面

```
     <router-link :to="'/introduce/test1/' + message"
​            tag="button">跳转传参</router-link>
```

test1.vue 接受页面

```
 1）直接获取：
 <el-button type="primary">{{$route.params.id}}</el-button>
 
或者
2）调用computed获取参数：
<el-button type="primary">{{parameter}}</el-button>
  computed: {
    parameter () {
      return this.$route.params.id
    }
  },


```

```

this.$router.push({ path: "/" + m.url });  
//对应子组件: 这样来获取参数
this.$route.params.id
```

##### 1.2 携带参数跳转2

test.vue 跳转页面

```
 <el-button type="primary"
     @click="skip">跳转传参2</el-button>
  <el-table :data="tableData"
  skip () {
      this.$router.push({
        path: '/introduce/test1',
        query: this.message
      })
    },
    
//对应子组件: 这样来获取参数
this.$route.query.id
```

test1.vue 接受页面

```
<el-button type="primary">{{parameter2}}</el-button>
 computed: {
  parameter2 () {
   return this.$route.query
  }
 },
```



##### 1.3 携带参数跳转3 页面刷新数据会丢失

```
   this.$router.push({
          name: 'particulars',
          params: {
            id: id
          }
        })
对应子组件: 这样来获取参数
this.$route.params.id
```

跳转不允许返回

```
`this.$router.replace(path: "/" );`  
```



#### 2 返回上一页

```
 goback: function() {
      this.$router.back(-1);
    },
```

#### 3 input 标签校验

`v-validate="'required|min:6'"` 校验规则

`readonly` 只读

`autocomplete="on"`是启用表单的自动完成功能。如果表单提交成功，那么下一次在表单控件中输入字符时，如果与上一次输入的内容的开头字符相符，表单会自动在控件中显示出上一次输入的内容。比方说你先输入abc并提交成功，然后你下一次输入a时，光标后面会自动出现

`disabled` 禁用及不禁用 返回 `true` `false`

`role`  role的作用是描述一个非标准的tag的实际作用。比如用div做button，那么设置div 的 `role=“button”`，辅助工具就可以认出这实际上是个button
`data-vv-as` - 为字段指定一个漂亮的名称
`data-vv-delay` - 为触发验证指定的延迟时间(单位是毫秒)
`data-vv-name` - 为字段指定一个名称，用于组件验证并作为 inputs 输入框的回退名称
`data-vv-scope` - 为字段指定一个作用域。
`data-vv-value-path` - 指定组件 $data 中的 value 路径，用于检索组件当前值。仅用于组件。
`data-vv-validate-on` - 用于指定由 '|' 分隔的事件名称列表, 默认值因 inputs 输入框类型而异。

`@keyup.enter` 在监听键盘回车事件

##### 3.1 校验全局

`this.$validator.validateAll()`

`this.$refs.tips.show();`　
1、ref 加在普通的元素上，用this.$refs.（ref值） 获取到的是dom元素
2、ref 加在子组件上，用this.$refs.（ref值） 获取到的是组件实例，可以使用组件的所有方法。在使用方法的时候直接this.$refs.（ref值）.方法（） 就可以使用了。

##### 3.2change 事件

`@change="clickcheckbox`" 当元素的值发生改变时,会发生 change 事件

// 自定义验证规则,取名为phone, 通过该方式使用v-validate="'required|phone'"
Validator.extend('phone', {
  // 验证规则，符合规则通过，否则不通过 (规则为美国电话号码)
  validate: (value, ref) => {
    return /^(\d3|^\d{3}[.-]?)?\d{3}[.-]?\d{4}$/.test(value)
  },

#### 4 常用的页面高度获取与页面刷新

##### 4.1 动态获取页面滚动高度

```javascript
mounted(){
     window.addEventListener('scroll',this.scrollHandle);//绑定页面滚动事件
 },
//获取页面滚动高度
methods:{
      scrollHandle(e){
      let top = e.srcElement.scrollingElement.scrollTop;    // 获取页面滚动高度
      console.log(top);
  }
}
```

##### 4.2 监听F11按钮事件

```js
 mounted () {
    window.addEventListener("keydown", this.KeyDown, true)// 监听按键事件
    }

  methods: {
    KeyDown (event) {
      if (event.keyCode === 122) {
        event.returnValue = false
        this.fullScreen()   //触发全屏的按钮
      }
    }}
```

##### 4.3 窗口发生变化时的高度

方式1

```
mounted () {
    const that = this;
    window.onresize = () => {
      return (() => {
        that.screenHeight = window.innerHeight
      })()
    }
  },
  data(){
    return {
      screenHeight: window.innerHeight,
    }
  }
```

方式2

```js
export default {
   data(){
     return {
       screenHeight: window.innerHeight,
     }
   },
    mounted() {
        window.addEventListener('resize', this.onResize);
    },
    beforeDestroy() {
        window.removeEventListener("resize", this.onResize);
    },
    methods: {
        onResize() {
            this.screenHeight = window.innerHeight;
        }
    }
}
```

##### 4.4 控制F5刷新事件

```
 mounted () {
    window.addEventListener("keydown", this.KeyDown, true)// 监听按键事件
    }

  methods: {
    KeyDown (event) {
     var evt = window.event || e;
                    var code = evt.keyCode || evt.which;
                    if (code == 116) {
                        if (evt.preventDefault) {
                            evt.preventDefault();//禁止刷新
                        } else {
                        //放开刷新
                            evt.keyCode = 0;
                            evt.returnValue = false
                        }
      }
    }}
```

##### 4.5 浏览器刷新监听

```js
 mounted () {
        window.addEventListener('beforeunload', e => this.beforeunloadHandler(e))
    }

  methods: {
  //提示框不可修改
 beforeunloadHandler (e) {
      e = e || window.event
      if (e) {
        e.returnValue = '关闭提示'//如果不想显示弹框直接注释此处
      }
      return '关闭提示'//如果不想显示弹框直接注释此处
    }
​    }}
```

##### 4.6 列表定时刷新

```js
data(){
    return {
        intervalId:null
    }
},
methods:{
   // 定时刷新数据函数
    dataRefreh() {
      // 计时器正在进行中，退出函数
      if (this.intervalId != null) {
        return;
      }
      // 计时器为空，操作
      this.intervalId = setInterval(() => {
        console.log("刷新" + new Date());
        this.initData(); //加载数据函数
      }, 5000);
    }, 
    // 停止定时器
    clear() {
      clearInterval(this.intervalId); //清除计时器
      this.intervalId = null; //设置为null
    },
},
created(){
    this.dataRefreh();
},
destroyed(){
    // 在页面销毁后，清除计时器
    this.clear();
}
```

4. 7列表定时 实时刷新

   ```js
   export default {
       data() {
         return {
           list: []  // 获取的数据列表
         }
       }
       created() {
         this.getData()
       }
       methods: {
         // 这是获取数据的函数
         getData() {
           .....
         }
         // 这是一个定时器
         timer() {
           return setTimeout(()=>{
             this.getData()
           },5000)
         }
       },
       watch: {
         list() {
         this.timer() 
         }
       }
       destroyed() {
     clearTimeout(this.timer)
       }
     }
   </script>
   ```

# 生产环境打包运行

`npm run build`
`npm install -g serve`
`serve dist`

粗略记载笔记 详细问题搜索vue官网：https://cn.vuejs.org 

