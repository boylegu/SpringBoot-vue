<template>
    <div class="wrapper">
        <db-header></db-header>
        <el-row class="container">
            <el-col :span="4" class="menu">
                <db-sidebar></db-sidebar>
            </el-col>
            <el-col :span="20" class="content">
                <db-filterinput></db-filterinput>
                <db-table></db-table>

            </el-col>


        </el-row>

        <el-row>
            <el-col :span="24">
                <footer class="footer">
                    <db-footer></db-footer>
                </footer>

            </el-col>
        </el-row>
    </div>
</template>

<script>

    import DbHeader  from './components/DbHeader.vue'
    import DbSidebar from './components/DbSidebar.vue'
    import DbFilterinput from './components/DbFilterinput.vue'
    import DbTable from './components/DbTable.vue'
    import DbFooter from './components/DbFooter.vue'
    import ElRow from "element-ui/packages/row/src/row";

    export default {
        name: 'app',
        components: {
            ElRow, DbHeader,
            DbSidebar,
            DbFilterinput,
            DbTable,
            DbFooter
        },
    }

</script>

<style>

    element.style {
        background-color: rgb(10, 47, 88);
    }

    body {
        font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB", "Microsoft YaHei", "微软雅黑", Arial, sans-serif;
        margin: 0;
        display: flex;
        min-height: 100vh;
        flex-direction: column;
    }

    .el-menu, body, html {
        height: 100%;
    }

    .wrapper {

        position: relative;
    }

    footer, div {
        display: block;
    }

    .container {
        padding-top: 70px;
        flex: 1;
    }

    .container, .wrapper {
        height: 100%;
    }

    .menu {
        height: 100%;
        background-color: #eef1f6;
    }

    .content {
        padding-top: 25px;
        padding-right: 25px;
        padding-bottom: 125px;
        padding-left: 25px;
    }

    .footer {
        height: 120px;
        background-color: #324057;
        color: #a4aebd;
        width: 100%;
        z-index: 1000;
        margin-top: -120px;
        line-height: 1;
        font-size: 22px;
    }

</style>