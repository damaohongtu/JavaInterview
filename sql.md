**数据操纵语言**(DML)命令包括：SELECT（查询）、INSERT（添加）、UPDATE（修改）、DELETE（删除）；用于检索、插入和修改数据。    

**数据定义语言**(DDL)命令包括：CREATE、ALTER、DROP、TRUNCATE、RENAME等；用于改变数据库结构。

==TRUNCATE TABLE== 删除表中的所有行，但表结构及其列、约束、索引等保持不变。

**数据控制语言**(DCL)命令是用来设置或更改数据库用户或角色权限的语句,包括（grant,deny,revoke等）语句

**数据库对象**主要包含：触发器（Trigger）、表（Table）、视图（View）、存储过程（StoredProcedure）、索引（Index）、缺省值（Default）、图表（Diagram）、用户（User）、规则（Rule）等几类。

## **数据操纵语言**(DML)

### 查询SELECT

#### 检索数据

- ##### 大小写

SQL 语句关键字、函数名等对大小写不敏感。SELECT 等效于 select，但在**通配符**匹配时区分。**建议关键字都大写，列和表名小写**。

- ##### 不同行

关键词 **DISTINCT** 用于返回唯一不同的值，且应用于其后的所有列。

- ##### 限制结果

```mysql
SELECT column_name(s) FROM table_name LIMIT number
```

number指示返回不多于number行；还可制定检索的开始行和行数：

```mysql
SELECT column_name(s) FROM table_name LIMIT 1，1
```

检索出第2行（检索出来第一行为行0）

#### 排序数据

order by 子句中的列不一定为检索列；

默认排序方式为升序；降序需要DESC关键字，即：

```mysql
SELECT xx FROM xx ORDER BY xx DESC;
```

order by 和 limit 组合找出列中最高/低值：

```mysql
SELECT xx FROM xx ORDER BY xx DESC LIMIT 1;
```

#### 过滤数据

在有order by 时，order by 一定位于 where 后。

在一般执行匹配时，默认不区分大小写(通配符匹配要)

- ##### 范围匹配：

  注意：between...and...是闭区间；日期字符串可以用between...and...比较

```mysql
SELECT xx FROM xx WHERE xx BETWEEN xx AND xx;
```

- ##### 空值匹配：

```mysql
SELECT xx FROM xx WHERE xx IS NULL (IS NOT NULL);
```

##### 1. 组合where子句

通过AND 和 OR关键字组合 WHERE 子句；AND优先级高于OR，故注意使用括号.

##### 2. IN操作符

IN 和 WHERE搭配使用，指定要匹配值的清单；

##### 3. NOT操作符

通常用 NOT BETWEEN, NOT IN, NOT EXISTS

##### 4. 通配符过滤

==LIKE：LIKE 操作符用于在 WHERE 子句中搜索列中的指定模式==。

%还能匹配0个字符，但不能匹配 NULL；

```mysql
SELECT column_name(s) FROM table_name WHERE column_name LIKE 'N%';
SELECT column_name(s) FROM table_name WHERE column_name NOT LIKE 'N%';
```

此时区分大小写匹配。

#### 计算字段

##### 1.拼接字段

```mysql
SELECT Concat(RTrim(vend_name),'(',vend_country,')') FROM vendors ORDER BY vend_name;
```

结合RTrim和LTrim进行拼接。

##### 2.表别名

```mysql
SELECT Concat(RTrim(vend_name),'(',vend_country,')') AS vend_title FROM vendors ORDER BY vend_name;
```

##### 3.算数操作符

+、-、*、/，均可用于select之后

#### sql函数

##### 1.字符函数

CONCAT(X,Y) 连接字符串X和Y

LENGTH(X) 返回X的长度

LOWER(X) X转换成小写

UPPER(X) X转换成大写

LTRIM(X[,TRIM_STR]) 把X的左边截去trim_str字符串，缺省截去空格

RTRIM(X[,TRIM_STR]) 把X的右边截去trim_str字符串，缺省截去空格

