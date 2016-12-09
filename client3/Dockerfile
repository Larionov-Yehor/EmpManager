FROM node:4.4
RUN npm install -g npm

RUN mkdir /client
WORKDIR /client

EXPOSE 3000 3001

ENTRYPOINT ["npm", "run", "api"]