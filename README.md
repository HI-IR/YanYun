# YanYun（言韵）

红岩寒假考核。 本软件是一款集美言、美图、诗歌分享，收藏于一体的综合性文化内容推荐软件。



## 一、软件介绍

### 功能：

1. 推荐美言好句，优秀诗歌，每日美图

   例：

   ![image](https://github.com/HI-IR/YanYun/blob/master/app/image/1.1.1.gif)

   ![image](https://github.com/HI-IR/YanYun/blob/master/app/image/1.1.2.jpg)

2. 采用Room数据库实现收藏功能，供给用户回味曾经喜欢的美言精句等

​		![image](https://github.com/HI-IR/YanYun/blob/master/app/image/1.2.2.png)

​		![image](https://github.com/HI-IR/YanYun/blob/master/app/image/1.2.3.jpg)

​		![image](https://github.com/HI-IR/YanYun/blob/master/app/image/1.2.4.jpg)

​		![image](https://github.com/HI-IR/YanYun/blob/master/app/image/1.2.5.jpg)

​		![image](https://github.com/HI-IR/YanYun/blob/master/app/image/1.2.6.jpg)

​			



### 使用上

点击左下方的爱心键即可收藏该美言（美图，诗歌）,点击右下角刷新图标即可获取新的美言，诗歌，美图。

在左侧上方多选栏即可进入收藏页

![image](https://github.com/HI-IR/YanYun/blob/master/app/image/1.2.1.gif)

### 使用技术

使用MVP架构

数据库使用room数据库

网络请求使用自己简单写的工具类

使用Gson反序列化



## 二、亮点（加分点）

* 使用MVP架构，完成软件

* 图片加载优化机制：

  因为网络获取的美图分辨率很大，当加载收藏图片时有概率出现卡顿的情况，于是采用了优化机制：当图片被收藏时，在收藏图片的同时使用 Glide 将图片下载为Bitmap，然后对Bitmap进行压缩80%，用Base64编码成字符串后存入数据库中，以压缩图片品质，使得加载更流畅，当查看收藏图片的时候再从数据库中读取图片，以实现图片的缓存

* 融入Room数据库（算不算加分点呀?）



## 三、心得体会

一个月的时光即将悄然落幕。在这段宝贵的时间里，独立完成了一款兼具完整性与实用价值的 APP 从设计到开发的全过程。这一历程，于我而言是收获满满的成长之旅：加深了对java语言的理解，对面对对象编程和接口的回调理解更加深刻，学会了okhttp,gson,room,Retrofit，曾经那些晦涩难懂的概念，思维方式，如今已在实践中变得清晰明了。

更为重要的是，在编写这款 APP 的过程中，我内心深处对编程的热爱被彻底点燃，仿佛置身于一片全新的天地。这短短4个多月的学习，让我几乎从一个比较怯懦容易放弃的人，慢慢变成了一个遇到问题敢于去解决问题，死磕问题的人，从九月初次接触代码时的懵懂，到如今已经可以自信开发出一款简单的App。我想，如果没有踏入红岩，我便无法接触到如此丰富实用的知识，更无缘结识众多热情善良、倾囊相授的学长以及志同道合的同学，也没法获得如今如此明确的目标。在此，我想衷心地说一声：感谢红岩，感谢学长们！



## 四、提升与优化

希望之后深入钻研安卓相关知识体系，学会使用kotlin进行编程，学会jecpack，和mvvm架构，以及更多新技术。在前行的道路上，我将秉持死磕问题的决心，一次次死磕问题，冲破能力边界，突破自我！

