## Python 缩进

缩进指的是代码行开头的空格。

在其他编程语言中，代码缩进仅出于可读性的考虑，而 Python 中的缩进非常重要。

Python 使用缩进来指示代码块。

如果省略缩进，Python 会出错：

空格数取决于程序员，但至少需要一个。

您必须在同一代码块中使用相同数量的空格，否则 Python 会出错





## Python 变量

### 变量声明

Python 没有声明变量的命令。

变量是在首次为其赋值时创建的：

变量不需要使用任何特定类型声明，甚至可以在设置后更改其类型。

字符串变量可以使用单引号或双引号进行声明：

```
x = 5
print(x)
x = "Hello, World!"
print(x)

```

### 变量命名规则

- 变量名必须以字母或下划线字符开头
- 变量名称不能以数字开头
- 变量名只能包含字母数字字符和下划线（A-z、0-9 和 _）
- 变量名称区分大小写（age、Age 和 AGE 是三个不同的变量）

请记住，变量名称区分大小写

### 变量赋值

 向多个变量赋值

```
x, y, z = "Orange", "Banana", "Cherry"
print(x)
print(y)
print(z)
运行结果
Orange
Banana
Cherry

x = y = z = "Orange"
print(x)
print(y)
print(z)
```

### 输出变量

正确用法:

```
x = "awesome"
print("Python is " + x)

x = "Python is "
y = "awesome"
z =  x + y
print(z)

x = 5
y = 10
print(x + y)

```

错误用法: 

```
x = 10
y = "Bill"
print(x + y)
运行结果:
TypeError: unsupported operand type(s) for +: 'int' and 'str'
解释: 如果您尝试组合字符串和数字，Python 会给出错误：
```

正确用法

使用 format() 方法将数字插入字符串：

```
age = 63
txt = "My name is Bill, and I am {}"
print(txt.format(age))
```

多个占位符, 传入多个参数

```
quantity = 3
itemno = 567
price = 49.95
myorder = "I want {} pieces of item {} for {} dollars."
print(myorder.format(quantity, itemno, price))
```

可以使用索引号 {0} 来确保参数被放在正确的占位符中：

```
quantity = 3
itemno = 567
price = 49.95
myorder = "I want to pay {2} dollars for {0} pieces of item {1}."
print(myorder.format(quantity, itemno, price))
```



### 全局变量

在函数外部创建的变量（如上述所有实例所示）称为全局变量。

全局变量可以被函数内部和外部的每个人使用。



### 使用 global  在函数内部创建全局变量

通常，在函数内部创建变量时，该变量是局部变量，只能在该函数内部使用。

要在函数内部创建全局变量，您可以使用 global 关键字。

```
def myfunc():
  global x
  x = "fantastic"
```

要在函数内部更改全局变量的值，请使用 global 关键字引用该变量：

```
x = "awesome"

def myfunc():
  global x
  x = "fantastic"
```

### 数据类型

| 文本类型：   | str                          |
| ------------ | ---------------------------- |
| 数值类型：   | int, float, complex          |
| 序列类型：   | list, tuple, range           |
| 映射类型：   | dict                         |
| 集合类型：   | set, frozenset               |
| 布尔类型：   | bool                         |
| 二进制类型： | bytes, bytearray, memoryview |

### 获取数据类型

```
x = 10
print(type(x))
输出
<class 'int'>
```

在 Python 中，当您为变量赋值时，会设置数据类型：

如果希望指定数据类型，则您可以使用以下构造函数：

| 示例                                         | 数据类型   |
| :------------------------------------------- | :--------- |
| x = str("Hello World")                       | str        |
| x = int(29)                                  | int        |
| x = float(29.5)                              | float      |
| x = complex(1j)                              | complex    |
| x = list(("apple", "banana", "cherry"))      | list       |
| x = tuple(("apple", "banana", "cherry"))     | tuple      |
| x = range(6)                                 | range      |
| x = dict(name="Bill", age=36)                | dict       |
| x = set(("apple", "banana", "cherry"))       | set        |
| x = frozenset(("apple", "banana", "cherry")) | frozenset  |
| x = bool(5)                                  | bool       |
| x = bytes(5)                                 | bytes      |
| x = bytearray(5)                             | bytearray  |
| x = memoryview(bytes(5))                     | memoryview |



### 复数

复数用 "j" 作为虚部编写：

```
x = 2+3j
y = 7j
z = -7j
```

### 类型转换

您可以使用 int()、float() 和 complex() 方法从一种类型转换为另一种类型：

- int() - 用整数字面量、浮点字面量构造整数（通过对数进行下舍入, 保留整数去掉小数），或者用表示完整数字的字符串字面量
- float() - 用整数字面量、浮点字面量，或字符串字面量构造浮点数（提供表示浮点数或整数的字符串）
- str() - 用各种数据类型构造字符串，包括字符串，整数字面量和浮点字面量

