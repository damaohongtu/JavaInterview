Java研发工程师

[TOC]

## 一、计算机网络

#### 1.OSI、TCP/IP、五层体系结构联系与区别？

（1）三种比较？

![](./images/network/compare.png)

（2）七层结构细节？

![](./images/network/qiceng.gif)

（3）每一层对应的设备？

![](./images/network/device.png)

#### 2.说一说TCP/IP协议簇？

![](./images/network/protocol.png)

- 应用层（它是计算机用户，以及各种应用程序和网络之间的接口，其功能是直接向用户提供服务，完成用户希望在网络上完成的各种工作。）
  - SNMP
  - SMTP
- 传输层（向用户提供可靠的端到端的差错和流量控制，保证报文的正确传输。传输层的作用是向高层屏蔽下层数据通信的细节，即向用户透明地传送报文。）
- 网络层（通过路由选择算法，为报文或分组通过通信子网选择最适当的路径。）
  - ICMP
  - IGMP
  - RIP
  - BGP
  - OSPF
- 链路层（通过各种控制协议，将有差错的物理信道变为无差错的、能可靠传输数据帧的数据链路。）
  - ARP，RARP

#### 3.**TCP三次握手的过程？**

```
握手过程可以由客户端调用socket开启，客户端发送SYN和Seq，closed状态变换为SYN_SEND状态，服务器端由LISTEN状态变换为SYN_RECV状态，服务端回送SYN+ACK，客户端接收，客户端状态变为Established，客户端发送ACK，服务端接收到ACK，状态变为Established，至此，TCP三次握手的过程就完成了。
（1）第一次握手：服务端确定（服务端可以接收数据，客户端可以发送数据）
（2）第二次握手：客户端确定（服务端可以接收数据，服务端可以接收数据）
（3）第三次握手：服务端确定（客户端可以接收数据）
以上，（1）（2）（3）是的双方确定彼此可以接收和发送数据。
```

![](./images/network/woshou.png)

#### 4.TCP四次挥手的过程？

```
关闭连接的过程可以由服务端和客户端的任何一方发起，发起的一方状态变化为：Established------>FIN_WAIT_1------>FIN_WAIT_2------>TIME_WAIT------>CLOSED; 
被动关闭的一方的状态变化为Establised------>CLOSE_WAIT------>LAST_ACK------>CLOSED.
```

![](./images/network/huishou.png)

#### 5.TCP在三次握手的过程中是如何超时重传的？

```
(1) 如果第一个包，A发送给B请求建立连接的报文(SYN)如果丢掉了，A会周期性的超时重传，直到B发出确认(SYN+ACK)；
(2) 如果第二个包，B发送给A的确认报文(SYN+ACK)如果丢掉了，B会周期性的超时重传，直到A发出确认(ACK)；
(3) 如果第三个包，A发送给B的确认报文(ACK)如果丢掉了，
	- A在发送完确认报文之后，单方面会进入ESTABLISHED的状态，B还是SYN_RCVD状态
	- 如果此时双方都没有数据需要发送，B会周期性的超时发送(SYN+ACK)，直到收到A的确认报文(ACK)，此时B也进入ESTABLISHED状态，双方可以发送数据；
	- 如果A有数据发送，A发送的是(ACK+DATA)，B会在收到这个数据包的时候自动切换到ESTABLISHED状态，并接受数据(DATA)；
	- 如果这个时候B要发送数据，B是发送不了数据的，会周期性的超时重传(SYN+ACK)直到收到A的确认(ACK)B才能发送数据。
```



#### 6.**为什么要三次握手，四次挥手？**

（1）为什么要进行三次握手？
**这是防止已失效的连接请求报文段突然又传送到了B而引发错误。**
举例，客户端A向服务端B发送数据，受到网络状态的影响，可能A发送的数据B很久以后才收到（实际上A已经通过重传机制重新发送了），当这个阻塞的数据到来的时候，B就会误以为这是一个新的连接，则B将等待A，但是实际上A并没有发起新的请求，这就导致了资源的浪费。
（2）为什么要进行四次挥手？
TCP通信是一个双工通信，在结束连接的时候FIN和ACK是分开发送的，A向B发送FIN仅仅表示A不在发送数据，并不表示自己不在接收数据，同理，B向A发送FIN仅仅表示B不在发送数据，但是自己是可以接收数据的。为什么要在发起端加上TIME_WAIT？是为了保证ACK丢失的时候可以重传。

#### 7.**在浏览器地址栏输入一个url到浏览器返回页面的过程？**

```
（1）浏览器解析地址
（2）DNS
（3）建立TCP连接（三次握手）
（4）得到服务器响应数据，浏览器进行渲染
（5）关闭连接（四次挥手）
```

