/**
 * Created by gubaoer on 17/5/11.
 */

var webpack = require("webpack");
var prodWebpackConfig = require('./webpack.prod.config');
webpack(prodWebpackConfig, function (err, stats) {
    process.stdout.write(stats.toString());
});