FROM node:4.4
RUN npm install -g npm

RUN mkdir /client

COPY src client/src
COPY *.json client/
COPY e2e client/e2e

WORKDIR /client

EXPOSE 4200

ENTRYPOINT ["npm", "start"]