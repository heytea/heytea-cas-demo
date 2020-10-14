
This demo declares how `spring cloud gateway` 2.2.x uses OAuth2 flow to login OAuth2 provider.

`application.yml` configuration looks like below. 

* 1. The `dev-cas` provider is a apereo cas 6.3.x server builds on [cas-overlay-template](https://github.com/apereo/cas-overlay-template) .

* 2. it also can integrate gitlab.com or self hosted gitlab to login.

* 3. [Spring Security OAuth](https://github.com/spring-projects/spring-security-oauth) can be a OAuth2 provider too, although the Spring Security OAuth project is deprecated, so it is not recommended to be use in production environment.

```
spring:
  security:
    oauth2:
      client:
        provider:
          dev-cas: ## 1. apereo cas 6.3.x OAuth2 login provider
            authorization-uri: https://cas.example.com/cas/oauth2.0/authorize
            token-uri: https://cas.example.com/cas/oauth2.0/accessToken
            user-info-uri: https://cas.example.com/cas/oauth2.0/profile
            user-name-attribute: id
            user-info-authentication-method: form
          heytea-gitlab: ## 2. gitlab.com or self hosted gitlab OAuth2 login provider
            authorization-uri: https://gitlab.example.com/oauth/authorize
            token-uri: https://gitlab.example.com/oauth/token
            user-info-uri: https://gitlab.example.com/api/v4/user
            jwk-set-uri: https://gitlab.example.com/oauth/discovery/keys
            user-name-attribute: username
          heytea-oauth2server: ## 3. Spring Security OAuth login provider
            authorization-uri: http://localhost:8081/oauth/authorize
            token-uri: http://localhost:8081/oauth/token
            user-info-uri: http://localhost:8081/oauth/userinfo
            user-name-attribute: name
        registration:
          github:
            client-id: 5c3d...501e
            client-secret: 6760...c541
          gateway:
            provider: dev-cas
            client-name: gateway cas
            client-id: exampleOauthClient
            client-secret: exampleOauthClientSecret
            authorization-grant-type: authorization_code
            # scope: user, read
          gateway-gitlab: ## create a gitlab applications with api, profile scopes enabled
            provider: heytea-gitlab
            client-name: gateway gitlab
            client-id: cf39a0...6b547aa
            client-secret: 29d554...ab6c70a
            authorization-grant-type: authorization_code
            scope:
            - profile
            - api
          gateway-oauth2server:
            provider: heytea-oauth2server
            client-name: gateway uua
            client-id: exampleOauthClient
            client-secret: exampleOauthClientSecret
            authorization-grant-type: authorization_code
            scope: read
```

Run project as spring boot application `mvn spring-boot:run`, open http://localhost:8998 in browser, choose a login provider, and it will redirect you to OAuth2 provider login page.

After login OAuth2 provider with correct username and password, it will redirect you back to `greeting.html` or `index.html` page which will show current user's information details.

#### reference

> https://spring.io/blog/2019/08/16/securing-services-with-spring-cloud-gateway

> https://github.com/saagar2000/oauth_server

> issue: [Spring Cloud Gateway + Spring security CAS](https://github.com/spring-cloud/spring-cloud-gateway/issues/987)

> issue: [spring-security-cas use in webflux](https://github.com/spring-projects/spring-security/issues/5887)

