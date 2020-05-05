<template>
  <v-app light>
    <!--<left-tool-bar isDrawer="lefttoolbar"></left-tool-bar>-->
    <head-bar></head-bar>
    <router-view></router-view>
    <v-alert :value="alert" type="error" dismissible>{{this.getErrorAfterReloadPage}}</v-alert>
  </v-app>
</template>

<script>
//import LeftToolBar from "./navigation/LeftToolBar.vue";
import HeadBar from "./component/head/HeadBar.vue";
import MainContant from "./component/body/MainContant.vue";
import { mapGetters, mapState, mapMutations } from "vuex";

export default {
  name: "App",
  components: {
    HeadBar,
    MainContant
  },
  computed: {
    ...mapGetters(["getErrorAfterReloadPage"]),
    ...mapState(["feData"])
  },
  data() {
    return {
      lefttoolbar: false,
      alert: false
    };
  },
  created: function() {
    if (this.feData != null && this.feData.errorMessage != null) {
      this.alert = true;
    }
    setTimeout(this.hideErrorAlert, 5000);
  },
  watch: {},
  methods: {
    ...mapMutations(["invalidateErrorMessage"]),
    hideErrorAlert() {
      this.alert = false;
      this.invalidateErrorMessage();
    }
  }
};
</script>

<style scoped>
.theme--light.v-application {
  background-color: #faf8f7;
  font-family: "Titillium Web", sans-serif;
  font-style: normal;
  font-weight: 200;
}
</style>