> - 浏览器分析超链指向页面的 URL。
> - 浏览器向 DNS 请求解析 [www.tsinghua.edu.cn](http://www.tsinghua.edu.cn) 的 IP 地址。
> - 域名系统 DNS 解析出清华大学服务器的 IP 地址。
> - 浏览器与服务器建立 TCP 连接
> - 浏览器发出取文件命令：GET /chn/yxsz/index.htm。
> - 服务器给出响应，把文件 index.htm 发给浏览器。
> - TCP 连接释放。
> - 浏览器显示“清华大学院系设置”文件 index.htm 中的所有文本。

#### 8.**说一说在三次握手的时候可能存在的安全问题？**

```
当第二次握手后，服务端将会进入SYN_RECV状态（又叫做半连接状态），通过伪造客户端的地址，这个时候服务器端一直在等待客户端返回ACK，但是由于地址是伪造的，所以根本就无法收到ACK。当这种伪造的连接数量大的时候就会导致DDOS。
```

#### 9.域名解析

m.xyz.com需要查找y.abc.com的IP地址：

> - 主机m.xyz.com向本地域名服务器进行递归查询。
>
>   > 主机向本地域名服务器查询时一般使用递归查询。
>   >
>   > - **递归查询**：就是如果本地域名服务器没有所需域名的IP地址，本地域名服务器就以客户的方式向其他根域名服务器继续查询，而不是主机自己进行查询。
>   >
>   > 本地域名服务器向其他根域名服务器进行查询的时一般使用迭代查询。
>   >
>   > - **迭代查询：** 当某个根域名服务器收到本地域名服务器的请求报文时，要么告诉它所需域名的IP地址，要么告诉它下一步应该向哪个服务器发起询问。然后让本地域名服务器自己去查询。
>
> - 本地域名服务器迭代查询，先向一个根域名服务器查询。
>
> - 根域名服务器告诉本地域名服务器，下一步应该向顶级域名服务器dns.com查询。
>
> - 顶级域名服务器dns.com告诉本地域名服务器，下一步查找权限域名服务器：dns.adc.com。
>
> - 本地域名服务器向权限域名服务器发起查询。权限域名服务器告诉本地服务器所需的IP地址，本地服务器在告诉给本地主机。

#### 10.**TCP是如何保证可靠传输的？**(分编校丢流拥重超)

   ```
   （1）应用数据被TCP分割成为适合发送的数据块
   （2）TCP将会给每一个包进行编号，接收方会对数据进行排序，将有序的数据传输给应用层。
           序列号：TCP传输时将每个字节的数据都进行了编号，这就是序列号。
           确认应答：TCP传输的过程中，每次接收方收到数据后，都会对传输方进行确认应答。也就是发送ACK报文。这个ACK报文当中带有对应的确认序列号，告诉发送方，接收到了哪些数据，下一次的数据从哪里发。
           序列号的作用不仅仅是应答的作用，有了序列号能够将接收到的数据根据序列号排序，并且去掉重复序列号的数据。这也是TCP传输可靠性的保证之一。
   （3）TCP将会保持首部和数据的校验和，目的是检查数据在传输的过程中是否被修改
   （4）丢弃重复发送的数据
   （5）流量控制：TCP连接的每一方都有一个固定的缓冲空间，TCP的接收端只允许发送端发送接收端缓冲区能够容纳的数据，当接收方来不及处理的时候，能够提示发送端降低发送的速率，防止丢包。（TCP使用的是滑动窗口进行流量控制）
   （6）拥塞控制（当网络阻塞的时候，减少数据的发送，拥塞控制就是防止过多的数据注入到网络中，这样使网络中的路由器或者链路不至于过载。）
   （7）自动重传（为了实现可靠的传输，每发送完一个分组就会停止发送，等待对方确认，确认后再发送下一个分组。）
   （8）超时重传（当TCP发出一个分组后，它将启动一个定时器，等待目的端确认接收，如果不及时，将会重传。）
   ```

   

#### 11.**TCP和UDP之间的区别？**(面头流速可有界)

| 区别     | TCP                                   | UDP                                                          |
| -------- | ------------------------------------- | ------------------------------------------------------------ |
| 面向连接 | 面向连接，**TCP不提供广播和多播服务** | 面向无连接，**UDP支持一对一、多对一、一对多、多对多的交互通信。** |
| 头部大小 | 头部至少为20个字节                    | 头部为8个字节                                                |
| 流量控制 | 有流量控制                            | 没有流量控制                                                 |
| 速度     | TCP速度较慢                           | UDP速度较快                                                  |
| 可靠性   | 可靠传输                              | 不可靠传输                                                   |
| 有序     | 有序                                  | 无序                                                         |
| 界       | TCP有界，通过字节流传输               | UDP无界，每一个包是单独传输的，发送方的UDP对应用程序交下来的报文添加首部后直接交付给IP层。UDP对应用层交下来的报文，既不合并，也不拆分，而是保留这些报文的边界。 |
| 适用场景 | 视频                                  | 文件传输                                                     |



#### 12.post和get的区别？

| 区别   | POST                                                   | GET                               |
| ------ | ------------------------------------------------------ | --------------------------------- |
| 可见性 | 数据在url中不可见                                      | 参数在url中可见                   |
| 长度   | 没有长度限制                                           | 有长度限制                        |
| 编码   | application/x-www-form-urlencoded, multipart/form-data | application/x-www-form-urlencoded |
| 缓存   | 不支持                                                 | 支持                              |
| 安全性 | 相对安全                                               | 相对不安全                        |

 

#### 13.**在TCP和UDP之上都有哪些应用层的协议？**

```
TCP：HTTP，HTTPS，SMTP（简单邮件传输协议），POP3，SSH
UDP：DNS，Telnet，SNMP（简单网络管理协议），IGMP（网络组管理协议）,RIP(路由信息协议)，DHCP（动态主机设置协议）
```



#### 14.**HTTPS握手的过程？**

```
（1）客户端给出一个协议版本号、一个客户端生成的随机数（Client random）以及客户端支持的加密算法。（客户端发送了三件东西）
（2）服务端确认双方使用的加密算法，并且给出数字证书，以及一个随机数（server random）。（服务端发送了两件东西）
（3）客户端确认数字证书有效，然后生成一个新的随机数（Premaster secret），并且使用数字证书中的公钥，加密这个随机数，将其发送给服务端。（客户端发送了一个非对称加密的随机数）
（4）服务端使用自己的私钥，获取来自客户端的加密随机数（Premaster secret）。（服务端使用非对称加密算法进行解密）
（5）客户端和服务端根据约定的加密方法，使用前面的三个随机数，生成对话密钥（session key），用来加密整个会话。（服务端使用对称密钥会话）
```



#### 15.**TCP头部，UDP头部比较？**

（1）TCP头部至少由20个字节构成（最长60个），如下图：

![]()

<img src="./images/network/tcp.png" width="500"/>

（2）UDP头部由8个字节构成，如下图：

![](./images/network/udp.png)

#### 16.IP头部



<img src="./images/network/ip.png" width="500"/>

#### 17.HTTP请求，HTTP响应，字段？

（1）HTTP请求

- 请求行
  - 方法，url，协议版本
- 请求首部字段
- 空行（这一个空行一定存在）
- 内容实体

![](./images/network/request.png)

（2）HTTP响应

- 响应行
  - 协议版本，响应状态码，原因短语
- 响应首部字段
- 空行
- 内容实体

（3）字段

- 通用头（通用头域包含请求和响应消息都支持的头域，通用头域包含缓存头部Cache-Control、Pragma及信息性头部Connection、Date、Transfer-Encoding、Update、Via）

| 名字                  | 含义                                                         |
| :-------------------- | ------------------------------------------------------------ |
| **Date**              | Date头域表示消息发送的时间，服务器响应中要包含这个头部，因为缓存在评估响应的新鲜度时要用到，其时间的描述格式由RFC822定义。例如，Date:Mon,31 Dec 2001 04:25:57 GMT。Date描述的时间表示世界标准时，换算成本地时间，需要知道用户所在的时区。 |
| **Transfer-Encoding** | WEB 服务器表明自己对本响应消息体（不是消息体里面的对象）作了怎样的编码，比如是否分块（chunked），例如：Transfer-Encoding: chunked |
| **Pragma**            | Pragma头域用来包含实现特定的指令，最常用的是Pragma:no-cache。在HTTP/1.1协议中，它的含义和Cache- Control:no-cache相同。 |
| **Connection**        | Connection表示是否需要持久连接。                             |
| **Cache-Control**     | Cache-Control指定请求和响应遵循的缓存机制。在请求消息或响应消息中设置 Cache-Control并不会修改另一个消息处理过程中的缓存处理过程。请求时的缓存指令包括no-cache、no-store、max-age、max-stale、min-fresh、only-if-cached，响应消息中的指令包括public、private、no-cache、no-store、no-transform、must-revalidate、proxy-revalidate、max-age。 |
| **Upgrade**           | 它可以指定另一种可能完全不同的协议，如HTTP/1.1客户端可以向服务器发送一条HTTP/1.0请求，其中包含值为“HTTP/1.1”的Update头部，这样客户端就可以测试一下服务器是否也使用HTTP/1.1了。 |
| **Via**               | 列出从客户端到 OCS 或者相反方向的响应经过了哪些代理服务器，他们用什么协议（和版本）发送的请求。 |

- HTTP请求头（请求头用于说明是谁或什么在发送请求、请求源于何处，或者客户端的喜好及能力。服务器可以根据请求头部给出的客户端信息，试着为客户端提供更好的响应。）

| 名字                    | 含义                                                         |
| ----------------------- | ------------------------------------------------------------ |
| **Accept**              | 告诉WEB服务器自己接受什么介质类型，*/* 表示任何类型，type/* 表示该类型下的所有子类型，type/sub-type。 |
| **Accept-Charset**      | 浏览器告诉服务器自己能接收的字符集。                         |
| **Accept-Encoding**     | 浏览器申明自己接收的编码方法，通常指定压缩方法，是否支持压缩，支持什么压缩方法（gzip，deflate）。 |
| **Accept-Language**     | 浏览器申明自己接收的语言。语言跟字符集的区别：中文是语言，中文有多种字符集，比如big5，gb2312，gbk等等。 |
| **Authorization**       | 当客户端接收到来自WEB服务器的 WWW-Authenticate 响应时，用该头部来回应自己的身份验证信息给WEB服务器。 |
| **If-Match**            | 如果对象的 ETag 没有改变，其实也就意味著对象没有改变，才执行请求的动作，获取文档。 |
| **If-None-Match**       | 如果对象的 ETag 改变了，其实也就意味著对象也改变了，才执行请求的动作，获取文档。 |
| **If-Modified-Since**   | 如果请求的对象在该头部指定的时间之后修改了，才执行请求的动作（比如返回对象），否则返回代码304，告诉浏览器该对象没有修改。例如：If-Modified-Since：Thu, 10 Apr 2008 09:14:42 GMT |
| **If-Unmodified-Since** | 如果请求的对象在该头部指定的时间之后没修改过，才执行请求的动作（比如返回对象）。 |
| **If-Range**            | 浏览器告诉 WEB 服务器，如果我请求的对象没有改变，就把我缺少的部分给我，如果对象改变了，就把整个对象给我。浏览器通过发送请求对象的ETag 或者自己所知道的最后修改时间给 WEB 服务器，让其判断对象是否改变了。总是跟 Range 头部一起使用。 |
| **Range**               | 浏览器（比如 Flashget 多线程下载时）告诉 WEB 服务器自己想取对象的哪部分。例如：Range: bytes=1173546 |
| **Proxy-Authenticate**  | 代理服务器响应浏览器，要求其提供代理身份验证信息。           |
| **Proxy-Authorization** | 浏览器响应代理服务器的身份验证请求，提供自己的身份信息。     |
| **Host**                | 客户端指定自己想访问的WEB服务器的域名/IP 地址和端口号。如Host：rss.sina.com.cn |
| **Referer**             | 浏览器向WEB 服务器表明自己是从哪个网页URL获得点击当前请求中的网址/URL，例如：Referer：[http://www.jb51.net](http://www.jb51.net/) |
| **User-Agent**          | 浏览器表明自己的身份（是哪种浏览器）。例如：User-Agent：Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN;rv:1.8.1.14) Gecko/20080404 Firefox/2.0.0.14 |

- HTTP响应头（响应头向客户端提供一些额外信息，比如谁在发送响应、响应者的功能，甚至与响应相关的一些特殊指令。这些头部有助于客户端处理响应，并在将来发起更好的请求。）

| 名字              | 含义                                                         |
| ----------------- | ------------------------------------------------------------ |
| **Age**           | 当代理服务器用自己缓存的实体去响应请求时，用该头部表明该实体从产生到现在经过多长时间了。 |
| **Server**        | WEB 服务器表明自己是什么软件及版本等信息。例如：Server：Apache/2.0.61 (Unix) |
| **Accept-Ranges** | WEB服务器表明自己是否接受获取其某个实体的一部分（比如文件的一部分）的请求。bytes：表示接受，none：表示不接受。 |
| **Vary**          | WEB服务器用该头部的内容告诉 Cache 服务器，在什么条件下才能用本响应所返回的对象响应后续的请求。假如源WEB服务器在接到第一个请求消息时，其响应消息的头部为：Content-Encoding:gzip; Vary: Content-Encoding，那么Cache服务器会分析后续请求消息的头部，检查其Accept-Encoding，是否跟先前响应的Vary头部值一致，即是否使用相同的内容编码方法，这样就可以防止Cache服务器用自己Cache里面压缩后的实体响应给不具备解压能力的浏览器。例如：Vary：Accept-Encoding。 |

- HTTP实体头部（实体头部提供了有关实体及其内容的大量信息，从有关对象类型的信息，到能够对资源使用的各种有效的请求方法。总之，实体头部可以告知接收者它在对什么进行处理。请求消息和响应消息都可以包含实体信息，实体信息一般由实体头域和实体组成。实体头域包含关于实体的原信息，实体头包括信息性头部Allow、Location，内容头部Content-Base、Content-Encoding、Content-Language、Content-Length、Content-Location、Content-MD5、Content-Range、Content-Type，缓存头部Etag、Expires、Last-Modified、extension-header。）

| 名字                 | 含义                                                         |
| -------------------- | ------------------------------------------------------------ |
| **Allow**            | 服务器支持哪些请求方法（如GET、POST等）。                    |
| **Location**         | 表示客户应当到哪里去提取文档，用于将接收端定位到资源的位置（URL）上。Location通常不是直接设置的，而是通过HttpServletResponse的sendRedirect方法，该方法同时设置状态代码为302。 |
| **Content-Base**     | 解析主体中的相对URL时使用的基础URL。                         |
| **Content-Encoding** | WEB服务器表明自己使用了什么压缩方法（gzip，deflate）压缩响应中的对象。例如：Content-Encoding：gzip |
| **Content-Language** | WEB 服务器告诉浏览器理解主体时最适宜使用的自然语言。         |
| **Content-Length**   | WEB服务器告诉浏览器自己响应的对象的长度或尺寸，例如：Content-Length: 26012 |
| **Content-Location** | 资源实际所处的位置。                                         |
| **Content-MD5**      | 主体的MD5校验和。                                            |
| **Content-Range**    | 实体头用于指定整个实体中的一部分的插入位置，他也指示了整个实体的长度。在服务器向客户返回一个部分响应，它必须描述响应覆盖的范围和整个实体长度。一般格式：Content-Range:bytes-unitSPfirst-byte-pos-last-byte-pos/entity-legth。例如，传送头500个字节次字段的形式：Content-Range:bytes0-499/1234如果一个http消息包含此节（例如，对范围请求的响应或对一系列范围的重叠请求），Content-Range表示传送的范围，Content-Length表示实际传送的字节数。 |
| **Content-Type**     | WEB 服务器告诉浏览器自己响应的对象的类型。例如：Content-Type：application/xml |
| **Etag**             | 就是一个对象（比如URL）的标志值，就一个对象而言，比如一个html文件，如果被修改了，其Etag也会别修改，所以，ETag的作用跟Last-Modified的作用差不多，主要供WEB服务器判断一个对象是否改变了。比如前一次请求某个html文件时，获得了其<br/>ETag，当这次又请求这个文件时，浏览器就会把先前获得ETag值发送给WEB服务器，然后WEB服务器会把这个ETag跟该文件的当前ETag进行对比，然后就知道这个文件有没有改变了。 |
| **Expires**          | WEB服务器表明该实体将在什么时候过期，对于过期了的对象，只有在跟WEB服务器验证了其有效性后，才能用来响应客户请求。是 HTTP/1.0 的头部。例如：Expires：Sat, 23 May 2009 10:02:12 GMT |
| **Last-Modified**    | WEB服务器认为对象的最后修改时间，比如文件的最后修改时间，动态页面的最后产生时间等等。例如：Last-Modified：Tue, 06 May 2008 02:42:43 GMT |



#### 18.HTTP1.0，HTTP1.1，HTTP2.0之间的区别？

```
（1）HTTP1.0：
- 无法复用连接
- 对头阻塞（head of line blocking）

（2）HTTP1.1：
- 长连接（在头部加入了connection：keep-alive）
- 管道化（将请求队列移动到服务端队列）
- 缓存机制（引入了新的字段cache-control，支持断点重传）
- 增加了host字段（使得一个服务器可创建多个站点）
（3）HTTP2.0：
- 二进制分帧
- 多路复用（消息由一个帧或者多个帧组成，可以乱序进行发送，之后使用帧的stream id进行重组，二进制分帧使得多路复用成为可能，多路复用实现真正的并发）
- 头部压缩，通信双方保存header filed表
- 服务器推送（不用客户端进行明确请求）
```

**新HTTP1.0与HTTP1.1区别：**

> HTTP1.0最早在网页中使用是在1996年，那个时候只是使用一些较为简单的网页上和网络请求上，而HTTP1.1则在1999年才开始广泛应用于现在的各大浏览器网络请求中，同时HTTP1.1也是当前使用最为广泛的HTTP协议。 主要区别主要体现在：
>
> - **缓存处理**，在HTTP1.0中主要使用header里的If-Modified-Since,Expires来做为缓存判断的标准，HTTP1.1则引入了更多的缓存控制策略例如Entity  tag，If-Unmodified-Since, If-Match, If-None-Match等更多可供选择的缓存头来控制缓存策略。
> - **带宽优化及网络连接的使用**，HTTP1.0中，存在一些浪费带宽的现象，例如客户端只是需要某个对象的一部分，而服务器却将整个对象送过来了，并且不支持断点续传功能，HTTP1.1则在请求头引入了range头域，它允许只请求资源的某个部分，即返回码是206（Partial  Content），这样就方便了开发者自由的选择以便于充分利用带宽和连接。
> - **错误通知的管理**，在HTTP1.1中新增了24个错误状态响应码，如409（Conflict）表示请求的资源与资源的当前状态发生冲突；410（Gone）表示服务器上的某个资源被永久性的删除。
> - **Host头处理**，在HTTP1.0中认为每台服务器都绑定一个唯一的IP地址，因此，请求消息中的URL并没有传递主机名（hostname）。但随着虚拟主机技术的发展，在一台物理服务器上可以存在多个虚拟主机（Multi-homed  Web  Servers），并且它们共享一个IP地址。HTTP1.1的请求消息和响应消息都应支持Host头域，且请求消息中如果没有Host头域会报告一个错误（400  Bad Request）。
> - **长连接、持续连接**，HTTP  1.1支持长连接（PersistentConnection）和请求的流水线（Pipelining）处理，在一个TCP连接上可以传送多个HTTP请求和响应，减少了建立和关闭连接的消耗和延迟，在HTTP1.1中默认开启Connection：  keep-alive，一定程度上弥补了HTTP1.0每次请求都要创建连接的缺点。

**HTTP1.1与HTTP2.0的区别：**

> - **新的二进制格式**（Binary  Format），HTTP1.x的解析是基于文本。基于文本协议的格式解析存在天然缺陷，文本的表现形式有多样性，要做到健壮性考虑的场景必然很多，二进制则不同，只认0和1的组合。基于这种考虑HTTP2.0的协议解析决定采用二进制格式，实现方便且健壮。
> - **多路复用**（MultiPlexing），即连接共享，即每一个request都是是用作连接共享机制的。一个request对应一个id，这样一个连接上可以有多个request，每个连接的request可以随机的混杂在一起，接收方可以根据request的  id将request再归属到各自不同的服务端请求里面。
> - **header压缩**，如上文中所言，对前面提到过HTTP1.x的header带有大量信息，而且每次都要重复发送，HTTP2.0使用encoder来减少需要传输的header大小，通讯双方各自cache一份header  fields表，既避免了重复header的传输，又减小了需要传输的大小。
> - **服务端推送**（server push），同SPDY一样，HTTP2.0也具有server push功能

#### 19.cookie和session的区别？**

（1）cookie数据存放在客户的浏览器上，session存放在服务器上。

（2）cookie不是安全的，别人可以分析存放在本地的cookie进行cookie欺骗。

（3）session会一定时间内存放在服务器上，当访问次数增多的时候，会影响性能。

（4）单个cookie保存的数据不会超过4K，很多浏览器限制一个站点的cookie数目不超过20个。

#### 20.**状态码？**

（1）概括：

|      | 类别                             | 原因短语                   |
| ---- | -------------------------------- | -------------------------- |
| 1XX  | Informational（信息状态码）      | 接收的请求正在处理         |
| 2XX  | Success（成功状态码）            | 请求正常处理完毕           |
| 3XX  | Redirection（重定向状态码）      | 需要进行附加操作以完成请求 |
| 4XX  | Client Error（客户端错误状态码） | 服务器无法处理请求         |
| 5XX  | Server Error（服务器错误状态码） | 服务器处理请求出错         |

（2）细节

| 状态码 | 状态码英文名称                  | 中文描述                                                     |
| ------ | ------------------------------- | ------------------------------------------------------------ |
| 100    | Continue                        | 继续。客户端应继续其请求                                     |
| 101    | Switching Protocols             | 切换协议。服务器根据客户端的请求切换协议。只能切换到更高级的协议，例如，切换到HTTP的新版本协议 |
|        |                                 |                                                              |
| 200    | OK                              | 请求成功。一般用于GET与POST请求                              |
| 201    | Created                         | 已创建。成功请求并创建了新的资源                             |
| 202    | Accepted                        | 已接受。已经接受请求，但未处理完成                           |
| 203    | Non-Authoritative Information   | 非授权信息。请求成功。但返回的meta信息不在原始的服务器，而是一个副本 |
| 204    | No Content                      | 无内容。服务器成功处理，但未返回内容。在未更新网页的情况下，可确保浏览器继续显示当前文档 |
| 205    | Reset Content                   | 重置内容。服务器处理成功，用户终端（例如：浏览器）应重置文档视图。可通过此返回码清除浏览器的表单域 |
| 206    | Partial Content                 | 部分内容。服务器成功处理了部分GET请求                        |
|        |                                 |                                                              |
| 300    | Multiple Choices                | 多种选择。请求的资源可包括多个位置，相应可返回一个资源特征与地址的列表用于用户终端（例如：浏览器）选择 |
| 301    | Moved Permanently               | 永久移动。请求的资源已被永久的移动到新URI，返回信息会包括新的URI，浏览器会自动定向到新URI。今后任何新的请求都应使用新的URI代替 |
| 302    | Found                           | 临时移动。与301类似。但资源只是临时被移动。客户端应继续使用原有URI |
| 303    | See Other                       | 查看其它地址。与301类似。使用GET和POST请求查看               |
| 304    | Not Modified                    | 未修改。所请求的资源未修改，服务器返回此状态码时，不会返回任何资源。客户端通常会缓存访问过的资源，通过提供一个头信息指出客户端希望只返回在指定日期之后修改的资源 |
| 305    | Use Proxy                       | 使用代理。所请求的资源必须通过代理访问                       |
| 306    | Unused                          | 已经被废弃的HTTP状态码                                       |
| 307    | Temporary Redirect              | 临时重定向。与302类似。使用GET请求重定向                     |
|        |                                 |                                                              |
| 400    | Bad Request                     | 客户端请求的语法错误，服务器无法理解                         |
| 401    | Unauthorized                    | 请求要求用户的身份认证                                       |
| 402    | Payment Required                | 保留，将来使用                                               |
| 403    | Forbidden                       | 服务器理解请求客户端的请求，但是拒绝执行此请求               |
| 404    | Not Found                       | 服务器无法根据客户端的请求找到资源（网页）。通过此代码，网站设计人员可设置"您所请求的资源无法找到"的个性页面 |
| 405    | Method Not Allowed              | 客户端请求中的方法被禁止                                     |
| 406    | Not Acceptable                  | 服务器无法根据客户端请求的内容特性完成请求                   |
| 407    | Proxy Authentication Required   | 请求要求代理的身份认证，与401类似，但请求者应当使用代理进行授权 |
| 408    | Request Time-out                | 服务器等待客户端发送的请求时间过长，超时                     |
| 409    | Conflict                        | 服务器完成客户端的 PUT 请求时可能返回此代码，服务器处理请求时发生了冲突 |
| 410    | Gone                            | 客户端请求的资源已经不存在。410不同于404，如果资源以前有现在被永久删除了可使用410代码，网站设计人员可通过301代码指定资源的新位置 |
| 411    | Length Required                 | 服务器无法处理客户端发送的不带Content-Length的请求信息       |
| 412    | Precondition Failed             | 客户端请求信息的先决条件错误                                 |
| 413    | Request Entity Too Large        | 由于请求的实体过大，服务器无法处理，因此拒绝请求。为防止客户端的连续请求，服务器可能会关闭连接。如果只是服务器暂时无法处理，则会包含一个Retry-After的响应信息 |
| 414    | Request-URI Too Large           | 请求的URI过长（URI通常为网址），服务器无法处理               |
| 415    | Unsupported Media Type          | 服务器无法处理请求附带的媒体格式                             |
| 416    | Requested range not satisfiable | 客户端请求的范围无效                                         |
| 417    | Expectation Failed              | 服务器无法满足Expect的请求头信息                             |
|        |                                 |                                                              |
| 500    | Internal Server Error           | 服务器内部错误，无法完成请求                                 |
| 501    | Not Implemented                 | 服务器不支持请求的功能，无法完成请求                         |
| 502    | Bad Gateway                     | 作为网关或者代理工作的服务器尝试执行请求时，从远程服务器接收到了一个无效的响应 |
| 503    | Service Unavailable             | 由于超载或系统维护，服务器暂时的无法处理客户端的请求。延时的长度可包含在服务器的Retry-After头信息中 |
| 504    | Gateway Time-out                | 充当网关或代理的服务器，未及时从远端服务器获取请求           |
| 505    | HTTP Version not supported      | 服务器不支持请求的HTTP协议的版本，无法完成处理               |

**1XX——表示通知信息，如请求收到了或正在进行处理**

**2XX——表明请求被正常处理了**

> - 200 OK：请求已正常处理。
> - 204 No Content：请求处理成功，但没有任何资源可以返回给客户端，一般在只需要从客户端往服务器发送信息，而对客户端不需要发送新信息内容的情况下使用。
> - 206 Partial Content：是对资源某一部分的请求，该状态码表示客户端进行了范围请求，而服务器成功执行了这部分的GET请求。响应报文中包含由Content-Range指定范围的实体内容。

**3XX——表明浏览器需要执行某些特殊的处理以正确处理请求**

> - 301 Moved Permanently：资源的uri已更新，你也更新下你的书签引用吧。永久性重定向，请求的资源已经被分配了新的URI，以后应使用资源现在所指的URI。
> - 302 Found：资源的URI已临时定位到其他位置了，姑且算你已经知道了这个情况了。临时性重定向。和301相似，但302代表的资源不是永久性移动，只是临时性性质的。换句话说，已移动的资源对应的URI将来还有可能发生改变。
> - 303  See  Other：资源的URI已更新，你是否能临时按新的URI访问。该状态码表示由于请求对应的资源存在着另一个URL，应使用GET方法定向获取请求的资源。303状态码和302状态码有着相同的功能，但303状态码明确表示客户端应当采用GET方法获取资源，这点与302状态码有区别。当301,302,303响应状态码返回时，几乎所有的浏览器都会把POST改成GET，并删除请求报文内的主体，之后请求会自动再次发送。
> - 304  Not  Modified：资源已找到，但未符合条件请求。该状态码表示客户端发送附带条件的请求时（采用GET方法的请求报文中包含If-Match，If-Modified-Since，If-None-Match，If-Range，If-Unmodified-Since中任一首部）服务端允许请求访问资源，但因发生请求未满足条件的情况后，直接返回304。
> - 307 Temporary Redirect：临时重定向。与302有相同的含义。

**4XX——表明客户端是发生错误的原因所在。**

> - 400 Bad Request：服务器端无法理解客户端发送的请求，请求报文中可能存在语法错误。
> - 401 Unauthorized：该状态码表示发送的请求需要有通过HTTP认证（BASIC认证，DIGEST认证）的认证信息。
> - 403 Forbidden：不允许访问那个资源。该状态码表明对请求资源的访问被服务器拒绝了。（权限，未授权IP等）
> - 404 Not Found：服务器上没有请求的资源。路径错误等。

**5XX——服务器本身发生错误**

> - 500 Internal Server Error：貌似内部资源出故障了。该状态码表明服务器端在执行请求时发生了错误。也有可能是web应用存在bug或某些临时故障。
> - 503 Service Unavailable：抱歉，我现在正在忙着。该状态码表明服务器暂时处于超负载或正在停机维护，现在无法处理请求。

#### 21.TCP是如何实现面向连接的？面向连接和非面向连接的区别？

（1）状态和序列号，以及错误校验。描述TCP和UDP头之间的差异！

#### 22.TCP的拥塞控制？（重传就可能导致拥塞）

（1）慢启动？

（2）拥塞避免？

（3）快重传？

（4）快恢复？

TCP通过**慢启动、拥塞避免、快重传以及快恢复**这四个算法来进行拥塞控制：

> - **慢启动：**一开始先设置一个比较小的拥塞窗口值cwnd（报文段的倍数），然后进行数据传输，每收到一个报文段的确认，我们就将**cwnd+1**，这样下来，cwnd总体上是乘以**2^n**的倍数增长。（慢启动非增长速度慢，只是增长的初始基数比较小）
> - **拥塞避免：** 因为慢启动算法的增长比较快，当cwnd = ssthresh（预先设置好的门限值）时，我们启动拥塞避免算法，窗口值开始线性增长。
>
> > 随着拥塞避免算法的进行，网络出现超时的情况（这时判断为**拥塞出现**）。这时将cwnd降为一开始的值，重新进行**慢开始-拥塞避免**，并且此时的门限值设为出现拥塞时的cwnd的一半。
>
> - **快重传：** 快重传的目的是为了让发送方尽早知道某个报文段的丢失。如何知道呢？**当我们重复收到某一个报文段的3次确认时，我们就可以判断，它的下一个报文段可能出现了丢失**。这时我们启动快重传算法，立即重传丢失的报文段。
> - **快恢复：** 上面快重传算法的启动只是因为个别报文段的丢失，我们这时并不判断为网络拥塞，而是启动快恢复算法。我们将cwnd=ssthresh=当前cwnd的一半，并且开始拥塞避免算法。
>
> > 当然，也有的快恢复算法是将当前拥塞窗口再增大3个报文段的值，因为既然收到了3个重复的ACK，则说明有三个分组已经离开了网络，不在占用网络资源而是停留在对方缓存当中，可以适当将窗口值增大。

<img src="./images/network/yongsekongzhi.png" width=500/>

#### 23.TCP的流量控制？

滑动窗口协议

#### 24.重传算法？

SACK方法

- 为了解决快速重传的缺点，一种更好的SACK重传策略被提出
- 基于快速重传，同时在tcp头里加了一个SACK的东西
- 解决了什么问题：客户端应该发送哪些超时包的问题

#### 25.路由算法？

（1）路由：找到任意两个节点之间开销最小的路径。

（2）距离向量，链路状态

- 距离向量：网络中没有任何一个节点知道整张表的信息，自己只知道它自己的路由表的内容。好处：所有的节点在没有任何集中授权的额情况下取得网络的一致视图。（RIP协议）
- 链路状态：每一个节点都有足够的信息构建完整的网络映象。（OSPF协议，开放最短路径优先），路由的计算采用迪杰特斯拉算法进行计算。

#### 26.IP数据报格式？

<img src="./images/network/ip.png" width="500"/>

#### 27.ABC类地址

> - A、B、C类IP地址的网络号字段分别是1、2、3个字节长，而在网络号的1-3位是类别位，分别是：0、10、110。
> - A、B、C类IP地址的主机号字段分别为3、2、1个字节。
> - A、B、C类IP地址是单播地址，D类IP地址（前四位为1110）为多播地址，E类IP地址（前四位1111）保留为以后使用。
> - A类地址的网络号中：全0和127是不指派的；主机号中：全0代表本主机所连接的单个网络地址，全1代表网络上的所有主机，也是不指派的。
> - B类IP地址网络号中：**128.0.0.0不指派**；主机号中：全0和全1也不指派。
> - C类IP地址网络号中：**192.0.0.0不指派**；主机号中：全0和全1也不指派。

#### 28.端口号

| 应用程序   | FTP  | TELNET | SMTP | DNS  | TFTP | HTTP | SNMP | SNMP(trap) | HTTPS |
| ---------- | ---- | ------ | ---- | ---- | ---- | ---- | ---- | ---------- | ----- |
| 熟知端口号 | 21   | 23     | 25   | 53   | 69   | 80   | 161  | 162        | 443   |

#### 29.滑动窗口（解决的是速率不匹配问题）

- 解决了什么问题：发送方和接收方速率不匹配时，保证可靠传输和包乱序的问题

- 机制：接收方根据目前缓冲区大小，通知发送方目前能接收的最大值。发送方根据接收方的处理能力来发送数据。通过这种协调机制，防止接收端处理不过来。

- 窗口大小：接收方发给发送端的这个值称为窗口大小

#### 30.拥塞窗口（控制的是发送方）

- 解决什么问题：发送方发送速度过快，导致中转路由器拥堵的问题
- 机制：发送方增加一个拥塞窗口（cwnd），每次受到ack，窗口值加1。发送时，取拥塞窗口和接收方发来的窗口大小取最小值发送
- 起到发送方流量控制的作用

#### 31.细节

- MIME (*M*ultipurpose *I*nternet *M*ail *E*xtensions) 是描述消息内容类型的因特网标准。
- Request For Comments（*RFC*），是一系列以编号排定的文件。文件收集了有关互联网相关信息，以及UNIX和互联网社区的软件文件。
- RIP使用UDP，OSPF使用IP,而BGP使用TCP。
  - OSPF本身提供主从协商机制，可以保证可靠的传输，另外全网路由器保持着同样的一个LSDB（链路状态数据库），当拓扑发生变化时，需要携带的变更信息较少，
  - 通过IP协议即可完成RIP协议采用UDP是因为RIP每周期需全网组播路由信息，路由信息数目较大，故使用UDP协议可以提高效率
  - BGP为边界网关协议，因携带的路由信息较多，且可能跨不同网络传送路由信息，为保证可靠性，需使用TCP协议，可兼顾容量和可靠性

## 二、操作系统

### （一）基础

#### 1.原码、补码、反码

- 原码：原码用第一位表示符号, 其余位表示值. 比如如果是8位二进制
- 补码
  - 正数：正数的补码就是其本身
  - 负数：负数的补码是在其原码的基础上, 符号位不变, 其余各位取反, 最后+1。 (即在反码的基础上+1)
- 反码
  - 正数：正数的反码是其本身
  - 负数：负数的反码是在其原码的基础上, 符号位不变，其余各个位取反.

### （二）并发

#### 1.进程、线程、管程、协程？

（1）线程和进程

线程是程序执行的一条路径，在多线程的OS中，线程是调度和分配的基本单位，而进程是拥有资源的基本单位。结合Java的内存区域==（线程共享和线程私有）。==

```java
package JavaDemo.MultiThreadTest;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @Author MaoTian
 * @Classname MultiThread
 * @Description 查看有哪些线程
 *
 * [5] Monitor Ctrl-Break
 * [4] Signal Dispatcher
 * [3] Finalizer
 * [2] Reference Handler
 * [1] main
 *
 * @Date 下午9:23 2019/8/13
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
public class MultiThread {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean= ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos=threadMXBean.dumpAllThreads(false,false);
        for (ThreadInfo threadInfo:threadInfos){
            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
        }
    }
}
```



（2）线程的属性

> - **轻型实体**：线程中的实体基本上不拥有系统资源，只是有一点必不可少的、能保证独立运行的资源。线程的实体包括==程序、数据和TCB==。线程是动态概念，它的动态特性由线程控制块TCB（Thread Control Block）描述。==TCB包括以下信息：==
>- 线程状态。
>   - 当线程不运行时，被保存的现场资源。
>   - 一组执行堆栈。
>   - 存放每个线程的局部变量主存区。
>   - 访问同一个进程中的主存和其它资源。
> 
>用于指示被执行指令序列的程序计数器、保留局部变量、少数状态参数和返回地址等的一组寄存器和堆栈。
>   
>- **独立调度和分派的基本单位**：在多线程OS中，线程是能独立运行的基本单位，因而也是独立调度和分派的基本单位。由于线程很“轻”，故线程的切换非常迅速且开销小（在同一进程中的）。
> 
>- **可并发执行**：在一个进程中的多个线程之间，可以并发执行，甚至允许在一个进程中所有线程都能并发执行；同样，不同进程中的线程也能并发执行，充分利用和发挥了处理机与外围设备并行工作的能力。
> 
>- **共享进程资源**：在同一进程中的各个线程，都可以共享该进程所拥有的资源，这首先表现在：所有线程都具有相同的地址空间（进程的地址空间），这意味着，线程可以访问该地址空间的每一个虚地址；此外，还可以访问进程所拥有的已打开文件、定时器、信号量机构等。由于同一个进程内的线程共享内存和文件，所以线程之间互相通信不必调用内核。

#### 2.进程之间的通信？（套共消，管信信）

（1）套接字

（2）共享内存

（3）消息队列

（4）管程

（5）信号

（6）信号量

> **信号量**
>
> 是一个确定的二元组（s，q），其中s是一个具有非负初值的整形变量，q是一个初始状态为空的队列，整形变量s表示系统中某类资源的数目：
>
> - 当其值 `>= 0` 时，表示系统中当前可用资源的数目
> - 当其值 `< 0` 时，其绝对值表示系统中因请求该类资源而被阻塞的进程数目
>
> 除信号量的初值外，信号量的值仅能由P操作和V操作更改，操作系统利用它的状态对进程和资源进行管理
>
> ##### P操作
>
> P操作记为P(s)，其中s为一信号量，它执行时主要完成以下动作：
>
> ```
> s.value = s.value - 1；  /*可理解为占用1个资源，若原来就没有则记帐“欠”1个*/
> ```
>
> 若`s.value ≥ 0`，则进程继续执行，否则（即s.value < 0），则进程被阻塞，并将该进程插入到信号量s的等待队列s.queue中
>
> > 实际上，P操作可以理解为分配资源的计数器，或是使进程处于等待状态的控制指令
>
> ##### V操作
>
> V操作记为V(s)，其中s为一信号量，它执行时，主要完成以下动作：
>
> ```
> s.value = s.value + 1；/*可理解为归还1个资源，若原来就没有则意义是用此资源还1个欠帐*/
> ```
>
> 若`s.value > 0`，则进程继续执行，否则（即s.value ≤ 0），则从信号量s的等待队s.queue中移出第一个进程，使其变为就绪状态，然后返回原进程继续执行
>
> > 实际上，V操作可以理解为归还资源的计数器，或是唤醒进程使其处于就绪状态的控制指令      

#### 3.信号和信号量之间的区别？

- 信号量：（Semaphore）进程间通信处理同步互斥的机制。是在多线程环境下使用的一种设施, 它负责协调各个线程, 以保证它们能够正确、合理的使用公共资源。（特点，pv操作，用于同步进程）
- 信号：（signal）是一种处理异步事件的方式。信号是比较复杂的通信方式，用于通知接受进程有某种事件发生，除了用于进程外，还可以发送信号给进程本身。（特点，通知）

#### 4.线程之间的通信？

（1）锁机制

（2）信号量机制

（3）信号机制

#### 5.死锁产生的条件？

（1）互斥

（2）请求与保持:指进程已经保持至少一个资源，但又提出了新的资源请求，而该资源已被其它进程占有，此时请求进程阻塞，但又对自己已获得的其它资源保持不放。

（3）循环等待

（4）不可剥夺

#### 6.死锁的解除和预防的方法？

- 死锁避免:银行家算法

> 我们只要破坏产生死锁的四个条件中的其中一个就可以了。
>
> **破坏互斥条件**
>
> 这个条件我们没有办法破坏，因为我们用锁本来就是想让他们互斥的（临界资源需要互斥访问）。
>
> **破坏请求与保持条件**
>
> 一次性申请所有的资源。
>
> **破坏不剥夺条件**
>
> 占用部分资源的线程进一步申请其他资源时，如果申请不到，可以主动释放它占有的资源。
>
> **破坏循环等待条件**
>
> 靠按序申请资源来预防。按某一顺序申请资源，释放资源则反序释放。破坏循环等待条件。

#### 7.调度

（1）调度策略

- `响应时间`：从用户输入到产生反应的时间
- `周转时间`：从任务开始到任务结束的时间
- `平均周转时间`：周转总时间除以作业个数

（2）调度算法(8种)

- [1] FCFS：调度的顺序就是任务到达就绪队列的顺序。对短作业不公平。

  > 公平、简单(FIFO队列)、非抢占、不适合交互式。未考虑任务特性，平均等待时间可以缩短

- [2] SJF：最短的作业(CPU区间长度最小)最先调度。

  > 可以证明，SJF可以保证最小的平均等待时间。

- [3] SRJF：SJF的可抢占版本，比SJF更有优势。

     SJF(SRJF): 如何知道下一CPU区间大小？根据历史进行预测: 指数平均法。

- [4] HRN：最高响应比优先法，是FCFS和SJF的综合平衡，响应比R定义如下： `R =(W+T)/T` 。

- [5] 优先权调度：每个任务关联一个优先权，调度优先权最高的任务。

  > 注意：优先权太低的任务一直就绪，得不到运行，出现“饥饿”现象。
  >
  > FCFS是RR的特例，SJF是优先权调度的特例。这些调度算法都不适合于交互式系统。

- [6] Round-Robin(RR)：设置一个时间片，按时间片来轮转调度

  > 优点: 定时有响应，等待时间较短；缺点: 上下文切换次数较多；
  >
  > 时间片太大，响应时间太长；吞吐量变小，周转时间变长；当时间片过长时，退化为FCFS。

- [7] 多级队列调度

  > - 按照一定的规则建立多个进程队列
  > - 不同的队列有固定的优先级（高优先级有抢占权）
  > - 不同的队列可以给不同的时间片和采用不同的调度方法
  >
  > 存在问题1：没法区分I/O bound和CPU bound；
  >
  > 存在问题2：也存在一定程度的“饥饿”现象；

- [8] 多级反馈队列：在多级队列的基础上，任务可以在队列之间移动，更细致的区分任务。可以根据“享用”CPU时间多少来移动队列，阻止“饥饿”。

  > 最通用的调度算法，多数OS都使用该方法或其变形，如UNIX、Windows等。

#### 8.锁

（1）互斥锁

> 同一时间只能有一个线程访问加锁的数据。

（2）自旋锁

> 互斥锁的一种实现，如果自旋锁已经被别的执行单元保持，调用者就一直 **循环等待** 是否该自旋锁的保持者已经释放了锁。

（3）读写锁

> 一种特殊的自旋锁，它把对共享资源的访问者划分成读者和写者，读者只对共享资源进行读访问，写者则需要对共享资源进行写操作。**写者是排他性的，一个读写锁同时只能有一个写者或多个读者（与CPU数相关），但不能同时既有读者又有写者**。

（4）阻塞锁

> 与自旋锁不同，改变了线程的运行状态。**让线程进入阻塞状态进行等待，当获得相应的信号（唤醒，时间） 时，才可以进入线程的准备就绪状态**，准备就绪状态的所有线程，通过竞争，进入运行状态。
>
> > 在Java中synchronized,ReentrantLock,Object.wait() / notify()都属于阻塞锁。

（5）可重入锁

> 也叫做递归锁，指的是同一线程上该锁是可重入的，对于不同线程则相当于普通的互斥锁。

（6）公平锁

> 加锁前检查是否有排队等待的线程，优先排队等待的线程，先来先得。

（7）非公平锁

> 加锁时不考虑排队等待问题，直接尝试获取锁，获取不到自动到队尾等待。`ReentrantLock`中的`lock()`默认就是非公平锁。

（8）悲观锁

> 假定会发生并发冲突，屏蔽一切可能违反数据完整性的操作。加锁的时间可能会很长，也就是说悲观锁的并发访问性不好。

（9）乐观锁

> 假设不会发生并发冲突，只在提交操作时检查是否违反数据完整性。乐观锁不能解决脏读的问题，可以通过添加时间戳和版本来来解决。

#### 9.CAS

> 比较并交换(compare and swap, CAS)**，是原子操作的一种，可用于在多线程编程中实现不被打断的数据交换操作。**该操作通过将内存中的值与指定数据进行比较，当数值一样时将内存中的数据替换为新的值。
>
> 在使用上，通常会记录下某块内存中的旧值，通过对旧值进行一系列的操作后得到新值，然后通过CAS操作将新值与旧值进行交换。**如果这块内存的值在这期间内没被修改过，则旧值会与内存中的数据相同，这时CAS操作将会成功执行使内存中的数据变为新值**。如果内存中的值在这期间内被修改过，则一般来说旧值会与内存中的数据不同，这时CAS操作将会失败，新值将不会被写入内存。

### （三）内存管理

1. 页面置换算法
   - **FIFO算法**：先入先出，即淘汰最早调入的页面。
   - **OPT(MIN)算法**：选未来最远将使用的页淘汰，是一种最优的方案，可以证明缺页数最小。可惜，MIN需要知道将来发生的事，只能在理论中存在，实际不可应用。
   - **LRU(Least-Recently-Used)算法**：用过去的历史预测将来，选最近最长时间没有使用的页淘汰(也称最近最少使用)。性能最接近OPT。**与页面使用时间有关**。
   - **LFU(Least Frequently Used)算法**：即最不经常使用页置换算法，要求在页置换时置换引用计数最小的页，因为经常使用的页应该有一个较大的引用次数。**与页面使用次数有关**。
   - **Clock**：给每个页帧关联一个使用位，当该页第一次装入内存或者被重新访问到时，将使用位置为1。每次需要替换时，查找使用位被置为0的第一个帧进行替换。在扫描过程中，如果碰到使用位为1的帧，将使用位置为0，在继续扫描。如果所谓帧的使用位都为0，则替换第一个帧。

### （四）I/O

#### 1.I/O模式？[参考](https://segmentfault.com/a/1190000003063859)

（1）阻塞I/O（blocking IO）

> 当用户进程调用了 `recvfrom` 这个系统调用， `kernel` 就开始了 IO 的第一个阶段：准备数据（对于网络IO来说，很多时候数据在一开始还没有到达。比如，还没有收到一个完整的 `UDP` 包。这个时候 `kernel` 就要等待足够的数据到来）。这个过程需要等待，也就是说数据被拷贝到操作系统内核的缓冲区中是需要一个过程的。而在用户进程这边，整个进程会被阻塞（当然，是进程自己选择的阻塞）。当 `kernel` 一直等到数据准备好了，它就会将数据从 `kernel` 中拷贝到用户内存，然后 `kernel` 返回结果，用户进程才解除 `block` 的状态，重新运行起来。
>
> > blocking IO的特点就是在IO执行的两个阶段都被block了

（2）非阻塞I/O（nonblocking IO）

> 当用户进程发出 `read` 操作时，如果 `kernel` 中的数据还没有准备好，那么它并不会 `block` 用户进程，而是立刻返回一个 `error` 。从用户进程角度讲 ，它发起一个 `read` 操作后，并不需要等待，而是马上就得到了一个结果。用户进程判断结果是一个 `error` 时，它就知道数据还没有准备好，于是它可以再次发送 `read` 操作。一旦 `kernel` 中的数据准备好了，并且又再次收到了用户进程的 `system call` ，那么它马上就将数据拷贝到了用户内存，然后返回。
>
> > nonblocking IO的特点是用户进程需要不断的主动询问kernel数据好了没有
> >
> > NIO**和****IO****之间一个最大区别：****IO****是面向流的，****NIO****是面向缓冲区的。**

（3）I/O多路复用（ IO multiplexing）（Java中的NIO使用channel来完成多路复用）

> IO multiplexing就是我们说的select，poll，epoll，有些地方也称这种IO方式为event driven IO。select/epoll的好处就在于单个process就可以同时处理多个网络连接的IO。它的基本原理就是select，poll，epoll这个function会不断的轮询所负责的所有socket，当某个socket有数据到达了，就通知用户进程。
>
> > 所以，I/O 多路复用的特点是通过一种机制一个进程能同时等待多个文件描述符，而这些文件描述符（套接字描述符）其中的任意一个进入读就绪状态，select()函数就可以返回。

（4）信号驱动I/O（ signal driven IO）

（5）异步I/O（asynchronous IO）（并不会加快io的过程）

> 用户进程发起 `read` 操作之后，立刻就可以开始去做其它的事。而另一方面，从 `kernel` 的角度，当它受到一个 `asynchronous read` 之后，首先它会立刻返回，所以不会对用户进程产生任何 `block` 。然后，`kernel` 会等待数据准备完成，然后将数据拷贝到用户内存，当这一切都完成之后，`kernel` 会给用户进程发送一个 `signal` ，告诉它 `read` 操作完成了。

#### 2.零拷贝zero-copy是什么？如何实现？

（1）用户态和内核态？

（2）零拷贝实现？

#### 3.同步异步，阻塞非阻塞的区别。

（阻塞，非阻塞指的有无返回值，同步异步指的是能否继续执行）无论阻塞式IO还是非阻塞式IO，都是同步IO模型，区别就在与第一步是否完成后才返回，但第二步都需要当前进程去完成，异步IO呢，就是从第一步开始就返回，直到第二步完成后才会返回一个消息，也就是说，非阻塞能够让你在第一步时去做其它的事情，而真正的异步IO能让你第二步的过程也能去做其它事情.

### （五）linux使用

#### 1.CPU占用过高排查

>（1）top
>
>（2）ps -ef | grep java或者jps定位
>
>（3）定位到具体的线程：ps -mp 进程 -o THREAD,tid,time
>
>（4）将线程ID转换为16进制的格式：print "%x\n" 数字
>
>（5）jstack 进程id | grep tid（16进制线程id的小写）-A60

#### 2.补充：

- 计算机硬件由运算器、控制器、存储器、输入设备和输出设备五大部分组成。
- 操作系统的五大功能，分别为：`作业管理`、`文件管理`、`存储管理`、`输入输出设备管理`、`进程及处理机管理`
- 中断：所谓的中断就是在计算机执行程序的过程中，由于出现了某些特殊事情，使得CPU暂停对程序的执行，转而去执行处理这一事件的程序。等这些特殊事情处理完之后再回去执行之前的程序。中断一般分为三类：
  - `内部异常中断`：由计算机硬件异常或故障引起的中断；
  - `软中断`：由程序中执行了引起中断的指令而造成的中断（这也是和我们将要说明的系统调用相关的中断）；
  - `外部中断`：由外部设备请求引起的中断，比如I/O请求。
- 系统调用：进程的执行在系统上的两个级别：用户级和核心级，也称为`用户态`和`系统态`(`user mode` and `kernel mode`)。**程序的执行一般是在用户态下执行的，但当程序需要使用操作系统提供的服务时，比如说打开某一设备、创建文件、读写文件等，就需要向操作系统发出调用服务的请求，这就是系统调用**。

#### 3.awk命令的使用？



## 三、数据结构

1. B-树，B+树，AVL树？

## 四、算法

1. 算法的分类？
2. 弗洛伊德算法？
3. 迪杰斯特拉算法？

## 五、Java

### （一）基础

#### 1.泛型？

#### 2.内部类？（成局静匿）

（1）成员内部类

> 一个类定义在一个类的内部，看起来像类的成员。
>
> > 问题：
> >
> > - 有隐藏的问题
> > - 访问：成员内部类可以无条件地访问外部类的成员，而外部类想访问成员内部类的成员却不是这么随心所欲了。在外部类中如果要访问成员内部类的成员，必须先创建一个成员内部类的对象，再通过指向这个对象的引用来访问

（2）局部内部类

> 定义在方法或者是一个作用域内，和成员内部类的区别在于访问权限上。
>
> > 问题：
> >
> > - 局部内部类是定义在一个方法或者一个作用域里面的类，它和成员内部类的区别在于局部内部类的访问仅限于方法内或者该作用域内。
> > - 是不能有 public、protected、private 以及 static 修饰符的。

（3）静态内部类

> 静态内部类也是定义在另一个类里面的类，只不过在类的前面多了一个关键字static。静态内部类是不需要依赖于外部类的，这点和类的静态成员属性有点类似，`并且它不能使用外部类的非static成员变量或者方法`
>
> > - 静态内部类是不依赖于外部类的，也就说可以在不创建外部类对象的情况下创建内部类的对象。

（4）匿名内部类

> 一般使用匿名内部类的方法来编写事件监听代码。同样的，匿名内部类也是不能有访问修饰符和 static 修饰符的。

#### 3.构造器能不能override？

不可以，可以重载，不可以重写，理由：父类的私有属性以及构造器不能够被重载。

#### 4.StringBuffer怎么实现线程安全的？

对方法或者被调用的方法加了同步锁。

<img src="./images/basic/StringBuffer.png" width="500"/>

#### 5.static相关？（目的：方便在没有new的情况下使用方法和属性）

（1）修饰？

- 类
- 方法：是没有this的，因为它不依附于任何对象，在静态方法中不能访问类的非静态成员变量和非静态成员方法，因为非静态成员方法/变量都是必须依赖具体的对象才能够被调用。非静态成员方法中是可以访问静态成员方法/变量的。
- 属性：静态变量被所有的对象所共享，在内存中只有一个副本，它当且仅当在类初次加载时会被初始化。而非静态变量是对象所拥有的，在创建对象的时候被初始化，存在多个副本，各个对象拥有的副本互不影响。
- 代码块：用来形成静态代码块以优化程序性能。static块可以置于类中的任何地方，类中可以有多个static块。在类初次被加载的时候，会按照static块的顺序来执行每个static块，并且只会执行一次。

（2）特点

- 在static方法内部不能调用非静态方法。

- 例题：

```java
/**
 * @Author MaoTian
 * @Classname StaticTest
 * @Description static使用
 *
 * test static
 * myclass static
 * person static
 * person Test
 * test constructor
 * person MyClass
 * myclass constructor
 *
 * @Date 下午8:23 2019/8/12
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */

class Person{
    static{
        System.out.println("person static");
    }
    public Person(String str) {
        System.out.println("person "+str);
    }
}

//StaticTest已经加载过了
//而在生成对象的时候，必须先初始化父类的成员变量，因此会执行Test中的Person person = new Person()
class MyClass extends StaticTest {
    
    Person person = new Person("MyClass");
    //（3）被加载
    static{
        System.out.println("myclass static");
    }
    public MyClass() {
        System.out.println("myclass constructor");
    }
}

//
public class StaticTest  {
    Person person = new Person("Test");

    //（1）首先被加载
    static{
        System.out.println("test static");
    }

    public StaticTest() {
        System.out.println("test constructor");
    }
    
    public static void main(String[] args) {
        //（2）被执行
        new MyClass();
    }
```

#### 6.接口和抽象类的区别？

（1）接口？

- 一个类可以实现多个接口。
- 接口中除了static、final变量，不能有其他变量，不能够有方法的实现，java 8开始支持default。
- 接口默认是：public的
- 从设计上讲：抽象是对类的抽象

（2）抽象类？

- 一个类只能继承一个抽象类。
- 抽象类中可以有属性以及方法的实现。
- 从设计上讲：是对行为的抽象。
- 抽象方法可以有public、protected和default这些修饰符（抽象方法就是为了被重写所以不能使用private关键字修饰！）

#### 7.equals和hashcode的区别？

- 如果两个对象相等，则hashcode一定也是相同的

- 两个对象相等,对两个对象分别调用equals方法都返回true

- 两个对象有相同的hashcode值，它们也不一定是相等的

- **因此，equals 方法被覆盖过，则 hashCode 方法也必须被覆盖**

- hashCode() 的默认行为是对堆上的对象产生独特值。如果没有重写 hashCode()，则该 class 的两个对象无论如何都不会相等（即使这两个对象指向相同的数据）
- 注意equas值相等并不是说hashcode就会一样！！！equals方法是可以自行定义的！并不是equals相等，两个对象就相等。

#### 8.Throwable类？

（1）结构？

> java.lang
>
> ## Class Throwable
>
> - [java.lang.Object](https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html)
> - - java.lang.Throwable
>
> - - All Implemented Interfaces:
>
>     [Serializable](https://docs.oracle.com/javase/8/docs/api/java/io/Serializable.html)
>
>   - Direct Known Subclasses:
>
>     [Error](https://docs.oracle.com/javase/8/docs/api/java/lang/Error.html), [Exception](https://docs.oracle.com/javase/8/docs/api/java/lang/Exception.html)
>
> > 常用的方法：
> >
> > - **public string getMessage()**:返回异常发生时的详细信息
> > - **public string toString()**:返回异常发生时的简要描述
> > - **public string getLocalizedMessage()**:返回异常对象的本地化信息。使用Throwable的子类覆盖这个方法，可以声称本地化信息。如果子类没有覆盖该方法，则该方法返回的信息与getMessage（）返回的结果相同
> > - **public void printStackTrace()**:在控制台上打印Throwable对象封装的异常信息

（2）常见的异常和错误？

- 异常
  - ArithmeticException
  - IndexOutOfBoundsException
  - RuntimeException
  - NullPointerException
- 错误
  - OutOfMemoryError
  - StackOverflowError

| **编号** | **异常Exception**                                            | **错误Error**                                                |
| -------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1        | [ArithmeticException](https://docs.oracle.com/javase/8/docs/api/java/lang/ArithmeticException.html) | [AbstractMethodError](https://docs.oracle.com/javase/8/docs/api/java/lang/AbstractMethodError.html) |
| 2        | [ArrayIndexOutOfBoundsException](https://docs.oracle.com/javase/8/docs/api/java/lang/ArrayIndexOutOfBoundsException.html) | [AssertionError](https://docs.oracle.com/javase/8/docs/api/java/lang/AssertionError.html) |
| 3        | [ArrayStoreException](https://docs.oracle.com/javase/8/docs/api/java/lang/ArrayStoreException.html) | [BootstrapMethodError](https://docs.oracle.com/javase/8/docs/api/java/lang/BootstrapMethodError.html) |
| 4        | [ClassCastException](https://docs.oracle.com/javase/8/docs/api/java/lang/ClassCastException.html) | [ClassCircularityError](https://docs.oracle.com/javase/8/docs/api/java/lang/ClassCircularityError.html) |
| 5        | [ClassNotFoundException](https://docs.oracle.com/javase/8/docs/api/java/lang/ClassNotFoundException.html) | [ClassFormatError](https://docs.oracle.com/javase/8/docs/api/java/lang/ClassFormatError.html) |
| 6        | [CloneNotSupportedException](https://docs.oracle.com/javase/8/docs/api/java/lang/CloneNotSupportedException.html) | [Error](https://docs.oracle.com/javase/8/docs/api/java/lang/Error.html) |
| 7        | [EnumConstantNotPresentException](https://docs.oracle.com/javase/8/docs/api/java/lang/EnumConstantNotPresentException.html) | [ExceptionInInitializerError](https://docs.oracle.com/javase/8/docs/api/java/lang/ExceptionInInitializerError.html) |
| 8        | [Exception](https://docs.oracle.com/javase/8/docs/api/java/lang/Exception.html) | [IllegalAccessError](https://docs.oracle.com/javase/8/docs/api/java/lang/IllegalAccessError.html) |
| 9        | [IllegalAccessException](https://docs.oracle.com/javase/8/docs/api/java/lang/IllegalAccessException.html) | [IncompatibleClassChangeError](https://docs.oracle.com/javase/8/docs/api/java/lang/IncompatibleClassChangeError.html) |
| 10       | [IllegalArgumentException](https://docs.oracle.com/javase/8/docs/api/java/lang/IllegalArgumentException.html) | [InstantiationError](https://docs.oracle.com/javase/8/docs/api/java/lang/InstantiationError.html) |
| 11       | [IllegalMonitorStateException](https://docs.oracle.com/javase/8/docs/api/java/lang/IllegalMonitorStateException.html) | [InternalError](https://docs.oracle.com/javase/8/docs/api/java/lang/InternalError.html) |
| 12       | [IllegalStateException](https://docs.oracle.com/javase/8/docs/api/java/lang/IllegalStateException.html) | [LinkageError](https://docs.oracle.com/javase/8/docs/api/java/lang/LinkageError.html) |
| 13       | [IllegalThreadStateException](https://docs.oracle.com/javase/8/docs/api/java/lang/IllegalThreadStateException.html) | [NoClassDefFoundError](https://docs.oracle.com/javase/8/docs/api/java/lang/NoClassDefFoundError.html) |
| 14       | [IndexOutOfBoundsException](https://docs.oracle.com/javase/8/docs/api/java/lang/IndexOutOfBoundsException.html) | [NoSuchFieldError](https://docs.oracle.com/javase/8/docs/api/java/lang/NoSuchFieldError.html) |
| 15       | [InstantiationException](https://docs.oracle.com/javase/8/docs/api/java/lang/InstantiationException.html) | [NoSuchMethodError](https://docs.oracle.com/javase/8/docs/api/java/lang/NoSuchMethodError.html) |
| 16       | [InterruptedException](https://docs.oracle.com/javase/8/docs/api/java/lang/InterruptedException.html) | [OutOfMemoryError](https://docs.oracle.com/javase/8/docs/api/java/lang/OutOfMemoryError.html) |
| 17       | [NegativeArraySizeException](https://docs.oracle.com/javase/8/docs/api/java/lang/NegativeArraySizeException.html) | [StackOverflowError](https://docs.oracle.com/javase/8/docs/api/java/lang/StackOverflowError.html) |
| 18       | [NoSuchFieldException](https://docs.oracle.com/javase/8/docs/api/java/lang/NoSuchFieldException.html) | [ThreadDeath](https://docs.oracle.com/javase/8/docs/api/java/lang/ThreadDeath.html) |
| 19       | [NoSuchMethodException](https://docs.oracle.com/javase/8/docs/api/java/lang/NoSuchMethodException.html) | [UnknownError](https://docs.oracle.com/javase/8/docs/api/java/lang/UnknownError.html) |
| 20       | [NullPointerException](https://docs.oracle.com/javase/8/docs/api/java/lang/NullPointerException.html) | [UnsatisfiedLinkError](https://docs.oracle.com/javase/8/docs/api/java/lang/UnsatisfiedLinkError.html) |
| 21       | [NumberFormatException](https://docs.oracle.com/javase/8/docs/api/java/lang/NumberFormatException.html) | [UnsupportedClassVersionError](https://docs.oracle.com/javase/8/docs/api/java/lang/UnsupportedClassVersionError.html) |
| 22       | [ReflectiveOperationException](https://docs.oracle.com/javase/8/docs/api/java/lang/ReflectiveOperationException.html) | [VerifyError](https://docs.oracle.com/javase/8/docs/api/java/lang/VerifyError.html) |
| 23       | [RuntimeException](https://docs.oracle.com/javase/8/docs/api/java/lang/RuntimeException.html) | [VirtualMachineError](https://docs.oracle.com/javase/8/docs/api/java/lang/VirtualMachineError.html) |
| 24       | [SecurityException](https://docs.oracle.com/javase/8/docs/api/java/lang/SecurityException.html) |                                                              |
| 25       | [StringIndexOutOfBoundsException](https://docs.oracle.com/javase/8/docs/api/java/lang/StringIndexOutOfBoundsException.html) |                                                              |
| 26       | [TypeNotPresentException](https://docs.oracle.com/javase/8/docs/api/java/lang/TypeNotPresentException.html) |                                                              |
| 27       | [UnsupportedOperationException](https://docs.oracle.com/javase/8/docs/api/java/lang/UnsupportedOperationException.html) |                                                              |

#### 9. OutOfMemory详解

| 名字                                                         | 图片                                                         | 解释                                                |
| ------------------------------------------------------------ | ------------------------------------------------------------ | --------------------------------------------------- |
| Exception in thread "main" java.lang.StackOverflowError      | <img src="images/basic/StackOverflowError.png" width="600"/> | 递归调用，深度太深                                  |
| Exception in thread "main" java.lang.OutOfMemoryError: Java heap space | <img src="images/basic/JavaHeapSpace.png" width="600"/>      | 堆空间不够（）                                      |
| java.lang.OutOfMemoryError: GC overhead limit exceeded       | <img src="images/basic/GCoverheadlimitexceeded.png" width="600"/> | 垃圾回收事倍功半，GC直接罢工                        |
| Exception in thread "main" java.lang.OutOfMemoryError: Direct buffer memory | <img src="./images/basic/DirectBufferMemory.png" width="600"/> | nio分配直接内存，不够导致                           |
| Exception in thread "main" java.lang.OutOfMemoryError: unable to create new native thread | <img src="./images/basic/UnableToCreateNewNativeThread.png" width="600"/> | 同一个进程创建的线程太多了，Linux默认限制为1024个。 |
|                                                              |                                                              |                                                     |
|                                                              |                                                              |                                                     |
|                                                              |                                                              |                                                     |



#### 10.Collections和Arrays常见的方法？https://gitee.com/SnailClimb/JavaGuide/blob/master/docs/java/Basis/Arrays,CollectionsCommonMethods.md

#### 11.反射

> **JAVA反射机制是在运行状态中，对于任意一个类，都能够知道==这个类的所有属性和方法==；对于任意一个对象，都能够==调用它的任意方法和属性==；这种动态获取信息以及动态调用对象方法的功能称为java语言的反射机制。**
>
> | 类名          | 用途                                             |                                                              |
> | ------------- | ------------------------------------------------ | ------------------------------------------------------------ |
> | Class类       | 代表类的实体，在运行的Java应用程序中表示类和接口 | ==//第1种方式获取Class对象 ：通过实例对象getClass()<br>==Person p1=new Person(); <br>Class clazz1=p1.getClass(); <br> ==//第2种方式获取Class对象:类名.class <br>==Class clazz2=Person.class; <br> ==//第3种方式获取Class对象 Class :全类名==<br>clazz3=Class.forName("JavaDemo.VMTest.ReflectDemo.Person"); |
> | Field类       | 代表类的成员变量（成员变量也称为类的属性）       | Field field2===clazz.getDeclaredField("idcard");== <br>field2.setAccessible(true); <br>field2.set(obj, "123456"); |
> | Method类      | 代表类的方法                                     | Method m2=clazz.getDeclaredMethod("show",String.class); <br>m2.setAccessible(true);<br>m2.invoke(obj,"smt"); |
> | Constructor类 | 代表类的构造方法                                 | //获取私有构造方法 <br>Constructor cc3=clazz.getDeclaredConstructor(int.class);<br> //暴力访问 <br>cc3.setAccessible(true); <br>==Object oo3=cc3.newInstance(1);== |
>
> **如何使用反射** 
> (1)使用Class类,获取出被解剖的这个类的class文件对象 
> (2) 使用Class类方法,获取出类中的所有成员 
> (3) 将成员获取出来后,交给对应类,对应类中的方法,运行成员
>
> > 如何获取,class文件对象
> >
> > >使用类的对象获取
> > >- 每个类都使用Object作为父类,Object类方法 getClass()返回这个类的class文件对象,方法返回值Class类型对象
> > >- 使用类的静态属性获取:==类名.class== 返回这个类的class文件对象.属性运行结果也是Class类型对象==(并不是使用的是编译后的字节码class文件！)==
> > >- 使用Class类的静态方法获取:Class类静态方法 forName(String 类名) 传递字符串类名获取到这个类的class文件对象,方法返回值也是Class类型对象
> > >不管用哪种方式获取的Class对象，他们都是相等的。

### （二）容器

#### 1.HashMap？

> 并发场景下如果要保证一种可行的方式是使用 ==Collections.synchronizedMap()==方法来包装我们的 HashMap。但这是通过使用一个全局的锁来同步不同线程间的并发访问，因此会带来不可忽视的性能问题。

#### 2.ArrayList的扩容？（扩容为原来的1.5倍）

(1)先从 ArrayList 的构造函数

| 编号 | 构造函数                                               | 意义                                                     |
| ---- | ------------------------------------------------------ | -------------------------------------------------------- |
| 1    | <img src="./images/basic/arraylist1.png" width="600"/> | 指定了初始化的容量大小                                   |
| 2    | <img src="./images/basic/arraylist2.png" width="600"/> | 默认为空，在add的时候会生成一个大小为10的ArrayList       |
| 3    | <img src="./images/basic/arraylist3.png" width="600"/> | 使用集合来构造，会拷贝集合中的值，使用集合大小进行初始化 |

（2）扩容（通常大小会变为原来大小的1.5倍，注意和HashMap的扩容机制进行比较）

| 编号 | 方法                   | 解释                                                         |
| ---- | ---------------------- | ------------------------------------------------------------ |
| 1    | add                    | 确保判断当前要加入的有空间                                   |
| 2    | ensureCapacityInternal | 和默认的大小10进行比较                                       |
| 3    | ensureExplicitCapacity | 判读是不是需要扩容，需要扩容就进行扩容                       |
| 4    | grow                   | 将原来的大小变为1.5倍，看看符合要求不，不符合，就是用需求的大小，如果计算出的新的大小必最大值还大，就是用hugeCapacity |
| 5    | hugeCapacity           | 就是使用最大的整数进行初始化                                 |
| 6    | ensureCapacity         | 这个函数是提供给用户使用的，可以节约时间                     |

（3）补充

- System.arraycopy()` 和 `Arrays.copyOf()方法

  > //elementData:源数组;index:源数组中的起始位置;elementData：目标数组；index + 1：目标数组中的起始位置； size - index：要复制的数组元素的数量；
  >
  >  System.arraycopy(elementData, index, elementData, index + 1, size - index);

- 使用 `Arrays.copyOf()`方法主要是为了给原有数组扩容

#### 3.HashMap的扩容？（扩容为原来的两倍）

HashMap的扩容要和ArrayList的扩容进行区分，HashMap的扩容的真正原因是为了回避Hash冲突，当table中已经倍占用了75%（默认负载因子）就需要进行扩容，扩容的大小为原来的两倍。

- 时机：阈值=负载因子×table大小
- 扩容table
- rehash

#### 4.HashMap和HashTable的区别？

| 区别                          | HashMap                                                      | HashTable                                                    |
| ----------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 底层实现                      | 1.8：Node数组+红黑树，1.8之前（链表散列）                    | 数组+链表（链表散列）                                        |
| 扩容机制                      | 默认是16，扩容翻倍；HashMap 会将其扩充为2的幂次方大小（HashMap 中的`tableSizeFor()`方法保证）<br><img src="images/basic/tableSizeFor.png" width="600"/> | 默认是11，扩容2n+1；指定的话，将会按照指定大小。             |
| 效率                          | 相对高                                                       | 相对低一些                                                   |
| 对Null key 和Null value的支持 | null 可以作为键，这样的键只有一个，可以有一个或多个键所对应的值为 null | 但是在 HashTable 中 put 进的键值只要有一个 null，直接抛出 NullPointerException |
| 线程是否安全                  | HashMap 是非线程安全的                                       | HashTable 内部的方法基本都经过`synchronized` 修饰            |

#### 5.HashMap中的Node，及其类型？

（1）Node（实现接口Map.Entry）

<img src="./images/basic/node.png" width="600">

（2）TreeNode(继承自LinkedHashMap.Entry)

<img src="./images/basic/TreeNode.png" width="600">

（3）ConcurrentHash的节点？

| 编号 | 名字                | 解释                                                         |
| ---- | ------------------- | ------------------------------------------------------------ |
| 1    | Node结点            | 默认链接到`table[i]`——桶上的结点就是Node结点。               |
| 2    | TreeNode结点        | TreeNode就是红黑树的结点，TreeNode不会直接链接到`table[i]`——桶上面，而是由TreeBin链接，TreeBin会指向红黑树的根结点。 |
| 3    | TreeBin节点         | TreeBin相当于TreeNode的代理结点。TreeBin会直接链接到table[i]——桶上面，该结点提供了一系列红黑树相关的操作，以及加锁、解锁操作。 |
| 4    | ForwardingNode节点  | ForwardingNode结点仅仅在扩容时才会使用。                     |
| 5    | ReservationNode节点 | 保留结点，ConcurrentHashMap中的一些特殊方法会专门用到该类结点。 |



<img src="./images/basic/concurrenthashmap.png" width="600"/>

#### 6.ArrayLis实现

<img src="./images/basic/arraylist0.png" width="600"/>

- 实现接口
  - List
  - RandomAccess
  - Cloneable
  - java.io.Serializable

- 继承的类

  - AbstractList

- 内部类

  - private class Itr implements Iterator<E>  
  - private class ListItr extends Itr implements ListIterator<E>  
  - private class SubList extends AbstractList<E> implements RandomAccess  
  - static final class ArrayListSpliterator<E> implements Spliterator<E> 

  > ArrayList有四个内部类，其中的**Itr是实现了Iterator接口**，同时重写了里面的**hasNext()**，**next()**，**remove()**等方法；其中的**ListItr**继承**Itr**，实现了**ListIterator接口**，同时重写了**hasPrevious()**，**nextIndex()**，**previousIndex()**，**previous()**，**set(E e)**，**add(E e)**等方法，所以这也可以看出了 **Iterator和ListIterator的区别:**ListIterator在Iterator的基础上增加了添加对象，修改对象，逆向遍历等方法，这些是Iterator不能实现的。

#### 7.LinkedList实现

- LinkedList是通过双向链表实现的！

<img src="./images/basic/linkedlist.png" width="600"/>

<img src="./images/basic/linkedlist1.png" width="600"/>

### （三）并发

#### 1.Java内存模型？

#### 2.单例模式的实现？

- 懒汉模式（双重检查加锁）

```java
public class Singleton {
    
    //uniqueInstance 采用 volatile 关键字修饰也是很有必要的， uniqueInstance = new Singleton(); 
    //这段代码其实是分为三步执行：
    //1. 为 uniqueInstance 分配内存空间
    //2. 初始化 uniqueInstance
    //3. 将 uniqueInstance 指向分配的内存地址
    private volatile static Singleton uniqueInstance;
    private Singleton(){}
    public static Singleton getUniqueInstance(){
        if(uniqueInstance==null){
            synchronized (Singleton.class){
                if(uniqueInstance==null){
                    uniqueInstance=new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
```

- 静态内部类模式

```java
public class Singleton2 {
    private static final class SingleHandler{
        private static final Singleton2 INSTANCE=new Singleton2();
    }
    private Singleton2(){}
    public static Singleton2 getInstance(){
        return SingleHandler.INSTANCE;
    }
}
```



#### 3.线程的实现方式？怎么使用lambda的形式？

（1）Thread------------run()方法

（2）Runnable------------run()方法

（3）Callable----------call()----------FutureTask

```java
package JavaBasic;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Classname ThreadTest
 * @Description 多线程的三种实现方式
 * @Date 19-7-22 上午9:30
 * @Created by mao<tianmao818@qq.com>
 */

class MyThread1 extends Thread{
    @Override
    public void run(){
        System.out.println("thread by extends Thread");
    }
}

class MyThread2 implements Runnable{
    @Override
    public void run(){
        System.out.println("thread by implements Runnable");
    }
}

class MyThread3 implements Callable{
    @Override
    public String call() throws Exception{
        return "thread by implements Callable";
    }
}

public class ThreadTest {
    public static void main(String[] args){
        MyThread1 myThread1=new MyThread1();
        myThread1.start();

        MyThread2 myThread2=new MyThread2();
        new Thread(myThread2).start();
        
        //FutureTask的使用
        //Future类的使用
        FutureTask<String> futureTask=new FutureTask<>(new MyThread3());
        new Thread(futureTask).start();
        try {
            String res=futureTask.get();
            System.out.println(res);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
```

(4)使用匿名内部类

```java
        new Thread(()->{
            System.out.println(Thread.currentThread()+"thread by lambda");
        }).start();

        new Thread() {
            public void run() {
                System.out.println(Thread.currentThread()+"thread by 1");
            }
        }.start();

        Runnable r = new Runnable() {//创建方式2
            public void run() {
                System.out.println(Thread.currentThread()+"thread by 2");
            }
        };
        new Thread(r).start();
```

> 补充：
>
> 对于同一个Thread使用两次start将会有什么结果？
>
> <img src="./images/multithread/2start.png" width="600">

#### 4.线程池

- ThreadPoolExecutor参数(7个参数)

  > - @param corePoolSize                                核心线程池中的最大线程数
  >
  > - @param maximumPoolSize                      总线程池中的最大线程数
  >
  > - @param keepAliveTime                              空闲线程的存活时间
  >
  > - @param unit                                                 keepAliveTime的单位
  >
  > - @param workQueue                                   任务队列, 保存已经提交但尚未被执行的线程
  >
  > - @param threadFactory                               线程工厂(用于指定如果创建一个线程)
  >
  > - @param handler                                           拒绝策略 (当任务太多导致工作队列满时的处理策略)

- ==线程池的状态（高三位表示状态，第29位表示线程的数量）==

  > ==RUNNING==                                                              -1 接受新任务, 且处理已经进入阻塞队列的任务
  >
  > ==SHUTDOWN==                                                           0 不接受新任务, 但处理已经进入阻塞队列的任务
  >
  > ==STOP==                                                                        1 接受新任务, 且不处理已经进入阻塞队列的任务, 同时中断正在运行的任务
  >
  > ==TIDYING==                                                                  2 所有任务都已终止, 工作线程数为0, 线程转化为TIDYING状态并准备调用terminated方法
  >
  > ==TERMINATED==                                                          3 terminated方法已经执行完成

- execute执行流程图

  <img src="images/juc/execute.png"  width="600"/>
  
  > 场景：今天是周末，一银行网点只开放了几个窗口，当前值班窗口的数量就是核心线程池的上限。一开始，顾客陆续进来，值班的窗口还有空闲的，则进来一个人就可以直接去柜台办理。随着人数的增加，当天值班窗口全部有人在办理业务，这个时候有人进来，就要在大厅里找个座位坐下来等待，大厅的座位就是阻塞队列。但是，当天人数越来越多，连大厅的座位都坐满了人，这个时候这个网点领导将会通知将当天休息的窗口也打开（所有的窗口数目就是总的线程池上限），当人数还继续增加的话，处于安全考虑，银行就会拒绝继续进入，这就是执行了拒绝策略。

#### 5.Java 并发包提供了哪些并发工具类？

- juc-locks 锁框架

  > juc-locks锁框架中一共就三个接口：Lock、Condition、ReadWriteLock
  >
  > >  ReadWriteLock: 一个单独的接口（未继承Lock接口），该接口提供了获取读锁和写锁的方法。
  > >
  > > ReentrantLock：ReentrantLock内部通过内部类实现了AQS框架(AbstractQueuedSynchronizer)的API来实现**独占锁**的功能。
  > >
  > > ReentrantReadWriteLock：ReentrantReadWriteLock使得多个读线程同时持有读锁（只要写锁未被占用），而写锁是独占的。写锁可以降级成读锁，读锁不能升级成写锁。

  ![](images/juc/locks.png)

- juc-atomic 原子类框架（ J.U.C之atomic框架：Unsafe类）

  > 其实底层就是通过Unsafe类实现的一种比较并交换的算法，大致的结构如下（具体入参，根据上下文有所不同）：
  > `boolean compareAndSet(expectedValue, updateValue);`
  > 当希望修改的值与expectedValue相同时，则尝试将值更新为updateValue，更新成功返回true，否则返回false。
  >
  > > Unsafe类，来源于`sun.misc`包。该类封装了许多类似指针操作，可以直接进行内存管理、操纵对象、阻塞/唤醒线程等操作。Java本身不直接支持指针的操作，所以这也是该类命名为Unsafe的原因之一。

- juc-sync 同步器框架

- juc-collections 集合框架

  ![](images/juc/juc-collections.png)

- juc-executors 执行器框架

  - 线程池
  - Future模式,Future接口仅仅定义了5个方法。
  
  <img src="images/juc/future.png" align='left' height="150"><img src="images/juc/futuretask_state.png" height="150">
  
  - Fork/Join框架



(1)提供了比 synchronized 更加高级的各种同步结构

> 包括 CountDownLatch、CyclicBarrier、Sempahore 等，可以实现更加丰富的多线程操作，比如利用 Semaphore 作为资源控制器，限制同时进行工作的线程数量。
>
> > - CountDownLatch，允许一个或多个线程等待某些操作完成
> >
> > - CyclicBarrier，一种辅助性的同步结构，允许多个线程等待到达某个屏障
> >
> > > - CountDownLatch 是不可以重置的，所以无法重用；而 CyclicBarrier 则没有这种限制，可以重用。
> > > - CountDownLatch 的基本操作组合是 countDown/await。调用 await 的线程阻塞等待countDown 足够的次数，不管你是在一个线程还是多个线程里 countDown，只要次数足够即可。所以就像 Brain Goetz 说过的，CountDownLatch 操作的是事件。
> > > - CyclicBarrier 的基本操作组合，则就是 await，当所有的伙伴（parties）都调用了 await，才会继续进行任务，并自动进行重置。
> >
> > - Semaphore，Java 版本的信号量实现,总的来说，Semaphore 就是个计数器，其基本逻辑基于 acquire/release.

(2)各种线程安全的容器

> 比如最常见的 ConcurrentHashMap、有序的ConcunrrentSkipListMap，或者通过类似快照机制，实现线程安全的动态数组CopyOnWriteArrayList 等。
>
> > Concurrent
> >
> > CopyOnWrite
> >
> > Blocking

(3)并发队列实现

> 如各种 BlockedQueue 实现，比较典型的 ArrayBlockingQueue、SynchorousQueue 或针对特定场景的 PriorityBlockingQueue 等。

(4)强大的 Executor 框架

> 可以创建各种不同类型的线程池，调度任务运行等，绝大部分情况下，不再需要自己从头实现线程池和任务调度器

(5)AQS框架(AbstractQueuedSynchronizer抽象类)

> > - AQS利用了模板方法模式，其中大多数方法都是final或是private的，我们把这类方法称为**Skeleton Method**，也就是说这些方法是AQS框架自身定义好的骨架，子类是不能覆写的。
> > - 支持中断、超时
> > - 支持独占模式和共享模式
> > - 支持Condition条件等待
>
> AQS方法说明:
>
> > - CAS操作
> >
> > - 等待队列的核心操作
> >
> > - 资源的获取操作
> >
> > - 资源的释放操作
>
> 三个基本问题：
>
> > - 同步状态（synchronization state）的管理
> > - 阻塞/唤醒线程的操作
> > - 线程等待队列的管理
>
> CLH队列
>
> > CLH队列中的结点是对线程的包装，结点一共有两种类型：独占（EXCLUSIVE）和共享（SHARED）。
> > 每种类型的结点都有一些状态，其中独占结点使用其中的CANCELLED(1)、SIGNAL(-1)、CONDITION(-2)，共享结点使用其中的CANCELLED(1)、SIGNAL(-1)、PROPAGATE(-3)。
>
> Node节点

#### 6.哪些队列是有界的，哪些是无界的？从源码的角度，常见的线程安全队列是如何实现的，并进行了哪些改进以提高性能表现？

(1)有界or无界

> - ArrayBlockingQueue 是最典型的的有界队列，其内部以 final 的数组保存数据，数组的大小就决定了队列的边界，所以我们在创建 ArrayBlockingQueue 时，都要指定容量
> - LinkedBlockingQueue，容易被误解为无边界，但其实其行为和内部代码都是基于有界的逻辑实现的，只不过如果我们没有在创建队列时就指定容量，那么其容量限制就自动被设置为
>   Integer.MAX_VALUE，成为了无界队列。
> - SynchronousQueue，每个删除操作都要等待插入操作，反之每个插入操作也都要等待删除动作。那么这个队列的容量是多少呢？是 1 吗？其实不是的，其内部容量是 0。
> - PriorityBlockingQueue 是无边界的优先队列，虽然严格意义上来讲，其大小总归是要受系统资源影响
> - DelayedQueue 和 LinkedTransferQueue 同样是无边界的队列。

(2)安全?

> - BlockingQueue 基本都是基于锁实现
> - 类似 ConcurrentLinkedQueue 等，则是基于 CAS 的无锁技术，不需要在每个操作时使用锁，所以扩展性表现要更加优异

#### 7.生产者 - 消费者?

（1）传统版synchronized: sync--------------->wait------------->notify

（2）传统版lock： lock---------->await---------->Signal

（3）阻塞队列

> ```
> * 1 线程    操作   资源类
> * 2 判断    干活   通知
> * 3 虚假唤醒
> ```

```java
package JavaDemo.MultiThreadTest;

/**
 * @Author MaoTian
 * @Classname ProducerConsumerSync
 * @Description TODO
 * @Date 上午8:48 2019/8/9
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
class ShareSource{
    private int number=0;
    public synchronized void increment()throws InterruptedException{
        while (number!=0){
            this.wait();
        }
        ++number;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        this.notifyAll();
    }
    public synchronized void decrement()throws InterruptedException{
        while (number==0){
            this.wait();
        }
        --number;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        this.notifyAll();
    }
}
public class ProducerConsumerSync {
    public static void main(String[] args) {
        ShareSource shareSource=new ShareSource();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    shareSource.increment();
                }catch (Exception e){

                }
            }
        },"producer-1").start();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                try {
                    shareSource.decrement();
                }catch (Exception e){

                }
            }
        },"consumer-1").start();
    }
}

```



```java
class ShareData{
    private int number=0;
    private Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();
    public void increment()throws Exception{
        lock.lock();
        try{
            //判断,不能够使用if判断，必须使用while判断
            while (number!=0){
                //等待
                condition.await();
            }
            //干活
            number++;
            System.out.println(Thread.currentThread().getName()+":"+number);
            //通知
            condition.signalAll();
        }catch (Exception e){
        }finally {
            lock.unlock();
        }
    }
    public void decrement()throws Exception{
        lock.lock();
        try{
            //判断
            while (number==0){
                //等待
                condition.await();
            }
            //干活
            number--;
            System.out.println(Thread.currentThread().getName()+":"+number);
            //通知
            condition.signalAll();
        }catch (Exception e){
        }finally {
            lock.unlock();
        }
    }
}
public class ProducerConsumerTraditional {
    public static void main(String[] args) {
        ShareData shareData=new ShareData();
        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"producer").start();

        new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"consumer").start();
    }
}
```

```java
package JavaDemo.MultiThreadTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author MaoTian
 * @Classname ProducerConsumerBlockingQueue
 * @Description 使用阻塞队列，生产一个消费一个
 * @Date 下午8:51 2019/8/8
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */

class Resource{
    private volatile boolean FLAG=true; //可见性
    private AtomicInteger atomicInteger=new AtomicInteger();//原子类
    BlockingQueue<String> blockingQueue=null;//阻塞队列

    public Resource(BlockingQueue<String> blockingQueue){
        this.blockingQueue=blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }
    public void myProd()throws Exception{
        String data=null;
        boolean retvalue;
        while (FLAG){
            data=atomicInteger.incrementAndGet()+"";
            retvalue=blockingQueue.offer(data,2L, TimeUnit.SECONDS);
            if(retvalue){
                System.out.println(Thread.currentThread()+":insert ok "+data);
            }else{
                System.out.println(Thread.currentThread()+":insert fail");
            }
//            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread()+":producer stop");
    }

    public void myCons()throws Exception{
        String result;
        while (FLAG){
            result=blockingQueue.poll(2L, TimeUnit.SECONDS);
            if(null==result||result.equalsIgnoreCase("")){
                FLAG=false;
                System.out.println(Thread.currentThread()+":consumer stop");
                return;
            }
            System.out.println(Thread.currentThread()+":consume ok "+result);
        }
    }

    public void stop(){
        this.FLAG=false;
    }
}
public class ProducerConsumerBlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        Resource resource=new Resource(new ArrayBlockingQueue<>(10));
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" producer start");
            try {
                resource.myProd();
            }catch (Exception e){

            }
        },"producer").start();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+" consumer start");
            try {
                resource.myCons();
            }catch (Exception e){

            }
        },"consumer").start();

        TimeUnit.SECONDS.sleep(5);
        resource.stop();
    }
}

```

#### 8.synchronized和lock的区别？用lock的好处？

| 区别           | synchronized                                                 | lock                                                         |
| -------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 原始构成       | （关键字）jvm层面，底层通过monitor对象来完成，monitorenter和monitorexit（两个monitorexit） | （具体类）Lock是具体的类（java.concurrent.locks.Lock）,是api层面的锁（使用java p） |
| 使用方法       | 自动释放                                                     | 需要使用try、finally释放                                     |
| 等待是否可中断 | 不可以被中断                                                 | 可以被中断，==lock.lockInterruptibly()==来实现这个机制。也就是说正在等待的线程可以选择放弃等待，改为处理其他事情。 |
| 加锁是否公平   | 非公平锁                                                     | 默认是非公平锁，构造函数传参，true公平，false非公平          |
| 锁绑定多个条件 | 没有                                                         | 可以用来实现分组唤醒需要唤醒的线程，可以精确唤醒，synchronized随机唤醒一个或者多个 |

```java
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author MaoTian
 * @Classname SyncAndLockCondition
 * @Description lock可以绑定多个condition，可以精确唤醒A-B-C-D-A
 * @Date 下午8:23 2019/8/8
 * @Version 1.0
 * @Created by mao<tianmao818@qq.com>
 */
class ShareResource{
    private int number=0; //A=1,B=2,C=3
    //
    private Lock lock=new ReentrantLock();
    private Condition c1=lock.newCondition();
    private Condition c2=lock.newCondition();
    private Condition c3=lock.newCondition();
    //
    public void print_5(){
        lock.lock();
        try {
            while (number!=0){
                c1.await();
            }
            for (int i = 0; i <5 ; i++) {
                System.out.println(Thread.currentThread()+":"+number);
            }
            number=1;
            c2.signal();
        }catch (Exception e){
        }finally {
            lock.unlock();
        }
    }
    //
    public void print_10(){
        lock.lock();
        try {
            while (number!=1){
                c2.await();
            }
            for (int i = 0; i <10 ; i++) {
                System.out.println(Thread.currentThread()+":"+number);
            }
            number=2;
            c3.signal();
        }catch (Exception e){
        }finally {
            lock.unlock();
        }
    }
    public void print_15(){
        lock.lock();
        try {
            while (number!=2){
                c3.await();
            }
            for (int i = 0; i <15 ; i++) {
                System.out.println(Thread.currentThread()+":"+number);
            }
            number=0;
            c1.signal();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }
    }
}
public class SyncAndLockCondition {
    public static void main(String[] args) {
        ShareResource shareResource=new ShareResource();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                shareResource.print_5();
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                shareResource.print_10();
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                shareResource.print_15();
            }
        }).start();
    }
}

