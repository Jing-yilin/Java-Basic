# Hashtable和HashMap对比

|           | 版本 | 线程安全（同步） | 效率 | 允许null键；允许null值 |
| --------- | ---- | ---------------- | ---- | ---------------------- |
| HashMap   | 1.2  | 不安全           | 高   | 可以                   |
| HashTable | 1.0  | 安全             | 较低 | 不可以                 |

HashMap会树化，HashTable不会树化

