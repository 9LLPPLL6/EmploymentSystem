#!/bin/bash

# 安装 Docker
install_docker() {
    # 更新系统软件包
    sudo apt update

    # 安装 Docker 依赖
    sudo apt install -y apt-transport-https ca-certificates curl software-properties-common

    # 添加 Docker GPG 密钥
    curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /usr/share/keyrings/docker-archive-keyring.gpg

    # 添加 Docker 软件源
    echo "deb [arch=amd64 signed-by=/usr/share/keyrings/docker-archive-keyring.gpg] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null

    # 更新软件包索引
    sudo apt update

    # 安装 Docker 引擎
    sudo apt install -y docker-ce docker-ce-cli containerd.io

    # 添加当前用户到 docker 用户组
    sudo usermod -aG docker $USER

    # 启动 Docker 服务
    sudo systemctl start docker

    # 设置 Docker 服务开机自启
    sudo systemctl enable docker

    # 显示 Docker 版本信息
    docker version
}

#安装 make
install_make(){
  sudo apt install make
}

# 安装 Docker Compose
install_docker_compose() {
    # 下载 Docker Compose 二进制文件
    sudo curl -L "https://github.com/docker/compose/releases/latest/download/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose

    # 授予执行权限
    sudo chmod +x /usr/local/bin/docker-compose

    # 显示 Docker Compose 版本信息
    docker-compose version
}

main() {
    echo "开始安装 Docker..."
    install_docker

    echo "开始安装 Docker Compose..."
    install_docker_compose

    echo "开始安装make"
    install_make

    echo "安装完成！"
}

main