```
x = 10 # int
y = 6.3 # float
z = 1j # complex

# 把整数转换为浮点数

a = float(x)

# 把浮点数转换为整数

b = int(y)

# 把整数转换为复数：

c = complex(x)
```

### 随机数

Python 没有 random() 函数来创建随机数，但 Python 有一个名为 random 的内置模块，可用于生成随机数：

导入 random 模块，并显示 1 到 9 之间的随机数：

```
import random

print(random.randrange(1,10))
```



## 字符串

python 中的字符串字面量由单引号或双引号括起。

### 多行字符串

您可以使用 三个单引号  或  三个双引号  将多行字符串赋值给变量：

```
a = """Python is a widely used general-purpose, high level programming language. 
It was initially designed by Guido van Rossum in 1991 
and developed by Python Software Foundation. 
It was mainly developed for emphasis on code readability, 
and its syntax allows programmers to express concepts in fewer lines of code."""
```

### 字符串即字符数组

Python 没有字符数据类型，单个字符就是长度为 1 的字符串。

方括号可用于访问字符串的元素。

获取位置 1 处的字符（请记住第一个字符的位置为 0）：

```
a = "Hello, World!"
print(a[1])
```

### 字符串裁切

获取从位置 2 到位置 5（不包括）的字符：

```
b = "Hello, World!"
print(b[2:5])
```

使用负索引从字符串末尾开始切片：

获取从位置 5 到位置 1 的字符，从字符串末尾开始计数：

```
b = "Hello, World!"
print(b[-5:-2])
```

### 字符串长度

如需获取字符串的长度，请使用 len() 函数。

```
a = "Hello, World!"
print(len(a))
```

### 字符串方法

strip() 方法删除开头和结尾的空白字符：

```
a = " Hello, World! "
print(a.strip()) # returns "Hello, World!"
```

lower() 返回小写的字符串：

```
a = "Hello, World!"
print(a.lower())
```

upper() 方法返回大写的字符串：

```
a = "Hello, World!"
print(a.upper())
```

replace() 用另一段字符串来替换字符串：

```
a = "Hello, World!"
print(a.replace("World", "Kitty"))
```

split() 方法在找到分隔符的实例时将字符串拆分为子字符串：

```
a = "Hello, World!"
print(a.split(",")) # returns ['Hello', ' World!']
```

### 判断字符串包含

如需检查字符串中是否存在特定短语或字符，我们可以使用 in 或 not in 关键字。

```
txt = "China is a great country"
x = "ina" in txt
print(x)
```

```
txt = "China is a great country"
x = "ain" not in txt
print(x) 
```

## 