TRIM([TRIM_STR  FROM]X) 把X的两边截去trim_str字符串，缺省截去空格

REPLACE(X,old,new) 在X中查找old，并替换成new

SUBSTR(X,start,length) 返回X的子串，从start处开始，截取length个字符；缺省length，默认到结尾。字符串用单引号括起来

##### 2.日期函数

**日期转换函数：**

MySQL 日期、时间转换函数**date_format**：date_format(date,format), time_format(time,format) 能够把一个日期/时间转换成各种各样的字符串格式。它是 str_to_date(str,format) 函数的一个逆转换。

```mysql
select date_format('2008-08-08 22:23:01', '%Y%m%d%H%i%s');

+----------------------------------------------------+
| date_format('2008-08-08 22:23:01', '%Y%m%d%H%i%s') |
+----------------------------------------------------+
| 20080808222301 |
+----------------------------------------------------+
```

```mysql
select str_to_date('08/09/2008', '%m/%d/%Y'); -- 2008-08-09
select str_to_date('08/09/08' , '%m/%d/%y'); -- 2008-08-09
select str_to_date('08.09.2008', '%m.%d.%Y'); -- 2008-08-09
select str_to_date('08:09:30', '%h:%i:%s'); -- 08:09:30
select str_to_date('08.09.2008 08:09:30', '%m.%d.%Y %h:%i:%s'); -- 2008-08-09 08:09:30
```

MySQL 拼凑日期、时间函数：makdedate(year,dayofyear), maketime(hour,minute,second)

```mysql
select makedate(2001,31); -- '2001-01-31'
select makedate(2001,32); -- '2001-02-01'
select maketime(12,15,30); -- '12:15:30'
```

**日期计算函数：**

MySQL 日期、时间相减函数**datediff**：datediff(date1,date2), timediff(time1,time2)

```mysql
MySQL datediff(date1,date2)：两个日期相减 date1 - date2，返回天数。
select datediff('2008-08-08', '2008-08-01'); -- 7
select datediff('2008-08-01', '2008-08-08'); -- -7
```

MySQL **timediff**(time1,time2)：两个日期相减 time1 - time2，返回 time 差值。

```mysql
select timediff('2008-08-08 08:08:08', '2008-08-08 00:00:00'); -- 08:08:08
select timediff('08:08:08', '00:00:00'); -- 08:08:08
```

注意：timediff(time1,time2) 函数的两个参数类型必须相同。mysql中变量不用事前申明。

```mysql
set @dt = '2008-09-10 07:15:30.123456';

select date(@dt); -- 2008-09-10
select time(@dt); -- 07:15:30.123456
select year(@dt); -- 2008
select quarter(@dt); -- 3
select month(@dt); -- 9
select week(@dt); -- 36 返回一年对应的周数
select day(@dt); -- 10
select hour(@dt); -- 7
select minute(@dt); -- 15
select second(@dt); -- 30
select microsecond(@dt); -- 123456
```

**last_day() 函数**：返回月份中的最后一天。

select last_day('2008-02-01'); -- 2008-02-29

select last_day('2008-08-08'); -- 2008-08-31

MySQL last_day() 函数非常有用，比如我想得到当前月份中有多少天，可以这样来计算：

```mysql
Copy select now(), day(last_day(now())) as days;

+---------------------+------+
| now() | days |
+---------------------+------+
| 2008-08-09 11:45:45 | 31 |
+---------------------+------+
```

**TO_DAYS函数：**

```mysql
SELECT TO_DAYS('1997-10-07');   
```

结果  729669 就是从0年开始到1997年10月7号之间的天数。

查询某一天数据：

```mysql
--今天
select * from 表名 where to_days(时间字段名) = to_days(now());
--昨天
SELECT * FROM 表名 WHERE TO_DAYS(NOW( )) - TO_DAYS( 时间字段名) <= 1
```

**date_add()和adddate()是同义词**.

与 DATE_SUB() 相反

**参数说明**:

　　date:起始日期或者起始时间

