
### 启动服务

```
mvn clean spring-boot:run
```

### 测试

浏览器打开：https://dev-sso-client1.heyteago.com/ ，heyteago.com 域名只是示例，商户可以把自己真正使用的域名发给喜茶进行报备。


### Nginx 代理参考

```
server {
    listen       80;
    listen       443 ssl http2;
    server_name  dev-sso-client1.heyteago.com;

    # ssl 证书位置，和自己真正使用的域名匹配，这里只是示例
    ssl_certificate /Users/houyehua/Documents/heytea/heyteago.com-证书/Nginx/1_heyteago.com_bundle.crt;
    ssl_certificate_key /Users/houyehua/Documents/heytea/heyteago.com-证书/Nginx/2_heyteago.com.key;
    
    ssl_protocols TLSv1 TLSv1.1 TLSv1.2;
    ssl_ciphers ECDHE-RSA-AES128-GCM-SHA256:HIGH:!aNULL:!MD5:!RC4:!DHE;
    ssl_prefer_server_ciphers on;
    ssl_session_cache shared:SSL:10m;
    ssl_session_timeout 10m;
    error_page 497  https://$host$request_uri;

    location / {
        proxy_pass http://localhost:8901/;
        proxy_set_header  Host              $http_host;
        proxy_set_header  X-Real-IP         $remote_addr;
        proxy_set_header  X-Forwarded-For   $proxy_add_x_forwarded_for;
        proxy_set_header  X-Forwarded-Proto $scheme;

        proxy_buffering off;
        proxy_request_buffering off;

        # disable any limits to avoid http 413 for large image uploads
        client_max_body_size 100m;

        # required to avoid http 411: see issue #1486 (https://github.com/docker/docker/issues/1486)
        chunked_transfer_encoding on;

        add_header X-Cache $upstream_cache_status;

        expires 12h;
    }

    error_page   500 502 503 504  /50x.html;
    location = /50x.html {
        root   /usr/share/nginx/html;
    }

}
```