| 方法                                                         | 描述                                               |
| :----------------------------------------------------------- | :------------------------------------------------- |
| [capitalize()](https://www.w3school.com.cn/python/ref_string_capitalize.asp) | 把首字符转换为大写。                               |
| [casefold()](https://www.w3school.com.cn/python/ref_string_casefold.asp) | 把字符串转换为小写。                               |
| [center()](https://www.w3school.com.cn/python/ref_string_center.asp) | 返回居中的字符串。                                 |
| [count()](https://www.w3school.com.cn/python/ref_string_count.asp) | 返回指定值在字符串中出现的次数。                   |
| [encode()](https://www.w3school.com.cn/python/ref_string_encode.asp) | 返回字符串的编码版本。                             |
| [endswith()](https://www.w3school.com.cn/python/ref_string_endswith.asp) | 如果字符串以指定值结尾，则返回 true。              |
| [expandtabs()](https://www.w3school.com.cn/python/ref_string_expandtabs.asp) | 设置字符串的 tab 尺寸。                            |
| [find()](https://www.w3school.com.cn/python/ref_string_find.asp) | 在字符串中搜索指定的值并返回它被找到的位置。       |
| [format()](https://www.w3school.com.cn/python/ref_string_format.asp) | 格式化字符串中的指定值。                           |
| format_map()                                                 | 格式化字符串中的指定值。                           |
| [index()](https://www.w3school.com.cn/python/ref_string_index.asp) | 在字符串中搜索指定的值并返回它被找到的位置。       |
| [isalnum()](https://www.w3school.com.cn/python/ref_string_isalnum.asp) | 如果字符串中的所有字符都是字母数字，则返回 True。  |
| [isalpha()](https://www.w3school.com.cn/python/ref_string_isalpha.asp) | 如果字符串中的所有字符都在字母表中，则返回 True。  |
| [isdecimal()](https://www.w3school.com.cn/python/ref_string_isdecimal.asp) | 如果字符串中的所有字符都是小数，则返回 True。      |
| [isdigit()](https://www.w3school.com.cn/python/ref_string_isdigit.asp) | 如果字符串中的所有字符都是数字，则返回 True。      |
| [isidentifier()](https://www.w3school.com.cn/python/ref_string_isidentifier.asp) | 如果字符串是标识符，则返回 True。                  |
| [islower()](https://www.w3school.com.cn/python/ref_string_islower.asp) | 如果字符串中的所有字符都是小写，则返回 True。      |
| [isnumeric()](https://www.w3school.com.cn/python/ref_string_isnumeric.asp) | 如果字符串中的所有字符都是数，则返回 True。        |
| [isprintable()](https://www.w3school.com.cn/python/ref_string_isprintable.asp) | 如果字符串中的所有字符都是可打印的，则返回 True。  |
| [isspace()](https://www.w3school.com.cn/python/ref_string_isspace.asp) | 如果字符串中的所有字符都是空白字符，则返回 True。  |
| [istitle()](https://www.w3school.com.cn/python/ref_string_istitle.asp) | 如果字符串遵循标题规则，则返回 True。              |
| [isupper()](https://www.w3school.com.cn/python/ref_string_isupper.asp) | 如果字符串中的所有字符都是大写，则返回 True。      |
| [join()](https://www.w3school.com.cn/python/ref_string_join.asp) | 把可迭代对象的元素连接到字符串的末尾。             |
| [ljust()](https://www.w3school.com.cn/python/ref_string_ljust.asp) | 返回字符串的左对齐版本。                           |
| [lower()](https://www.w3school.com.cn/python/ref_string_lower.asp) | 把字符串转换为小写。                               |
| [lstrip()](https://www.w3school.com.cn/python/ref_string_lstrip.asp) | 返回字符串的左修剪版本。                           |
| maketrans()                                                  | 返回在转换中使用的转换表。                         |
| [partition()](https://www.w3school.com.cn/python/ref_string_partition.asp) | 返回元组，其中的字符串被分为三部分。               |
| [replace()](https://www.w3school.com.cn/python/ref_string_replace.asp) | 返回字符串，其中指定的值被替换为指定的值。         |
| [rfind()](https://www.w3school.com.cn/python/ref_string_rfind.asp) | 在字符串中搜索指定的值，并返回它被找到的最后位置。 |
| [rindex()](https://www.w3school.com.cn/python/ref_string_rindex.asp) | 在字符串中搜索指定的值，并返回它被找到的最后位置。 |
| [rjust()](https://www.w3school.com.cn/python/ref_string_rjust.asp) | 返回字符串的右对齐版本。                           |
| [rpartition()](https://www.w3school.com.cn/python/ref_string_rpartition.asp) | 返回元组，其中字符串分为三部分。                   |
| [rsplit()](https://www.w3school.com.cn/python/ref_string_rsplit.asp) | 在指定的分隔符处拆分字符串，并返回列表。           |
| [rstrip()](https://www.w3school.com.cn/python/ref_string_rstrip.asp) | 返回字符串的右边修剪版本。                         |
| [split()](https://www.w3school.com.cn/python/ref_string_split.asp) | 在指定的分隔符处拆分字符串，并返回列表。           |
| [splitlines()](https://www.w3school.com.cn/python/ref_string_splitlines.asp) | 在换行符处拆分字符串并返回列表。                   |
| [startswith()](https://www.w3school.com.cn/python/ref_string_startswith.asp) | 如果以指定值开头的字符串，则返回 true。            |
| [strip()](https://www.w3school.com.cn/python/ref_string_strip.asp) | 返回字符串的剪裁版本。                             |
| [swapcase()](https://www.w3school.com.cn/python/ref_string_swapcase.asp) | 切换大小写，小写成为大写，反之亦然。               |
| [title()](https://www.w3school.com.cn/python/ref_string_title.asp) | 把每个单词的首字符转换为大写。                     |
| translate()                                                  | 返回被转换的字符串。                               |
| [upper()](https://www.w3school.com.cn/python/ref_string_upper.asp) | 把字符串转换为大写。                               |
| [zfill()](https://www.w3school.com.cn/python/ref_string_zfill.asp) | 在字符串的开头填充指定数量的 0 值。                |

**注释：**所有字符串方法都返回新值。它们不会更改原始字符串。



## 布尔类型 True False

```
print(8 > 7)
print(8 == 7)
print(8 > 7)
```

### bool() 函数

可让您评估任何值，并为您返回 True 或 False。

除空字符串外，任何字符串均为 True。

除 0 外，任何数字均为 True。

除空列表外，任何列表、元组、集合和字典均为 True。

7种空值为false的情况

```
bool(False)
bool(None)
bool(0)
bool("")
bool(())
bool([])
bool({})
```

要使对象的计算结果为 False，则对象带有 __len__ 函数的类生成的，且该函数返回 0 或 False：

```
class myclass():
  def __len__(self):
    return 0

myobj = myclass()
print(bool(myobj)) #结果为False
```

### isinstance() 函数

该函数可用于确定对象是否具有某种数据类型：

```
x = 200
print(isinstance(x, int))
```



## 运算符

- 算术运算符

  

- 赋值运算符

- 比较运算符

- 逻辑运算符

- 身份运算符

- 成员运算符

- 位运算符

