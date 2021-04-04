# Docker project for spring boot

Create image

```dockerfile
docker build -f Dockerfile -t docker-project-for-spring-boot .
```

Run app with below code

```dockerfile
docker container run --name project -p 8085:8085 docker-project-for-spring-boot
```

Also, you can run app with docker stack. But should use docker-compose.yml. 

```dockerfile
docker stack deploy -c .\docker-compose.yml docker-spring-stack
```

Note: Before use docker stack you should create a image.

Url :

localhost:8085/swagger-ui/index.html

![api](/figures/apidoc.png)

By the way, If user want to order, user should be a customer firstly.And then user can order with user Id.

![orderandcustomer](/figures/img.png)	