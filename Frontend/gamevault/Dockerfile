# Use a imagem oficial do Node.js como base
FROM node:18-alpine

# Configure o diretório de trabalho dentro do container
WORKDIR /app

# Copie o arquivo package.json e package-lock.json para o container
COPY package*.json ./

# Instale as dependências
RUN npm install

# Copie o restante dos arquivos do projeto para o container
COPY . .

# Exponha a porta que será usada pela aplicação React
EXPOSE 3000

# Comando para rodar a aplicação
CMD ["npm", "start"]
