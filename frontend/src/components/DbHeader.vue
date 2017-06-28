<template>
    <header style="background-color: rgb(10, 47, 88);">
        <div class="text-logo">{{msg}}</div>
        <p class="meta">This demo project for express new develop practice demo.</p>
        <ul class="header-operations">
        </ul>
    </header>
</template>

<script>
    export default {
        name: 'db-header',
        data () {
            return {
                msg: 'SpringBoot-vue'
            }
        }
    }
</script>

<style>
    header {
        height: 70px;
        position: absolute;
        width: 100%;
        top: 0;
        left: 0;
        padding: 0 20px;
        z-index: 1;
        box-sizing: border-box;
    }

    .text-logo {
        display: inline-block;
        vertical-align: middle;
        border-style: none;
        position: relative;
        top: 26px;
        right: -20px;
        font-size: 25px;
        color: white;

    }

    .meta {
        color: #7e95c5;
        width: 200px;
        display: block;
        margin: -5px 0 0 225px;
        font-weight: 700;
        font-size: 0.3rem;
    }
</style>