/**
 * Created by gubaoer on 17/5/10.
 */


var path = require('path');
module.exports = {
    dev: {
        outputPath: path.resolve(__dirname, '../dist'),
        outputPublicPath: '/',
        port: 8080
    },
    prod: {
        outputPath: path.resolve(__dirname, '../dist'),
        outputPublicPath: '/'
    }
}