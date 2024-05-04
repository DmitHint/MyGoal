# # Используйте официальный образ Node.js
# FROM node:16 AS builder

# # Установите рабочую директорию внутри контейнера
# WORKDIR /app

# # Копируйте package.json и package-lock.json
# COPY package*.json ./

# # Установите зависимости
# RUN npm install

# # Копируйте исходный код приложения
# COPY . .

# # Создайте production-версию React-приложения
# RUN npm run build

# # Используйте изображение node:16 для запуска
# FROM node:16

# # Установите рабочую директорию внутри контейнера
# WORKDIR /app

# # Копируйте файлы сборки React-приложения из builder-этапа
# COPY --from=builder /app/build /app

# # Укажите порт, который будет прослушивать приложение
# EXPOSE 3000

# # Запустите приложение с помощью serve (необходимо добавить в зависимости)
# CMD ["npx", "serve", "-s", ".", "-l", "3000"]


FROM node:18-alpine

WORKDIR /app

EXPOSE 3000

COPY ["package.json", "package-lock.json*", "./"]

RUN npm install

COPY . .

CMD ["npm", "start"]