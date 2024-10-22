FROM node:20 AS build

WORKDIR /app

COPY package.json package-lock.json ./
RUN npm install
RUN npm install -g @angular/cli

COPY . .
RUN npx npm run build --prod

#http sunucusu ile host
FROM nginx:alpine

COPY --from=build app/dist/telco.crm.front/browser /usr/share/nginx/html
EXPOSE 80
