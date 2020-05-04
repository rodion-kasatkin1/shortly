<template>

    <v-app light>
        <!--<left-tool-bar isDrawer="lefttoolbar"></left-tool-bar>-->
       <head-bar></head-bar>
       <main-contant>
       </main-contant>
    </v-app>
</template>

<script>
    //import LeftToolBar from "./navigation/LeftToolBar.vue";
    import HeadBar from "./component/head/HeadBar.vue";
    import MainContant from './component/body/MainContant.vue'

    export default {
        name: "App",
        components: {
            HeadBar, MainContant
        },
        data() {
            return {
                lefttoolbar: false,
            }
        }
    }
</script>

<style scoped>
    .theme--light.v-application {
        background-color: #FAF8F7;
        font-family: 'Titillium Web', sans-serif;
        font-style: normal;
        font-weight: 200;
    }
</style>