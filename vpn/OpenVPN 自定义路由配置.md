# [OpenVPN 自定义路由配置](https://6xyun.cn/article/97)



通常openvpn部署好以后，客户端连接VPN后会被配置一些路由，其客户端的路由会被修改为所有的流量都通过VPN来传输。但有时候，我们需要客户端的某些IP走VPN或者本地网关。这里有两种方法进行openvpn的路由配置

# 第一种方法： 客户端进行配置

在配置文件下增加如下内容：

```
route-nopull # 客户端连接openvpn后 不从服务端获取路由
max-routes 1000 # 设置路由的最大条数，默认是100，这里可以根据需求修改
route 192.168.0.0 255.255.255.0 net_gateway # 使192.168.0.0/24网段，不走vpn网关
route 192.168.1.0 255.255.255.0 vpn_gateway # 使192.168.1.0/24网段，走vpn网关
```

注意： 如果配置中有 `redirect-gateway def1` 则需要先移除

# 第二种方法： 在服务端进行配置

服务端和客户端的配置略有不同

```
push "route 192.168.0.0 255.255.255.0 net_gateway" # 将引号中的路由推送到客户端
push "route 192.168.1.0 255.255.255.0 vpn_gateway" # 将引号中的路由推送到客户端
```

注意： 如果配置中有 `redirect-gateway` 则需要先移除

配置完成后，需要重启openvpn服务。

两种方法选取其一即可。