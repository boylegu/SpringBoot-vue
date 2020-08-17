FROM vuejs/ci:latest
COPY ./frontend /opt
WORKDIR /opt
RUN npm install 
ENTRYPOINT npm run dev
EXPOSE 8080  