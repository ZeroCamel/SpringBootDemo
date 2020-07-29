# SpringBootDemo
* MySql部署  
1、阿里云镜像地址 http://mirrors.aliyun.com/centos/7/isos/x86_64/  
2、DockerHub相关命令 https://hub.docker.com/search?q=mysql&type=image  
* Docker安装  
uname -r  
yum update  
yum install docker  
systemctl start docker  
systemctl stop docker  
docker search key  
docker pull key  
docker rmi image-id  
docker run --name container-name -d image-name   
docker ps -a  
docker stop container-name/container-id  
docker start container-name/container-id  
docker rm container-id  
docker run -d -p 3306:3306 --name myredis  
docker logs container-name/container-id  
