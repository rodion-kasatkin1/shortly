<template>
  <div>
    <v-container fluid>
      <v-row justify="center" align="baseline">
        <v-col cols="11">
          <v-text-field
            v-model="inputLink"
            outlined
            label="Enter URL you want to shorten"
            placeholder="http://"
            autofocus
            clearable
            :error-messages="showErrors"
          ></v-text-field>
        </v-col>
        <v-col cols="1">
          <v-btn large class="primary-color pt-2" dark @click="onGenerateBtnClick">Generate</v-btn>
        </v-col>
        <v-col cols="12">
          <v-text-field v-if="generatedValue != null" v-model="generatedValue" readonly></v-text-field>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import { mapActions, mapMutations, mapState } from "vuex";
export default {
  name: "LinkInputAreaVue",
  data() {
    return {
      inputLink: null,
      generatedValue: null
    };
  },
  computed: {
    ...mapState(["shortLink", "error"]),
    showErrors() {
      if (this.error != null) {
        return Object.values(this.error);
      } else {
        return [];
      }
    }
  },
  watch: {
    shortLink: function() {
      this.generatedValue = this.shortLink.shortLink;
    }
  },
  methods: {
    ...mapActions(["generateShortLinkApi"]),
    ...mapMutations(["throwErrorMessage"]),
    onGenerateBtnClick() {
      this.generatedValue = null;
      this.generateShortLinkApi({ inputLink: this.inputLink });
      this.throwErrorMessage(null);
    }
  }
};
</script>
<style scoped>
.primary-color {
  background-color: #14646f !important;
}
</style>