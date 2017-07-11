/**
 * Created by gubaoer on 17/5/11.
 */

var webpack = require('webpack');
var webpackDevServer = require('webpack-dev-server');
var devConfig = require("./webpack.dev.config");
var config = require("./config");
var compiler = webpack(devConfig);
var server = new webpackDevServer(compiler, {
    hot: true,
    noInfo: true,
    publicPath: config.dev.outputPublicPath,
    stats: { colors: true }
});
server.listen(config.dev.port, "0.0.0.0");
var url = `http://localhost:${config.dev.port}/`;
var opn = require('opn');
// auto start brower
server.middleware.waitUntilValid(function() {
    console.log(`> Listening at ${url}`);
    opn(`${url}`);
})