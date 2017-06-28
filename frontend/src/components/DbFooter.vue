<template>
    <div class="container">
        <div class="footer-main"><p class="footer-main-title">{{ message }}</p><a
                href="https://github.com/boylegu/SanicCRUD-vue" target="_blank" class="footer-main-link">Github</a><a
                href="mailto:gubaoer@hotmail.com" class="footer-main-link">Email</a><a
                href="https://github.com/ElemeFE/element/blob/master/.github/CONTRIBUTING.en-US.md" target="_blank"
                class="footer-main-link">License</a></div>

        <div class="layout-copy footdoc">

            <i class="footdoc">
                <canvas id="myCanvas" width="80" height="80" style="background-color: transparent;"></canvas>
            </i>
            <i class="footdoc">2017 @ Boyle.Gu 顾鲍尔. Commemorate the 6 anniversary of enter the profession </i>
        </div>

        <div class="footer-social">
            <i class="doc-icon-weixin footdoc">
                <span>Design by Boyle</span>
                <img src="data:image/png;base64,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"/>
            </i>

            <i class="doc-icon-github footdoc"></i>
        </div>

    </div>

</template>

<script>

    export default {
        data(){
            return {
                message: 'SpringBoot-Vue.js v0.1',
            }
        },
        mounted (){

            const {Stage, Curve, motion} = this.$curvejs;

            let canvas = document.getElementById('myCanvas'),
                stage = new Stage(canvas);

            let curve = new Curve({
                color: '#ffaeac',
                data: {value: 0, step: 0.01, width: 80, height: 80},
                motion: motion.noise
            });
            stage.add(curve);

            function tick() {

                stage.update();
                requestAnimationFrame(tick)
            }

            tick()
        },

    }
</script>

<style scoped>
    .container {
        width: 1140px;
        padding: 0 30px;
        margin: 0 auto;
    }

    a {
        text-decoration: none;
    }

    .footer-main {
        font-size: 0;
        padding-top: 40px;
        display: inline-block;
    }

    .footer-main .footer-main-title {
        line-height: 1;
        font-size: 22px;
        margin: 0;
    }

    .footer-main .footer-main-link {
        display: inline-block;
        margin: 12px 18px 0 0;
        line-height: 1;
        font-size: 12px;
        color: #768193;
    }

    .layout-copy {
        display: inline-block;
        width: 570px;
        height: 70px;
        margin-left: 3px;
    }

    .layout-copy .footdoc {
        display: inline-block;
        text-align: center;
        color: #8d99ab;
        width: 570px;
        vertical-align: middle;
        font-size: 12px;
    }

    .footer-social {
        float: right;
        font-size: 0;
        padding: 0 30px;
    }

    .footdoc span {
        display: inline-block;
        font-size: 14px;
        color: #768193;

    }

    .footdoc img {
        display: inline-block;
        width: 84px;
        height: 80px;
        margin-top: 20px;
        transform:rotate(330deg);
        -ms-transform:rotate(330deg); /* Internet Explorer */
        -moz-transform:rotate(330deg); /* Firefox */
        -webkit-transform:rotate(330deg); /* Safari 和 Chrome */
        -o-transform:rotate(330deg); /* Opera */

    }


</style>