```

#### 9.JUC主要包含的内容？[[透彻理解Java并发编程](https://segmentfault.com/blog/ressmix_multithread)](https://segmentfault.com/blog/ressmix_multithread)

（1）概览

<img src="images/juc/juc.png" width="400"/>

(2)并发容器

- CopyOnWrite*(List,Set)

<img src="images/juc/copyonwrite.png" width="600"/>

- Concurrent*(SkipListSet,SkipListMap,Map,LinkedQueue)

  <img src="images/juc/concurrent.png" width="600"/>

- Blocking*(Queue, Deque)(Array,Linked,Priority)

![](images/juc/blocking.png)



| List，Set                                                    | Map                                            | Queue                                                        |
| ------------------------------------------------------------ | ---------------------------------------------- | ------------------------------------------------------------ |
| CopyOnWriteArrayList<br>CopyOnWriteArraySet<br>ConcurrentSkipListSet<br> | ConcurrentHashMap<br>ConcurrentSkipListMap<br> | ArrayBlockingQueue<br>LinkedBlockingQueue<br>ConcurrentLinkedQueue<br>ConcurrentLinkedDeque<br> |

| 类                    | ji(Ctrl+H,Alt+7)                                             | 并发                                                         |                                                              |
| --------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| CopyOnWriteArrayList  | Cloneable (java.lang)<br/>List (java.util)<br/>    Collection (java.util)<br/>        Iterable (java.lang)<br/>Object (java.lang)<br/>RandomAccess (java.util)<br/>Serializable (java.io) | <img src="images/juc/CopyOnWriteArrayList.png" width=800/>   | ReentrantLock,读取是完全不用加锁的，并且更厉害的是：写入也不会阻塞读取操作。`CopyOnWriteArrayList` 类的所有可变操作（add，set等等）都是通过==创建底层数组的新副本==来实现的。 |
| CopyOnWriteArraySet   | AbstractSet (java.util)<br/>    AbstractCollection (java.util)<br/>        Collection (java.util)<br/>            Iterable (java.lang)<br/>        Object (java.lang)<br/>    Set (java.util)<br/>        Collection (java.util)<br/>Serializable (java.io) | * A {@link java.util.Set} that uses an internal {@link CopyOnWriteArrayList} * for all of its operations.<br>  Thus, it shares the same basic properties*<br/><img src="./images/juc/CopyOnWriteArraySet.png" width="800"/> | ReentrantLock                                                |
| ConcurrentSkipListSet | AbstractSet (java.util)<br/>    AbstractCollection (java.util)<br/>        Collection (java.util)<br/>            Iterable (java.lang)<br/>        Object (java.lang)<br/>    Set (java.util)<br/>        Collection (java.util)<br/>            Iterable (java.lang)<br/>Cloneable (java.lang)<br/>NavigableSet (java.util)<br/>    SortedSet (java.util)<br/>        Set (java.util)<br/>            Collection (java.util)<br/>                Iterable (java.lang)<br/>Serializable (java.io) |                                                              |                                                              |
| ConcurrentHashMap     | AbstractMap (java.util)<br/>    Map (java.util)<br/>    Object (java.lang)<br/>`ConcurrentMap (java.util.concurrent)`<br/>    Map (java.util)<br/>Serializable (java.io) | <img src="./images/juc/cas.png" width="800"/>                | JDK1.8:<br>Node + CAS + Synchronized                         |
| ConcurrentSkipListMap | AbstractMap (java.util)<br/>    Map (java.util)<br/>    Object (java.lang)<br/>Cloneable (java.lang)<br/>ConcurrentNavigableMap (java.util.concurrent)<br/>    ConcurrentMap (java.util.concurrent)<br/>        Map (java.util)<br/>    `NavigableMap (java.util)`<br/>        SortedMap (java.util)<br/>            Map (java.util)<br/>Serializable (java.io) | 使用跳表实现Map 和使用哈希算法实现Map的另外一个不同之处是：==哈希并不会保存元素的顺序，而跳表内所有的元素都是排序的==。因此在对跳表进行遍历时，你会得到一个有序的结果。所以，如果你的应用需要有序性，那么跳表就是你不二的选择。JDK 中实现这一数据结构的类是ConcurrentSkipListMap。 |                                                              |
| ArrayBlockingQueue    | AbstractQueue (java.util)<br/>    AbstractCollection (java.util)<br/>        Collection (java.util)<br/>            Iterable (java.lang)<br/>        Object (java.lang)<br/>    Queue (java.util)<br/>        Collection (java.util)<br/>            Iterable (java.lang)<br/>BlockingQueue (java.util.concurrent)<br/>    Queue (java.util)<br/>        Collection (java.util)<br/>            Iterable (java.lang)<br/>Serializable (java.io) | <img src="./images/juc/ArrayBlockingQueue.png" width=800>    | Lock+Condition                                               |
| LinkedBlockingQueue   | AbstractQueue (java.util)<br/>    AbstractCollection (java.util)<br/>        Collection (java.util)<br/>            Iterable (java.lang)<br/>        Object (java.lang)<br/>    Queue (java.util)<br/>        Collection (java.util)<br/>            Iterable (java.lang)<br/>BlockingQueue (java.util.concurrent)<br/>    Queue (java.util)<br/>        Collection (java.util)<br/>            Iterable (java.lang)<br/>Serializable (java.io) | ArrayBlockingQueue与LinkedBlockingQueue的比较?<br>相同点：<br>ArrayBlockingQueue和LinkedBlockingQueue都是通过condition通知机制来实现可阻塞式插入和删除元素，并满足线程安全的特性；<br>ArrayBlockingQueue底层是采用的数组进行实现,而LinkedBlockingQueue则是采用链表数据结构；<br>不同点:<br>ArrayBlockingQueue插入和删除数据，只采用了一个lock，==而LinkedBlockingQueue则是在插入和删除分别采用了`putLock`和`takeLock`，==这样可以降低线程由于线程无法获取到lock而进入WAITING状态的可能性，从而提高了线程并发执行的效率。 |                                                              |
| ConcurrentLinkedQueue | AbstractQueue (java.util)<br/>    AbstractCollection (java.util)<br/>        Collection (java.util)<br/>            Iterable (java.lang)<br/>        Object (java.lang)<br/>    Queue (java.util)<br/>        Collection (java.util)<br/>            Iterable (java.lang)<br/>Queue (java.util)<br/>    Collection (java.util)<br/>        Iterable (java.lang)<br/>Serializable (java.io) | ==阻塞队列==的典型例子是 BlockingQueue,==非阻塞队列==的典型例子是ConcurrentLinkedQueue，在实际应用中要根据实际需要选用阻塞队列或者非阻塞队列。 **阻塞队列可以通过加锁来实现，非阻塞队列可以通过 CAS 操作实现。**<img src="images/juc/ConcurrentLinkedQueue.png" width=800/> | 无锁算法，底层基于**自旋+CAS**的方式实现。                   |
| ConcurrentLinkedDeque | AbstractCollection (java.util)<br/>    Collection (java.util)<br/>        Iterable (java.lang)<br/>    Object (java.lang)<br/>Deque (java.util)<br/>    Queue (java.util)<br/>        Collection (java.util)<br/>            Iterable (java.lang)<br/>Serializable (java.io) |                                                              |                                                              |



> - CopyOnWrite*：只有两个
> - Concurrent*
> - Blocking*

(3)ConcurrentHashMap(注意，和HashMap相比较，实现上，ConcurrentHashMap节点种类是5种)

<img src="./images/juc/concurrenthashmap.png" width=800>

```java
    final V putVal(K key, V value, boolean onlyIfAbsent) {
        //不允许 key或value为null
        if (key == null || value == null) throw new NullPointerException();
        //计算hash值
        int hash = spread(key.hashCode());
        int binCount = 0;
        //死循环 何时插入成功 何时跳出
        for (Node<K,V>[] tab = table;;) {
            Node<K,V> f; int n, i, fh;
            //如果table为空的话，初始化table 
            if (tab == null || (n = tab.length) == 0)
                tab = initTable();
            //根据hash值计算出在table里面的位置
            else if ((f = tabAt(tab, i = (n - 1) & hash)) == null) {
                //如果这个位置没有值 ，直接放进去，不需要加锁
                if (casTabAt(tab, i, null,
                             new Node<K,V>(hash, key, value, null)))
                    break;                   // no lock when adding to empty bin
            }
            //当遇到表连接点时，需要进行整合表的操作
            else if ((fh = f.hash) == MOVED)
                tab = helpTransfer(tab, f);
            else {
                V oldVal = null;
                //结点上锁  这里的结点可以理解为hash值相同组成的链表的头结点
                synchronized (f) {
                    if (tabAt(tab, i) == f) {
                        if (fh >= 0) {
                            binCount = 1;
                            //在这里遍历链表所有的结点
                            for (Node<K,V> e = f;; ++binCount) {
                                K ek;
                                //如果hash值和key值相同  则修改对应结点的value值 
                                if (e.hash == hash &&
                                    ((ek = e.key) == key ||
                                     (ek != null && key.equals(ek)))) {
                                    oldVal = e.val;
                                    if (!onlyIfAbsent)
                                        e.val = value;
                                    break;
                                }
                                Node<K,V> pred = e;
                                 //如果遍历到了最后一个结点，那么就证明新的节点需要插入 就把它插入在链表尾部
                                if ((e = e.next) == null) {
                                    pred.next = new Node<K,V>(hash, key,
                                                              value, null);
                                    break;
                                }
                            }
                        }
                        //如果这个节点是树节点，就按照树的方式插入值
                        else if (f instanceof TreeBin) {
                            Node<K,V> p;
                            binCount = 2;
                            if ((p = ((TreeBin<K,V>)f).putTreeVal(hash, key,
                                                           value)) != null) {
                                oldVal = p.val;
                                if (!onlyIfAbsent)
                                    p.val = value;
                            }
                        }
                    }
                }
                //如果链表长度已经达到临界值8 就需要把链表转换为树结构
                if (binCount != 0) {
                    if (binCount >= TREEIFY_THRESHOLD)
                        treeifyBin(tab, i);
                    if (oldVal != null)
                        return oldVal;
                    break;
                }
            }
        }
        //将当前ConcurrentHashMap的元素数量+1
        addCount(1L, binCount);
        return null;
    }
