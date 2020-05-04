<template>
  <v-app-bar app class= "primary-color" dark>
    <v-container fluid>
      <v-row no-gutters justify="start" align="center">
        <v-col cols="12" align-self="center">
          <v-row justify="space-between" align="center">
            <v-col cols="2" align-self="center"></v-col>
            <v-col cols="8" align-self="center">
              <v-toolbar-title class="pl-1" >
                <v-icon class="title-font purple-color mb-4">mdi-human-handsup</v-icon>
                <v-icon class="lower-font purple-color mb-2">mdi-human-handsup</v-icon>
                <span class="pr-2"></span>
                <span class="title-font">short.ly</span>
              </v-toolbar-title>
            </v-col>
            <v-col cols="2" align-self="center"></v-col>
          </v-row>
        </v-col>
      </v-row>
    </v-container>
  </v-app-bar>
</template>

</template>
<script>
export default {
  name: "HeadBar",
  data() {
    return {};
  }
};
</script>
<style scoped>
.title-font {
  font-size: 36px !important;
}
.lower-font {
  font-size: 18px !important;
  
}
.purple-color{
    color: #e86100 !important;
}
.primary-color{
    background-color: #14646f !important;
}
</style>