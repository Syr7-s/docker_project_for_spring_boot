# Docker project for spring boot

Create image

```dockerfile
docker build -f Dockerfile -t docker-project-for-spring-boot
```

Run app with below code

```dockerfile
docker run -8085:8085 docker-project-spring-boot
```

Url :

localhost:8085/swagger-ui/index.html

![api](/figures/apidocs.png)

By the way, If user want to order, user should be a customer firstly.And then user can order with user Id.

![orderandcustomer](/figures/image.png)	