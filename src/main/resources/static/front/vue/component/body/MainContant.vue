<template>
  <v-content>
    <v-container fluid>
      <v-row>
        <v-col cols="2"></v-col>
        <v-col cols="8">
          <link-input-area></link-input-area>
        </v-col>
        <v-col cols="2"></v-col>
      </v-row>
    </v-container>
  </v-content>
</template>

<script>
import LinkInputArea from "./input/LinkInputArea.vue";
export default {
    name:'MainContant',
  components: {
    LinkInputArea
  },
  data() {
    return {};
  }
};
</script>
<style scoped>
</style>