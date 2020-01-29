FROM nodered/node-red

# copy node-red project files into place
COPY data/flows.json /data/flows.json
COPY data/flows_cred.json /data/flows_cred.json
COPY data/settings.js /data/settings.js

# copy package.json to the WORKDIR so npm builds for node-red
COPY data/package.json .
RUN npm install --unsafe-perm --no-update-notifier --no-audit --only=production

CMD ["npm", "start"]