```

（4）原子类

> AtomicInteger 类主要利用 CAS (compare and swap) + volatile 和 native 方法来保证原子操作，从而避免 synchronized 的高开销，执行效率大为提升。
>
> CAS的原理是拿期望的值和原本的一个值作比较，如果相同则更新成新的值。UnSafe 类的 objectFieldOffset() 方法是一个本地方法，这个方法是用来拿到“原来的值”的内存地址，返回值是 valueOffset。另外 value 是一个volatile变量，在内存中可见，因此 JVM 可以保证任何时刻任何线程总能拿到该变量的最新值。

| 编号 | 名字               | 解释                                                         |
| ---- | ------------------ | ------------------------------------------------------------ |
| 1    | 基本类型           | ==AtomicInteger：==整型原子类 ，==AtomicLong：==长整型原子类 ，==AtomicBoolean ：==布尔型原子类 |
| 2    | 数组类型           | ==AtomicIntegerArray：==整型数组原子类， ==AtomicLongArray：==长整型数组原子类， ==AtomicReferenceArray==：引用类型数组原子类 |
| 3    | 引用类型           | CAS 只对单个共享变量有效，当操作涉及跨多个共享变量时 CAS 无效。但是从 JDK 1.5开始，<br>提供了==AtomicReference类==来保证引用对象之间的原子性，你可以把==多个变量放在一个对象==<br>里来进行 CAS 操作.所以我们可以使用锁或者利用`AtomicReference类`把多个共享变量合并<br>成一个共享变量来操作。<br>==AtomicReference==：引用类型原子类,==AtomicStampedReference==：原子更新引用类型里的字段原子类==AtomicMarkableReference==：原子更新带有标记位的引用类型 |
| 4    | 对象的属性修改类型 | AtomicIntegerFieldUpdater:原子更新整型字段的更新器,AtomicLongFieldUpdater：原子更新长整型字段的更新器 |

> ==引用类型==
>
> ```java
> import java.util.concurrent.atomic.AtomicReference;
> public class AtomicReferenceTest {
> 	public static void main(String[] args) {
> 		AtomicReference<Person> ar = new AtomicReference<Person>();
> 		Person person = new Person("SnailClimb", 22);
> 		ar.set(person);
> 		Person updatePerson = new Person("Daisy", 20);
> 		ar.compareAndSet(person, updatePerson);
> 		System.out.println(ar.get().getName());
> 		System.out.println(ar.get().getAge());
> 	}
> }
> class Person {
> 	private String name;
> 	private int age;
> 	public Person(String name, int age) {
> 		super();
> 		this.name = name;
> 		this.age = age;
> 	}
> 	public String getName() {
> 		return name;
> 	}
> 	public void setName(String name) {
> 		this.name = name;
> 	}
> 	public int getAge() {
> 		return age;
> 	}
> 	public void setAge(int age) {
> 		this.age = age;
> 	}
> }
> ```





(5) Demo()

#### 10.为什么要使用多线程？

> 先从总体上来说：
>
> - **从计算机底层来说：**==线程可以比作是轻量级的进程，是程序执行的最小单位,线程间的切换和调度的成本远远小于进程。==另外，多核 CPU 时代意味着多个线程可以同时运行，这减少了线程上下文切换的开销。
> - **从当代互联网发展趋势来说：** 现在的系统动不动就要求百万级甚至千万级的并发量，==而多线程并发编程正是开发高并发系统的基础==，利用好多线程机制可以大大提高系统整体的并发能力以及性能。
>
> 再深入到计算机底层来探讨：
>
> - **单核时代：** 在单核时代多线程主要是为了==提高 CPU 和 IO 设备的综合利用率==。举个例子：当只有一个线程的时候会导致 CPU 计算时，IO 设备空闲；进行 IO 操作时，CPU 空闲。我们可以简单地说这两者的利用率目前都是 50%左右。但是当有两个线程的时候就不一样了，当一个线程执行 CPU 计算时，另外一个线程可以进行 IO 操作，这样两个的利用率就可以在理想情况下达到 100%了。	
> - **多核时代:** 多核时代多线程主要是为了==提高 CPU 利用率==。举个例子：假如我们要计算一个复杂的任务，我们只用一个线程的话，CPU 只会一个 CPU 核心被利用到，而创建多个线程就可以让多个 CPU 核心被利用到，这样就提高了 CPU 的利用率。

#### 11.上下文切换？

> 多线程编程中一般==线程的个数都大于 CPU 核心的个数==，而一个 CPU 核心在任意时刻只能被一个线程使用，为了让这些线程都能得到有效执行，CPU 采取的策略是==为每个线程分配时间片并轮转的形式==。当一个线程的时间片用完的时候就会重新处于就绪状态让给其他线程使用，这个过程就属于一次上下文切换。
>
> 概括来说就是：当前任务在执行完 CPU 时间片切换到另一个任务之前会先保存自己的状态，以便下次再切换会这个任务时，可以再加载这个任务的状态。==**任务从保存到再加载的过程就是一次上下文切换**。==
>
> 上下文切换通常是计算密集型的。也就是说，它需要相当可观的处理器时间，在每秒几十上百次的切换中，每次切换都需要纳秒量级的时间。所以，上下文切换对系统来说意味着消耗大量的 CPU 时间，事实上，可能是操作系统中时间消耗最大的操作。 
>
> Linux 相比与其他操作系统（包括其他类 Unix 系统）有很多的优点，其中有一项就是，其上下文切换和模式切换的时间消耗非常少。

#### 12.synchronized 关键字

（1）说一说对synchronized关键字？

> synchronized关键字解决的是==多个线程之间访问资源的同步性==，synchronized关键字可以保证被==它修饰的方法或者代码块在任意时刻只能有一个线程执行。==  另外，在 Java 早期版本中，==synchronized属于重量级锁==，效率低下，因为监视器锁（monitor）是依赖于底层的操作系统的Mutex Lock 来实现的，Java 的线程是映射到操作系统的原生线程之上的。如果要挂起或者唤醒一个线程，都需要操作系统帮忙完成，==而操作系统实现线程之间的切换时需要从用户态转换到内核态，这个状态之间的转换需要相对比较长的时间，时间成本相对较高==，这也是为什么早期的 synchronized 效率低的原因。庆幸的是在 Java 6 之后 Java 官方对从 JVM 层面对synchronized 较大优化，所以现在的 synchronized 锁效率也优化得很不错了。JDK1.6对锁的实现引入了大量的优化，如==自旋锁、适应性自旋锁、锁消除、锁粗化、偏向锁、轻量级锁等技术==来减少锁操作的开销。
>
> > （1）synchronized 同步语句块的情况？
> >
> > > synchronized 同步语句块的实现使用的是 ==monitorenter 和 monitorexit 指令==，其中 monitorenter 指令指向同步代码块的开始位置，monitorexit 指令则指明同步代码块的结束位置。** 当执行 monitorenter 指令时，线程试图获取锁也就是获取 monitor(==monitor对象存在于每个Java对象的对象头中，synchronized 锁便是通过这种方式获取锁的==，也是为什么Java中任意对象可以作为锁的原因) 的持有权。==当计数器==为0则可以成功获取，获取后将锁计数器设为1也就是加1。相应的在执行 monitorexit 指令后，将锁计数器设为0，表明锁被释放。如果获取对象锁失败，那当前线程就要阻塞等待，直到锁被另外一个线程释放为止。
> >
> >  （2）synchronized 修饰方法的的情况
> >
> > > synchronized 修饰的方法并没有 monitorenter 指令和 monitorexit 指令，取得代之的是==ACC_SYNCHRONIZED==标识，该标识指明了该方法是一个同步方法，JVM 通过该 ACC_SYNCHRONIZED 访问标志来辨别一个方法是否声明为同步方法，从而执行相应的同步调用。

（2）优化

> 锁主要存在四中状态，依次是：==无锁状态、偏向锁状态、轻量级锁状态、重量级锁状态==，他们会随着竞争的激烈而==逐渐升级==。注意锁可以升级不可降级，这种策略是为了提高获得锁和释放锁的效率。

| 编号 | 名字               | 解释                                                         |
| ---- | ------------------ | ------------------------------------------------------------ |
| 1    | 偏向锁             | **引入偏向锁的目的和引入轻量级锁的目的很像，他们都是为了没有多线程竞争的前提下，减少传统的重量级锁使用操作系统互斥量产生的性能消耗。但是不同是：轻量级锁在无竞争的情况下使用 ==CAS 操作==去代替使用互斥量。而==偏向锁在无竞争的情况下会把整个同步都消除掉==** |
| 2    | 轻量级锁           | **轻量级锁不是为了代替重量级锁，它的本意是在没有多线程竞争的前提下，==减少传统的重量级锁使用操作系统互斥量产生的性能消耗==，因为使用轻量级锁时，不需要申请互斥量。另外，==轻量级锁的加锁和解锁都用到了CAS操作。==** |
| 3    | 自旋锁和自适应自旋 | 轻量级锁失败后，虚拟机为了==避免线程真实地在操作系统层面挂起==，还会进行一项称为自旋锁的优化手段。互斥同步对性能最大的影响就是阻塞的实现，==因为挂起线程/恢复线程的操作都需要转入内核态中完成（用户态转换到内核态会耗费时间）==。对于互斥锁，如果资源已经被占用，资源申请者只能进入睡眠状态。==但是自旋锁不会引起调用者睡眠，如果自旋锁已经被别的执行单元保持，调用者就一直循环在那里看是否该自旋锁的保持者已经释放了锁，"自旋"一词就是因此而得名==。**自旋的时间不在固定了，而是和前一次同一个锁上的自旋时间以及锁的拥有者的状态来决定，虚拟机变得越来越“聪明”了**。 |
| 4    | 锁消除             | 锁消除理解起来很简单，它指的就是虚拟机即使编译器在运行时，如果检测到那些共享数据不可能存在竞争，那么就执行锁消除。锁消除可以节省毫无意义的请求锁的时间。 |
| 5    | 锁粗化             | 原则上，我们在编写代码的时候，总是推荐将同步块的==作用范围限制得尽量小==，——直在共享数据的实际作用域才进行同步，这样是为了使得需要同步的操作数量尽可能变小，如果存在锁竞争，那等待线程也能尽快拿到锁。大部分情况下，上面的原则都是没有问题的，但是如果一系列的连续操作都对同一个对象反复加锁和解锁，那么会带来很多不必要的性能消耗。 |

#### 13.AQS原理分析（AbstractQueuedSynchronizer）

> **AQS核心思想是，如果被请求的==共享资源空闲，则将当前请求资源的线程设置为有效的工作线程，并且将共享资源设置为锁定状态。==如果被请求的共享资源被占用，那么就==需要一套线程阻塞等待以及被唤醒时锁分配的机制==，这个机制AQS是用CLH队列锁实现的，即将暂时获取不到锁的线程加入到队列中。**
>
> ==ReentrangLock、Semaphore，==它们的实现都用到了一个共同的基类--**AbstractQueuedSynchronizer**,简称AQS。AQS是一个用来构建锁和同步器的框架，使用AQS能简单且高效地构造出应用广泛的大量的同步器，比如我们提到的ReentrantLock，Semaphore，其他的诸如==ReentrantReadWriteLock，SynchronousQueue，FutureTask==等等皆是基于AQS的。当然，我们自己也能利用AQS非常轻松容易地构造出符合我们自己需求的同步器。

#### 14.AQS组件

> - ==Semaphore(信号量)==-允许多个线程同时访问：** synchronized 和 ReentrantLock 都是一次只允许一个线程访问某个资源，==Semaphore(信号量)可以指定多个线程同时访问某个资源。==
> - **==CountDownLatch （倒计时器）==：** CountDownLatch是一个同步工具类，用来协调多个线程之间的同步。这个工具通常用来控制线程等待，它可以让某一个线程等待直到倒计时结束，再开始执行。
> - **==CyclicBarrier(循环栅栏)==：** CyclicBarrier 和 CountDownLatch 非常类似，它也可以实现线程间的技术等待，但是它的功能比 CountDownLatch 更加复杂和强大。主要应用场景和 CountDownLatch 类似。CyclicBarrier 的字面意思是可循环使用（Cyclic）的屏障（Barrier）。它要做的事情是，让一组线程到达一个屏障（也可以叫同步点）时被阻塞，直到最后一个线程到达屏障时，屏障才会开门，所有被屏障拦截的线程才会继续干活。CyclicBarrier默认的构造方法是 CyclicBarrier(int parties)，其参数表示屏障拦截的线程数量，==每个线程调用await()方法告诉 CyclicBarrier 我已经到达了屏障，然后当前线程被阻塞。==
>
> >| 编号 | CountDownLatch          | CyclicBarrier                   |
> >| ---- | ----------------------- | ------------------------------- |
> >| 1    | 减数方式                | 加数方式                        |
> >| 2    | countDown函数+await函数 | await函数                       |
> >| 3    | 计数为0以后，无法重置   | 计数达到指定的值后，从0重新开始 |
> >| 4    | 不可重复利用            | 可以重复利用                    |

#### 15.AQS对于资源的共享方式

> - ==Exclusive（独占）==：只有一个线程能执行，如ReentrantLock。又可分为公平锁和非公平锁：
>   - 公平锁：按照线程在队列中的排队顺序，先到者先拿到锁
>   - 非公平锁：当线程要获取锁时，无视队列顺序直接去抢锁，谁抢到就是谁的
> - ==**Share**（共享）==：多个线程可同时执行，如Semaphore/CountDownLatch。Semaphore、CountDownLatch、 CyclicBarrier、ReadWriteLock 我们都会在后面讲到。

#### 16.自定义同步器时需要重写下面几个AQS提供的模板方法

```java
isHeldExclusively()//该线程是否正在独占资源。只有用到condition才需要去实现它。
tryAcquire(int)//独占方式。尝试获取资源，成功则返回true，失败则返回false。
tryRelease(int)//独占方式。尝试释放资源，成功则返回true，失败则返回false。
tryAcquireShared(int)//共享方式。尝试获取资源。负数表示失败；0表示成功，但没有剩余可用资源；正数表示成功，且有剩余资源。
tryReleaseShared(int)//共享方式。尝试释放资源，成功则返回true，失败则返回false。
```

> ==以ReentrantLock为例==，state初始化为0，表示未锁定状态。A线程lock()时，==会调用tryAcquire()独占该锁并将state+1==。此后，其他线程再tryAcquire()时就会失败，==直到A线程unlock()到state=0（即释放锁）为止==，其它线程才有机会获取该锁。当然，释放锁之前，A线程自己是可以重复获取此锁的（state会累加），这就是可重入的概念。但要注意，获取多少次就要释放多么次，这样才能保证state是能回到零态的。
>
> 再以CountDownLatch以例，任务分为N个子线程去执行，==state也初始化为N（注意N要与线程个数一致）==。这N个子线程是并行执行的，每个子线程执行完后==countDown()一次，state会CAS(Compare and Swap)减1==。等到所有子线程都执行完后(即state=0)，==会unpark()主调用线程==，然后主调用线程就会从==await()函数返回==，继续后余动作。
>
> 一般来说，自定义同步器要么是独占方法，要么是共享方式，他们也只需实现`tryAcquire-tryRelease`、`tryAcquireShared-tryReleaseShared`中的一种即可。但AQS也支持自定义同步器同时实现独占和共享两种方式，如`ReentrantReadWriteLock`。

#### 17.Future和FutureTask的区别？==(Future等结果，FutureTask可以被提交)==

> 线程的创建方式中有两种，一种是==实现Runnable接口，另一种是继承Thread==，但是这两种方式都有个缺点，那就是在任务执行完成之后无法获取返回结果，于是就有了Callable接口，Future接口与FutureTask类的配和取得返回的结果。==FutureTask除了实现了Future接口外还实现了Runnable接口==,Future<V>接口是用来获取异步计算结果的.==无论是Runnable接口的实现类还是Callable接口的实现类，都可以被ThreadPoolExecutor或ScheduledThreadPoolExecutor执行==
>
> [Future模式](https://segmentfault.com/a/1190000015558810)是Java多线程设计模式中的一种常见模式，==它的主要作用就是异步地执行任务，并在需要的时候获取结果==。我们知道，一般调用一个函数，需要等待函数执行完成，调用线程才会继续往下执行，如果是一些计算密集型任务，需要等待的时间可能就会比较长。
>
> ```java
> <T> Future<T> submit(Callable<T> task);
> <T> Future<T> submit(Runnable task, T result);
> ```

> ```java
> //创建线程池  
> ExecutorService es = Executors.newSingleThreadExecutor();  
> //创建Callable对象任务  
> CallableDemo calTask=new CallableDemo();  
> //提交任务并获取执行结果  
> Future<Integer> future =es.submit(calTask);  
> //关闭线程池  
> es.shutdown(); 
> ```
>
> ```java
> //创建线程池  
> ExecutorService es = Executors.newSingleThreadExecutor();  
> //创建Callable对象任务  
> CallableDemo calTask=new CallableDemo();  
> //创建FutureTask  
> FutureTask<Integer> futureTask=new FutureTask<>(calTask);  
> //执行任务  
> es.submit(futureTask);  
> //关闭线程池  
> es.shutdown();  
> ```

#### 18.FutureTask的7种状态

> FutureTask的字段定义非常简单，State标识任务的当前状态，状态之间的转换通过==Unsafe来操作==，所有操作都基于==自旋+CAS==完成：

> | 编号 | 状态         | 解释                                                         |
> | ---- | ------------ | ------------------------------------------------------------ |
> | 1    | new          | 表示任务的初始化状态；                                       |
> | 2    | canceled     | 表示任务还没开始执行就被取消（非中断方式），属于最终状态；   |
> | 3    | interrupting | 表示任务还没开始执行就被取消（中断方式），正式被中断前的过渡状态，属于中间状态； |
> | 4    | interrupted  | 表示任务还没开始执行就被取消（中断方式），且已被中断，属于最终状态。 |
> | 5    | completing   | 表示任务已执行完成（正常完成或异常完成），==但任务结果或异常原因还未设置完成，属于中间状态；== |
> | 6    | exceptional  | 表示任务已经执行完成（异常完成），==且任务异常已设置完成，属于最终状态；== |
> | 7    | normal       | 表示任务已经执行完成（正常完成），==且任务结果已设置完成，属于最终状态；== |
>
> <img src="./images/juc/FutureTask.png" width="600"/>



#### 19.Java中的锁

| 编号 | 类别   | 解释                                                         | 实现机制                                                     |
| ---- | ------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1    | 悲观锁 | 总是假设最坏的情况，每次去拿数据的时候都认为别人会修改，所以每次在拿数据的时候都会上锁，这样别人想拿这个数据就会阻塞直到它拿到锁（**共享资源每次只给一个线程使用，其它线程阻塞，用完后再把资源转让给其它线程**）。传统的关系型数据库里边就用到了很多这种锁机制，比如行锁，表锁等，读锁，写锁等，都是在做操作之前先上锁。Java中`synchronized`和`ReentrantLock`等==独占锁==就是悲观锁思想的实现。 | 乐观锁一般会使用版==本号机制==或==CAS==算法实现。（==提交版本必须大于记录当前版本才能执行更新 “ 的乐观锁策略==） |
| 2    | 乐观锁 | 总是假设最好的情况，每次去拿数据的时候都认为别人不会修改，所以不会上锁，但是在更新的时候会判断一下在此期间别人有没有去更新这个数据，可以使用版本号机制和CAS算法实现。**乐观锁适用于多读的应用类型，这样可以提高吞吐量**，像数据库提供的类似于**write_condition机制**，其实都是提供的乐观锁。在Java中`java.util.concurrent.atomic`包下面的原子变量类就是使用了乐观锁的一种实现方式==CAS==实现的。 |                                                              |

> CAS的问题？
>
> -  ABA 问题
> - 循环时间长开销大
> - 只能保证一个共享变量的原子操作

### （四）JVM

#### 1.虚拟机的参数

| 编号 | 参数                                         | 含义                       |
| ---- | -------------------------------------------- | -------------------------- |
| 1    | -XX:PrintFlagsInitial                        | 打印默认的配置信息         |
| 2    | -Xms8m                                       | 堆空间8m                   |
| 3    | -Xmx8x                                       | 堆空间最大8m               |
| 4    |                                              |                            |
| 5    | -XX:MaxDirectMemorySize=5m                   | 最大直接内存5m             |
| 6    | -XX:MetaspaceSize=8m -XX:MaxMetaspaceSize=8m | 指定元空间的大小8m         |
| 7    | -XX:MaxTenuringThreshold                     | 对象晋升到老年代的年龄阈值 |
| 8    | -XX:PreBlockSpin                             | **自旋次数的默认值是10次** |

#### 2.Java 内存区域（运行时数据区）

| 编号 | 名字                                                  | 功能                                                         | 备注                                                         |
| ---- | ----------------------------------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1    | 堆<br><img src="./images/jvm/heap.png" width="1000"/> | 主要用于存放新创建的对象 (所有对象都在这里分配内存)          | jdk1.8之后永久代被替换成为了元空间（Metaspace）              |
| 2    | 方法区                                                | ==被虚拟机加载的类信息(版本、字段、方法、接口)、常量、静态变量、即时编译器编译后的代码等数据（加常静即==） | 运行时常量池是方法区的一部分。Class 文件中除了有类的版本、字段、方法、接口等描述信息外，还有常量池信息（用于存放编译期生成的各种字面量和符号引用） |
| 3    | 虚拟机栈（线程私有）                                  | 动态链接，方法出口，操作数栈，局部变量表（动方操局）         | 每个 Java 方法在执行的同时会创建一个栈帧用于存储局部变量表、操作数栈、常量池引用等信息。从方法调用直至执行完成的过程，就对应着一个栈帧在 Java 虚拟机栈中入栈和出栈的过程。 |
| 4    | 本地方法栈（线程私有）                                |                                                              | 区别是： **虚拟机栈为虚拟机执行 Java 方法 （也就是字节码）服务，而本地方法栈则为虚拟机使用到的 Native 方法服务。** 在 HotSpot 虚拟机中和 Java 虚拟机栈合二为一。 |
| 5    | 程序计数器（线程私有）                                |                                                              | 程序计数器主要有下面两个作用：==（1）字节码解释器通过改变程序计数器来依次读取指令，从而实现代码的流程控制==，如：顺序执行、选择、循环、异常处理。在多线程的情况下，==（2）程序计数器用于记录当前线程执行的位置==，从而当线程被切换回来的时候能够知道该线程上次运行到哪儿了。 |

堆的细节信息（使用虚拟机参数==-XX:+PrintGCDetails==）

> Heap
>  ==PSYoungGen==      total 74752K, used 3871K [0x000000076d180000, 0x0000000772480000, 0x00000007c0000000)
>   eden space 64512K, 6% used [0x000000076d180000,0x000000076d547c70,0x0000000771080000)
>   from space 10240K, 0% used [0x0000000771a80000,0x0000000771a80000,0x0000000772480000)
>   to   space 10240K, 0% used [0x0000000771080000,0x0000000771080000,0x0000000771a80000)
>  ==ParOldGen==       total 171008K, used 0K [0x00000006c7400000, 0x00000006d1b00000, 0x000000076d180000)
>   object space 171008K, 0% used [0x00000006c7400000,0x00000006c7400000,0x00000006d1b00000)
>  ==Metaspace==       used 3009K, capacity 4496K, committed 4864K, reserved 1056768K
>   class space    used 330K, capacity 388K, committed 512K, reserved 1048576K
>
> > 当 Eden 区没有足够空间进行分配时，虚拟机将发起一次 Minor GC.GC 期间虚拟机又发现 allocation1 无法存入 Survivor 空间，所以只好通过 **分配担保机制** 把新生代的对象提前转移到老年代中去，老年代上的空间足够存放 allocation1，所以不会出现 Full GC。执行 Minor GC 后，后面分配的对象如果能够存在 eden 区的话，还是会在 eden 区分配内存。

#### 3.直接内存也会爆出OutOfMemoryError

直接内存并不是虚拟机运行时数据区的一部分，也不是虚拟机规范中定义的内存区域，但是这部分内存也被频繁地使用。而且也可能导致 OutOfMemoryError 异常出现。

JDK1.4中新加入的 **NIO(New Input/Output) 类**，==引入了一种基于**通道（Channel）** 与**缓存区（Buffer）** 的 I/O 方式==，它可以直接使用Native函数库直接分配堆外内存，然后通过一个存储在 Java 堆中的 DirectByteBuffer 对象作为这块内存的引用进行操作。这样就能在一些场景中显著提高性能，因为**避免了在 Java 堆和 Native 堆之间来回复制数据**。

本机直接内存的分配不会收到 Java 堆的限制，但是，既然是内存就会受到本机总内存大小以及处理器寻址空间的限制。（demo：修改虚拟机参数，使用allocateDirect方法直接分配直接内存的空间）

#### 4.对象的创建过程？==（加分初设执）（双亲委派模型）==

（1）类加载检查

> 虚拟机遇到一条 new 指令时，首先将去检查这个指令的参数==是否能在常量池中定位到这个类的符号引用==，并且检查这个==符号引用代表的类是否已被加载过、解析和初始化过==。如果没有，那必须先执行相应的类加载过程。
>
> > 类加载过程==（加验准解初）==
> >
> > - 加载  protected Class<?> loadClass(String name, boolean resolve)是线程安全的！
> >   - 通过全类名获取定义此类的==二进制字节流==
> >   - 将字节流所代表的==静态存储结构==转换为方法区的==运行时数据结构==
> >   - 在内存中生成一个代表该类的==Class 对象==,作为方法区这些数据的访问入口
> >
> > - 验证（文元字符）
> >   - 文件格式验证
> >   - 元数据验证
> >   - 字节码验证
> >   - 符号引用验证
> > - 准备：准备阶段是正式为==类变量分配内存并设置类变量初始值==的阶段
> > - 解析：解析阶段是虚拟机将常量池内的==符号引用替换为直接引用的过程==。解析动作主要针对==类或接口、字段、类方法、接口方法、方法类型、方法句柄和调用限定符==7类符号引用进行。
> > - 初始化：初始化是类加载的最后一步，也是真正执行类中定义的 Java 程序代码(字节码)，初始化阶段是执行==类构造器 `<clinit> ()`方法的过程。==
>
> 加载器
>
> > - **BootstrapClassLoader(启动类加载器)** ：最顶层的加载类，由C++实现，负责加载 `%JAVA_HOME%/lib`目录下的jar包和类或者或被 `-Xbootclasspath`参数指定的路径中的所有类。
> > - **ExtensionClassLoader(扩展类加载器)** ：主要负责加载目录 `%JRE_HOME%/lib/ext` 目录下的jar包和类，或被 `java.ext.dirs` 系统变量所指定的路径下的jar包。
> > - **AppClassLoader(应用程序类加载器)** :面向我们用户的加载器，负责加载当前应用classpath下的所有jar包和类。
> >
> > > 每一个类都有一个对应它的类加载器。系统中的 ClassLoder 在协同工作的时候会默认使用 **双亲委派模型** 。==即在类加载的时候，系统会首先判断当前类是否被加载过。已经被加载的类会直接返回，否则才会尝试加载。==**加载的时候，首先会把该请求委派该父类加载器的 `loadClass()` 处理，因此所有的请求最终都应该传送到顶层的启动类加载器 `BootstrapClassLoader` 中。当父类加载器无法处理时，才由自己来处理。**当父类加载器为null时，会使用启动类加载器 `BootstrapClassLoader` 作为父类加载器。
> > >
> > > <img src="./images/jvm/shuangqinweipai.png" width="400"/>
> > >
> > > ==双亲委派模型保证了Java程序的稳定运行，可以避免类的重复加载==（JVM 区分不同类的方式不仅仅根据类名，相同的类文件被不同的类加载器加载产生的是两个不同的类），==也保证了 Java 的核心 API 不被篡改==。如果不用没有使用双亲委派模型，而是每个类加载器加载自己的话就会出现一些问题，比如我们编写一个称为 `java.lang.Object` 类的话，那么程序运行的时候，系统就会出现多个不同的 `Object` 类。

（2）分配内存 

> 在**类加载检查**通过后，接下来虚拟机将为新生对象**分配内存**。对象所需的内存大小在类加载完成后便可确定，为对象分配空间的任务等同于把一块确定大小的内存从 Java 堆中划分出来。**分配方式**有 ==**“指针碰撞”** 和 **“空闲列表”**==两种，**选择那种分配方式由 Java 堆是否规整决定，而Java堆是否规整又由所采用的垃圾收集器是否带有压缩整理功能决定**。

（3）初始化零值

> 内存分配完成后，虚拟机需要将分配到的内存空间都初始化为零值（不包括对象头），这一步操作保证了对象的实例字段在 Java 代码中可以不赋初始值就直接使用，程序能访问到这些字段的数据类型所对应的零值。

（4）设置对象头（元数据信息，对象的哈希码，对象的GC分代信息）

> 初始化零值完成之后，**虚拟机要对对象进行必要的设置**，例如这个对象是那个类的实例、如何才能找到==类的元数据信息、对象的哈希码、对象的 GC 分代年龄等信息==。 **这些信息存放在对象头中。** 另外，==根据虚拟机当前运行状态的不同，如是否启用偏向锁等，对象头会有不同的设置方式。==

（5）执行init方法

> 在上面工作都完成之后，从虚拟机的视角来看，一个新的对象已经产生了，但从 Java 程序的视角来看，对象创建才刚开始，==`<init>` 方法还没有执行，所有的字段都还为零。所以一般来说，执行 new 指令之后会接着执行 `<init>` 方法，把对象按照程序员的意愿进行初始化，这样一个真正可用的对象才算完全产生出来。==

#### 5.JVM常见面试题

（1）如何判断对象是否死亡（两种方法）?

> - 引用计数法（和引用有关系）
>
> > 给对象中添加一个引用计数器，每当有一个地方引用它，计数器就加 1；当引用失效，计数器就减 1；任何时候计数器为 0 的对象就是不可能再被使用的。这个方法实现简单，效率高，但是目前主流的虚拟机中并没有选择这个算法来管理内存，其最主要的原因是它==很难解决对象之间相互循环引用的问题==。
>
> - 可达性分析（和引用有关系）
>
> > 这个算法的基本思想就是通过一系列的称为==GC Roots的对象==作为起点，从这些节点开始向下搜索，节点所走过的路径称为引用链，==当一个对象到 GC Roots 没有任何引用链相连的话，则证明此对象是不可用的。==

（2）简单的介绍一下强引用、软引用、弱引用、虚引用（虚引用与软引用和弱引用的区别、使用软引用能带来的好处）?

> - 强引用
>
> > 我们使用的大部分引用实际上都是强引用，这是使用最普遍的引用。如果一个对象具有强引用，那就类似于**必不可少的生活用品**，==垃圾回收器绝不会回收它==。当内存空 间不足，Java 虚拟机宁愿抛出 OutOfMemoryError 错误，使程序异常终止，也不会靠随意回收具有强引用的对象来解决内存不足问题。
>
> - 软引用
>
> > 如果内存空间足够，垃圾回收器就不会回收它，如果内存空间不足了，就会回收这些对象的内存。只要垃圾回收器没有回收它，该对象就可以被程序使用。==软引用可用来实现内存敏感的高速缓存。==
>
> - 弱引用
>
> > 弱引用与软引用的区别在于：==只具有弱引用的对象拥有更短暂的生命周期。==在垃圾回收器线程扫描它 所管辖的内存区域的过程中，==一旦发现了只具有弱引用的对象，不管当前内存空间足够与否，都会回收它的内存。==不过，由于垃圾回收器是一个优先级很低的线程， 因此不一定会很快发现那些只具有弱引用的对象。 
> >
> > 弱引用可以和一个引用队列（ReferenceQueue）联合使用，如果弱引用所引用的对象被垃圾回收，Java 虚拟机就会把这个弱引用加入到与之关联的引用队列中。
>
> - 虚引用
>
> > 与其他几种引用都不同，==虚引用并不会决定对象的生命周期。==如果一个对象仅持有虚引用，那么它就和没有任何引用一样，在任何时候都可能被垃圾回收。

（3）如何判断一个常量是废弃常量?

> 假如在常量池中存在字符串 "abc"，如果当前==没有任何 String 对象引用该字符串常量==的话，就说明常量 "abc" 就是废弃常量，如果这时发生内存回收的话而且有必要的话，"abc" 就会被系统清理出常量池。

（4）如何判断一个类是无用的类?

> 方法区主要回收的是无用的类，那么如何判断一个类是无用的类的呢？
>
> 判定一个常量是否是“废弃常量”比较简单，而要判定一个类是否是“无用的类”的条件则相对苛刻许多。类需要同时满足下面 3 个条件才能算是 **“无用的类”** ：
>
> - ==该类所有的实例都已经被回收，也就是 Java 堆中不存在该类的任何实例。==
> - ==加载该类的 ClassLoader 已经被回收。==(双亲委派模型)
> - ==该类对应的 java.lang.Class 对象没有在任何地方被引用，无法在任何地方通过反射访问该类的方法。==
>
> 虚拟机可以对满足上述 3 个条件的无用类进行回收，这里说的仅仅是“可以”，而并不是和对象一样不使用了就会必然被回收。

（5）垃圾收集有哪些算法，各自的特点？

> - 复制算法
>
> > ==为了解决效率问题==，“复制”收集算法出现了。它可以将内存分为大小相同的两块，每次使用其中的一块。当这一块的内存使用完后，就将还存活的对象复制到另一块去，然后再把使用的空间一次清理掉。这样就使每次的内存回收都是对内存区间的一半进行回收。
>
> - 标记清除
>
> > 该算法分为“标记”和“清除”阶段：首先标记出所有需要回收的对象，在标记完成后统一回收所有被标记的对象。它是最基础的收集算法，后续的算法都是对其不足进行改进得到。这种垃圾收集算法会带来两个明显的问题：
> >
> > > ==**效率问题**==
> > >
> > > ==空间问题==（标记清除后会产生大量不连续的碎片）
>
> - 标记整理
>
> > 根据老年代的特点特出的一种标记算法，标记过程仍然与“标记-清除”算法一样，但后续步骤不是直接对可回收对象回收，而是==让所有存活的对象向一端移动，然后直接清理掉端边界以外的内存。==
>
> - 分代

（6）HotSpot 为什么要分为新生代和老年代？

> 根据对象存活周期的不同将内存分为几块。==一般将 java 堆分为新生代和老年代==，这样我们就可以==根据各个年代的特点选择合适的垃圾收集算法。==比如在新生代中，每次收集都会有大量对象死去，所以可以选择复制算法，只需要付出少量对象的复制成本就可以完成每次垃圾收集。而老年代的对象存活几率是比较高的，而且没有额外的空间对它进行分配担保，所以我们必须选择“标记-清除”或“标记-整理”算法进行垃圾收集。

（7）常见的垃圾回收器有那些？

<img src="./images/jvm/gc.png" width="600">

| 编号 | 回收器                           | 算法                                                         | 步骤                                                         | 备注                                                         |
| ---- | -------------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 1    | Serial 收集器（串行）            | <img src="./images/jvm/serial.png" width="400"/>             |                                                              | 单CPU的client模式                                            |
| 2    | ParNew 收集器（并行）            | <img src="./images/jvm/parnew.png" width="400"/>             |                                                              | 它是许多运行在==Server 模式==下的虚拟机的首要选择，除了 Serial 收集器外，只有它能与 CMS 收集器配合工作。 |
| 3    | Parallel Scavenge 收集器（并行） |                                                              |                                                              | ==（吞吐量）==Parallel Scavenge 收集器关注点是==吞吐量==（高效率的利用 CPU），==后台运行不需要太多交互== |
| 4    | Serial Old 收集器（串行）        |                                                              |                                                              | 单CPU的client模式，和CMS配合                                 |
| 5    | Parallel Old 收集器（并行）      |                                                              |                                                              | ==（吞吐量）====后台运行不需要太多交互==                     |
| 6    | CMS 收集器（并发）               | <img src="./images/jvm/cms.png" width="400"/><br>==标记清除== | （1）初始标记<br>（2）并发标记（混合）<br/>（3）重新标记<br/>（4）并发清除（混合） | CMS 等垃圾收集器的关注点更多的是==用户线程==的停顿时间（提高用户体验），集中使用在互联网或者B/S系统服务端 |
| 7    | G1 收集器（并发）                |                                                              |                                                              | 面向服务端，将来替换CMS                                      |



（8）Minor Gc 和 Full GC 有什么不同呢？

> - **==新生代 GC（Minor GC）==**:指发生新生代的的垃圾收集动作，Minor GC 非常频繁，回收速度一般也比较快。
> - **==老年代 GC（Major GC/Full GC）==**:指发生在老年代的 GC，出现了 Major GC 经常会伴随至少一次的 Minor GC（并非绝对），Major GC 的速度一般会比 Minor GC 的慢 10 倍以上。

#### 6.JDK 监控和故障处理工具总结

| 编号 | 工具     | 解释                                                         | 用法                                                     |
| ---- | -------- | ------------------------------------------------------------ | -------------------------------------------------------- |
| 1    | jps      | (JVM Process Status）: 类似 UNIX 的 `ps` 命令。用户查看所有 Java 进程的启动类、传入参数和 Java 虚拟机参数等信息； |                                                          |
| 2    | jinfo    | (Configuration Info for Java) : Configuration Info forJava,显示==虚拟机配置信息;== | （1）jinfo -flag MaxHeapSize<br>                         |
| 3    | jstat    | (JVM Statistics Monitoring Tool):  用于收集 HotSpot 虚拟机各方面的==运行数据==; |                                                          |
| 4    | jmap     | (Memory Map for Java) :生成==堆转储快照;==                   | （1）可以使用==-XX:+HeapDumpOnOutOfMemoryError==代替<br> |
| 5    | jhat     | (JVM Heap Dump Browser ) : 用于分析 ==heapdump 文件==，它会建立一个 HTTP/HTML 服务器，让用户可以在浏览器上查看分析结果; |                                                          |
| 6    | jstack   | (Stack Trace for Java):生成虚拟机当前时刻的==线程快照==，线程快照就是当前虚拟机内每一条线程正在执行的方法堆栈的集合。 |                                                          |
| 7    | jconsole |                                                              |                                                          |
| 8    | javap    | 查看字节码                                                   |                                                          |

#### 7.类文件结构（魔文常访当字方属）

| 编号 | 数据                               | 解释                                                         |
| ---- | ---------------------------------- | ------------------------------------------------------------ |
| 1    | 魔数                               | 每个 Class 文件的头四个字节称为魔数（Magic Number）,它的唯一作用是**确定这个文件是否为一个能被虚拟机接收的 Class 文件**。 |
| 2    | Class文件版本                      | 高版本的 Java 虚拟机可以执行低版本编译器生成的 Class 文件，但是低版本的 Java 虚拟机不能执行高版本编译器生成的 Class 文件。所以，我们在实际开发的时候要确保开发的的 JDK 版本和生产环境的 JDK 版本保持一致。 |
| 3    | 常量池                             | 常量池主要存放两大常量：==字面量和符号引用==。字面量比较接近于 Java 语言层面的的常量概念，如文本字符串、声明为 final 的常量值等。==javap -v *.class查看== |
| 4    | 访问标志                           | 在常量池结束之后，紧接着的两个字节代表访问标志，这个标志用于识别一些类或者接口层次的访问信息，包括：==这个 Class 是类还是接口，是否为 public 或者 abstract 类型，如果是类的话是否声明为 final 等等。== |
| 5    | 当前类索引，父类索引和接口索引集合 | ==类索引用于确定这个类的全限定名，父类索引用于确定这个类的父类的全限定名==，由于 Java 语言的单继承，所以父类索引只有一个，除了 `java.lang.Object` 之外，所有的 java 类都有父类，因此除了 `java.lang.Object` 外，所有 Java 类的父类索引都不为 0。==接口索引集合用来描述这个类实现了那些接口==，这些被实现的接口将按`implents`(如果这个类本身是接口的话则是`extends`) 后的接口顺序从左到右排列在接口索引集合中。 |
| 6    | 字段表集合                         | 字段表（field info）用于描述接口或类中声明的变量。字段包括==类级变量以及实例变量==，但不包括在方法内部声明的局部变量。 |
| 7    | 方法表集合                         | Class 文件存储格式中对方法的描述与对字段的描述几乎采用了完全一致的方式。方法表的结构如同字段表一样，依次包括了==访问标志、名称索引、描述符索引、属性表集合几项。== |
| 8    | 属性表集合                         | 在 Class 文件，字段表，方法表中都可以携带自己的属性表集合，以用于描述某些场景专有的信息。与 Class 文件中其它的数据项目要求的顺序、长度和内容不同，属性表集合的限制稍微宽松一些，不再要求各个属性表具有严格的顺序，并且只要不与已有的属性名重复，任何人实现的编译器都可以向属性表中写 入自己定义的属性信息，Java 虚拟机运行时会忽略掉它不认识的属性。 |

#### 8.常量池存放（字面量，符号引用）

（1）字面量

> 字面量比较接近于 Java 语言层面的的常量概念，如文本字符串、声明为 final 的常量值等。

（2）符号引用(==全限定名，描述符==)

> - 类和接口的全限定名 
> - 字段的名称和描述符 
> - 方法的名称和描述符

#### 9.自定义加载器(==不要轻易覆盖loadClass==)

双亲委派模型是为了保证 如果加载的类是一个系统类，那么会优先由Bootstrap ClassLoader 、Extension ClassLoader先去加载，而不是使用我们自定义的ClassLoader去加载，保证系统的安全！

> ```java
> URLClassLoader v2 = new URLClassLoader(new URL[]{new URL(v2dir)});
> Class<?> depv1Class = v1.loadClass("JavaDemo.VMTest.DiamondDependency.v1.Dep");
> ```

**为什么要自定义ClassLoader？**

> 因为系统的ClassLoader只会加载指定目录下的class文件,如果你想加载自己的class文件,那么就可以自定义一个ClassLoader。而且我们可以根据自己的需求，对class文件进行加密和解密。==有很多字节码加密技术就是依靠定制 ClassLoader 来实现的。==先使用工具对字节码文件进行加密，运行时使用定制的 ClassLoader 先解密文件内容再加载这些解密后的字节码。

**如何自定义ClassLoader？**==（findClass------>defineClass------>loadClass）==

> - 新建一个类继承自java.lang.ClassLoader,==重写它的findClass方法。==
>
> - 将class字节码数组转换为==Class类==的实例（这点需要和判断一个类是不是没用建立联系）
>
> - 使用：==调用loadClass方法即可==（这点要和判断一个类是不是没用建立联系）
>
> ```java
> package JavaDemo.VMTest.ClassLoaderDemo;
> 
> import java.io.*;
> 
> public class MyClassLoader extends ClassLoader {
>     //指定路径
>     private String path ;
> 
>     public MyClassLoader(String classPath){
>         path=classPath;
>     }
>     /**
>      * 重写findClass方法
>      * @param name 是我们这个类的全路径
>      * @return
>      * @throws ClassNotFoundException
>      */
>     @Override
>     protected Class<?> findClass(String name) throws ClassNotFoundException {
>         Class log = null;
>         // 获取该class文件字节码数组
>         byte[] classData = getData();
> 
>         if (classData != null) {
>             // 将class的字节码数组转换成Class类的实例
>             log = defineClass(name, classData, 0, classData.length);
>         }
>         return log;
>     }
> 
>     /**
>      * 将class文件转化为字节码数组
>      * @return
>      */
>     private byte[] getData() {
>         File file = new File(path);
>         if (file.exists()){
>             FileInputStream in = null;
>             ByteArrayOutputStream out = null;
>             try {
>                 in = new FileInputStream(file);
>                 out = new ByteArrayOutputStream();
> 
>                 byte[] buffer = new byte[1024];
>                 int size = 0;
>                 while ((size = in.read(buffer)) != -1) {
>                     out.write(buffer, 0, size);
>                 }
> 
>             } catch (IOException e) {
>                 e.printStackTrace();
>             } finally {
>                 try {
>                     in.close();
>                 } catch (IOException e) {
>                     e.printStackTrace();
>                 }
>             }
>             return out.toByteArray();
>         }else{
>             return null;
>         }
>     }
> }
> ```
>
> ```java
> package JavaDemo.VMTest.ClassLoaderDemo;
> 
> public class Log {
>     public static void main(String[] args) {
>         System.out.println("load Log class successfully");
>     }
> }
> ```
>
> ```java
> package JavaDemo.VMTest.ClassLoaderDemo;
> 
> import java.lang.reflect.InvocationTargetException;
> import java.lang.reflect.Method;
> 
> public class ClassLoaderMain {
>     public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, InvocationTargetException {
>         //这个类class的路径
>         String classPath = "/home/mao/workspace/java/out/production/java/JavaDemo/VMTest/ClassLoaderDemo/Log.class";
> 
>         MyClassLoader myClassLoader = new MyClassLoader(classPath);
> 
>         //类的全称
>         String packageNamePath = "JavaDemo.VMTest.ClassLoaderDemo.Log";
>         //加载Log这个class文件
>         Class<?> Log = myClassLoader.loadClass(packageNamePath);
> 
>         System.out.println("类加载器是:" + Log.getClassLoader());
> 
>         //利用反射获取main方法
>         Method method = Log.getDeclaredMethod("main", String[].class);
>         Object object = Log.newInstance();
>         String[] arg = {"ad"};
>         method.invoke(object, (Object) arg);
>     }
> }
> 
> ```

#### 10.钻石依赖问题

项目管理上有一个著名的概念叫着「钻石依赖」，是指软件依赖导致同一个软件包的两个版本需要共存而不能冲突。ClassLoader 固然可以解决依赖冲突问题，不过它也限制了不同软件包的操作界面必须使用==反射或接口的方式==进行动态调用。

```java
package JavaDemo.VMTest.DiamondDependency.v1;