　　expr:指定的是一个间隔值,在起始时间中增加或者减少,**注意**:expr是一个**字符串**.对于负值间隔,可以以"-"开头

　　unit:表示的是一个单位,比如,加上的是1天还是一个小时.

1.对某个日期加上n天的操作

```mysql
select date_add('2018-06-26',INTERVAL 5 day);
+-----------------------------------------+
| date_add('2018-06-26',INTERVAL 5 day) |
+-----------------------------------------+
| 2018-07-01                              |
+-----------------------------------------+
row in set (0.00 sec)

mysql> select date_add('2018-06-26',INTERVAL -5 day);
+------------------------------------------+
| date_add('2018-06-26',INTERVAL -5 day) |
+------------------------------------------+
| 2018-06-21                               |
+------------------------------------------+
row in set (0.01 sec)

近7天
SELECT * FROM 表名 where DATE_SUB(CURDATE(), INTERVAL 7 DAY) <= date(时间字段名)

近30天
SELECT * FROM 表名 where DATE_SUB(CURDATE(), INTERVAL 30 DAY) <= date(时间字段名)
```

![img](https://images2018.cnblogs.com/blog/1226424/201806/1226424-20180626135953354-1600572151.png)

日期between用法：

查询2016-10-17到2016-10-18的数据【闭区间】：

```mysql
WHERE Date BETWEEN '2016-10-17' AND '2016-10-18'
等价于
WHERE [Date] >= '2016-10-17 00:00:00:000' AND [Date] <= '2016-10-18 00:00:00:000'
```

**2.**

```mysql
查询本季度数据
select * from `ht_invoice_information` where QUARTER(create_date)=QUARTER(now());
查询上季度数据
select * from `ht_invoice_information` where QUARTER(create_date)=QUARTER(DATE_SUB(now(),interval 1 QUARTER));
查询本年数据
select * from `ht_invoice_information` where YEAR(create_date)=YEAR(NOW());
查询上年数据
select * from `ht_invoice_information` where year(create_date)=year(date_sub(now(),interval 1 year));
```



##### 3.聚集函数

avg()：**忽略列值为null的行**  

```mysql
SELECT Customer FROM Orders WHERE OrderPrice>(SELECT AVG(OrderPrice) FROM Orders)   

select avg(distinct XX) AS XX from XX where XX=  ;
```

count()：

```mysql
SELECT COUNT(DISTINCT Customer) AS NumberOfCustomers FROM Order   
```

count(*) 包含null,**count(列名)忽略null**

max()：MAX 函数返回一列中的最大值。忽略列值为null的行 。 MIN 和 MAX 也可用于文本列，以获得按字母顺序排列的最高或最低值。

sum()：忽略列值为null的行。

```mysql
SELECT SUM(OrderPrice) AS OrderTotal FROM Orders 
```

输出结果以别名显示

##### 4.高级函数

> case/ case when

```mysql
--简单Case函数
CASE sex
WHEN '1' THEN '男'
WHEN '2' THEN '女'
ELSE '其他' END 
```

```mysql
--搜索函数 
CASE WHEN sex = '1' THEN '男' 
WHEN sex = '2' THEN '女' 
ELSE '其他' END  
```

示例：

```mysql
select 
sum(HTZJE) as ysje,--预算金额
sum(yfje) as ljfse,--累计发生额
sum(jyje) as jyje,--结余金额
(sum(jyje) / sum(HTZJE)) as jezb, --结余占比
(sum(yfje) / sum(HTZJE)) as fyzb,--费用占比
case htlb
when '1' then 'cblb1'
when '2' then 'cblb2'
when '3' then 'cblb3'
ELSE '其他' END bieMing
from tb_table
group by bieMing
```

用到 case when 的字段作为别名的时候一定不要加“as” 否则会报错。直接在END 后加上想用的别名即可。如：文中 bieMing

> 窗口函数：函数名（列）over(选项)

​        **普通聚合函数每组只能返回一个值，而开窗函数可以每组返回多个值。**

​        比如我们想查询每个工资小于5000元的员工信息（城市以及年龄），并且在每行中都显示所有工资小于5000元的员工个数，执行下面的SQL语句：

```mysql
select t.fcity,t.fage,count(*) from person t where t.fsalary<5000
```

​        这个语句显然是错误的，因为count()是聚合函数，然后fname和fage字段没有包含在分组里面。

```mysql
select t.fcity,t.fage,count(*) from person t where t.fsalary<5000 group by t.fcity,t.fage
```

​        这与我们每行中都显示所有工资小于5000元的员工个数这个条件是不符合的(这是分组统计)。

```mysql
select t.fcity,
       t.fage,
       (select count(*) from person f where f.fsalary < 5000)
  from person t
 where t.fsalary < 5000	
```

​        这次的查询结果和我们想要的结果一样了，但是这样写多了一个子查询，非常麻烦。使用开窗函数可以大大简化实现.

```mysql
select t.fcity, t.fage, count(*) over()
   from person t
  where t.fsalary < 5000
```

​        over关键字表示把函数当成开窗函数而不是聚合函数，SQL标准允许将所有聚合函数用做开窗函数，使用over关键字来区分这两种用法。

​        在上面的例子中，开窗函数count(*) over()对于查询结果的每一行都返回所有符合条件的行的条数，如果over关键字后的括号中选项为空，则开窗函数会对结果集中的所有行进行聚合运算。

> partition by 子句

​	开窗函数的over关键字后括号中可以使用 Partition by 子句来定义行的分区，进行聚合运算。与group by 字句不同，partition by子句创建的分区是独立于结果集的，创建的分区只是提供聚合计算的，而且不同的开窗函数所创建的分区也不相互影响。

1. 下面的sql语句用于显示每一个人员的信息以及所属城市的人员数：

```mysql
select t.fname,
         t.fcity,
         t.fage,
         count(*) over(partition by t.fcity)
    from person t
```

​	count(*)over(partition by t.fcity) 表示对结果集按照 fcity 进行分区，并且计算当前行所属区的聚合计算结果。

2. 在同一个SELECT语句中可以同时使用多个开窗函数，而且这些开窗函数不会相互影响。比如，显示每一个人员的信息、所属城市的人员数以及同龄人的人数：

```mysql
select t.fname,
         t.fcity,
         t.fage,
         count(*) over(partition by t.fcity) as "城市分组",
         count(*) over(partition by t.fage) as "年龄分组"
    from person t
```

partition  by用于给结果集分组，如果没有指定那么它把整个结果集作为一个分组。

> Rank 是在每个分组内部进行排名的。
>
> rank() 排序相同时会重复，总数不会变
>
> dense_rank() 排序相同时会重复，总数会减少
>
> row_number() 会根据顺序计算
>

##### 5.窗口分析函数

> SUM,AVG,MIN,MAX

sum(...) over( )，对所有行求和

sum(...) over( order by ... )，第一行到与当前行同序号相同的所有行的所有值求和

```sql
with aa as
( 
SELECT 1 a,1 b, 3 c FROM dual union
SELECT 2 a,2 b, 3 c FROM dual union
SELECT 3 a,3 b, 3 c FROM dual union
SELECT 4 a,4 b, 3 c FROM dual union
SELECT 5 a,5 b, 3 c FROM dual union
SELECT 6 a,5 b, 3 c FROM dual union
SELECT 7 a,2 b, 3 c FROM dual union
SELECT 8 a,2 b, 8 c FROM dual union
SELECT 9 a,3 b, 3 c FROM dual
)
SELECT a,b,c,
sum(c) over(order by b) sum1,--有排序，求和当前行所在顺序号的C列所有值
sum(c) over() sum2--无排序，求和 C列所有值
from aa;
```

![img](https://images0.cnblogs.com/blog/87310/201412/101455251032807.jpg)

sum(...) over( partition by... )，同组内所行求和

sum(...) over( partition by... order by ... )，同第1点中的排序求和原理，只是范围限制在组内

```sql
with aa as
( 
SELECT 1 a,1 b, 3 c FROM dual union
SELECT 2 a,2 b, 3 c FROM dual union
SELECT 3 a,3 b, 3 c FROM dual union
SELECT 4 a,4 b, 3 c FROM dual union
SELECT 5 a,5 b, 3 c FROM dual union
SELECT 6 a,5 b, 3 c FROM dual union
SELECT 7 a,2 b, 3 c FROM dual union
SELECT 7 a,2 b, 8 c FROM dual union
SELECT 9 a,3 b, 3 c FROM dual
)
SELECT a,b,c,sum(c) over( partition by b ) partition_sum,
sum(c) over( partition by b order by a desc) partition_order_sum
  FROM aa;
```

![img](https://images0.cnblogs.com/blog/87310/201412/101539020714139.jpg)

> WINDOW子句：rows between ... preceding and ... following

```sql
    SELECT cookieid,
    createtime,
    pv,
    SUM(pv) OVER(PARTITION BY cookieid ORDER BY createtime) AS pv1, -- 默认为从起点到当前行
    SUM(pv) OVER(PARTITION BY cookieid ORDER BY createtime ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW) AS pv2, --从起点到当前行，结果同pv1
    SUM(pv) OVER(PARTITION BY cookieid) AS pv3,        --分组内所有行
    SUM(pv) OVER(PARTITION BY cookieid ORDER BY createtime ROWS BETWEEN 3 PRECEDING AND CURRENT ROW) AS pv4, --当前行+往前3行
    SUM(pv) OVER(PARTITION BY cookieid ORDER BY createtime ROWS BETWEEN 3 PRECEDING AND 1 FOLLOWING) AS pv5, --当前行+往前3行+往后1行
    SUM(pv) OVER(PARTITION BY cookieid ORDER BY createtime ROWS BETWEEN CURRENT ROW AND UNBOUNDED FOLLOWING) AS pv6 ---当前行+往后所有行
    FROM lxw1234;
     
    cookieid createtime pv pv1 pv2 pv3 pv4 pv5 pv6
    -----------------------------------------------------------------------------
    cookie1 2015-04-10 1 1 1 26 1 6 26
    cookie1 2015-04-11 5 6 6 26 6 13 25
    cookie1 2015-04-12 7 13 13 26 13 16 20
    cookie1 2015-04-13 3 16 16 26 16 18 13
    cookie1 2015-04-14 2 18 18 26 17 21 10
    cookie1 2015-04-15 4 22 22 26 16 20 8
    cookie1 2015-04-16 4 26 26 26 13 13 4
```

如果不指定ROWS BETWEEN,默认为从起点到当前行;

如果不指定ORDER BY，则将分组内所有值累加;

关键是理解ROWS BETWEEN含义,也叫做WINDOW子句：

PRECEDING：往前

FOLLOWING：往后

CURRENT ROW：当前行

UNBOUNDED：起点，UNBOUNDED PRECEDING 表示从前面的起点， UNBOUNDED FOLLOWING：表示到后面的终点

> lag,lead函数类似于preceding和following子句

LAG(col,n,DEFAULT) 用于统计窗口内往上第n行值

第一个参数为列名，第二个参数为往上第n行（可选，默认为1），第三个参数为默认值（当往上第n行为NULL时候，取默认值，如不指定，则为NULL）

与LAG相反，LEAD(col,n,DEFAULT) 用于统计窗口内往下第n行值

第一个参数为列名，第二个参数为往下第n行（可选，默认为1），第三个参数为默认值（当往下第n行为NULL时候，取默认值，如不指定，则为NULL）

> Ntile函数

​	它把有序的数据集合 **平均分配 **到 **指定的数量**（num）个桶中, 将桶号分配给每一行。如果不能平均分配，则优先分配较小编号的桶，并且各个桶中能放的行数最多相差1。

> first_value

取分组内排序后，截止**到当前行**，第一个值。

```sql
SELECT cookieid,
createtime,
url,
ROW_NUMBER() OVER(PARTITION BY cookieid ORDER BY createtime) AS rn,
FIRST_VALUE(url) OVER(PARTITION BY cookieid ORDER BY createtime) AS first1 
FROM lxw1234;
 
cookieid  createtime            url     rn      first1
---------------------------------------------------------
cookie1 2015-04-10 10:00:00     url1    1       url1
cookie1 2015-04-10 10:00:02     url2    2       url1
cookie1 2015-04-10 10:03:04     1url3   3       url1
cookie1 2015-04-10 10:10:00     url4    4       url1
cookie1 2015-04-10 10:50:01     url5    5       url1
cookie1 2015-04-10 10:50:05     url6    6       url1
cookie1 2015-04-10 11:00:00     url7    7       url1
cookie2 2015-04-10 10:00:00     url11   1       url11
cookie2 2015-04-10 10:00:02     url22   2       url11
cookie2 2015-04-10 10:03:04     1url33  3       url11
cookie2 2015-04-10 10:10:00     url44   4       url11
cookie2 2015-04-10 10:50:01     url55   5       url11
cookie2 2015-04-10 10:50:05     url66   6       url11
cookie2 2015-04-10 11:00:00     url77   7       url11
```

> last_value

取分组内排序后，截止**到当前行**，最后一个值

```sql
SELECT cookieid,
createtime,
url,
ROW_NUMBER() OVER(PARTITION BY cookieid ORDER BY createtime) AS rn,
LAST_VALUE(url) OVER(PARTITION BY cookieid ORDER BY createtime) AS last1 
FROM lxw1234;
 
 
cookieid  createtime            url    rn       last1  
-----------------------------------------------------------------
cookie1 2015-04-10 10:00:00     url1    1       url1
cookie1 2015-04-10 10:00:02     url2    2       url2
cookie1 2015-04-10 10:03:04     1url3   3       1url3
cookie1 2015-04-10 10:10:00     url4    4       url4
cookie1 2015-04-10 10:50:01     url5    5       url5
cookie1 2015-04-10 10:50:05     url6    6       url6
cookie1 2015-04-10 11:00:00     url7    7       url7
cookie2 2015-04-10 10:00:00     url11   1       url11
cookie2 2015-04-10 10:00:02     url22   2       url22
cookie2 2015-04-10 10:03:04     1url33  3       1url33
cookie2 2015-04-10 10:10:00     url44   4       url44
cookie2 2015-04-10 10:50:01     url55   5       url55
cookie2 2015-04-10 10:50:05     url66   6       url66
cookie2 2015-04-10 11:00:00     url77   7       url77
```

如果想要取分组内排序后最后一个值，则

```sql
FIRST_VALUE(url) OVER(PARTITION BY cookieid ORDER BY createtime DESC) AS first1
```

**行列互换**

```mysql
--统计数据
select year as "年"
       , sum(case season when 1 then sale else 0 end) as "一季度"
       , sum(case season when 2 then sale else 0 end) as "二季度"
       , sum(case season when 3 then sale else 0 end) as "三季度"
       , sum(case season when 4 then sale else 0 end) as "四季度"
  from tb_sales t
 group by t.year;
 
年    一季度    二季度    三季度    四季度
2018    21        22        23    24
2017    11        12        13    14
```

##### hive百分位函数

percentile_approx(col, p)；其中percentile要求输入的字段必须是int类型的，而percentile_approx则是数值类似型的都可以

其实percentile_approx还有一个参数B：percentile_approx(col, p，B)，参数B控制内存消耗的近似精度，B越大，结果的准确度越高。默认为10,000。当col字段中的distinct值的个数小于B时，结果为准确的百分位数。 
$$
percentile\_approx(col,array(0.05,0.5,0.95),9999)
$$

#### 分组数据

##### GROUP BY语句

语句用于结合聚集函数，根据一个或多个列对结果集进行分组

- group by 有一个原则，就是 select 后面的所有列中，没有使用聚合函数的列必须出现在 group by 后面



- group by 与having搭配使用，可通过AND,OR,NOT将多个条件组合在一起；但**在group by前可以用where**
- WHERE在数据分组前进行过滤，HAVING在数据分组后进行过滤。
- ==**where 后不能跟聚合函数**，因为where执行顺序大于聚合函数==。
- 可以在不使用group by的语句后面使用having，也可在from 表名之后使用，就像 select * from emp having empno>1，这样写是没有错的，前提是having后的字段出现在select字段中
- having 子句的作用是筛选满足条件的组，即在分组之后过滤数据，**条件中经常包含聚合函数**，使用having 条件显示特定的组，也可以使用多个分组标准进行分组

##### sql执行顺序 

(1) from 
(3) join 
(2) on 
(4) where 
(5) group by (开始使用select中的别名，后面的语句中都可以使用)
(6) avg, sum.... 
(7) having 
(8) select 
(9) distinct 
(10) order by 

#### 子查询

##### 作为过滤手段

结合IN操作符。（代替表连接)

查询id最大的一件商品：

```mysql
SELECT goods_id,goods_name,shop_price FROM goods WHERE goods_id = (SELECT MAX(goods_id) FROM goods);
```

查询每个类别下id最大的商品:

```mysql
SELECT goods_id,goods_name,cat_id,shop_price FROM goods WHERE goods_id IN (SELECT MAX(goods_id) FROM goods GROUP BY cat_id);
```

##### 作为计算字段

即在SELECT之后FROM之前

#### 表连接

根据两个或多个表中的列之间的关系，从这些表中查询数据

主键（Primary Key）是一个列，在表中，每个主键的值都是唯一的。这样做的目的是在不重复每个表中的所有数据的情况下，把表间的数据交叉捆绑在一起

注意查询多个列和多个表，要用逗号隔开

##### inner join

在表中存在至少一个匹配时，INNER JOIN 关键字返回行。 从数学的角度讲就是求两个表的交集.与where同

```mysql
SELECT * FROM XXX1 INNER JOIN XXX2 ON XXX1.Id=XXX2.id; # 注意是ON而不是where
```

INNER JOIN 与 JOIN 是相同的。

**注意：对于inner join，满足on后面的条件表的数据才能查出，可以起到过滤作用。也可以把条件放到where后面。**

##### left join

==LEFT JOIN 关键字会从左表 (table_name1) 那里返回所有的行，即使在右表 (table_name2) 中没有匹配的行。==

```mysql
SELECT * FROM XXX1 left JOIN XXX2 ON XXX1.Id=XXX2.id;
```

注意如果左表中某个属性对应右表多个取值，则记录显示有多行.

**注意：对于left join，不管on后面跟什么条件，左表的数据全部查出来，因此要想过滤需把条件放到where后面**

##### right join

RIGHT JOIN 关键字会右表 (table_name2) 那里返回所有的行，即使在左表 (table_name1) 中没有匹配的行.

```mysql
SELECT * FROM XXX1 right JOIN XXX2 ON XXX1.Id=XXX2.id;
```

##### full join（外连接）

只要其中某个表存在匹配，FULL JOIN 关键字就会返回行。等价于select 左连接 union select 右连接

```mysql
SELECT * FROM XXX1 full JOIN XXX2 ON XXX1.Id=XXX2.id;
```

##### 自联结

通常用于替代自查询，查询速度更快

#### 组合查询

union/union all

- UNION 操作符用于==合并两个或多个 SELECT 语句的结果集==。
- 请注意，UNION 内部的 SELECT 语句必须拥有相同数量的列。列也必须拥有相似的数据类型。同时，每条 SELECT 语句中的列的顺序必须相同,但列名则不一定需要相同。
- SELECT column_name(s) FROM table_name1 union SELECT column_name(s) FROM table_name2
- 默认地，UNION 操作符选取不同的值。如果允许重复的值，请使用 UNION ALL
- UNION 结果集中的列名总是等于 UNION 中第一个 SELECT 语句中的列名

### 插入INSERT

```mysql
INSERT INTO 表名称 VALUES (值1, 值2,....)

INSERT INTO table_name (列1, 列2,...) VALUES (值1, 值2,....)

INSERT INTO table_name (列1, 列2,...) SELECT 列1, 列2,... FROM table_name1  # 插入检索出的数据
```

### 更新UPDATE

```mysql
UPDATE table_name SET 列名称 = 新值 WHERE 列名称 = 某值
 
# Update 语句用于修改表中的数据。set后可同时修改多列

UPDATE Person SET Address = 'Zhongshan 23', City = 'Nanjing' WHERE LastName = 'Wilson'

UPDATE table_name SET 列名称 = NULL WHERE 列名称 = 某值    # 删除某列值
```

### 删除DELETE

DELETE 语句用于删除表中的行。

```mysql
DELETE FROM 表名称 WHERE 列名称 = 值
```

可以在不删除表的情况下删除所有的行,这意味着表的结构、属性和索引都是完整的

```mysql
DELETE (*) FROM table_name
```

删除所有行。

## **数据定义语言**(DDL)

### 创建CREATE

CREATE DATABASE database_name;name不用引号

```mysql
CREATE TABLE 表名称    
(    
 列名称1 数据类型 约束,
 列名称2 数据类型 约束,
 列名称3 数据类型 约束,
 ....    
)
```

### 更新ALTER

#### 添加约束

当表已被创建时，如需在 "Id_P" 列创建 UNIQUE 约束：

```mysql
ALTER TABLE Persons ADD UNIQUE (Id_P)；
ALTER TABLE Persons ADD CONSTRAINT uc_PersonID UNIQUE (Id_P,LastName)
ALTER TABLE Persons DROP CONSTRAINT uc_PersonID
```

当表已被创建时，如需在 "Id_P" 列创建  PRIMARY KEY约束：

```mysql
ALTER TABLE Persons ADD PRIMARY KEY(Id_P)； 
ALTER TABLE Persons ADD CONSTRAINT pk_PersonID PRIMARY KEY (Id_P,LastName)
ALTER TABLE Persons DROP CONSTRAINT pk_PersonID
```

如果在 "Orders" 表已存在的情况下为 "Id_P" 列创建 FOREIGN KEY 约束,    

```mysql
ALTER TABLE Orders ADD FOREIGN KEY (Id_P) REFERENCES Persons(Id_P)
ALTER TABLE Orders add CONSTRAINT fk_PerOrders FOREIGN KEY (Id_P,...) REFERENCES Persons(Id_P,...)
ALTER TABLE Orders DROP CONSTRAINT fk_PerOrders
```

如果在表已存在的情况下为 "Id_P" 列创建 CHECK 约束 

```mysql
ALTER TABLE Persons ADD CHECK (Id_P>0)；
ALTER TABLE Persons ADD CONSTRAINT chk_Person CHECK (Id_P>0 AND City='Sandnes')
ALTER TABLE Persons DROP CONSTRAINT chk_Person
```

在表已存在的情况下为 "City" 列创建 DEFAULT 约束，

```mysql
ALTER TABLE Persons ALTER COLUMN City SET DEFAULT 'SANDNES'
ALTER TABLE Persons ALTER COLUMN City DROP DEFAULT
```

#### 在已有的表中添加、修改或删除列

添加字段的语法：

```mysql
alter table table_name add (字段名 number(2) not null);
```

删除字段的语法：

```mysql
alter table table_name drop column 字段名;
```

修改字段的名：

```mysql
alter table 表名 rename column 原子段 to 新字段;
```

修改字段的语法：

```mysql
ALTER TABLE  表名  MODIFY (列名 数据类型); 
```

### 删除表DROP

使用 DROP 语句，可以轻松地删除索引、表和数据库删除索引：DROP INDEX index_name;

删除表 （表的结构、属性以及索引也会被删除）：DROP TABLE 表名称；

删除数据库：DROP DATABASE 数据库名称；

删除表内数据而不删除表本身：TRUNCATE TABLE 表名称

注意delete from后面可以写条件，truncate不可以。

