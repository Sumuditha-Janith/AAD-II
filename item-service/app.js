const express = require('express');
const Eureka = require('eureka-js-client').Eureka;

const app = express();
const PORT = 3000;

app.get('/api/v1/item/details', (req, res) => {
    res.json({ message: "Item Service (Node.js) is Running" });
});

const client = new Eureka({
    instance: {
        app: 'item-service',
        hostName: 'localhost',
        ipAddr: '127.0.0.1',
        port: { '$': PORT, '@enabled': 'true' },
        vipAddress: 'item-service',
        dataCenterInfo: {
            '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
            name: 'MyOwn'
        }
    },
    eureka: {
        host: 'localhost',
        port: 8761,
        servicePath: '/eureka/apps/'
    }
});

client.start();

app.listen(PORT, () => {
    console.log(`Node service running on port ${PORT}`);
});