public class Dep {
    public void print() {
        System.out.println("v1");
    }
}
```

```java
package JavaDemo.VMTest.DiamondDependency.v2;

public class Dep {
    public void print() {
        System.out.println("v2");
    }
}

```

```java
package JavaDemo.VMTest.DiamondDependency;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class DiamondDependencyTest {
    public static void main(String[] args) throws MalformedURLException,
            ClassNotFoundException,
            NoSuchMethodException,
            IllegalAccessException,
            InvocationTargetException,
            InstantiationException {
        String v1dir = "file:///home/mao/workspace/java/out/production/java/JavaDemo/VMTest/DiamondDependency/v1/";
        String v2dir = "file:///home/mao/workspace/java/out/production/java/JavaDemo/VMTest/DiamondDependency/v2/";
        URLClassLoader v1 = new URLClassLoader(new URL[]{new URL(v1dir)});
        URLClassLoader v2 = new URLClassLoader(new URL[]{new URL(v2dir)});

        Class<?> depv1Class = v1.loadClass("JavaDemo.VMTest.DiamondDependency.v1.Dep");
        Object depv1 = depv1Class.getConstructor().newInstance();
        depv1Class.getMethod("print").invoke(depv1);

        Class<?> depv2Class = v2.loadClass("JavaDemo.VMTest.DiamondDependency.v2.Dep");
        Object depv2 = depv2Class.getConstructor().newInstance();
        depv2Class.getMethod("print").invoke(depv2);

        System.out.println(depv1Class.equals(depv2Class));

    }
}
```



### （五）I/O

#### 1.InputStream,OutputStream,Reader,Writer？

> - InputStream,OutputStream:面向字节流
>
> - Reader,Writer:面向字符流
>
> > 操作对象(文件,数组,基本数据类型,缓冲,管道,打印,对象序列化,转化)
> >
> > - (1)文件
> >
> > > FileInputStream
> > > FileOutputStream
> > > FileReader
> > > FileWriter
> >
> > - (2)数组
> >
> > > ByteArrayInputStream
> > > ByteArrayOutputStream
> > > CharArrayReader
> > > CharArrayWriter
> >
> > - (3)基本数据类型
> >
> > > DataInputStream
> > > DataOutputStream
> >
> > - (4)缓冲
> >
> > > BufferedInputStream
> > > BufferedOutputStream
> > > BufferedReader
> > > BufferedWriter
> >
> > - (5)管道
> >
> > > PipedInputStream
> > > PipedOutputStream
> > > PipedReader
> > > PipedWriter
> >
> > - (6)打印
> >
> > > printStream
> > > printWriter
> >
> > - (7)对象序列化
> >
> > > ObjectInputStream
> > > ObjectOutputStream
> >
> > - (8)转化
> >
> > > InputStreamReader
> > > OutputStreamWriter

#### 2.I/O相关的概念（如同步/异步，阻塞/非阻塞）

> （1）I/O分类
>
> > - java 中 IO 流分为几种?
> >   - 按照流的流向分，可以分为输入流和输出流；
> >   - 按照操作单元划分，可以划分为字节流和字符流；
> >   - 按照流的角色划分为节点流和处理流。
> > - Java Io流共涉及40多个类， Java I0流的40多个类都是从如下4个抽象类基类中派生出来的。
> >   - InputStream/Reader: 所有的输入流的基类，前者是字节输入流，后者是字符输入流。
> >   - OutputStream/Writer: 所有输出流的基类，前者是字节输出流，后者是字符输出流。
>
> （2）同步/异步，阻塞/非阻塞
>
> > - 同步/异步（==被调用==者不会/会直接返回结果）
> > - 阻塞/非阻塞（==调用者==不会/会去做其他的事情，需不需要一直等）

#### 3.Java NIO和IO之间第一个最大的区别是，IO是面向流的，NIO是面向缓冲区的

| IO                         | NIO                                               |
| -------------------------- | ------------------------------------------------- |
| IO流是阻塞的               | NIO流是不阻塞的                                   |
| IO 面向流(Stream oriented) | NIO 面向缓冲区(Buffer oriented)                   |
|                            | NIO 通过Channel（通道） 进行读写。                |
|                            | NIO有选择器，选择器用于使用单个线程处理多个通道。 |

> （1）面向流和面向缓冲区比较(Stream Oriented vs. Buffer Oriented)
>
> > 第一个重大差异是==IO是面向流的，而NIO是面向缓存区==的。这句话是什么意思呢？
> >
> > Java IO面向流意思是我们每次从流当中读取一个或多个字节。怎么处理读取到的字节是我们自己的事情。他们不会再任何地方缓存。再有就是我们不能在流数据中向前后移动。如果需要向前后移动读取位置，那么我们需要首先为它创建一个缓存区。==socket.getOutputStream().write()==,  ==InputStream inputStream = socket.getInputStream();==    ==inputStream.read(data))==  这里data可以被指定为一个数组
> >
> > Java NIO是面向缓冲区的，这有些细微差异。数据是被读取到缓存当中以便后续加工。我们可以在缓存中向向后移动。这个特性给我们处理数据提供了更大的弹性空间。当然我们任然需要在使用数据前检查缓存中是否包含我们需要的所有数据。另外需要确保在往缓存中写入数据时避免覆盖了已经写入但是还未被处理的数据。
>
> （2）阻塞和非阻塞IO比较（Blocking vs. No-blocking IO）
>
> > Java IO的各种流都是阻塞的。这意味着一个线程一旦调用了read(),write()方法，那么该线程就被阻塞住了，知道读取到数据或者数据完整写入了。在此期间线程不能做其他任何事情。
> >
> > Java NIO的非阻塞模式使得线程可以通过==channel来读数据==，并且是返回当前已有的数据，或者什么都不返回如果但钱没有数据可读的话。这样一来线程不会被阻塞住，它可以继续向下执行。 NIO提供了与传统BIO模型中的 ==Socket==和 ==ServerSocket==相对应的 ==SocketChannel==和 ==ServerSocketChannel== 两种不同的套接字通道实现,两种通道都支持阻塞和非阻塞两种模式。
> >
> > 通常线程在调用非阻塞操作后，会通知处理其他channel上的IO操作。因此一个线程可以管理多个channel的输入输出。

#### 4.NIO和AIO的对比？

> - ==NIO是同步非阻塞的，AIO是异步非阻塞的==
> - 由于NIO的读写过程依然在应用线程里完成，所以对于那些读写过程时间长的，NIO就不太适合。而AIO的读写过程完成后才被通知，所以AIO能够胜任那些重量级，读写过程长的任务。

NIO:http://wiki.jikexueyuan.com/project/java-nio-zh/java-nio-non-blocking-server.html

#### 5.Channel，Buffer,Seletor?

(1)Channel

> - FileChannel
>
> > 在Java NIO中如果一个channel是FileChannel类型的，那么他可以直接把数据传输到另一个channel。逐个特性得益于FileChannel包含的==transferTo和transferFrom两个方法。==
> >
> > > ==transferFrom()==:FileChannel.transferFrom方法把数据从通道源传输到FileChannel：
> > >
> > > ```java
> > > RandomAccessFile fromFile = new RandomAccessFile("fromFile.txt", "rw");
> > > FileChannel      fromChannel = fromFile.getChannel();
> > > 
> > > RandomAccessFile toFile = new RandomAccessFile("toFile.txt", "rw");
> > > FileChannel      toChannel = toFile.getChannel();
> > > 
> > > long position = 0;
> > > long count    = fromChannel.size();
> > > 
> > > toChannel.transferFrom(fromChannel, position, count);
> > > ```
> > >
> > > ==transferTo()==:transferTo方法把FileChannel数据传输到另一个channel,下面是案例：
> > >
> > > ```java
> > > RandomAccessFile fromFile = new RandomAccessFile("fromFile.txt", "rw");
> > > FileChannel      fromChannel = fromFile.getChannel();
> > > 
> > > RandomAccessFile toFile = new RandomAccessFile("toFile.txt", "rw");
> > > FileChannel      toChannel = toFile.getChannel();
> > > 
> > > long position = 0;
> > > long count    = fromChannel.size();
> > > 
> > > fromChannel.transferTo(position, count, toChannel);
> > > ```
>
> - DatagramChannel
> - SocketChannel
> - ServerSocketChannel
>
> > FileChannel用于文件的数据读写。
> > DatagramChannel用于UDP的数据读写。
> > SocketChannel用于TCP的数据读写。
> > ServerSocketChannel允许我们监听TCP链接请求，每个请求会创建会一个SocketChannel.

(2)Buffer(7)（没有boolean）

> - ByteBuffer
> - ==MappedBytesBuffer,一般用于和内存映射的文件。==
> - CharBuffer
> - DoubleBuffer
> - FloatBuffer
> - IntBuffer
> - LongBuffer
> - ShortBuffer
>
> > 利用Buffer读写数据，通常遵循四个步骤：
> >
> > - 把数据==写入buffer==；
> > - 调用flip；
> > - 从Buffer中读取数据；
> > - 调用buffer.clear()或者buffer.compact(), clear会清空整个buffer，compact则只清空已读取的数据
>
> 一个Buffer有三个属性是必须掌握的，分别是：
>
> > - capacity容量
> > - position位置
> > - limit限制
>
> 分配一个Buffer（Allocating a Buffer）
>
> > ```
> > ByteBuffer buf = ByteBuffer.allocate(48);
> > ```
>
> 写入数据到Buffer（Writing Data to a Buffer）
>
> > - 从Channel中写数据到Buffer
> > - 手动写数据到Buffer，调用put方法
> >
> > > ```
> > > int bytesRead = inChannel.read(buf); //read into buffer.
> > > ```
> > >
> > > ```
> > > buf.put(127);    
> > > ```
>
> 翻转flip()
>
> > flip()方法可以吧Buffer从==写模式切换到读模式==。调用==flip方法会把position归零，并设置limit为之前的position的值==。也就是说，现在position代表的是读取位置，limit标示的是已写入的数据位置。
>
> 从Buffer读取数据（Reading Data from a Buffer）
>
> > - 从buffer读数据到channel
> > - 从buffer直接读取数据，调用get方法
> >
> > ```
> > //read from buffer into channel.
> > int bytesWritten = inChannel.write(buf);
> > byte aByte = buf.get();
> > ```
>
> rewind()
>
> > Buffer.rewind()方法将position置为0，这样我们可以重复读取buffer中的数据。limit保持不变。
>
> clear() and compact()
>
> > 一旦我们从buffer中读取完数据，需要复用buffer为下次写数据做准备。只需要调用clear或compact方法。
> >
> > clear方法会重置position为0，limit为capacity，也就是整个Buffer清空。实际上Buffer中数据并没有清空，我们只是把标记为修改了。
> >
> > 如果Buffer还有一些数据没有读取完，调用clear就会导致这部分数据被“遗忘”，因为我们没有标记这部分数据未读。
> >
> > 针对这种情况，如果需要保留未读数据，那么可以使用compact。 因此compact和clear的区别就在于对未读数据的处理，是保留这部分数据还是一起清空。
>
> mark() and reset()
>
> > 通过mark方法可以标记当前的position，通过reset来恢复mark的位置，这个非常像canva的save和restore：
> >
> > ```
> > buffer.mark();
> > 
> > //call buffer.get() a couple of times, e.g. during parsing.
> > 
> > buffer.reset();  //set position back to mark.    
> > ```

(3) Java NIO Selector选择器

> Selector是Java NIO中的一个组件，用于检查一个或多个NIO Channel的状态是否处于可读、可写。如此可以实现单线程管理多个channels,也就是可以管理多个网络链接。
>
> 创建一个Selector可以通过Selector.open()方法：
>
> > ```java
> > Selector selector = Selector.open();
> > ```
>
> 注册Channel到Selector上(Registering Channels with the Selector)
>
> > ```java
> > channel.configureBlocking(false);
> > SelectionKey key = channel.register(selector, SelectionKey.OP_READ);
> > ```
> >
> > register第二个参数，有四种基础类型可供监听：
> >
> > - Connect------------------->SelectionKey.OP_CONNECT
> >
> > - Accept--------------------->SelectionKey.OP_ACCEPT
> >
> > - Read------------------------>SelectionKey.OP_READ
> >
> > - Write------------------------>SelectionKey.OP_WRITE
> >
> > 一个channel触发了一个事件也可视作该事件处于就绪状态。因此当channel与server连接成功后，那么就是“连接就绪”状态。server channel接收请求连接时处于“可连接就绪”状态。channel有数据可读时处于“读就绪”状态。channel可以进行数据写入时处于“写就绪”状态。
> >
> > ```java
> > int interestSet = SelectionKey.OP_READ | SelectionKey.OP_WRITE;
> > ```
> >
> > SelectionKeys包含了的属性
> >
> > - The interest set
> > - The ready set
> > - The Channel
> > - The Selector
> > - An attached object (optional)
> >
> > > **Interest Set**
> > >
> > > 这个“关注集合”实际上就是我们希望处理的事件的集合，它的值就是注册时传入的参数，我们可以用按为与运算把每个事件取出来
> > >
> > > ```java
> > > int interestSet = selectionKey.interestOps();
> > > 
> > > boolean isInterestedInAccept  = interestSet & SelectionKey.OP_ACCEPT;
> > > boolean isInterestedInConnect = interestSet & SelectionKey.OP_CONNECT;
> > > boolean isInterestedInRead    = interestSet & SelectionKey.OP_READ;
> > > boolean isInterestedInWrite   = interestSet & SelectionKey.OP_WRITE; 
> > > ```
> > >
> > > **Ready Set**
> > >
> > > "就绪集合"中的值是当前channel处于就绪的值，一般来说在调用了select方法后都会需要用到就绪状态
> > >
> > > ```java
> > > selectionKey.isAcceptable();
> > > selectionKey.isConnectable();
> > > selectionKey.isReadable();
> > > selectionKey.isWritable();
> > > ```
> > >
> > > **Channel + Selector**
> > >
> > > ```java
> > > Channel  channel  = selectionKey.channel();
> > > Selector selector = selectionKey.selector();   
> > > ```
> > >
> > > **Attaching Objects**
> > >
> > > 我们可以给一个SelectionKey附加一个Object，这样做一方面可以方便我们识别某个特定的channel，同时也增加了channel相关的附加信息。例如，可以把用于channel的buffer附加到SelectionKey上：
> > >
> > > ```java
> > > selectionKey.attach(theObject);
> > > 
> > > Object attachedObj = selectionKey.attachment();
> > > ```
> > >
> > > 附加对象的操作也可以在register的时候就执行：
> > >
> > > ```java
> > > SelectionKey key = channel.register(selector, SelectionKey.OP_READ, theObject);
> > > ```
>
> 从Selector中选择channel(Selecting Channels via a Selector)
>
> > - int select()
> > - int select(long timeout)
> > - int selectNow()
>
> selectedKeys()
>
> > 在调用select并返回了有channel就绪之后，可以通过选中的key集合来获取channel，这个操作通过调用selectedKeys()方法
>
> wakeUp()
>
> close()

(4)主要步骤和元素

> - 首先，通过 Selector.open() 创建一个 ==Selector==，作为类似调度员的角色。
> - 然后，创建一个==ServerSocketChannel，并且向 Selector 注册==，通过指定SelectionKey.OP_ACCEPT，告诉调度员，它关注的是新的连接请求。注意，为什么我们要明确配置非阻塞模式呢？这是因为阻塞模式下，注册操作是不允许的，会抛出 IllegalBlockingModeException 异常。
> - Selector 阻塞在== select 操作==，当有 Channel 发生接入请求，就会被唤醒。
> - 通过 ==SocketChannel 和 Buffer== 进行数据操作，在本例中是发送了一段字符串。

| Channel | Buffer | Selector |
| ------- | ------ | -------- |
|         |        |          |



#### 6.Java NIO Channel通道和流非常相似，主要有以下几点区别?

> - 通道可以读也可以写，流一般来说是单向的（只能读或者写）。
> - 通道可以异步读写。
> - 通道总是基于缓冲区Buffer来读写。

#### 7.SocketChannel ,  ServerSocketChannel

|      | SocketChannel                                               | ServerSocketChannel                |
| ---- | ----------------------------------------------------------- | ---------------------------------- |
| 方法 | open();    close();    write();      read();     connect(); | open();     close();     accept(); |



#### 8.[AsynchronousChannel](https://docs.oracle.com/javase/8/docs/api/java/nio/channels/AsynchronousChannel.html)(提前返回)

(1)read

- ==第一种方式（使用CompletionHandler）==

![](./images/io/aio_read_1.png)

- ==第二种方式（使用Future）==

![](./images/io/aio_read_2.png)

(2)write

- ==第一种方式（使用CompletionHandler）==

![](./images/io/aio_write_1.png)

- ==第二种方式（使用Future）==

![](./images/io/aio_write_2.png)

#### 9.什么是Java序列化，如何实现Java序列化？

#### 10.Java有几种文件拷贝方式？哪一种最高效？

(1)利用 java.io 类库，直接为源文件构建一个 FileInputStream 读取，然后再为目标文件构建一个FileOutputStream，完成写入工作.

(2)利用 java.nio 类库提供的 transferTo 或 transferFrom 方法实现。

(3)Java 标准类库本身提供了几种 Files.copy 的实现。（java.nio.file.Files.copy）

![](./images/io/nio_copy.png)

> 对于 Copy 的效率，这个其实与操作系统和配置等情况相关，总体上来说，NIO transferTo/From 的方式可能更快，因为它更能利用现代操作系统底层机制，避免不必要拷贝
> 和上下文切换。

12. Reactor, Proactor?

13. Netty

### （六）Java 8

## 六、Spring
## 七、Docker

## 八、Redis高并发

1. Redis的高并发和快速原因？

   >（1）Redis是基于内存的，内存的读写速度非常快；
   >
   >（2）Redis是单线程的，省去了很多上下文切换线程的时间；
   >
   >（3）Redis使用多路复用技术，可以处理并发的连接。非阻塞IO 内部实现采用epoll，采用了epoll+自己实现的简单的事件框架。epoll中的读、写、关闭、连接都转化成了事件，然后利用epoll的多路复用特性，绝不在io上浪费一点时间。

2. 为什么Redis是单线程的？

   >（1）官方答案
   >
   >因为Redis是基于内存的操作，CPU不是Redis的瓶颈，Redis的瓶颈最有可能是机器内存的大小或者网络带宽。既然单线程容易实现，而且CPU不会成为瓶颈，那就顺理成章地采用单线程的方案了。
   >
   >（2）性能指标
   >
   >关于redis的性能，官方网站也有，普通笔记本轻松处理每秒几十万的请求。
   >
   >（3）详细原因
   >
   >- 不需要各种锁的性能消耗
   >
   >> Redis的数据结构并不全是简单的Key-Value，还有list，hash等复杂的结构，这些结构有可能会进行很细粒度的操作，比如在很长的列表后面添加一个元素，在hash当中添加或者删除一个对象。这些操作可能就需要加非常多的锁，导致的结果是同步开销大大增加。总之，在单线程的情况下，就不用去考虑各种锁的问题，不存在加锁释放锁操作，没有因为可能出现死锁而导致的性能消耗。
   >
   >- 单线程多进程集群方案
   >
   >> 单线程的威力实际上非常强大，每核心效率也非常高，多线程自然是可以比单线程有更高的性能上限，但是在今天的计算环境中，即使是单机多线程的上限也往往不能满足需要了，需要进一步摸索的是多服务器集群化的方案，这些方案中多线程的技术照样是用不上的。所以单线程、多进程的集群不失为一个时髦的解决方案。
   >
   >- CPU消耗
   >
   >> 采用单线程，避免了不必要的上下文切换和竞争条件，也不存在多进程或者多线程导致的切换而消耗 CPU。

3. Redis支持的数据结构？

   (1)String

   (2)List

   (3)Map

   (4)Set

   (5)ZSet

## 九、kafka

## 十、补充

### 1.布隆过滤器？

### 2.BitMap？

### 3.爬虫的链接死循环？

### 4.各种状态？

#### （1）FutureTask状态？

#### （2）Channel状态？

#### （3）线程池的状态？



